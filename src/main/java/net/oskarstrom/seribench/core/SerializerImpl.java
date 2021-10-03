package net.oskarstrom.seribench.core;

import net.oskarstrom.seribench.core.objects.MainObject;

public interface SerializerImpl {
	void init();
	void encode(MainObject mainObject);
	boolean decode(MainObject mainObject);
	void reset();
	int size();
	String getName();
}
