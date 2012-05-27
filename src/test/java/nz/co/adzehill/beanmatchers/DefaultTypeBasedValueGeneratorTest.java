package nz.co.adzehill.beanmatchers;

import nz.co.adzehill.beanmatchers.data.EnumWithOneValue;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DefaultTypeBasedValueGeneratorTest {

    private DefaultTypeBasedValueGenerator unitUnderTest;

    @Mock
    private ValueGeneratorRepository valueGeneratorRepositoryMock;

    @Mock
    private ValueGenerator<Integer> valueGeneratorMock;

    @Mock
    private TypeBasedValueGenerator nonFinalTypeBasedValueGeneratorMock;

    @Mock
    private TypeBasedValueGenerator enumBasedValueGeneratorMock;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        unitUnderTest = new DefaultTypeBasedValueGenerator(
                valueGeneratorRepositoryMock,
                nonFinalTypeBasedValueGeneratorMock,
                enumBasedValueGeneratorMock);
    }

    @Test
    public void shouldDelegateGeneration() {
        // given
        Integer expectedValue = 84982;
        when(valueGeneratorRepositoryMock.retrieveValueGenerator(Integer.class)).thenReturn(valueGeneratorMock);
        when(valueGeneratorMock.generate()).thenReturn(expectedValue);

        // when
        Integer value = unitUnderTest.generate(Integer.class);

        // then
        assertThat(value, is(expectedValue));
    }

    @Test
    public void shouldUseNonFinalGeneratorWhenNoGeneratorRegisteredForTypeAndTypeIsNotFinal() {
        // given
        File expectedValue = new File(".");
        when(valueGeneratorRepositoryMock.retrieveValueGenerator(File.class)).thenReturn(null);
        when(nonFinalTypeBasedValueGeneratorMock.generate(File.class)).thenReturn(expectedValue);

        // when
        File value = unitUnderTest.generate(File.class);

        // then
        assertThat(value, is(expectedValue));
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void shouldThrowExceptionWhenNoGeneratorRegisteredForTypeAndTypeIsFinal() {
        // given
        when(valueGeneratorRepositoryMock.retrieveValueGenerator(String.class)).thenReturn(null);

        // when
        unitUnderTest.generate(String.class);
    }

    @Test
    public void shouldUseEnumGeneratorGivenTypeIsEnum() {
        // given
        EnumWithOneValue expectedValue = EnumWithOneValue.ONE_VALUE;
        when(valueGeneratorRepositoryMock.retrieveValueGenerator(EnumWithOneValue.class)).thenReturn(null);
        when(enumBasedValueGeneratorMock.generate(EnumWithOneValue.class)).thenReturn(expectedValue);

        // when
        EnumWithOneValue value = unitUnderTest.generate(EnumWithOneValue.class);

        // then
        assertThat(value, is(expectedValue));
    }
}
