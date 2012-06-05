package com.google.code.beanmatchers.data;

import java.util.Date;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

public class TestBeanWithManyProperties {

    private Object object;
    private String string;
    private Integer integerObject;
    private Integer[] integerObjectArray;
    private int integerPrimitive;
    private int[] integerPrimitiveArray;
    private Date date;
    private Date[] dateArray;
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

    @Override
    public String toString() {
        return reflectionToString(this);
    }
}
