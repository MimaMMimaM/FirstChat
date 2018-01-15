package iscae.mr.Resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injVar")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)

public class InjVarResource {
	
	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("pame") String matrixppam,
			                                @HeaderParam("Authorization") String Header,
			                                @CookieParam("name") String cookie){
		return "Test " + matrixppam+ "Header Param : "+Header + " Cookie :" + cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders headers){
		String path =uriInfo.getAbsolutePath().toString();
		String cookis=headers.getCookies().toString();
		return "Path : "+path +"Cookie "+cookis;
	}
	

}
