package edu.nju.educationSystem.server.model;

public enum Major {
	A("1"), B("2"), C("3");

	private final String majorPrefix;

	private Major(String prefix) {
		majorPrefix = prefix;
	}

	public String getPrefix() {
		return majorPrefix;
	}

}