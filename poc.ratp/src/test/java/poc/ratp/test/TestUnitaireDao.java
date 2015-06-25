package poc.ratp.test;

import fr.ratp.phoebus.beanMetier.Agent;
import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.gson.Gson;

import java.util.List;

import javax.sql.DataSource;

/**
 * Implémentation de l'interface AgentDao
 */
public class TestUnitaireDao {

	protected DataSource dataSource;
	protected JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<TestUnitaire> getAll() {
		String requete = "SELECT * FROM T_TEST_UNITAIRE";
		List<TestUnitaire> tests = jdbcTemplate.query(requete, new BeanPropertyRowMapper(Agent.class));
		return tests;
	}

	public ContextMatriculeItem getContextByIdTest(int id) {
		String requete = "SELECT * from T_TEST_UNITAIRE where id_test = ?";
		TestUnitaire tu = jdbcTemplate.queryForObject(requete, new Object[] { id }, new BeanPropertyRowMapper(TestUnitaire.class));
		Gson gs = new Gson();
		ContextMatriculeItem myContexte = gs.fromJson(tu.getContext_json(), ContextMatriculeItem.class);
		return myContexte;
	}

}
