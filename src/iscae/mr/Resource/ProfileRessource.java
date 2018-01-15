package iscae.mr.Resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import iscae.mr.Model.Profile;
import iscae.mr.service.ProfileService;

@Path("/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProfileRessource {
	
	ProfileService profileservice = new ProfileService();
	@GET 
	public List<Profile> getProfile()
	 {
		  return profileservice.getToutProfile();
	  }
	 
	 @POST
	  public Profile addtProfile(Profile profile){
		  return profileservice.addProfile(profile);
	  }
	 
	  @GET
	  @Path("/{profileNom}")
	  public Profile getProfile(@PathParam("profileNom") String profileNom){
		  return profileservice.getProfile(profileNom);
	  }
	
	  @PUT
	  @Path("/{profileNom}")
	  public Profile updateProfile(@PathParam("profileNom") String profileNom,Profile profile){
		profile.setProFileNom(profileNom);
		  return profileservice.updateProfile(profile);
	
	
	  }
}
