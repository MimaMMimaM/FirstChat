package iscae.mr.Database;

import java.util.HashMap;
import java.util.Map;

import iscae.mr.Model.*;

public class DataBClasse {

	private static Map<Long, message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, message> getmessages() {
		return messages;
	}

	public static Map<String, Profile> getProfile() {

		return profiles;
	}
}
