package fr.ratp.phoebus.itemProcessor;

import fr.ratp.phoebus.context.AppContext; 
import fr.ratp.phoebus.dao.AgentsDao;
import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import fr.ratp.phoebus.exception.PhoebusException;

import org.springframework.context.ApplicationContext;

/**
 * Created by vermelinj on 22/05/2015.
 */
public class Prime1CalculatorV1 extends AbstractPrimeCalculator {

    public ContextMatriculeItem process(ContextMatriculeItem item) throws Exception {

        LOGGER.debug("Recherche de l'agent dont le matricule est " + item.getMatricule());

        ApplicationContext applicationContext = AppContext.getApplicationContext();
        AgentsDao agentDao = (AgentsDao) applicationContext.getBean("agentsDao");
        agentDao.findByMatricule(item.getMatricule());


        // On simule lors du calcul de la prime
            //throw new PhoebusException("Erreur lors du calcul de la prime 1");

        item.setPrime1(100);

        return item;
    }
}
