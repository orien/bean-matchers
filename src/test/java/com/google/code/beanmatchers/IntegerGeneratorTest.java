package com.google.code.beanmatchers;

import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class IntegerGeneratorTest {

    private IntegerGenerator unitUnderTest;

    @Mock
    private Random randomMock;

    @BeforeMethod
    public void setUp() {
        initMocks(this);
        unitUnderTest = new IntegerGenerator(randomMock);
    }

    @Test
    public void shouldGenerateRandomInteger() {
        // given
        Integer expectedInteger = 743;
        when(randomMock.nextInt()).thenReturn(expectedInteger);

        // when
        Integer result = unitUnderTest.generate();

        // then
        assertThat(result, is(expectedInteger));
    }
}
