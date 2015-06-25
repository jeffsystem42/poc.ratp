package fr.ratp.phoebus.preparedStatementSetter;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Alimente le PreparedStatement de la requête du writer cleanInputWriter
 */
public class CleanInputSetter implements ItemPreparedStatementSetter<ContextMatriculeItem> {


    public void setValues(ContextMatriculeItem item, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setObject(1, item.getMatricule());
    }
}
