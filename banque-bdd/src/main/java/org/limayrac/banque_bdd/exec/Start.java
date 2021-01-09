package org.limayrac.banque_bdd.exec;

import org.limayrac.banque_bdd.dao.ClientDAO;
import org.limayrac.banque_bdd.dao.CompteDAO;
import org.limayrac.banque_bdd.entities.Client;
import org.limayrac.banque_bdd.entities.Compte;
import org.limayrac.banque_bdd.util.BanqueException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	private static ApplicationContext context;
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("bdd-context.xml");
		Client c = new Client();
		c.setNom("AUGE");
		c.setPrenom("Loïc");
		c.setAdresse("ici mdr");
		c.setCodepostal(31200);
		c.setVille("TLSE");
		//c.setMotdepasse("bonsoir");
		ClientDAO cDAO = (ClientDAO) context.getBean("clientDAO");
		try {
			cDAO.ajouterClient(c);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		Compte cpt = new Compte();
		cpt.setClient(c);
		cpt.setSolde(50);
		cpt.setNumero(5);
		CompteDAO cptDAO = (CompteDAO) context.getBean("compteDAO");
		try {
			cptDAO.ajouterCompte(cpt);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
