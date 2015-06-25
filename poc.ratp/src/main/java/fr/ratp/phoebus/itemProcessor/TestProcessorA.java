package fr.ratp.phoebus.itemProcessor;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Scope;
import javax.sql.DataSource;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import fr.ratp.phoebus.beanMetier.ContextMatriculeItem;
import fr.ratp.phoebus.context.AppContext;
import fr.ratp.phoebus.dao.AgentsDao;

/**
 * Created by vermelinj on 22/05/2015.
 */
@Component
public class TestProcessorA implements ItemProcessor<ContextMatriculeItem, ContextMatriculeItem> {

	@Autowired
	AgentsDao agentsDao;

	public ContextMatriculeItem process(ContextMatriculeItem item) throws Exception {

		// on recupere la DAO par le contexte si Spring n'arrive pas à l'injecter
		// c'est le cas lorsqu'on instancie dynamiquement la chaine, on fait des new à la place de Spring
		// par contre pour les tests unitaires, l'injection fonctionne mais pas la recherche dans le contexte
		if (agentsDao == null) {
			ApplicationContext applicationContext = AppContext.getApplicationContext();
			agentsDao = (AgentsDao) applicationContext.getBean("agentsDao");
		}

		// on fait une requete dans la base pour vérifier que ca marche bien
		//agentsDao.getAll().size();
		
		System.out.println(item.getMatricule());
		

		// on ajoute 300 à la prime
		item.setPrime1(item.getPrime1() + 300);

		return item;
	}

	// public ContextMatriculeItem process(ContextMatriculeItem item,
	// ApplicationContext app) throws Exception {

	// ApplicationContext applicationContext =
	// AppContext.getApplicationContext();
	// AgentsDao agentsDao = (AgentsDao)
	// applicationContext.getBean("agentsDao");

	// AgentsDao agentsDao = (AgentsDao) app.getBean(AgentsDao.class);

	// on ajoute 300 à la prime
	// item.setPrime1(item.getPrime1() + 300);

	// System.out.println(agentsDao.getAll().size());

	// return item;
	// }

}