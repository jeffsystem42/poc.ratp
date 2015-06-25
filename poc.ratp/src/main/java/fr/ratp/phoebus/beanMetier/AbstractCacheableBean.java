package fr.ratp.phoebus.beanMetier;

import java.io.Serializable;

/**
 * Classe abstraite dont doivent h�riter tous les beans mis en cache
 */
public abstract class AbstractCacheableBean implements Serializable{

    /**
     * Permet de d�finir la cl� du bean dans le cache
     * @return la cl� du bean dans le cache
     */
    public abstract String getKey();
}
