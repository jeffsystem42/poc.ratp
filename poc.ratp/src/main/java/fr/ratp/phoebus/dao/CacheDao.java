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
     * R�cup�re une liste d'objet � mettre en cache
     * @param requete
     * @param className
     * @return La liste de tous les objets renvoy�s par la requ�te
     * @throws ClassNotFoundException
     */
    List<AbstractCacheableBean> getOBjectToPutInCache(String requete, String className) throws ClassNotFoundException;
}
