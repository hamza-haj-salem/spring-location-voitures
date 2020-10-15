package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.enig.model.Client;
import tn.enig.model.Contrat;
import tn.enig.model.Voiture;
import tn.enig.service.ILocationService;
@Controller
public class LocationController {
	
	@Autowired
	ILocationService service;

	public void setService(ILocationService service) {
		this.service = service;
	}
	
	@GetMapping("/home")
	//@RequestMapping(value="/listeVoiture",method=RequestMethod.GET)
	public String get1(Model m) { 
		List<Voiture> listeVoiture = service.getAllVoitureNonLoue();
		//envoyer ll jsp un model 
		m.addAttribute("listeVoiture",listeVoiture);
		return "home";
	}
	
	@GetMapping("/addClient")
	public String get12(Model m) {
		Client c=new Client();
		m.addAttribute("cl",c);
		return "ajoutClient";
	}
	
	@PostMapping("/saveClient")
	public String get13(Model m , @ModelAttribute("cl") Client c) {
		service.saveClient(c);
		return "redirect:/home";
	}
	

	@GetMapping("/addContrat")
	public String get15(Model m) {
		Contrat c=new Contrat();
		List<Client> clts = service.getAllClient();
		List<Voiture> vts = service.getAllVoitureNonLoue();
		m.addAttribute("cl",c);
		m.addAttribute("vts",vts);
		m.addAttribute("clts",clts);
		return "ajoutContrat";
	}
	
	@PostMapping("/saveContrat")
	public String get16(Model m , @ModelAttribute("cl") Contrat c) {
		service.saveContrat(c);
		return "redirect:/home"; //normalement contrats
	}
	
	
	@GetMapping("/contrats")
	public String get14(Model m) {
		List<Contrat> listeContrats = service.getAllContrat();
		m.addAttribute("listeContrats",listeContrats);
		return "ListContrats";
		
	}
	
	
	
	
	/*
	@RequestMapping(value="/listeContrat",method=RequestMethod.GET)
	public String get2(Model m) {
		List<Contrat>listeContrat = service.getAllContrat(); 
		m.addAttribute("listeContrat",listeContrat);
		return "contrat";
	}
	
	@RequestMapping(value="/addContrat",method=RequestMethod.GET)
	public String get3(Model m) {
		List<Voiture> liste2 = service.getAllVoitureNonLoue();
		List<Client> listeClient = service.getAllClient();
		m.addAttribute("liste2",liste2);
		m.addAttribute("listeClient",listeClient);
		return "addContrat";
	}
	
	@RequestMapping(value="/addClient",method=RequestMethod.GET)
	public String get4(Model m) {
		return "addClient";
	}
	
	*/
	
	

}
