package org.limayrac.banque_bdd.dao;

import java.util.List;



import org.limayrac.banque_bdd.entities.Client;
import org.limayrac.banque_bdd.entities.Users;
import org.limayrac.banque_bdd.util.BanqueException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface ClientDAO {

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=BanqueException.class)
	public abstract void ajouterClient(Client client) throws BanqueException;
	
	@Transactional(propagation=Propagation.NEVER)
	public abstract Client rechercheClientparID(long id) throws BanqueException;
	
	@Transactional(propagation=Propagation.NEVER)
	public abstract List<Client> rechercheToutClients() throws BanqueException;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=BanqueException.class)
	public abstract void modifierClient(Client client) throws BanqueException;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=BanqueException.class)
	public abstract void supprimerClient(Client client) throws BanqueException;
	
	@Transactional(propagation=Propagation.NEVER)
	public abstract Client rechercheClientparUser(String username) throws BanqueException;
}
