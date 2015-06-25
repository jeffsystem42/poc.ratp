package fr.ratp.phoebus.beanMetier;

import java.io.Serializable;

/**
 * Classe abstraite dont doivent hériter tous les beans mis en cache
 */
public abstract class AbstractCacheableBean implements Serializable{

    /**
     * Permet de définir la clé du bean dans le cache
     * @return la clé du bean dans le cache
     */
    public abstract String getKey();
}
