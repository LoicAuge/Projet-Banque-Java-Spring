package org.limayrac.banque_bdd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.limayrac.banque_bdd.entities.Client;
import org.limayrac.banque_bdd.entities.Compte;
import org.limayrac.banque_bdd.util.BanqueException;

public class HibernateCompte implements CompteDAO {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void ajouterCompte(Compte compte) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(compte);
		} catch(HibernateException e){
			throw new BanqueException("Erreur d'enregistrement du compte.");
		}
	}

	public Compte rechercheCompteparNum(Integer num) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			String hql = "from Compte where numero=";
			return (Compte) sessionFactory.getCurrentSession().createQuery(hql+num.toString()).list().get(0);
		} catch(HibernateException e){
			throw new BanqueException("Erreur de recherche du compte.");
		}
	}

	public List<Compte> rechercheComptesClient(Integer idCli) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			String hql = "from Compte where idClient=";
			return sessionFactory.getCurrentSession().createQuery(hql+idCli.toString()).list();
		} catch(HibernateException e){
			throw new BanqueException("Erreur de recherche des comptes.");
		}
	}

	public void modifierCompte(Compte compte) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().merge(compte);
		} catch(HibernateException e){
			throw new BanqueException("Erreur de modification du compte.");
		}
	}
	
	public void suppressionCompte(Compte compte) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(compte);
		} catch(HibernateException e){
			throw new BanqueException("Erreur de modification du compte.");
		}
	}

}
