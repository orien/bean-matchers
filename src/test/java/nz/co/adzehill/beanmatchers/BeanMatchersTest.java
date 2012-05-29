package nz.co.adzehill.beanmatchers;

import nz.co.adzehill.beanmatchers.data.TestBeanWithBadSetter;
import nz.co.adzehill.beanmatchers.data.TestBeanWithManyProperties;
import nz.co.adzehill.beanmatchers.data.TestBeanWithOneProperty;
import org.testng.annotations.Test;

import static nz.co.adzehill.beanmatchers.BeanMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BeanMatchersTest {

    @Test
    public void testHasValidSettersAndGettersFor() {
        assertThat(new TestBeanWithOneProperty(), hasValidSettersAndGettersFor("field1"));
    }

    @Test
    public void testHasValidSettersAndGettersExcluding() {
        assertThat(new TestBeanWithBadSetter(), hasValidSettersAndGettersExcluding("badField"));
    }

    @Test
    public void testHasValidSettersAndGetters() {
        assertThat(new TestBeanWithManyProperties(), hasValidSettersAndGetters());
    }
}
