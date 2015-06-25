package fr.ratp.phoebus.itemProcessor;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;

/**
 * Created by vermelinj on 26/05/2015.
 */
public class Prime1CalculatorV2 extends AbstractPrimeCalculator {

    public ContextMatriculeItem process(ContextMatriculeItem item) throws Exception {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calcul de la prime 1 pour le matricule " + item.getMatricule());
        }

        item.setPrime1(110);

        return item;
    }
}
