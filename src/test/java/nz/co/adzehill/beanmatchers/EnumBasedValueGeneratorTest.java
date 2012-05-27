package nz.co.adzehill.beanmatchers;

import nz.co.adzehill.beanmatchers.data.EnumWithOneValue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EnumBasedValueGeneratorTest {

    private EnumBasedValueGenerator unitUnderTest;

    @BeforeMethod
    public void setUp() {
        unitUnderTest = new EnumBasedValueGenerator();
    }

    @Test
    public void shouldObtainEnumValue() {

        // when
        EnumWithOneValue value = unitUnderTest.generate(EnumWithOneValue.class);

        // then
        assertThat(value, is(EnumWithOneValue.ONE_VALUE));
    }
}
