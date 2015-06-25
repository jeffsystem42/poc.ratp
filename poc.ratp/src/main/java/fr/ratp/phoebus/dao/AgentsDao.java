package fr.ratp.phoebus.dao;

import fr.ratp.phoebus.beanMetier.Agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.sql.DataSource;

/**
 * Implémentation de l'interface AgentDao
 */

@Component
public class AgentsDao  {

	   
    DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public List<Agent> getAll() {
		final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String requete = "SELECT * FROM AGENTS";
        List <Agent> agents = jdbcTemplate.query(requete, new BeanPropertyRowMapper(Agent.class));
        return agents;
    }

    @Cacheable(value="cacheAgent")
    public Agent findByMatricule(String matricule) {
    	final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String requete = "SELECT * FROM AGENTS WHERE MATRICULE = ?";
        Agent agent = (Agent) jdbcTemplate.queryForObject(requete, new Object[]{matricule}, new BeanPropertyRowMapper(Agent.class));
        return agent;
    }
}
