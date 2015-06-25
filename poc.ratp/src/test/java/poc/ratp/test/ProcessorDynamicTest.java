package poc.ratp.test;

/*

@Autowired
TestProcessorA processor_TestProcessorA;
@Autowired
TestProcessorA processor_TestProcessorA;
@Autowired
TestProcessorA processor_TestProcessorA;
@Autowired
TestProcessorB processor_TestProcessorB;
@Autowired
TestProcessorB processor_TestProcessorB;
@Autowired
TestProcessorA processor_TestProcessorA;


*/

/**
*
*   Classe generee automatiquement
*   Ne pas modifier !!!!!!!!!!!!!!!!!!!!!!!!!
**/

import org.junit.Assert; 
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.lang.reflect.Field; 

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import fr.ratp.phoebus.itemProcessor.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/testSpring.xml")
public class ProcessorDynamicTest 
{

	@Autowired
	private TestUnitaireDao testUnitaireDao ;

    private ContextMatriculeItem itemInput;

		@Autowired
		TestProcessorA processor_TestProcessorA1;
		@Autowired
		TestProcessorA processor_TestProcessorA2;
		@Autowired
		TestProcessorA processor_TestProcessorA3;
		@Autowired
		TestProcessorB processor_TestProcessorB4;
		@Autowired
		TestProcessorB processor_TestProcessorB5;
		@Autowired
		TestProcessorA processor_TestProcessorA6;



//	@Before
//	public void setUp() throws Exception {

//		MockitoAnnotations.initMocks(this);
//		itemInput = createMockItem();
//	}

	private ContextMatriculeItem createMockItemByIdTest(int i) {
		return(testUnitaireDao.getContextByIdTest(i));
	}



     /**
	 * @throws Exception
	 */

	@Test
	public void TestProcessorA1() throws Exception {

		// on cree le mock en allant le chercher dans la table des tests unitaires
		itemInput = createMockItemByIdTest(1);

		System.out.println("Lancement du test:1 ==> Contrôle du code contart matricule:" + itemInput.getMatricule());

		// Attention, le processor modifie l'item !!
		ContextMatriculeItem itemOutput = processor_TestProcessorA1.process(itemInput);

		// on regarde le resultat du test
		Assert.assertEquals("310", getValue("prime1", itemOutput) );
	 }


     /**
	 * @throws Exception
	 */

	@Test
	public void TestProcessorA2() throws Exception {

		// on cree le mock en allant le chercher dans la table des tests unitaires
		itemInput = createMockItemByIdTest(2);

		System.out.println("Lancement du test:2 ==> Calcul de la prime TS matricule:" + itemInput.getMatricule());

		// Attention, le processor modifie l'item !!
		ContextMatriculeItem itemOutput = processor_TestProcessorA2.process(itemInput);

		// on regarde le resultat du test
		Assert.assertEquals("330", getValue("prime1", itemOutput) );
	 }


     /**
	 * @throws Exception
	 */

	@Test
	public void TestProcessorA3() throws Exception {

		// on cree le mock en allant le chercher dans la table des tests unitaires
		itemInput = createMockItemByIdTest(3);

		System.out.println("Lancement du test:3 ==> Mise à jour du compteur Repos matricule:" + itemInput.getMatricule());

		// Attention, le processor modifie l'item !!
		ContextMatriculeItem itemOutput = processor_TestProcessorA3.process(itemInput);

		// on regarde le resultat du test
		Assert.assertEquals("345", getValue("prime1", itemOutput) );
	 }


     /**
	 * @throws Exception
	 */

	@Test
	public void TestProcessorB4() throws Exception {

		// on cree le mock en allant le chercher dans la table des tests unitaires
		itemInput = createMockItemByIdTest(4);

		System.out.println("Lancement du test:4 ==> Divise la prime2 par 2 matricule:" + itemInput.getMatricule());

		// Attention, le processor modifie l'item !!
		ContextMatriculeItem itemOutput = processor_TestProcessorB4.process(itemInput);

		// on regarde le resultat du test
		Assert.assertEquals("50", getValue("prime2", itemOutput) );
	 }


     /**
	 * @throws Exception
	 */

	@Test
	public void TestProcessorB5() throws Exception {

		// on cree le mock en allant le chercher dans la table des tests unitaires
		itemInput = createMockItemByIdTest(5);

		System.out.println("Lancement du test:5 ==> Ajoute 1 à prime3 matricule:" + itemInput.getMatricule());

		// Attention, le processor modifie l'item !!
		ContextMatriculeItem itemOutput = processor_TestProcessorB5.process(itemInput);

		// on regarde le resultat du test
		Assert.assertEquals("2", getValue("prime3", itemOutput) );
	 }


     /**
	 * @throws Exception
	 */

	@Test
	public void TestProcessorA6() throws Exception {

		// on cree le mock en allant le chercher dans la table des tests unitaires
		itemInput = createMockItemByIdTest(6);

		System.out.println("Lancement du test:6 ==> Vérification qu'on ne touche pas à prime2 matricule:" + itemInput.getMatricule());

		// Attention, le processor modifie l'item !!
		ContextMatriculeItem itemOutput = processor_TestProcessorA6.process(itemInput);

		// on regarde le resultat du test
		Assert.assertEquals("16", getValue("prime2", itemOutput) );
	 }



	public String getValue(String member, Object o) throws Exception {
		Field field = o.getClass().getDeclaredField(member);
		field.setAccessible(true);
		return field.get(o).toString();
	}

}