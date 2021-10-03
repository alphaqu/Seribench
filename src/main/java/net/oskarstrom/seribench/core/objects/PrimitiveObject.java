package net.oskarstrom.seribench.core.objects;

import java.util.Objects;
import java.util.Random;

@SuppressWarnings("unused")
public class PrimitiveObject {
	public boolean boolean1;
	public boolean boolean2;
	public boolean boolean3;
	public boolean boolean4;
	public byte byte1;
	public byte byte2;
	public byte byte3;
	public byte byte4;
	public char char1;
	public char char2;
	public char char3;
	public char char4;
	public short short1;
	public short short2;
	public short short3;
	public short short4;
	public int int1;
	public int int2;
	public int int3;
	public int int4;
	public float float1;
	public float float2;
	public float float3;
	public float float4;
	public long long1;
	public long long2;
	public long long3;
	public long long4;
	public double double1;
	public double double2;
	public double double3;
	public double double4;

	public PrimitiveObject() {
	}

	public PrimitiveObject(boolean boolean1, boolean boolean2, boolean boolean3, boolean boolean4, byte byte1, byte byte2, byte byte3, byte byte4, char char1, char char2, char char3, char char4, short short1, short short2, short short3, short short4, int int1, int int2, int int3, int int4, float float1, float float2, float float3, float float4, long long1, long long2, long long3, long long4, double double1, double double2, double double3, double double4) {
		this.boolean1 = boolean1;
		this.boolean2 = boolean2;
		this.boolean3 = boolean3;
		this.boolean4 = boolean4;
		this.byte1 = byte1;
		this.byte2 = byte2;
		this.byte3 = byte3;
		this.byte4 = byte4;
		this.char1 = char1;
		this.char2 = char2;
		this.char3 = char3;
		this.char4 = char4;
		this.short1 = short1;
		this.short2 = short2;
		this.short3 = short3;
		this.short4 = short4;
		this.int1 = int1;
		this.int2 = int2;
		this.int3 = int3;
		this.int4 = int4;
		this.float1 = float1;
		this.float2 = float2;
		this.float3 = float3;
		this.float4 = float4;
		this.long1 = long1;
		this.long2 = long2;
		this.long3 = long3;
		this.long4 = long4;
		this.double1 = double1;
		this.double2 = double2;
		this.double3 = double3;
		this.double4 = double4;
	}

	public static PrimitiveObject createDefault(Random random, int size) {
		final PrimitiveObject primitiveObject = new PrimitiveObject();
		primitiveObject.setBoolean1(random.nextBoolean());
		primitiveObject.setBoolean2(random.nextBoolean());
		primitiveObject.setBoolean3(random.nextBoolean());
		primitiveObject.setBoolean4(random.nextBoolean());
		primitiveObject.setByte1((byte) random.nextInt());
		primitiveObject.setByte2((byte) random.nextInt());
		primitiveObject.setByte3((byte) random.nextInt());
		primitiveObject.setByte4((byte) random.nextInt());
		primitiveObject.setChar1((char) random.nextInt());
		primitiveObject.setChar2((char) random.nextInt());
		primitiveObject.setChar3((char) random.nextInt());
		primitiveObject.setChar4((char) random.nextInt());
		primitiveObject.setShort1((short) random.nextInt());
		primitiveObject.setShort2((short) random.nextInt());
		primitiveObject.setShort3((short) random.nextInt());
		primitiveObject.setShort4((short) random.nextInt());
		primitiveObject.setInt1(random.nextInt());
		primitiveObject.setInt2(random.nextInt());
		primitiveObject.setInt3(random.nextInt());
		primitiveObject.setInt4(random.nextInt());
		primitiveObject.setFloat1(random.nextFloat());
		primitiveObject.setFloat2(random.nextFloat());
		primitiveObject.setFloat3(random.nextFloat());
		primitiveObject.setFloat4(random.nextFloat());
		primitiveObject.setLong1(random.nextLong());
		primitiveObject.setLong2(random.nextLong());
		primitiveObject.setLong3(random.nextLong());
		primitiveObject.setLong4(random.nextLong());
		primitiveObject.setDouble1(random.nextDouble());
		primitiveObject.setDouble2(random.nextDouble());
		primitiveObject.setDouble3(random.nextDouble());
		primitiveObject.setDouble4(random.nextDouble());
		return primitiveObject;
	}

	public boolean isBoolean1() {
		return boolean1;
	}

	public void setBoolean1(boolean boolean1) {
		this.boolean1 = boolean1;
	}

	public boolean isBoolean2() {
		return boolean2;
	}

	public void setBoolean2(boolean boolean2) {
		this.boolean2 = boolean2;
	}

	public boolean isBoolean3() {
		return boolean3;
	}

	public void setBoolean3(boolean boolean3) {
		this.boolean3 = boolean3;
	}

