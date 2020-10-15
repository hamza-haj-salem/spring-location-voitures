package tn.enig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enig.dao.ILocation;
import tn.enig.model.Client;
import tn.enig.model.Contrat;
import tn.enig.model.Voiture;

@Service
public class LocationServiceImp implements ILocationService {
	
	@Autowired
	private ILocation dao;
	
	public void setDao(ILocation dao) {
		this.dao = dao;
	}
	
	public void saveClient(Client c) {
		dao.saveClient(c);

	}

	public void saveVoiture(Voiture v) {
		dao.saveVoiture(v);
		
	}

	public void saveContrat(Contrat c) {
		dao.saveContrat(c);
		
	}

	public Client getClientById(int id) {
		return dao.getClientById(id);
	}

	public Voiture getVoiture(int id) {
		// TODO Auto-generated method stub
		return dao.getVoiture(id);
	}

	public List<Voiture> getAllVoitureNonLoue() {
		// TODO Auto-generated method stub
		return dao.getAllVoitureNonLoue();
	}

	public List<Contrat> getAllContrat() {
		// TODO Auto-generated method stub
		return dao.getAllContrat();
	}
	
	public List<Client> getAllClient(){
		return dao.getAllClient();
	}

}
