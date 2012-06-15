package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.TestBeanWithIntegerProperty;
import com.google.code.beanmatchers.data.TestBeanWithOneProperty;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JavaBeanTest {

    private JavaBean unitUnderTest;

    @Test
    public void canObtainBeanType() {
        // given
        TestBeanWithIntegerProperty bean = new TestBeanWithIntegerProperty();
        Class expectedType = TestBeanWithIntegerProperty.class;
        unitUnderTest = new JavaBean(bean);

        // when
        Class type = unitUnderTest.beanType();

        // then
        assertThat(type, is(equalTo(expectedType)));
    }

    @Test
    public void canObtainPropertyType() {
        // given
        TestBeanWithIntegerProperty bean = new TestBeanWithIntegerProperty();
        Class expectedType = Integer.class;
        unitUnderTest = new JavaBean(bean);

        // when
        Class type = unitUnderTest.propertyType("integerProperty");

        // then
        assertThat(type, is(equalTo(expectedType)));
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void propertyTypeShouldThrowExceptionGivenPropertyDoesNotExistOnBean() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        unitUnderTest.propertyType("propertyThatDoesNotExist");
    }

    @Test
    public void canSetPropertyOnBean() {
        // given
        Object value = "test value";
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        unitUnderTest.setProperty("field1", value);

        // then
        assertThat(bean.getField1(), is(value));
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void setPropertyShouldThrowExceptionGivenPropertyDoesNotExistOnBean() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        unitUnderTest.setProperty("propertyThatDoesNotExist", new Object());
    }

    @Test
    public void canGetPropertyFromBean() {
        // given
        Object expectedValue = "test value";
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        bean.setField1(expectedValue);
        unitUnderTest = new JavaBean(bean);

        // when
        Object value = unitUnderTest.getProperty("field1");

        // then
        assertThat(value, is(expectedValue));
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void getPropertyShouldThrowExceptionGivenPropertyDoesNotExistOnBean() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        unitUnderTest.getProperty("propertyThatDoesNotExist");
    }

    @Test
    public void propertiesShouldObtainTheOnlyPropertyOnBean() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        List<String> properties = unitUnderTest.properties();

        // then
        assertThat(properties, hasSize(1));
        assertThat(properties, hasItem("field1"));
    }

    @Test
    public void toStringShouldObtainTheToStringValueFromTargetBean() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        String toString = unitUnderTest.toString();

        // then
        assertThat(toString, is(equalTo(bean.toString())));
    }

    @Test
    public void hashCodeShouldObtainTheHashCodeValueFromTargetBean() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        int hashCode = unitUnderTest.hashCode();

        // then
        assertThat(hashCode, is(equalTo(bean.hashCode())));
    }

    @Test
    public void equalsShouldCompareToTargetBeanAndReturnTrueGivenBeansAreEqual() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        boolean equal = unitUnderTest.equals(bean);

        // then
        assertThat(equal, is(true));
    }

    @Test
    public void equalsShouldCompareToTargetBeanAndReturnFalseGivenBeansAreNotEqual() {
        // given
        TestBeanWithOneProperty bean1 = new TestBeanWithOneProperty();
        bean1.setField1("1");
        TestBeanWithOneProperty bean2 = new TestBeanWithOneProperty();
        bean2.setField1("2");
        unitUnderTest = new JavaBean(bean1);

        // when
        boolean equal = unitUnderTest.equals(bean2);

        // then
        assertThat(equal, is(false));
    }

    @Test
    public void equalsShouldCompareToTargetBeansAndReturnTrueGivenJavaBeanAndTargetBeansAreEqual() {
        // given
        TestBeanWithOneProperty bean1 = new TestBeanWithOneProperty();
        bean1.setField1("1");
        TestBeanWithOneProperty bean2 = new TestBeanWithOneProperty();
        bean2.setField1("1");
        unitUnderTest = new JavaBean(bean1);

        // when
        boolean equal = unitUnderTest.equals(new JavaBean(bean2));

        // then
        assertThat(equal, is(true));
    }

    @Test
    public void equalsShouldCompareToTargetBeansAndReturnFalseGivenJavaBeanAndTargetBeansAreNotEqual() {
        // given
        TestBeanWithOneProperty bean1 = new TestBeanWithOneProperty();
        bean1.setField1("1");
        TestBeanWithOneProperty bean2 = new TestBeanWithOneProperty();
        bean2.setField1("2");
        unitUnderTest = new JavaBean(bean1);

        // when
        boolean equal = unitUnderTest.equals(new JavaBean(bean2));

        // then
        assertThat(equal, is(false));
    }
}
