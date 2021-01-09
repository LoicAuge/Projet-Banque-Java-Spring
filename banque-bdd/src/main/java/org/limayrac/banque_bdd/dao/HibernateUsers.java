package org.limayrac.banque_bdd.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.limayrac.banque_bdd.entities.Client;
import org.limayrac.banque_bdd.entities.Users;
import org.limayrac.banque_bdd.util.BanqueException;

public class HibernateUsers implements UsersDAO {

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Users rechercheUser(String username) throws BanqueException {
		try {
			return (Users) sessionFactory.getCurrentSession().get(Users.class, new String(username));
		} catch(HibernateException e){
			throw new BanqueException(e.getMessage());
		}
	}

	public void ajouterUser(Users user) throws BanqueException {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(user);
		} catch(HibernateException e){
			throw new BanqueException(e.getMessage());
		}
	}

}
