package iscae.mr.Model;

public class Profile {
	private long id;
	private String proFileNom;
	private String nom;
	private String email;
	public Profile() {
		
		
	}
	public Profile(long id, String proFileNom, String nom, String email) {
		super();
		this.id = id;
		this.proFileNom = proFileNom;
		this.nom = nom;
		this.email = email;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProFileNom() {
		return proFileNom;
	}
	public void setProFileNom(String proFileNom) {
		this.proFileNom = proFileNom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
 
	

}
