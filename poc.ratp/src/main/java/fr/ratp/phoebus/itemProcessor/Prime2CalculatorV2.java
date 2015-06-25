package fr.ratp.phoebus.itemProcessor;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;

/**
 * Created by vermelinj on 26/05/2015.
 */
public class Prime2CalculatorV2 extends AbstractPrimeCalculator {

    public ContextMatriculeItem process(ContextMatriculeItem item) throws Exception {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calcul de la prime 2 pour le matricule " + item.getMatricule());
        }

        item.setPrime2(220);

        return item;
    }
}
