package net.oskarstrom.seribench.core;

public enum TestType {
	JSON(1000),
	XML(1000),
	YAML(1000),
	BYTE(1000000);

	public int size;

	TestType(int size) {
		this.size = size;
	}
}
