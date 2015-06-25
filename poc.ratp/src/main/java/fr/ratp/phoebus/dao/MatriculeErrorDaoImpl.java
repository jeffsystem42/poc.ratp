package fr.ratp.phoebus.dao;

import fr.ratp.phoebus.utils.PhoebusUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by vermelinj on 15/06/2015.
 */
public class MatriculeErrorDaoImpl extends AbstractPheobusDao implements MatriculeErrorDao {

    public void insert(final String matricule, final String motif) {
        String requete = "INSERT INTO MATRICULE_ERROR (ID, MATRICULE, DATE_TRT, MOTIF) VALUES (?, ?, ?, ?)";

        jdbcTemplate.batchUpdate(requete, new BatchPreparedStatementSetter() {

            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setObject(1, matricule);
                ps.setObject(2, matricule);
                ps.setObject(3, PhoebusUtils.getCurrentDate());
                ps.setObject(4, motif);
            }

            public int getBatchSize() {
                return 1;
            }

        });
    }
}
