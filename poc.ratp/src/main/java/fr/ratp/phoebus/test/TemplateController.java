package fr.ratp.phoebus.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import poc.ratp.test.TestUnitaireDao;
import fr.ratp.phoebus.beanMetier.TestUnitaire;
import fr.ratp.phoebus.context.AppContext;
import fr.ratp.phoebus.dao.AgentsDao;

@Component
public class TemplateController {
	
	public Map<String, Object> getTests() throws Exception {
		
		//ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/config/testSpring.xml");
		//System.out.println(testUnitaireDao.getAll().size());

		// on se connecte à la base de données pour récupérer les tests unitaire
		// à lancer

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ratp", "ratp");

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from T_TEST_UNITAIRE");

		List<TestUnitaire> Classes = new ArrayList<TestUnitaire>();
		HashMap<String, Object> result = new HashMap<String, Object>();
	
		while (rs.next()) {

			TestUnitaire tu = new TestUnitaire();
			tu.setId_test(rs.getInt(1));
			tu.setClasse_test(rs.getString(2));
			tu.setNom(rs.getString(3));
			tu.setValeur(rs.getString(4));
			tu.setContext_json(rs.getString(5));
			tu.setDescription(rs.getString(6));

			Classes.add(tu);
			

		}
		
		result.put("classes", Classes);
			

				

		return result;
	}

}