	public boolean isBoolean4() {
		return boolean4;
	}

	public void setBoolean4(boolean boolean4) {
		this.boolean4 = boolean4;
	}

	public byte getByte1() {
		return byte1;
	}

	public void setByte1(byte byte1) {
		this.byte1 = byte1;
	}

	public byte getByte2() {
		return byte2;
	}

	public void setByte2(byte byte2) {
		this.byte2 = byte2;
	}

	public byte getByte3() {
		return byte3;
	}

	public void setByte3(byte byte3) {
		this.byte3 = byte3;
	}

	public byte getByte4() {
		return byte4;
	}

	public void setByte4(byte byte4) {
		this.byte4 = byte4;
	}

	public char getChar1() {
		return char1;
	}

	public void setChar1(char char1) {
		this.char1 = char1;
	}

	public char getChar2() {
		return char2;
	}

	public void setChar2(char char2) {
		this.char2 = char2;
	}

	public char getChar3() {
		return char3;
	}

	public void setChar3(char char3) {
		this.char3 = char3;
	}

	public char getChar4() {
		return char4;
	}

	public void setChar4(char char4) {
		this.char4 = char4;
	}

	public short getShort1() {
		return short1;
	}

	public void setShort1(short short1) {
		this.short1 = short1;
	}

	public short getShort2() {
		return short2;
	}

	public void setShort2(short short2) {
		this.short2 = short2;
	}

	public short getShort3() {
		return short3;
	}

	public void setShort3(short short3) {
		this.short3 = short3;
	}

	public short getShort4() {
		return short4;
	}

	public void setShort4(short short4) {
		this.short4 = short4;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public int getInt3() {
		return int3;
	}

	public void setInt3(int int3) {
		this.int3 = int3;
	}

	public int getInt4() {
		return int4;
	}

	public void setInt4(int int4) {
		this.int4 = int4;
	}

	public float getFloat1() {
		return float1;
	}

	public void setFloat1(float float1) {
		this.float1 = float1;
	}

	public float getFloat2() {
		return float2;
	}

	public void setFloat2(float float2) {
		this.float2 = float2;
	}

	public float getFloat3() {
		return float3;
	}

	public void setFloat3(float float3) {
		this.float3 = float3;
	}

	public float getFloat4() {
		return float4;
	}

	public void setFloat4(float float4) {
		this.float4 = float4;
	}

	public long getLong1() {
		return long1;
	}

	public void setLong1(long long1) {
		this.long1 = long1;
	}

	public long getLong2() {
		return long2;
	}

	public void setLong2(long long2) {
		this.long2 = long2;
	}

	public long getLong3() {
		return long3;
	}

	public void setLong3(long long3) {
		this.long3 = long3;
	}

	public long getLong4() {
		return long4;
	}

	public void setLong4(long long4) {
		this.long4 = long4;
	}

	public double getDouble1() {
		return double1;
	}

	public void setDouble1(double double1) {
		this.double1 = double1;
	}

	public double getDouble2() {
		return double2;
	}

	public void setDouble2(double double2) {
		this.double2 = double2;
	}

	public double getDouble3() {
		return double3;
	}

	public void setDouble3(double double3) {
		this.double3 = double3;
	}

	public double getDouble4() {
		return double4;
	}

	public void setDouble4(double double4) {
		this.double4 = double4;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PrimitiveObject)) return false;
		PrimitiveObject that = (PrimitiveObject) o;
		return boolean1 == that.boolean1 && boolean2 == that.boolean2 && boolean3 == that.boolean3 && boolean4 == that.boolean4 && byte1 == that.byte1 && byte2 == that.byte2 && byte3 == that.byte3 && byte4 == that.byte4 && char1 == that.char1 && char2 == that.char2 && char3 == that.char3 && char4 == that.char4 && short1 == that.short1 && short2 == that.short2 && short3 == that.short3 && short4 == that.short4 && int1 == that.int1 && int2 == that.int2 && int3 == that.int3 && int4 == that.int4 && Float.compare(that.float1, float1) == 0 && Float.compare(that.float2, float2) == 0 && Float.compare(that.float3, float3) == 0 && Float.compare(that.float4, float4) == 0 && long1 == that.long1 && long2 == that.long2 && long3 == that.long3 && long4 == that.long4 && Double.compare(that.double1, double1) == 0 && Double.compare(that.double2, double2) == 0 && Double.compare(that.double3, double3) == 0 && Double.compare(that.double4, double4) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boolean1, boolean2, boolean3, boolean4, byte1, byte2, byte3, byte4, char1, char2, char3, char4, short1, short2, short3, short4, int1, int2, int3, int4, float1, float2, float3, float4, long1, long2, long3, long4, double1, double2, double3, double4);
	}
}
