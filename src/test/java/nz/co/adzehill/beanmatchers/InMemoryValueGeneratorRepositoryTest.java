package nz.co.adzehill.beanmatchers;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.MockitoAnnotations.initMocks;

public class InMemoryValueGeneratorRepositoryTest {

    private InMemoryValueGeneratorRepository unitUnderTest;

    @Mock
    private ValueGenerator<Integer> valueGeneratorMock;

    @BeforeMethod
    public void setUp() {
        unitUnderTest = new InMemoryValueGeneratorRepository();
        initMocks(this);
    }

    @Test
    public void canRegisterValueGenerator() {
        // when
        unitUnderTest.registerValueGenerator(valueGeneratorMock, Integer.class);

        // then
        assertThat(unitUnderTest.retrieveValueGenerator(Integer.class), is(valueGeneratorMock));
    }

    @Test
    public void shouldNotRegisterValueGeneratorForDifferingType() {
        // when
        unitUnderTest.registerValueGenerator(valueGeneratorMock, Integer.class);

        // then
        assertThat(unitUnderTest.retrieveValueGenerator(Integer.TYPE), is(not(valueGeneratorMock)));
    }

    @Test
    public void canRegisterValueGeneratorForTwoTypes() {
        // when
        unitUnderTest.registerValueGenerator(valueGeneratorMock, Integer.class, Integer.TYPE);

        // then
        assertThat(unitUnderTest.retrieveValueGenerator(Integer.class), is(valueGeneratorMock));
        assertThat(unitUnderTest.retrieveValueGenerator(Integer.TYPE), is(valueGeneratorMock));
    }

}
