package iscae.mr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iscae.mr.Database.DataBClasse;
import iscae.mr.Model.Comment;
import iscae.mr.Model.message;

public class CommentService {
	
	private static Map<Long, message> messages = DataBClasse.getmessages();

	public List<Comment> getToutComment(long messageID) {
		Map<Long,Comment> comments = messages.get(messageID).getComments();
		return new ArrayList<Comment>(comments.values());

	}
	
	public Comment getComment(long messageID,long commentID) {
		Map<Long,Comment> comments = messages.get(messageID).getComments();
		return comments.get(commentID);
	}
	
	public Comment addComment(long messageID,Comment comment) {
		Map<Long,Comment> comments = messages.get(messageID).getComments();
		comment.setId(messages.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageID,Comment comment) {
		Map<Long,Comment> comments = messages.get(messageID).getComments();
		if (comment.getId() <= 0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}

	public void delateComment(long messageID,long commentID) {
		Map<Long,Comment> comments = messages.get(messageID).getComments();
		comments.remove(commentID);
	}

}
