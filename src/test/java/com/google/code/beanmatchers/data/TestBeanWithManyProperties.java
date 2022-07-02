package com.google.code.beanmatchers.data;

import org.apache.commons.lang3.builder.ToStringStyle;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class TestBeanWithManyProperties {

  private Object object;
  private String string;
  private Integer integerObject;
  private Integer[] integerObjectArray;
  private int integerPrimitive;
  private int[] integerPrimitiveArray;
  private int[] clonedIntegerPrimitiveArray;
  private Date date;
  private Date[] dateArray;
  private Date[] clonedDateArray;
  private EnumWithThreeValues enumProperty;
  private Double doubleObject;
  private double doublePrimitive;
  private Boolean booleanObject;
  private boolean booleanPrimitive;
  private Long longObject;
  private long longPrimitive;
  private Float floatObject;
  private float floatPrimitive;
  private Byte byteObject;
  private byte bytePrimitive;
  private Character charObject;
  private char charPrimitive;
  private Short shortObject;
  private short shortPrimitive;
  private List<String> listOfString;
  private List<Long> listOfLong;
  private List<Boolean> unmodifiableList;
  private Set<String> unmodifiableSet;

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }

  public String getString() {
    return string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public Integer getIntegerObject() {
    return integerObject;
  }

  public void setIntegerObject(Integer integerObject) {
    this.integerObject = integerObject;
  }

  public Integer[] getIntegerObjectArray() {
    return integerObjectArray;
  }

  public void setIntegerObjectArray(Integer[] integerObjectArray) {
    this.integerObjectArray = integerObjectArray;
  }

  public int getIntegerPrimitive() {
    return integerPrimitive;
  }

  public void setIntegerPrimitive(int integerPrimitive) {
    this.integerPrimitive = integerPrimitive;
  }

  public int[] getIntegerPrimitiveArray() {
    return integerPrimitiveArray;
  }

  public void setIntegerPrimitiveArray(int[] integerPrimitiveArray) {
    this.integerPrimitiveArray = integerPrimitiveArray;
  }

  public int[] getClonedIntegerPrimitiveArray() {
    return clonedIntegerPrimitiveArray == null ? null : clonedIntegerPrimitiveArray.clone();
  }

  public void setClonedIntegerPrimitiveArray(int[] clonedIntegerPrimitiveArray) {
    this.clonedIntegerPrimitiveArray = clonedIntegerPrimitiveArray == null ? null : clonedIntegerPrimitiveArray.clone();
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Date[] getDateArray() {
    return dateArray;
  }

  public void setDateArray(Date[] dateArray) {
    this.dateArray = dateArray;
  }

  public Date[] getClonedDateArray() {
    return clonedDateArray == null ? null : clonedDateArray.clone();
  }

  public void setClonedDateArray(Date[] clonedDateArray) {
    this.clonedDateArray = clonedDateArray == null ? null : clonedDateArray.clone();
  }

  public EnumWithThreeValues getEnumProperty() {
    return enumProperty;
  }

  public void setEnumProperty(EnumWithThreeValues enumProperty) {
    this.enumProperty = enumProperty;
  }

  public Double getDoubleObject() {
    return doubleObject;
  }

  public void setDoubleObject(Double doubleObject) {
    this.doubleObject = doubleObject;
  }

  public double getDoublePrimitive() {
    return doublePrimitive;
  }

  public void setDoublePrimitive(double doublePrimitive) {
    this.doublePrimitive = doublePrimitive;
  }

  public Boolean getBooleanObject() {
    return booleanObject;
  }

  public void setBooleanObject(Boolean booleanObject) {
    this.booleanObject = booleanObject;
  }

  public boolean isBooleanPrimitive() {
    return booleanPrimitive;
  }

  public void setBooleanPrimitive(boolean booleanPrimitive) {
    this.booleanPrimitive = booleanPrimitive;
  }

  public Long getLongObject() {
    return longObject;
  }

  public void setLongObject(Long longObject) {
    this.longObject = longObject;
  }

  public long getLongPrimitive() {
    return longPrimitive;
  }

  public void setLongPrimitive(long longPrimitive) {
    this.longPrimitive = longPrimitive;
  }

  public Float getFloatObject() {
    return floatObject;
  }

  public void setFloatObject(Float floatObject) {
    this.floatObject = floatObject;
  }

  public float getFloatPrimitive() {
    return floatPrimitive;
  }

  public void setFloatPrimitive(float floatPrimitive) {
    this.floatPrimitive = floatPrimitive;
  }

  public Byte getByteObject() {
    return byteObject;
  }

  public void setByteObject(Byte byteObject) {
    this.byteObject = byteObject;
  }

  public byte getBytePrimitive() {
    return bytePrimitive;
  }

  public void setBytePrimitive(byte bytePrimitive) {
    this.bytePrimitive = bytePrimitive;
  }

  public Character getCharObject() {
    return charObject;
  }

  public void setCharObject(Character charObject) {
    this.charObject = charObject;
  }

  public char getCharPrimitive() {
    return charPrimitive;
  }

  public void setCharPrimitive(char charPrimitive) {
    this.charPrimitive = charPrimitive;
  }

  public Short getShortObject() {
    return shortObject;
  }

  public void setShortObject(Short shortObject) {
    this.shortObject = shortObject;
  }

  public short getShortPrimitive() {
    return shortPrimitive;
  }

  public void setShortPrimitive(short shortPrimitive) {
    this.shortPrimitive = shortPrimitive;
  }

  public List<String> getListOfString() {
    return listOfString;
  }

  public void setListOfString(List<String> listOfString) {
    this.listOfString = listOfString;
  }

  public List<Long> getListOfLong() {
    return listOfLong;
  }

  public void setListOfLong(List<Long> listOfLong) {
    this.listOfLong = listOfLong;
  }

  public List<Boolean> getUnmodifiableList() {
    return unmodifiableList == null ? null : Collections.unmodifiableList(unmodifiableList);
  }

  public void setUnmodifiableList(List<Boolean> unmodifiableList) {
    this.unmodifiableList = unmodifiableList == null ? null : Collections.unmodifiableList(unmodifiableList);
  }

  public Set<String> getUnmodifiableSet() {
    return unmodifiableSet == null ? null : Collections.unmodifiableSet(unmodifiableSet);
  }

  public void setUnmodifiableSet(Set<String> unmodifiableSet) {
    this.unmodifiableSet = unmodifiableSet == null ? null : Collections.unmodifiableSet(unmodifiableSet);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

  @Override
  public boolean equals(Object obj) {
    return reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return reflectionToString(this, new TestingToStringStyle());
  }

  private static final class TestingToStringStyle extends ToStringStyle {
    private static final long serialVersionUID = 1L;

    TestingToStringStyle() {
      setArrayStart("[");
      setArrayEnd("]");
    }
  }
}
