package org.limayrac.banque_metier;

import java.util.List;

import org.limayrac.banque_bdd.dao.*;
import org.limayrac.banque_bdd.entities.Client;
import org.limayrac.banque_bdd.entities.Compte;
import org.limayrac.banque_bdd.util.BanqueException;

public class BanqueServiceImpl implements BanqueService {
	
	ClientDAO cliDAO;
	CompteDAO cptDAO;

	public void setCliDAO(ClientDAO cliDAO) {
		this.cliDAO = cliDAO;
	}

	public void setCptDAO(CompteDAO cptDAO) {
		this.cptDAO = cptDAO;
	}

	/*public Client authentifier(String id, String mdp) throws BanqueException {
		try {
			Client cli = cliDAO.rechercheClientparID(Long.parseLong(id));
			if(cli != null) {
				if(cli.getMotdepasse().equals(mdp)) {
					return cli;
				} else {
					throw new BanqueException("Mot de passe faux.");
				}
			}else {
				throw new BanqueException("Client introuvable.");
			}
		} catch (Exception e){
			e.printStackTrace();
			throw new BanqueException("Erreur d'authentification.");
		}
	}*/

	public List<Compte> mesComptes(Integer idCli) throws BanqueException {
		try {
			return cptDAO.rechercheComptesClient(idCli);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BanqueException("Erreur de récupération de comptes.");
		}
	}

	public void virement(Integer cptADebiter, Integer ctpACrediter, double montant) throws BanqueException {
		try {
			Compte cptDebit = cptDAO.rechercheCompteparNum(cptADebiter);
			Compte cptCredit = cptDAO.rechercheCompteparNum(ctpACrediter);
			
			cptDebit.setSolde(cptDebit.getSolde()-montant);
			cptCredit.setSolde(cptCredit.getSolde()+montant);
			
			cptDAO.modifierCompte(cptDebit);
			cptDAO.modifierCompte(cptCredit);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BanqueException("Erreur de l'enregistrement du virement.");
		}

	}

}
