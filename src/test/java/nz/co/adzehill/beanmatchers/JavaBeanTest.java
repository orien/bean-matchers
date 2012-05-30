package nz.co.adzehill.beanmatchers;

import nz.co.adzehill.beanmatchers.data.TestBeanWithIntegerProperty;
import nz.co.adzehill.beanmatchers.data.TestBeanWithOneProperty;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JavaBeanTest {

    private JavaBean unitUnderTest;

    @Test
    public void canObtainPropertyType() {
        // given
        TestBeanWithIntegerProperty bean = new TestBeanWithIntegerProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        Class type = unitUnderTest.propertyType("integerProperty");

        // then
        assertThat(type, is(equalTo(Integer.class)));
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
}
