package edu.nju.educationSystem.server.model;

public enum Major {
	广告学("1"), 物理("2"), 软件工程("3");

	private final String majorPrefix;

	private Major(String prefix) {
		majorPrefix = prefix;
	}

	public String getPrefix() {
		return majorPrefix;
	}

}