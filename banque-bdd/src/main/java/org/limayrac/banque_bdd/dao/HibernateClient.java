package org.limayrac.banque_bdd.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.limayrac.banque_bdd.entities.Client;
import org.limayrac.banque_bdd.entities.Users;
import org.limayrac.banque_bdd.util.BanqueException;

public class HibernateClient implements ClientDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void ajouterClient(Client client) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(client);
		} catch(HibernateException e){
			throw new BanqueException(e.getMessage());
		}
	}

	public Client rechercheClientparID(long id) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			return (Client) sessionFactory.getCurrentSession().get(Client.class, new Long(id));
		} catch(HibernateException e){
			throw new BanqueException(e.getMessage());
		}
	}

	public List<Client> rechercheToutClients() throws BanqueException {
		// TODO Auto-generated method stub
		try {
			String hql = "from Client";
			return sessionFactory.getCurrentSession().createQuery(hql).list();
		} catch(HibernateException e){
			throw new BanqueException(e.getMessage());
		}
	}
	
	public void modifierClient(Client client) throws BanqueException{
		try {
			sessionFactory.getCurrentSession().update(client);
		} catch(HibernateException e){
			throw new BanqueException(e.getMessage());
		}
	}
	
	public void supprimerClient(Client client) throws BanqueException{
		try {
			sessionFactory.getCurrentSession().delete(client);
		} catch(HibernateException e){
			throw new BanqueException(e.getMessage());
		}
	}
	
	public Client rechercheClientparUser(String username) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			String hql = "from Client where username='";
			return (Client) sessionFactory.getCurrentSession().createQuery(hql+username+"'").list().get(0);
		} catch(HibernateException e){
			throw new BanqueException(e.getMessage());
		}
	}

}
