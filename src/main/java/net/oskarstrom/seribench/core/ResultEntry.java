package net.oskarstrom.seribench.core;

public class ResultEntry {
	public double initOp;
	public double encodeOp;
	public double decodeOp;
	public int size;
	public final String name;

	public ResultEntry(String name) {
		this.initOp = 0;
		this.encodeOp = 0;
		this.decodeOp = 0;
		this.size = -1;
		this.name = name;
	}

	public void div(float amount) {
		this.initOp /= amount;
		this.encodeOp /= amount;
		this.decodeOp /= amount;
	}


}
