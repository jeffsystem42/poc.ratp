package fr.ratp.phoebus.dao;

import fr.ratp.phoebus.beanMetier.AbstractCacheableBean;
import fr.ratp.phoebus.beanMetier.Agent;

import java.util.List;
import java.util.Map;

/**
 * Created by vermelinj on 16/06/2015.
 */
public interface CacheDao {

    /**
     * Récupère une liste d'objet à mettre en cache
     * @param requete
     * @param className
     * @return La liste de tous les objets renvoyés par la requête
     * @throws ClassNotFoundException
     */
    List<AbstractCacheableBean> getOBjectToPutInCache(String requete, String className) throws ClassNotFoundException;
}
