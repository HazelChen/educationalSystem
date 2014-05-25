package edu.nju.educationSystem.server.service;

import edu.nju.educationSystem.server.model.Major;

public class MajorService {

	public Major getMajor(String majorXml) {
		Major major = Major.valueOf(majorXml);
		return major;
	}
}
