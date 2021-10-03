package net.oskarstrom.seribench.core;

import net.oskarstrom.seribench.core.objects.MainObject;

import java.util.ArrayList;
import java.util.List;

public class SerializerTest {
	private static final float SECONDS = 1f;
	private final List<SerializerImpl> implementations;
	private final List<ResultEntry> results = new ArrayList<>();

	public SerializerTest(List<SerializerImpl> implementations) {
		this.implementations = implementations;
	}

	public void run(MainObject mainObject) {
		final int size = implementations.size();
		for (int i = 0; i < size; i++) {
			SerializerImpl implementation = implementations.get(i);
			final ResultEntry resultEntry = new ResultEntry(implementation.getName());

			print(i, size, implementation, "Init");
			resultEntry.initOp = testOps(SECONDS, implementation::init);

			print(i, size, implementation, "Encode");
			resultEntry.encodeOp = testOps(SECONDS, () -> implementation.encode(mainObject));

			print(i, size, implementation, "Decode");
			resultEntry.decodeOp = testOps(SECONDS, () -> implementation.decode(mainObject));
			resultEntry.div(SECONDS);
			resultEntry.size = implementation.size();
			results.add(resultEntry);
		}
	}

	public void print(int impl, int impls, SerializerImpl implementation, String task) {
		System.out.print("[" + (impl + 1) + "/" + impls + "] -> (" + implementation.getName() + ") Benchmarking " + task + "\r");
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

	public void printResults() {
		System.out.print("Printing Results. \r");
		StringBuilder sb = new StringBuilder("Name\tInit\tEncode\tDecode\tSize (kB)\n");
		for (ResultEntry result : results) {
			final double decodeTime = result.decodeOp;
			final double encodeTime = result.encodeOp;
			final double initTime = result.initOp;
			final float f = result.size / 1000f;
			sb.append(result.name).append("\t").append(initTime).append("\t").append(encodeTime).append("\t").append(decodeTime).append("\t").append(f).append("\n");
		}
		System.out.println(sb);
	}


}
