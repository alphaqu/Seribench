package net.oskarstrom.seribench.core;

import net.oskarstrom.seribench.core.objects.MainObject;

import java.io.IOException;

public interface SerializerImpl {
	void init();
	void encode(MainObject mainObject) throws IOException;
	boolean decode(MainObject mainObject) throws IOException;
	void reset();
	int size();
	String getName();
}
