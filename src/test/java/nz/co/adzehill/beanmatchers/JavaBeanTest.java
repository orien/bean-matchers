package nz.co.adzehill.beanmatchers;

import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class JavaBeanTest {

    private JavaBean unitUnderTest;

    @Test
    public void canObtainPropertyType() {
        // given
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        Class type = unitUnderTest.propertyType("field1");

        // then
        assertThat(type, is(equalTo(String.class)));
    }

    @Test
    public void canSetPropertyOnBean() {
        // given
        String value = "test value";
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        unitUnderTest = new JavaBean(bean);

        // when
        unitUnderTest.setProperty("field1", value);

        // then
        assertThat(bean.getField1(), is(value));
    }

    @Test
    public void canGetPropertyFromBean() {
        // given
        Object expectedValue = "test value";
        TestBeanWithOneProperty bean = new TestBeanWithOneProperty();
        bean.setField1((String) expectedValue);
        unitUnderTest = new JavaBean(bean);

        // when
        Object value = unitUnderTest.getProperty("field1");

        // then
        assertThat(value, is(expectedValue));

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
