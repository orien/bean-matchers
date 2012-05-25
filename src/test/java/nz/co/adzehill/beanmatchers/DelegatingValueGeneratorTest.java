package nz.co.adzehill.beanmatchers;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DelegatingValueGeneratorTest {

    private DelegatingValueGenerator unitUnderTest;

    @Mock
    private ValueGenerator<Integer> valueGeneratorMock;

    @BeforeMethod
    public void setUp() {
        unitUnderTest = new DelegatingValueGenerator();
        initMocks(this);
    }

    @Test
    public void shouldDelegateGeneration() {
        // given
        Integer expectedValue = 84982;
        when(valueGeneratorMock.generate()).thenReturn(expectedValue);
        unitUnderTest.addValueGenerator(valueGeneratorMock, Integer.class);

        // when
        Integer value = unitUnderTest.generate(Integer.class);

        // then
        assertThat(value, is(expectedValue));
    }

    @Test
    public void canRegisterValueGenerator() {
        // when
        unitUnderTest.addValueGenerator(valueGeneratorMock, Integer.class);

        // then
        assertThat(unitUnderTest.getValueGenerator(Integer.class), is(valueGeneratorMock));
    }

    @Test
    public void shouldNotRegisterValueGeneratorForDifferingType() {
        // when
        unitUnderTest.addValueGenerator(valueGeneratorMock, Integer.class);

        // then
        assertThat(unitUnderTest.getValueGenerator(Integer.TYPE), is(not(valueGeneratorMock)));
    }

    @Test
    public void canRegisterValueGeneratorForTwoTypes() {
        // when
        unitUnderTest.addValueGenerator(valueGeneratorMock, Integer.class, Integer.TYPE);

        // then
        assertThat(unitUnderTest.getValueGenerator(Integer.class), is(valueGeneratorMock));
        assertThat(unitUnderTest.getValueGenerator(Integer.TYPE), is(valueGeneratorMock));
    }
}
