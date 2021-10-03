package net.oskarstrom.seribench.core;

import net.oskarstrom.seribench.core.objects.MainObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializerTest {
	private static final float SECONDS = 0.5f;
	private final List<SerializerImpl> implementations;
	private final List<ResultEntry> results = new ArrayList<>();

	public SerializerTest(List<SerializerImpl> implementations) {
		this.implementations = implementations;
	}

	public void clear() {
		results.clear();
	}

	public void run(TestType type, MainObject mainObject, boolean warmup) {
		final int size = implementations.size();

		for (int i = 0; i < size; i++) {
			SerializerImpl implementation = implementations.get(i);
			if (warmup)
				System.out.print("Warming up " + type + "[" + i + "/" + size + "]" + "\r");
			final ResultEntry resultEntry = new ResultEntry(implementation.getName());

			if (!warmup)
				print(type, i, size, implementation, "Init");

			resultEntry.initOp = testOps(SECONDS, implementation::init);
			if (!warmup)
				print(type, i, size, implementation, "Encode");

			resultEntry.encodeOp = testOps(SECONDS, () -> {
				try {
					implementation.encode(mainObject);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			if (!warmup)
				print(type, i, size, implementation, "Decode");
			resultEntry.decodeOp = testOps(SECONDS, () -> {
				try {
					implementation.decode(mainObject);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			resultEntry.div(SECONDS);
			resultEntry.size = implementation.size();
			results.add(resultEntry);
		}
	}

	public void print(TestType type, int impl, int impls, SerializerImpl implementation, String task) {
		System.out.print(type + " [" + (impl + 1) + "/" + impls + "] -> (" + implementation.getName() + ") Benchmarking " + task + "\r");
	}

	public long testOps(float seconds, Runnable runnable) {
		long targetTime = (long) (System.nanoTime() + (seconds * 1_000_000_000L));
		long op = 0;
		while (System.nanoTime() < targetTime) {
			runnable.run();
			op++;
		}
		return op;
	}

	public void printResults(TestType type) {
		System.out.print("Printing Results. \r");
		System.out.println(type);
		StringBuilder sb = new StringBuilder("Name\tEncode\tDecode\tInit\tSize (kB)\n");
		for (ResultEntry result : results) {
			final double decodeTime = result.decodeOp;
			final double encodeTime = result.encodeOp;
			final double initTime = result.initOp;
			final float f = result.size / 1000f;
			sb.append(result.name).append("\t").append(encodeTime).append("\t").append(decodeTime).append("\t").append(initTime).append("\t").append(f).append("\n");
		}
		System.out.println(sb.toString().replace('.', ','));
	}


}
