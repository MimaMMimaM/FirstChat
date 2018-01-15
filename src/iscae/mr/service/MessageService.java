package iscae.mr.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;




import iscae.mr.Database.DataBClasse;
import iscae.mr.Model.message;

public class MessageService {
	
	private static Map<Long, message> messages = DataBClasse.getmessages();

	public    List<message> getToutMessage() {
       
		return new ArrayList<message>(messages.values());

	}
	
	public  List<message> gettoutPourAne(int  year){
		List<message> messagePourAne=new ArrayList<>();
		Calendar cal =Calendar.getInstance();
		for(message message:messages.values()){
			cal.setTime(message.getDate());
			if(cal.get(Calendar.YEAR)== year){
				messagePourAne.add(message);
			}
			
		}
		return messagePourAne;
	}

	public List<message> getToutPaginated(int start,int size){
		List<message> list=new ArrayList<>(messages.values());
		if(start+ size >list.size()) return new ArrayList<message>();
			return list.subList(start, start+ size);
		
	}
	
	public message getmessage(long id) {
		return messages.get(id);
	}

	public   message addmessage(message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public   message updatemessage(message message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public   void delatemessage(long id) {
		 messages.remove(id);
	}

	public  List<message> messagePourAne(int year) {
		// TODO Auto-generated method stub
		return null;
	
	}
}
