package org.sameer.javaweb.messenger.resources;

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
import javax.ws.rs.core.MediaType;

import org.sameer.javaweb.messenger.service.MessageService;
import org.sameer.javaweb.messenger.model.*;;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size")int size){
		if(year>0){
			return messageService.getAllMessagesYear(year);
		}
		if (start>=0 && size >0){
			return messageService.getMessagesPaginated(start,size);
		}
		return messageService.getAllMessages();
	}

	
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long Id,Message message){
		message.setId(Id);
		return messageService.updateMessage(message);
	}
	
	
	
	@GET
	@Path("/{messageId}")
	public Message test(@PathParam("messageId") long messageId){
		return messageService.getMessage(messageId);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void delete(@PathParam("messageId") long messageId){
		messageService.removeMessage(messageId);
	}
	

}
