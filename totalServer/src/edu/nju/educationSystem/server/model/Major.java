package edu.nju.educationSystem.server.model;

public enum Major {
	���ѧ("1"), ����("2"), �������("3");

	private final String majorPrefix;

	private Major(String prefix) {
		majorPrefix = prefix;
	}

	public String getPrefix() {
		return majorPrefix;
	}

}