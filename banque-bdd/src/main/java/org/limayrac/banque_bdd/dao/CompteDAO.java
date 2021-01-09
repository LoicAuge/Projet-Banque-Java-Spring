package org.limayrac.banque_bdd.dao;

import java.util.List;
import org.limayrac.banque_bdd.entities.*;
import org.limayrac.banque_bdd.util.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface CompteDAO {

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=BanqueException.class)
	public abstract void ajouterCompte(Compte compte) throws BanqueException;
	
	@Transactional(propagation=Propagation.NEVER)
	public abstract Compte rechercheCompteparNum(Integer num) throws BanqueException;
	
	@Transactional(propagation=Propagation.NEVER)
	public abstract List<Compte> rechercheComptesClient(Integer idCli) throws BanqueException;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=BanqueException.class)
	public abstract void modifierCompte(Compte compte) throws BanqueException;
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=BanqueException.class)
	public abstract void suppressionCompte(Compte compte) throws BanqueException;
	
}
