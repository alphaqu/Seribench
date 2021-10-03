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
	public final List<SerializerImpl> implementations;

	public Main(List<SerializerImpl> implementations) {
		this.implementations = implementations;
	}


	public static Main init() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		List<SerializerImpl> implementations = new ArrayList<>();
		for (Class<?> serializerClass : getAllClasses()) {
			if (Arrays.stream(serializerClass.getInterfaces()).anyMatch((c) -> c == SerializerImpl.class)) {
				System.out.println("Initializing " + serializerClass.getSimpleName());
				implementations.add((SerializerImpl) serializerClass.getConstructor().newInstance());
			}
		}
		return new Main(implementations);
	}

	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		final Main init = init();
		final SerializerTest serializerTest = new SerializerTest(init.implementations);
		System.out.println("Creating run object");
		final MainObject mainObject = MainObject.createDefault(RANDOM);
		serializerTest.run(mainObject);
		serializerTest.printResults();
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
