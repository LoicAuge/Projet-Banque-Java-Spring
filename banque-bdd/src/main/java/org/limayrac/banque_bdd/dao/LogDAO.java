package org.limayrac.banque_bdd.dao;

import org.limayrac.banque_bdd.entities.Compte;
import org.limayrac.banque_bdd.entities.Log;
import org.limayrac.banque_bdd.util.BanqueException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface LogDAO {

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=BanqueException.class)
	public abstract void ajouterLog(Log log) throws BanqueException;
	
}
