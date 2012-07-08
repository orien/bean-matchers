package com.google.code.beanmatchers;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.code.beanmatchers.ValueGenerators.generateTwoDistinctValues;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ValueGeneratorsTest {

    @Mock
    private TypeBasedValueGenerator valueGeneratorMock;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void canGenerateTwoValues() {
        // given
        when(valueGeneratorMock.generate(Integer.class)).thenReturn(1, 2);

        // when
        DistinctValues<Integer> result = generateTwoDistinctValues(valueGeneratorMock, Integer.class);

        // then
        assertThat(result, is(notNullValue()));
        assertThat(result.getValueOne(), is(equalTo(1)));
        assertThat(result.getValueTwo(), is(equalTo(2)));
    }

    @Test
    public void shouldGenerateTwoDistinctValues() {
        // given
        when(valueGeneratorMock.generate(Integer.class)).thenReturn(1, 1, 2);

        // when
        DistinctValues<Integer> result = generateTwoDistinctValues(valueGeneratorMock, Integer.class);

        // then
        assertThat(result, is(notNullValue()));
        assertThat(result.getValueOne(), is(equalTo(1)));
        assertThat(result.getValueTwo(), is(equalTo(2)));
    }

    @Test(expectedExceptions = BeanMatchersException.class)
    public void shouldThrowExceptionGivenCannotGenerateTwoDistinctValuesAfterTenAttempts() {
        // given
        when(valueGeneratorMock.generate(Integer.class)).thenReturn(1);

        // when
        try {
            generateTwoDistinctValues(valueGeneratorMock, Integer.class);
        } catch (RuntimeException e) {
            verify(valueGeneratorMock, times(32 + 1)).generate(Integer.class);
            throw e;
        }
    }
}
