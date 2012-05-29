package nz.co.adzehill.beanmatchers.data;

import java.util.Date;

public class TestBeanWithManyProperties {

    private Object object;
    private String string;
    private Integer integerObject;
    private int integerPrimitive;
    private Date date;
    private EnumWithThreeValues enumProperty;
    private Double doubleObject;
    private double doublePrimitive;

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

    public int getIntegerPrimitive() {
        return integerPrimitive;
    }

    public void setIntegerPrimitive(int integerPrimitive) {
        this.integerPrimitive = integerPrimitive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
