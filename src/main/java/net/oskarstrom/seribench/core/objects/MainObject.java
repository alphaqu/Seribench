package net.oskarstrom.seribench.core.objects;

import java.util.Objects;
import java.util.Random;

public class MainObject {
	public PrimitiveObject primitiveObject;
	public ArrayObject arrayObject;

	public MainObject() {
	}

	public static MainObject createDefault(Random random) {
		MainObject object = new MainObject();
		object.setPrimitiveObject(PrimitiveObject.createDefault(random));
		object.setArrayObject(ArrayObject.createDefault(random));
		return object;
	}

	public MainObject(PrimitiveObject primitiveObject, ArrayObject arrayObject) {
		this.primitiveObject = primitiveObject;
		this.arrayObject = arrayObject;
	}

	public PrimitiveObject getPrimitiveObject() {
		return primitiveObject;
	}

	public void setPrimitiveObject(PrimitiveObject primitiveObject) {
		this.primitiveObject = primitiveObject;
	}

	public ArrayObject getArrayObject() {
		return arrayObject;
	}

	public void setArrayObject(ArrayObject arrayObject) {
		this.arrayObject = arrayObject;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MainObject)) return false;
		MainObject that = (MainObject) o;
		return Objects.equals(primitiveObject, that.primitiveObject) && Objects.equals(arrayObject, that.arrayObject);
	}

	@Override
	public int hashCode() {
		return Objects.hash(primitiveObject, arrayObject);
	}
}
