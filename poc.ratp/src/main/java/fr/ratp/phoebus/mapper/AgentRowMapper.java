package fr.ratp.phoebus.mapper;

import fr.ratp.phoebus.beanMetier.Agent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper entre la table AGENT et le bean Agent
 */
public class AgentRowMapper implements RowMapper<Agent> {

    public Agent mapRow(ResultSet resultSet, int i) throws SQLException {

        Agent agent = new Agent();
        agent.setId(resultSet.getInt("ID"));
        agent.setMatricule(resultSet.getString("MATRICULE"));
        agent.setNom(resultSet.getString("NOM"));
        agent.setPrenom(resultSet.getString("PRENOM"));

        return agent;
    }
}
