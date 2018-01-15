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

import iscae.mr.Model.Comment;
import iscae.mr.service.CommentService;

@Path("/commant")
@Consumes(MediaType.APPLICATION_JSON)
@Produces("application/json")

public class CommantResource {
	
	private CommentService commentservice =new CommentService();
	
	   @GET
		public List<Comment> gettoutComment(@PathParam("messageID") long messageID)
		{
		   
			return commentservice.getToutComment(messageID);
		}
	   
	   @POST	  
	   public Comment addComment(@PathParam("messageID") long messageID,Comment comment){
		   return commentservice.addComment(messageID, comment);
		   
	   }
	   
	   @POST
	   @Path("/{commentID}") 
	   public Comment UpdateComment(@PathParam("messageID") long messageID,@PathParam("commentID") long id,Comment comment){
		  comment.setId(id);
		   return commentservice.updateComment(messageID, comment);
		  
	   }
	   
	   @PUT
	   @Path("/{commentID}")
	   public void deletComment(@PathParam("messageID") long messageID,@PathParam("commentID") long commentID){
		 
		    commentservice.delateComment(messageID, commentID);
		  
	   }
	   
	   @GET
	   @Path("/{commentID}")
		public Comment getComment(@PathParam("messageID") long messageID,@PathParam("commentID") long commentID)
		{
			return commentservice.getComment(messageID, commentID);
		}

}
