package org.limayrac.banque;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.limayrac.banque_bdd.dao.ClientDAO;
import org.limayrac.banque_bdd.dao.CompteDAO;
import org.limayrac.banque_bdd.dao.LogDAO;
import org.limayrac.banque_bdd.dao.UsersDAO;
import org.limayrac.banque_bdd.entities.Client;
import org.limayrac.banque_bdd.entities.Compte;
import org.limayrac.banque_bdd.entities.Users;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.RequestContextHolder;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static ApplicationContext context = new ClassPathXmlApplicationContext("bdd-context.xml");
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/admin/homeAdmin**", method = RequestMethod.GET)
	public String adminPage( Model model) {
	
		model.addAttribute("message", "Page d'administation");
		String username = null;
		User princ = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = princ.getUsername();
	
		model.addAttribute("username", username);
		
		return "homeAdmin";
	}
	
	@RequestMapping(value = "/user/homeUser**", method = RequestMethod.GET)
	public String userPage( Model model) {
		
		CompteDAO cptDAO = (CompteDAO) context.getBean("compteDAO");
		ClientDAO cliDAO = (ClientDAO) context.getBean("clientDAO");
		//LogDAO logDAO = (LogDAO) context.getBean("logDAO");
		//UsersDAO usersDAO = (UsersDAO) context.getBean("usersDAO");
		Client cli = null;
		List<Compte> cpts = null;
		Users user = null;
		model.addAttribute("message", "Page d'administation");
		String username = null;
		User princ = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = princ.getUsername();
	
		model.addAttribute("username", username);
		
		try {
			cli = cliDAO.rechercheClientparUser(username);
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("client",cli);
		try {
			cpts = cptDAO.rechercheComptesClient((int) cli.getId());
		} catch (BanqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("comptes", cpts);
		
		return "homeClient";
	}
	
	@RequestMapping(value = "/login**", method = RequestMethod.GET)
	public String login( Model model) {
	
		//model.addAttribute("message", "Page d'administation");
		
		return "login";
	}
	
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(Model model) {
        model.addAttribute("error", "true");
        return "denied";
    }
	
}
