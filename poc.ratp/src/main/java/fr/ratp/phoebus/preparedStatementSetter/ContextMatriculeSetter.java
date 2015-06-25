package fr.ratp.phoebus.preparedStatementSetter;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Alimente le PreparedStatement de la requête du writer contextMatriculeWriter
 */
public class ContextMatriculeSetter implements ItemPreparedStatementSetter<ContextMatriculeItem> {


    public void setValues(ContextMatriculeItem item, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setObject(1, item.getMatricule());
        preparedStatement.setObject(2, item.getMatricule());
        preparedStatement.setObject(3, getCurrentDate());
        preparedStatement.setObject(4, item.getPrime1());
        preparedStatement.setObject(5, item.getPrime2());
        preparedStatement.setObject(6, item.getPrime3());
    }


    /**
     * Renvoie la date du jour au format SQL
     * @return la date du jour au format SQL
     */
    private static java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
}
