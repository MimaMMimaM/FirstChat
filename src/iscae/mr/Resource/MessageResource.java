package iscae.mr.Resource;

import java.net.URI;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import iscae.mr.Model.message;
import iscae.mr.service.MessageService;

@Path("/message")
@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/json")
public class MessageResource {
	
	
	 MessageService messageService = new MessageService();

	    @GET 
		public List<message> getmessage(@QueryParam("year") int year,
		                                @QueryParam("start") int start,
		                                @QueryParam("size") int size){
		  if( year > 0 ){
		     return messageService.messagePourAne(year);
		     }
		  if( start >=0 && size>=0 ){
			  return messageService.getToutPaginated(start, size);
		  }
		  return messageService.getToutMessage();
	  }
	  @POST
	  public Response addmasseges(message message,@Context UriInfo uriInfo) {
		 message newmessage = messageService.addmessage(message);
		 String newid =String.valueOf(newmessage.getId());
		 URI uri =uriInfo.getAbsolutePathBuilder().path(newid).build();
		  return Response.created(uri)
				  .entity(newmessage)
				  .build();
		  //return messageservice.addMessage(message);
	  }
	  
	  @PUT
	  @Path("/{messageId}")
	  @Consumes(MediaType.APPLICATION_JSON)
	  public message updateMasseges(@PathParam("messageId") long id,message message){
		 message.setId(id);
		  return messageService.updatemessage(message);
	  }
	
	  @DELETE
	  @Path("/{messageId}")
	  public void deletmasseges(@PathParam("messageId") long id){	 
		  messageService.delatemessage(id);
	  }
	  
	  @GET
	  @Path("/{messageId}")
	  public message getmasseges(@PathParam("messageId") long id){
		  return messageService.getmessage(id);
	  }
	  
	  
	   @Path("/{messageId}/comments")
		public CommantResource getCommentResource()
		{
			return new CommantResource();
		}
		
	
	}
	


