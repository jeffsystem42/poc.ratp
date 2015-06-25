package fr.ratp.phoebus.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Classe abstraite dont doivent hérités tous les DAO
 */
public abstract class AbstractPheobusDao {

    protected DataSource dataSource;
    protected JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

}
