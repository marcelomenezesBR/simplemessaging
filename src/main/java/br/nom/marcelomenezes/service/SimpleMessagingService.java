package br.nom.marcelomenezes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.nom.marcelomenezes.access.DatabaseDAO;
import br.nom.marcelomenezes.access.KafkaDAO;
import br.nom.marcelomenezes.model.Message;

/**
 * Service class to handle the business logic in 
 * a decouped approach.
 * 		- KafkaDAO class handles kafka comunicação
 * 		- DatabaseDAO class handles database operations
 * 		- Gson does the serialization (bj to json) 
 * 		- Jackson does the deserialization (json to obj)
 */

public class SimpleMessagingService {

	/** Send a message object to a kafka topic */
	public static void sendMessage(Message message) {
		try {
			KafkaDAO dao = new KafkaDAO();
			Gson gson = new GsonBuilder().create();
			String json= gson.toJson(message);
			dao.send(json);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/** consumes a message obj from a kafka topic.
	 * strips sensitive information and stores 
	 * new message in daabase
	 */
	public static String readMessage() {
		KafkaDAO dao = new KafkaDAO();
		DatabaseDAO dbdao =  new DatabaseDAO();

		ObjectMapper mapper = new ObjectMapper();
		Message message = null;
		try {
			message = mapper.readValue(dao.receive(), Message.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (message!=null) {
			message.setAddress("REMOVED"); 
			message.setName("REMOVED");
			message.setCity("REMOVED"); 
			message.setPostalCode("REMOVED");
			message.setState("REMOVED"); 
			message.setLatitude(0.0f);
			message.setLongitude(0.0f);
			Gson gson = new Gson();	
			String anonymisedMessage =  gson.toJson(message);
			dbdao.insertMessage(anonymisedMessage);
			return anonymisedMessage;
		}else {
			return "";
		}
	}	
}

