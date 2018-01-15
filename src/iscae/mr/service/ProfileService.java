package iscae.mr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iscae.mr.Database.DataBClasse;
import iscae.mr.Model.Profile;
public class ProfileService {
	
	private static Map<String, Profile> profiles = DataBClasse.getProfile();

	public List<Profile> getToutProfile() {

		return new ArrayList<Profile>(profiles.values());

	}

	public Profile getProfile(String profileNom) {
		return profiles.get(profileNom);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProFileNom(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProFileNom().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProFileNom(), profile);
		return profile;
	}

	public void delateProfile(String profileNom) {
		 profiles.remove(profileNom);
	}

	

}
