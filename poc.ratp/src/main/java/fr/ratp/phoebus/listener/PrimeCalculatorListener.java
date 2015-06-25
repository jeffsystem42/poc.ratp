package fr.ratp.phoebus.listener;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import org.springframework.batch.core.ItemProcessListener;

/**
 * Listener sur les calculs des primes
 */
public class PrimeCalculatorListener implements ItemProcessListener<ContextMatriculeItem,ContextMatriculeItem> {

    public void beforeProcess(ContextMatriculeItem contextMatriculeItem) {
        // Do nothing
    }

    public void afterProcess(ContextMatriculeItem contextMatriculeItem, ContextMatriculeItem contextMatriculeItem2) {
        // Do nothing
    }

    public void onProcessError(ContextMatriculeItem contextMatriculeItem, Exception e) {
        System.out.println("LISTENER ON PROCESS ERROR " + contextMatriculeItem.getMatricule());
    }

}
