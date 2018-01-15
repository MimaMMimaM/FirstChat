package iscae.mr;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Utilisateur")
@Produces("application/json")
public class UtilisateurGestion {
	
	private static Map<Integer, info_utilisateur> memoire = new HashMap<>();

	@GET
	public Map<Integer, info_utilisateur> getValue() {
		return memoire;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void insert(Data_utlisateur data) {
      
		memoire.put(data.id, data.info_utilisateur);
      
	}

	// information de utilisateur nouveul 
	public static class info_utilisateur {
		String Nom;
		String email;
		String passWord;

	}

	// Data de utilisateur 
	public static class Data_utlisateur {
		Integer id;
		info_utilisateur info_utilisateur;

	}

}
