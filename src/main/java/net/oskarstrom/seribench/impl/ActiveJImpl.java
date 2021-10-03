package net.oskarstrom.seribench.impl;

import io.activej.serializer.BinarySerializer;
import io.activej.serializer.SerializerBuilder;
import io.activej.serializer.stream.StreamInput;
import io.activej.serializer.stream.StreamOutput;
import net.oskarstrom.seribench.core.Main;
import net.oskarstrom.seribench.core.SerializerImpl;
import net.oskarstrom.seribench.core.objects.MainObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ActiveJImpl implements SerializerImpl {
	public BinarySerializer<MainObject> serializer;
	public byte[] bytes;

	@Override
	public void init() {
		serializer = SerializerBuilder.create().build(MainObject.class);
	}

	@Override
	public void encode(MainObject mainObject) throws IOException {
		StreamOutput streamOutput = StreamOutput.create(new ByteArrayOutputStream());
		streamOutput.serialize(serializer, mainObject);
		bytes = streamOutput.array();
		streamOutput.close();
	}

	@Override
	public boolean decode(MainObject mainObject) throws IOException {
		StreamInput streamInput = StreamInput.create(new ByteArrayInputStream(bytes));
		final boolean equals = mainObject.equals(streamInput.deserialize(serializer));
		streamInput.close();
		return equals;
	}

	@Override
	public void reset() {

	}

	@Override
	public int size() {
		return bytes.length;
	}

	@Override
	public String getName() {
		return "ActiveJ";
	}
}
