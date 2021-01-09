package org.limayrac.banque;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.limayrac.banque_bdd.dao.*;
import org.limayrac.banque_bdd.entities.*;
import org.limayrac.banque_bdd.util.BanqueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WindowsController {

	private static ApplicationContext context = new ClassPathXmlApplicationContext("bdd-context.xml");
	
	@RequestMapping(value="/admin/listingClient")
	public String afficherClients(Model model) {
		ClientDAO cliDAO = (ClientDAO) context.getBean("clientDAO");
		CompteDAO cptDAO = (CompteDAO) context.getBean("compteDAO");
		LogDAO logDAO = (LogDAO) context.getBean("logDAO");
		List<Client> clients = null;
		List<Object[]> result = new ArrayList<Object[]>();
		String username = null;
		User princ = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = princ.getUsername();
	
		model.addAttribute("username", username);
		try {
			clients = cliDAO.rechercheToutClients();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		for(int i=0;i<clients.size();i++) {
			Object[] res = new Object[2];
			res[0]=clients.get(i);
			try {
				res[1]=cptDAO.rechercheComptesClient((int)clients.get(i).getId()).size();
			} catch (BanqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result.add(res);
		}
		
		model.addAttribute("clients",result);
		return "listingClient";
	}
	
	@RequestMapping(value="/admin/createCompte")
	public String afficherClients(@RequestParam Integer idCli, Model model) {
		
		CompteDAO cptDAO = (CompteDAO) context.getBean("compteDAO");
		ClientDAO cliDAO = (ClientDAO) context.getBean("clientDAO");
		LogDAO logDAO = (LogDAO) context.getBean("logDAO");
		Compte cpt = new Compte();
		Client cli = null;
		String username = null;
		User princ = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = princ.getUsername();
	
		model.addAttribute("username", username);
		try {
			cli = cliDAO.rechercheClientparID(idCli);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpt.setClient(cli);
		cpt.setSolde(0);
		try {
			cptDAO.ajouterCompte(cpt);
			Log log = new Log();
			log.setLog("M�thode ajouterCompte() appel�e pour le compte "+ cpt.getNumero() +".");
			log.setDate(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
			logDAO.ajouterLog(log);
			model.addAttribute("msg", "Le compte a bien �t� cr��.");
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "Erreur � la cr�ation du compte.");
		}
		model.addAttribute("url", "/banque/admin/listingClient");
		return "msg";
	}
	
	
	@RequestMapping(value="/**/listingCompte")
	public String afficherComptes(@RequestParam Integer idCli, Model model) {
		
		CompteDAO cptDAO = (CompteDAO) context.getBean("compteDAO");
		ClientDAO cliDAO = (ClientDAO) context.getBean("clientDAO");
		LogDAO logDAO = (LogDAO) context.getBean("logDAO");
		Client cli = null;
		List<Compte> cpts = null;
		String username = null;
		User princ = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = princ.getUsername();
	
		model.addAttribute("username", username);
		try {
			cli = cliDAO.rechercheClientparID(idCli);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("client",cli);
		try {
			cpts = cptDAO.rechercheComptesClient(idCli);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("comptes", cpts);
		
		return "listingCompte";
	}
	
@RequestMapping(value="/admin/supprCpt")
public String supprCompte(@RequestParam Integer idCpt, @RequestParam Integer idCli, Model model) {
	
	CompteDAO cptDAO = (CompteDAO) context.getBean("compteDAO");
	LogDAO logDAO = (LogDAO) context.getBean("logDAO");
	String username = null;
	User princ = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	username = princ.getUsername();

	model.addAttribute("username", username);
	try {
		Compte cpt = cptDAO.rechercheCompteparNum(idCpt);
		if(cpt.getSolde() == 0) {
			cptDAO.suppressionCompte(cpt);
			Log log = new Log();
			log.setLog("M�thode suppressionCompte() appel�e pour le compte "+ cpt.getNumero() +".");
			log.setDate(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
			logDAO.ajouterLog(log);
			model.addAttribute("msg", "Le compte a �t� supprim�");
		}else {
			model.addAttribute("msg", "Le solde du compte doit �tre � 0 pour �tre supprim�.");
		}
	} catch (BanqueException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	model.addAttribute("url", "/banque/admin/listingCompte?idCli="+idCli);
	return "msg";
}

@RequestMapping(value="/admin/supprCli")
public String supprClient(@RequestParam Integer idCli, Model model) {
	
	CompteDAO cptDAO = (CompteDAO) context.getBean("compteDAO");
	ClientDAO cliDAO = (ClientDAO) context.getBean("clientDAO");
	LogDAO logDAO = (LogDAO) context.getBean("logDAO");
	boolean supp = true;
	String username = null;
	User princ = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	username = princ.getUsername();

	model.addAttribute("username", username);
	try {
		List<Compte> cpts = cptDAO.rechercheComptesClient(idCli);
		for(int i=0;i<cpts.size();i++) {
			if(cpts.get(i).getSolde() != 0) {
				supp = false;
			}
		}
		if(supp) {
			for(int i=0;i<cpts.size();i++) {
				cptDAO.suppressionCompte(cpts.get(i));
				Log log = new Log();
				log.setLog("M�thode suppressionCompte() appel�e pour le compte "+ cpts.get(i).getNumero() +".");
				log.setDate(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
				logDAO.ajouterLog(log);
			}
			Client cli = cliDAO.rechercheClientparID(idCli);
			cliDAO.supprimerClient(cli);
			Log log = new Log();
			log.setLog("M�thode supprimerClient() appel�e pour le client "+ cli.getId() +".");
			log.setDate(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
			logDAO.ajouterLog(log);
			model.addAttribute("msg", "Le client a �t� supprim�");
		}else {
			model.addAttribute("msg", "Le solde des comptes doit �tre � 0 pour supprimer le client.");
		}
	} catch (BanqueException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	model.addAttribute("url", "/banque/admin/listingClient");
	return "msg";
}
}
