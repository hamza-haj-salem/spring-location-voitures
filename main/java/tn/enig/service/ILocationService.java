package tn.enig.service;

import java.util.List;

import tn.enig.model.Client;
import tn.enig.model.Contrat;
import tn.enig.model.Voiture;

public interface ILocationService {
	
	public void saveClient(Client c);
	public void saveVoiture(Voiture v);
	public void saveContrat(Contrat c);
	
	public Client getClientById(int id);
	public Voiture getVoiture(int id);
	
	public List<Voiture> getAllVoitureNonLoue();
	public List<Contrat> getAllContrat();
	public List<Client> getAllClient();

}
