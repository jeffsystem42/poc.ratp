package fr.ratp.phoebus.dao;

import fr.ratp.phoebus.beanMetier.AbstractCacheableBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * DAO g�n�rique qui ex�cute la requ�te pass�e en param�tre et renvoie une map (cl�/valeur pour chaques colonnes) pour chaques lignes
 */
public class CacheDaoImpl extends AbstractPheobusDao implements CacheDao {

    public List<AbstractCacheableBean> getOBjectToPutInCache(String requete, String className) throws ClassNotFoundException {
        return jdbcTemplate.query(requete, new BeanPropertyRowMapper(Class.forName(className)));
    }
}
