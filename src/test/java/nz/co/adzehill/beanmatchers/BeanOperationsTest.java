package nz.co.adzehill.beanmatchers;

import org.testng.annotations.Test;

import java.beans.PropertyDescriptor;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BeanOperationsTest {

    @Test
    public void canObtainPropertyDescriptorOfDefinedProperty() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();

        // when
        PropertyDescriptor[] properties = BeanOperations.propertyDescriptors(bean);

        // then
        assertThat(properties, hasItemInArray(hasProperty("name", equalTo("field1"))));
    }

    @Test
    public void canUseGetterToObtainPropertyValue() {
        // given
        Object expectedValue = "test value";
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        bean.setField1((String) expectedValue);
        PropertyDescriptor propertyDescriptor = propertyDescriptor(bean, "field1");

        // when
        Object result = BeanOperations.invokeGetter(bean, propertyDescriptor);

        // then
        assertThat(result, is(expectedValue));
    }

    @Test
    public void canUseSetterToSetPropertyValue() {
        // given
        String value = "test value";
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        PropertyDescriptor propertyDescriptor = propertyDescriptor(bean, "field1");

        // when
        BeanOperations.invokeSetter(bean, propertyDescriptor, value);

        // then
        assertThat(bean.getField1(), is(value));
    }

    private PropertyDescriptor propertyDescriptor(Object bean, String propertyName) {
        for (PropertyDescriptor propertyDescriptor: BeanOperations.propertyDescriptors(bean)) {
            if (propertyDescriptor.getName().equals(propertyName)) {
                return propertyDescriptor;
            }
        }
        throw new AssertionError("No property descriptor for property " + propertyName);
    }
}
