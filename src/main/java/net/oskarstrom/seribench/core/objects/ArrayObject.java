package net.oskarstrom.seribench.core.objects;

import java.util.*;

public class ArrayObject {
	private static final int SIZE = 20000;
	public int[] integers;
	public String[] strings;
	public List<Long> longList;
	public Map<String, Float> map;

	public ArrayObject() {
	}

	public ArrayObject(int[] integers, String[] strings, List<Long> longList, Map<String, Float> map) {
		this.integers = integers;
		this.strings = strings;
		this.longList = longList;
		this.map = map;

	}

	public static ArrayObject createDefault(Random random, int size) {
		final ArrayObject arrayObject = new ArrayObject();
		int[] integers = new int[size];
		for (int i = 0; i < size; i++) {
			integers[i] = random.nextInt();
		}
		arrayObject.setIntegers(integers);

		String[] strings = new String[size];
		for (int i = 0; i < size; i++) {
			strings[i] = genString(random);
		}
		arrayObject.setStrings(strings);

		List<Long> longList = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			longList.add(random.nextLong());
		}
		arrayObject.setLongList(longList);


		Map<String, Float> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			map.put(genString(random), random.nextFloat());
		}
		arrayObject.setMap(map);
		return arrayObject;
	}

	private static String genString(Random random) {
		return random.nextInt() + "yepthisiscool" + random.nextBoolean();
	}

	public int[] getIntegers() {
		return integers;
	}

	public void setIntegers(int[] integers) {
		this.integers = integers;
	}

	public String[] getStrings() {
		return strings;
	}

	public void setStrings(String[] strings) {
		this.strings = strings;
	}

	public List<Long> getLongList() {
		return longList;
	}

	public void setLongList(List<Long> longList) {
		this.longList = longList;
	}

	public Map<String, Float> getMap() {
		return map;
	}

	public void setMap(Map<String, Float> map) {
		this.map = map;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ArrayObject that)) return false;
		return Arrays.equals(integers, that.integers) && Arrays.equals(strings, that.strings) && Objects.equals(longList, that.longList) && Objects.equals(map, that.map);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(longList, map);
		result = 31 * result + Arrays.hashCode(integers);
		result = 31 * result + Arrays.hashCode(strings);
		return result;
	}
}
