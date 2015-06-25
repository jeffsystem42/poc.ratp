package fr.ratp.phoebus.itemProcessor;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import org.apache.log4j.Logger;
import org.springframework.batch.item.ItemProcessor;

/**
 * Classe abstraite dont doivent hérités tous les item processor
 */
public abstract class AbstractPrimeCalculator implements ItemProcessor<ContextMatriculeItem, ContextMatriculeItem> {

    /** LOGGER - Logger */
    protected static final Logger LOGGER = Logger.getLogger(AbstractPrimeCalculator.class);

}
