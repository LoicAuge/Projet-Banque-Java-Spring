package org.limayrac.banque_bdd.dao;

import org.limayrac.banque_bdd.entities.Client;
import org.limayrac.banque_bdd.entities.Users;
import org.limayrac.banque_bdd.util.BanqueException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UsersDAO {

	@Transactional(propagation=Propagation.NEVER)
	public abstract Users rechercheUser(String username) throws BanqueException;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=BanqueException.class)
	public abstract void ajouterUser(Users user) throws BanqueException;
}
