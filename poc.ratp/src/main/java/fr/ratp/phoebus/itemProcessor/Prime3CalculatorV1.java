package fr.ratp.phoebus.itemProcessor;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;

/**
 * Created by vermelinj on 22/05/2015.
 */
public class Prime3CalculatorV1 extends AbstractPrimeCalculator {

    public ContextMatriculeItem process(ContextMatriculeItem item) throws Exception {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calcul de la prime 3 pour le matricule " + item.getMatricule());
        }

        item.setPrime3(300);

        return item;
    }

}