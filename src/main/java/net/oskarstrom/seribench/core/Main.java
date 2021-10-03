package net.oskarstrom.seribench.core;

import net.oskarstrom.seribench.core.objects.MainObject;
import net.oskarstrom.seribench.core.objects.PrimitiveObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private static final Random RANDOM = new Random();
	private static final String SERIALIZER_PACKAGE = "net.oskarstrom.seribench.impl";
	public final EnumMap<TestType, List<SerializerImpl>> implementations;


	public Main(EnumMap<TestType, List<SerializerImpl>> implementations) {
		this.implementations = implementations;
	}

	public static Main init() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		EnumMap<TestType, List<SerializerImpl>> implementations = new EnumMap<>(TestType.class);
		for (TestType value : TestType.values()) {
			implementations.put(value, new ArrayList<>());
		}

		for (Class<?> serializerClass : getAllClasses()) {
			if (Arrays.stream(serializerClass.getInterfaces()).anyMatch((c) -> c == SerializerImpl.class)) {
				System.out.println("Initializing " + serializerClass.getSimpleName());
				final SerializerImpl serializer = (SerializerImpl) serializerClass.getConstructor().newInstance();
				implementations.get(serializer.getType()).add(serializer);
			}
		}
		return new Main(implementations);
	}

	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		final Main init = init();

		init.implementations.forEach((testType, serializers) -> {
			final SerializerTest serializerTest = new SerializerTest(serializers);
			final MainObject mainObject = MainObject.createDefault(RANDOM, testType.size);
			//warmup
			serializerTest.run(testType, mainObject, true);
			serializerTest.clear();
		});

		init.implementations.forEach((testType, serializers) -> {
			final SerializerTest serializerTest = new SerializerTest(serializers);
			final MainObject mainObject = MainObject.createDefault(RANDOM, testType.size);
			serializerTest.run(testType, mainObject, false);
			serializerTest.printResults(testType);
		});

	}


	private static Set<Class<?>> getAllClasses() {
		final BufferedReader packageNames = new BufferedReader(new InputStreamReader(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResourceAsStream(SERIALIZER_PACKAGE.replaceAll("[.]", "/")))));
		return packageNames.lines()
				.filter(line -> line.endsWith(".class"))
				.map(line -> getClass(line, SERIALIZER_PACKAGE))
				.collect(Collectors.toSet());
	}

	private static Class<?> getClass(String className, String packageName) {
		try {
			return Class.forName(packageName + "." + className.substring(0, className.lastIndexOf('.')));
		} catch (ClassNotFoundException ignored) {}
		return null;
	}
}
