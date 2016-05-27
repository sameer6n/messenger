package org.sameer.javaweb.messenger.database;
import java.util.HashMap;
import java.util.Map;

import org.sameer.javaweb.messenger.model.*;

public class DatabaseClass {
	private static HashMap<Long,Message> messages=new HashMap<Long,Message>();
	private static HashMap<String,Profile> profiles=new HashMap<String,Profile>();
	public static Map<Long,Message> getMessages(){
		return messages;
	}
	public static Map<String,Profile> getProfiles(){
		return profiles;
	}
	
}
