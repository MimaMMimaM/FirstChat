package iscae.mr.Model;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@XmlRootElement

public class message {
    
	private long id;
	
	
	private Date date;
	private String dateR;
	private String message;
	private String name;
	//private Date todateDate=getDatecreation();
	private Map<Long, Comment> comments= new HashMap<>();
	
	 public message(){
		
		//this.creatdatetosring= todateDate.toGMTString();
		//this.datecreation=datecreation.toGMTString();
	}
	
	public message(long id, String message, String name) {
		
		this.id = id;
		this.message = message;
		
		//this.creatdatetosring=getDatecreation().toGMTString();//datecreation.toGMTString();
		//this.creatdate = new Date();
		
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date= new Date();
	}

	public String getDateR() {
		return getDate().toString();
	}

	

	public void setDateR(String DateR) {
		this.dateR = DateR;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}
	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}
	
}
