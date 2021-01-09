package org.limayrac.banque_bdd.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.limayrac.banque_bdd.entities.Compte;
import org.limayrac.banque_bdd.entities.Log;
import org.limayrac.banque_bdd.util.BanqueException;

public class HibernateLog implements LogDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void ajouterLog(Log log) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(log);
		} catch(HibernateException e){
			throw new BanqueException("Erreur d'enregistrement du log.");
		}
	}

}
