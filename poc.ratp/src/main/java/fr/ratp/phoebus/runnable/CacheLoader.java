package fr.ratp.phoebus.runnable;

import fr.ratp.phoebus.beanMetier.AbstractCacheableBean; 
import fr.ratp.phoebus.beanMetier.Agent;
import fr.ratp.phoebus.dao.CacheDao;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by vermelinj on 16/06/2015.
 */
public class CacheLoader implements Runnable{

    /** LOGGER - Logger */
    private static final Logger LOGGER = Logger.getLogger(CacheLoader.class);

    /** DAO g�n�rique du cache */
    private CacheDao cacheDao = null;

    /** Cache manager */
    private EhCacheCacheManager cacheManager = null;

    /** Requete a ex�cuter */
    private String requete = null;

    /** Nom de la classe o� d�s�rialis�e le resultat de la requete */
    private String className = null;

     /** nom du cache o� sera stock� le r�sultat de la requ�te */
    private String cacheName = null;


    public CacheLoader(CacheDao cacheDao, EhCacheCacheManager cacheManager, String requete, String className, String cacheName ){
        this.cacheDao = cacheDao;
        this.cacheManager = cacheManager;
        this.requete = requete;
        this.cacheName = cacheName;
        this.className = className;
    }

    public void run() {

        System.out.println("Execution dans le thread " + Thread.currentThread().getName());

        // R�cup�ration du cache
       Cache cache = cacheManager.getCache(cacheName);

        // Acc�s en base pour r�cup�rer la liste des agents;
        List<AbstractCacheableBean> objects = null;
        try {
            objects = cacheDao.getOBjectToPutInCache(requete,className);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }

        // Mise en cache du r�sultat
       for (AbstractCacheableBean bean : objects) {
           cache.put(bean.getKey(), bean);
        }
    }
}
