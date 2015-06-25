package fr.ratp.phoebus.compositeItemProcessor;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;

import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Composite processor gerant l'appel des item processor
 */
public class PrimeCompositeProcessor extends CompositeItemProcessor<ContextMatriculeItem, ContextMatriculeItem>{

    /** LOGGER - Logger */
    private static final Logger LOGGER = Logger.getLogger(PrimeCompositeProcessor.class);

    private String threadName = null;

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // On en fait rien
        // La liste des processus delegues est determinee dynamiquement dans le process via la methode setDelegatesProcessor
        // qui se base sur la date de traitement contenu dans l'item pour determiner l'enchainement d'UT devant etre executee
    }

    @Override
    public ContextMatriculeItem process(ContextMatriculeItem item) throws Exception {

        // On definit la liste des item processor
        setDelegatesProcessor(item.getDateTrt());
        ContextMatriculeItem contextMatriculeItem = super.process(item);

        return contextMatriculeItem;
    }

    /**
     * Valorise dynamiquement la liste des item processor
     */
    private void setDelegatesProcessor(Date dateTrt){

        // Liste des sous-process
        List<ItemProcessor<ContextMatriculeItem, ContextMatriculeItem>> processors = new ArrayList<ItemProcessor<ContextMatriculeItem, ContextMatriculeItem>>();

        // On recupere le nom de toutes les classes (UT) a instancier
        List<String> executionFlow = getExecutionFlow(dateTrt);

        // Instanciation de toutes les UT
        for (String ut : executionFlow){
            processors.add(getInstance(ut));
        }

        // Valorisation des sous-process avec la liste des UT instanciees
        setDelegates(processors);
    }


    /**
     * Cette fonction doit ramener l'enchainement des UT via un acces base qui n'existe pas encore
     * Pour l'instant on se contente de creer une liste de string
     * @return La liste des UT a instancier
     */
    private List<String> getExecutionFlow(Date dateTrt){

        List<String> executionFlow = new ArrayList<String>();

            if (dateTrt.before(new Date())) {
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorB");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
            } else {
                executionFlow.add("fr.ratp.phoebus.itemProcessor.TestProcessorA");
                //executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime2CalculatorV2");
                //executionFlow.add("fr.ratp.phoebus.itemProcessor.Prime3CalculatorV1");
            }


        return executionFlow;
    }

    /**
     * Instancie la classe dont le nom est passe en parametre
     * @param className : Le nom de la classe a instancier
     * @return La classe instanciee
     */
    private ItemProcessor<ContextMatriculeItem, ContextMatriculeItem> getInstance(String className){

        ItemProcessor<ContextMatriculeItem, ContextMatriculeItem> processor = null;

        try {
            Class clazz = Class.forName(className);
            processor = (ItemProcessor<ContextMatriculeItem, ContextMatriculeItem>) clazz.newInstance();
        } catch (InstantiationException ie) {
            LOGGER.error(ie);
        } catch (IllegalAccessException iae) {
            LOGGER.error(iae);
        } catch (ClassNotFoundException cnfe) {
            LOGGER.error(cnfe);
        }

        return processor;

    }
}
