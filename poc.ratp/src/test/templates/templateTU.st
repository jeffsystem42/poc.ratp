templateTU(classes, robot, className) ::= <<
package poc.ratp.test;

/*

<classes:{each | 
@Autowired
<each.classe_test> processor_<each.classe_test>;
}>

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
public class <className> 
{

	@Autowired
	private TestUnitaireDao testUnitaireDao ;

    private ContextMatriculeItem itemInput;
	
	<classes:{each | 
	@Autowired
	<each.classe_test> processor_<each.classe_test><each.id_test>;
	}>

	
//	@Before
//	public void setUp() throws Exception {

//		MockitoAnnotations.initMocks(this);
//		itemInput = createMockItem();
//	}
	
	private ContextMatriculeItem createMockItemByIdTest(int i) {
		return(testUnitaireDao.getContextByIdTest(i));
	}


<classes:{each| 
   

     /**
	 * @throws Exception
	 */
	 
	@Test
	public void <each.classe_test><each.id_test>() throws Exception {

		// on cree le mock en allant le chercher dans la table des tests unitaires
		itemInput = createMockItemByIdTest(<each.id_test>);

		System.out.println("Lancement du test:<each.id_test> ==> <each.description> matricule:" + itemInput.getMatricule());
		
		// Attention, le processor modifie l'item !!
		ContextMatriculeItem itemOutput = processor_<each.classe_test><each.id_test>.process(itemInput);

		// on regarde le resultat du test
		Assert.assertEquals("<each.valeur>", getValue("<each.nom>", itemOutput) );
	 \}
   
}>

	public String getValue(String member, Object o) throws Exception {
		Field field = o.getClass().getDeclaredField(member);
		field.setAccessible(true);
		return field.get(o).toString();
	}

}
>>