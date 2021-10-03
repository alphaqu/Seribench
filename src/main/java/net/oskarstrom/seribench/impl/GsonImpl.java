package net.oskarstrom.seribench.impl;

import com.google.gson.Gson;
import net.oskarstrom.seribench.core.SerializerImpl;
import net.oskarstrom.seribench.core.TestType;
import net.oskarstrom.seribench.core.objects.MainObject;

import java.nio.charset.StandardCharsets;

public class GsonImpl implements SerializerImpl {
	public Gson gson;
	public String string;

	@Override
	public void init() {
		gson = new Gson();
	}

	@Override
	public void encode(MainObject mainObject) {
		string = gson.toJson(mainObject);
	}

	@Override
	public boolean decode(MainObject mainObject) {
		return mainObject.equals(gson.fromJson(string, mainObject.getClass()));
	}

	@Override
	public void reset() {
	}

	@Override
	public int size() {
		return string.getBytes(StandardCharsets.UTF_8).length;
	}

	@Override
	public TestType getType() {
		return TestType.JSON;
	}

	@Override
	public String getName() {
		return "Gson";
	}
}
