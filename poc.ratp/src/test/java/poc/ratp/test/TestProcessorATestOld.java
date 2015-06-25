package poc.ratp.test;

import java.lang.reflect.Field; 
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import fr.ratp.phoebus.beanMetier.TestUnitaire;
import fr.ratp.phoebus.context.AppContext;
import fr.ratp.phoebus.dao.AgentsDao;
import fr.ratp.phoebus.itemProcessor.TestProcessor;
import fr.ratp.phoebus.itemProcessor.TestProcessorA;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/testSpring.xml")
public class TestProcessorATestOld {

	@Autowired
	private TestUnitaireDao testUnitaireDao;

	@Autowired
	private AgentsDao agentsDao;

	private ContextMatriculeItem itemInput;

	@Autowired
	TestProcessorA processor;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		itemInput = createMockItem();
	}

	// on construit un item en entrée
	private ContextMatriculeItem createMockItem() {

		// on recupere la DAO
		ContextMatriculeItem cmi = new ContextMatriculeItem();
		cmi.setPrime1(10);
		cmi.setDateTrt(new Date());
		cmi.setMatricule("001245");

		cmi.setCompteurA(new BigDecimal("12.33"));
		cmi.setCompteurB(new BigDecimal("49912.33"));

		Gson gs = new GsonBuilder().setPrettyPrinting().create();

		System.out.println(gs.toJson(cmi));

		return cmi;
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testProcess() throws Exception {

		// ApplicationContext applicationContext =
		// AppContext.getApplicationContext();
		// AgentsDao totoDao =
		// (AgentsDao)applicationContext.getBean("agentsDao");

		// System.out.println("dans TU:" + totoDao.getAll().size());

		// Attention, le processor modifie l'item !!
		ContextMatriculeItem itemOutput = processor.process(itemInput);

		String champs2 = "310";

		Assert.assertEquals(getValue("prime1", itemOutput), champs2);

	

	}

	public String getValue(String member, Object o) throws Exception {
		Field field = o.getClass().getDeclaredField(member);
		field.setAccessible(true);
		return field.get(o).toString();

	}

}
