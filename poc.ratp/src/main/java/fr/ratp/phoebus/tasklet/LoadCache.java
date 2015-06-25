package fr.ratp.phoebus.tasklet;



import fr.ratp.phoebus.beanMetier.Agent; 
import fr.ratp.phoebus.dao.CacheDao;
import fr.ratp.phoebus.runnable.CacheLoader;
import net.sf.ehcache.CacheException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.apache.log4j.Logger;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Charge les objets dans le cache
 */
public class LoadCache implements Tasklet {

    /** LOGGER - Logger */
    private static final Logger LOGGER = Logger.getLogger(LoadCache.class);

    /** DAO du cache*/
    private CacheDao cacheDao = null;

    /** Cache manager */
    private EhCacheCacheManager cacheManager = null;

    /** Taille du pool de Thread */
    private int threadPoolSize = 10;

    public void setCacheDao(CacheDao cacheDao) {
        this.cacheDao = cacheDao;
    }

    public void setCacheManager(EhCacheCacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void setThreadPoolSize(int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        LOGGER.info("Debut du chargement du cache");

        List<Runnable> runnables = new ArrayList<Runnable>();
        CacheLoader cacheLoader = null;

        try {

            //Lecture du fichier JSON
          //  FileReader reader = new FileReader("..\\resources\\json\\cache.json");
            
        	        	
            BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/json/cache.json")));

            // Parsing du fichier JSON ==> tableau d'objet
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);

            //Pour chaque objet trouvé, on créé un CacheLoader et on l'ajoute à la liste des Runnables
            Iterator it = jsonArray.iterator();
            while (it.hasNext()) {
                JSONObject obj = (JSONObject) it.next();
                cacheLoader = new CacheLoader(cacheDao,cacheManager, (String)obj.get("requete"), (String)obj.get("bean_metier"), (String)obj.get("nom_cache"));
                runnables.add(cacheLoader);
            }

            //Création d'un pool de Threads
            ExecutorService service = Executors.newFixedThreadPool(threadPoolSize);

            //Exécution des Threads
            for (Runnable runnable : runnables){
                service.execute(runnable);
            }
            
           
            service.shutdown();
            service.awaitTermination(2, TimeUnit.MINUTES);

         
            LOGGER.info("Fin du chargement du cache");


        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        } catch (IOException ioe){
            LOGGER.error(ioe);
        } catch (ParseException pe){
            LOGGER.error(pe);
        }

        return RepeatStatus.FINISHED;
    }
}
