package fr.ratp.phoebus.itemProcessor;



import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;

/**
 * Created by vermelinj on 22/05/2015.
 */

public class TestProcessor extends AbstractPrimeCalculator {


	public ContextMatriculeItem process(ContextMatriculeItem item) throws Exception {

		
		// on ajoute 300 à la prime
		item.setPrime1(item.getPrime1() + 300);

		return item;
	}

}