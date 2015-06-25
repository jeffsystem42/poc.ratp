package fr.ratp.phoebus.writer;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import fr.ratp.phoebus.utils.PhoebusUtils;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Writer de base de données
 */
public class ContextMatriculeWriter implements ItemWriter<ContextMatriculeItem>, InitializingBean {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private String tableName;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(this.tableName, "Un nom de table est requis");
	}

	public void write(List<? extends ContextMatriculeItem> list) throws Exception {

		StringBuilder sbDeleteRequest = new StringBuilder();
		sbDeleteRequest.append("DELETE FROM ").append(tableName).append(" WHERE MATRICULE = ?");

		String insertRequest = "INSERT INTO CONTEXT_MATRICULE_ITEM (ID, MATRICULE, DATE_TRT, PRIME1, PRIME2, PRIME3) values (?,?,?,?,?,?)";

		for (final ContextMatriculeItem item : list) {

			 // Puis on stocke le contextMatriculeItem en base
            jdbcTemplate.batchUpdate(insertRequest, new BatchPreparedStatementSetter() {

                public void setValues(PreparedStatement ps, int i) throws SQLException {
                    ps.setObject(1, item.getMatricule());
                    ps.setObject(2, item.getMatricule());
                    ps.setObject(3, PhoebusUtils.getCurrentDate());
                    ps.setObject(4, item.getPrime1());
                    ps.setObject(5, item.getPrime2());
                    ps.setObject(6, item.getPrime3());
                }

                public int getBatchSize() {
                    return 1;
                }

            });
			// Tout d'abord on supprime des tables d'entrée les items traités
			jdbcTemplate.batchUpdate(sbDeleteRequest.toString(), new BatchPreparedStatementSetter() {

				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setObject(1, item.getMatricule());
				}

				public int getBatchSize() {
					return 1;
				}

			});

			// Puis on stocke le contextMatriculeItem en base

		}

	}
}
