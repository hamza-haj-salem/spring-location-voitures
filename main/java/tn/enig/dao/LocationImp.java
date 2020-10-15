package tn.enig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;



import tn.enig.model.Client;
import tn.enig.model.Contrat;
import tn.enig.model.Voiture;

@Repository
public class LocationImp implements ILocation {
	
	@Autowired
	@Qualifier("dataSource")
	DataSource data;
	
	public void setData(DataSource data) {
		this.data = data;
	}

	public void saveClient(Client c) {
		try {
			Connection con = data.getConnection();
			PreparedStatement pre =con.prepareStatement("insert into client values(?,?,?)"); 
			pre.setInt(1, c.getNumPermis());
			pre.setString(2, c.getNom());
			pre.setString(3, c.getAdress());
			// 3ndi: 1/insert 2/select 3/update 4/delete --- 1+3+4: reqs de modif==> executeUpdate --  2 req selection==> executeQuery --> hathi lezem n7otha f vbl de type resulteSet
			pre.executeUpdate();
		}catch (Exception e) {
		// TODO: handle exception
		}
		
	}

	public void saveVoiture(Voiture v) {
		try {
			Connection con = data.getConnection();
			PreparedStatement pre =con.prepareStatement("insert into voiture values(null,?,?,?)"); 
			pre.setString(1, v.getMarque());
			pre.setString(2, v.getCategorie());
			pre.setBoolean(3, v.getDisponobilite());
			// 3ndi: 1/insert 2/select 3/update 4/delete --- 1+3+4: reqs de modif==> executeUpdate --  2 req selection==> executeQuery --> hathi lezem n7otha f vbl de type resulteSet
			pre.executeUpdate();
		}catch (Exception e) {
		// TODO: handle exception
		}
		
		
	}

	public void saveContrat(Contrat c) {
		try {
			Connection con = data.getConnection();
			PreparedStatement pre =con.prepareStatement("insert into contrat values(null,?,?,?,?)"); 
			pre.setInt(1, c.getClient().getNumPermis());
			pre.setInt(2, c.getVoiture().getId());
			pre.setString(3, c.getDateDebut());
			pre.setString(4, c.getDateFin());
			// 3ndi: 1/insert 2/select 3/update 4/delete --- 1+3+4: reqs de modif==> executeUpdate --  2 req selection==> executeQuery --> hathi lezem n7otha f vbl de type resulteSet
			pre.executeUpdate();
		}catch (Exception e) {
		// TODO: handle exception
		}
		
	}

	public Client getClientById(int id) { //n7ather 7aja far8a bch nrecuperi fiha
		Client c=null;
		try {
			
			Connection con = data.getConnection();
			PreparedStatement pre =con.prepareStatement("select * from client where numPermis=?"); 
			pre.setInt(1, id);
			ResultSet rs= pre.executeQuery();
			if(rs.next()) { //5ater obj wa7ed
				c = new Client(rs.getInt("numPermis"),rs.getString("nom"),rs.getString("adress"));
				
			}
		}catch (Exception e) {
		
		}
		return c;
	}

	public Voiture getVoiture(int id) {
		Voiture v=null;
		try {
			
			Connection con = data.getConnection();
			PreparedStatement pre =con.prepareStatement("select * from voiture where id=?"); 
			pre.setInt(1, id);
			ResultSet rs= pre.executeQuery();
			if(rs.next()) {
				v = new Voiture(rs.getInt("id"),rs.getString("marque"),rs.getString("categorie"));
				
			}
		}catch (Exception e) {
		
		}return v;
	}

	public List<Voiture> getAllVoitureNonLoue() {
		List<Voiture> liste=null;
		try {
			liste= new ArrayList<Voiture>();
			Connection con = data.getConnection();
			PreparedStatement pre =con.prepareStatement("select * from voiture where disponobilite=?"); 
			pre.setString(1, "true");
			ResultSet rs= pre.executeQuery();
			while(rs.next()) {
				Voiture lv = new Voiture(rs.getInt("id"),rs.getString("marque"),rs.getString("categorie"));
				liste.add(lv);
			}
		}catch (Exception e) {
		// TODO: handle exception
		}
		
		return liste;
	}

	public List<Contrat> getAllContrat() {
		
		List<Contrat> liste=null;
		try {
			liste= new ArrayList<Contrat>();
			Connection con = data.getConnection();
			PreparedStatement pre =con.prepareStatement("select * from contrat"); 
	
			ResultSet rs= pre.executeQuery();
			while(rs.next()) {
				Client cl = getClientById(rs.getInt("client"));
				Voiture v = getVoiture(rs.getInt("voiture"));
				Contrat lc = new Contrat(rs.getInt("id"),cl,v,rs.getString("dateDebut"),rs.getString("dateFin"));
				liste.add(lc);
			}
		}catch (Exception e) {
		// TODO: handle exception
		}
		return liste;
	}
	
	public List<Client> getAllClient(){
		List<Client> liste=null;
		try {
			liste= new ArrayList<Client>();
			Connection con = data.getConnection();
			PreparedStatement pre =con.prepareStatement("select * from client"); 
	
			ResultSet rs= pre.executeQuery();
			while(rs.next()) {
				
				Client lc = new Client(rs.getInt("numPermis"),rs.getString("nom"),rs.getString("adress"));
				liste.add(lc);
			}
		}catch (Exception e) {
		// TODO: handle exception
		}
		return liste;
	}
	
	public static void main(String[] args) {
		ILocation ll = new LocationImp();
		List<Voiture> lv = ll.getAllVoitureNonLoue();
		System.out.println(lv);
	}

}
