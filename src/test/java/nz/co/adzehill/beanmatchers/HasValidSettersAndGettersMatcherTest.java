package nz.co.adzehill.beanmatchers;

import nz.co.adzehill.beanmatchers.data.TestBeanWithBadGetter;
import nz.co.adzehill.beanmatchers.data.TestBeanWithBadSetter;
import nz.co.adzehill.beanmatchers.data.TestBeanWithOneProperty;
import org.hamcrest.Description;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HasValidSettersAndGettersMatcherTest {

    private HasValidSettersAndGettersMatcher unitUnderTest;

    @Mock
    private TypeBasedValueGenerator valueGeneratorMock;

    @Mock
    private Object value;

    @Mock
    private Description descriptionMock;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        when(valueGeneratorMock.generate(Object.class)).thenReturn(value);
        when(descriptionMock.appendText(anyString())).thenReturn(descriptionMock);
        when(descriptionMock.appendValue(any())).thenReturn(descriptionMock);
    }

    @Test
    public void beanWithValidGettersAndSettersShouldMatch() {
        // given
        Object bean = new TestBeanWithOneProperty();
        unitUnderTest = new HasValidSettersAndGettersMatcher(valueGeneratorMock, "field1");

        // when
        boolean match = unitUnderTest.matches(bean);

        // then
        assertThat(match, is(true));
    }

    @Test
    public void beanWithInvalidGetterShouldNotMatch() {
        // given
        unitUnderTest = new HasValidSettersAndGettersMatcher(valueGeneratorMock, "goodField", "badField");
        Object bean = new TestBeanWithBadGetter();

        // when
        boolean match = unitUnderTest.matches(bean);

        // then
        assertThat(match, is(false));
    }

    @Test
    public void beanWithInvalidSetterShouldNotMatch() {
        // given
        unitUnderTest = new HasValidSettersAndGettersMatcher(valueGeneratorMock, "goodField", "badField");
        Object bean = new TestBeanWithBadSetter();

        // when
        boolean match = unitUnderTest.matches(bean);

        // then
        assertThat(match, is(false));
    }

    @Test
    public void beanWithInvalidGetterShouldBeDiagnosed() {
        // given
        unitUnderTest = new HasValidSettersAndGettersMatcher(valueGeneratorMock, "goodField", "badField");
        Object bean = new TestBeanWithBadGetter();

        // when
        unitUnderTest.matches(bean, descriptionMock);

        // then
        verify(descriptionMock).appendText("bean of type ");
        verify(descriptionMock).appendValue(TestBeanWithBadGetter.class.getName());
        verify(descriptionMock).appendText(" had an invalid getter/setter for the property ");
        verify(descriptionMock).appendValue("badField");
    }
}
