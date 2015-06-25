package fr.ratp.phoebus;

import org.apache.log4j.Logger; 
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by vermelinj on 22/05/2015.
 */
public class PokBatch {

    /** LOGGER - Logger */
    private static final Logger LOGGER = Logger.getLogger(PokBatch.class);

    /**
     * constructeur privé
     */
    private PokBatch()
    {
        // Do nothing
    }

    /**
     * Lance le batch.
     *
     * @param args : Date + Matricule
     */
    public static void main(String[] args)
    {
        // On lance l'application
        LOGGER.info("Debut du traitement");
        startApplication("context.xml");
    }

    /**
     * Démarre l'application à partir du fichier de contexte spécifié
     *
     * @param contextFile Le fichier de contexte
     */
    protected static void startApplication(String contextFile)
    {
        // Récupération du contexte
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext(contextFile);

        JobLauncher jobLauncher = (JobLauncher) applicationContext.getBean("jobLauncher");
        Job job = (Job) applicationContext.getBean("primeCalculatorJob");

        try {
            JobParameters jbs = new JobParametersBuilder().addString("writer", "contextMatriculeWriter").toJobParameters();
            jobLauncher.run(job, jbs);
            LOGGER.info("Fin du traitement");
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}

