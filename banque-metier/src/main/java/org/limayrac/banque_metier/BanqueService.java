package org.limayrac.banque_metier;

import java.util.List;

import org.limayrac.banque_bdd.entities.*;
import org.limayrac.banque_bdd.util.*;

public interface BanqueService {

	//public abstract Client authentifier(String id, String mdp) throws BanqueException;
	
	public abstract List<Compte> mesComptes(Integer idCli) throws BanqueException;
	
	public abstract void virement(Integer cptADebiter, Integer ctpACrediter, double montant) throws BanqueException;
}
