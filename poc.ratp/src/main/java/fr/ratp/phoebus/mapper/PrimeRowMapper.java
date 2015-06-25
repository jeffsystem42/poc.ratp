package fr.ratp.phoebus.mapper;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mapper entre les tables INPUT_TABLE_X et le bean ContextMatriculeItem
 */
public class PrimeRowMapper implements RowMapper<ContextMatriculeItem> {

    public ContextMatriculeItem mapRow(ResultSet rs, int rowNum) throws SQLException {

        ContextMatriculeItem item = new ContextMatriculeItem();

        item.setMatricule(rs.getString("MATRICULE"));
        item.setDateTrt(rs.getDate("DATE_TRT"));

        return item;
    }
}
