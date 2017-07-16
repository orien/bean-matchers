package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.EnumWithOneValue;
import com.google.code.beanmatchers.data.EnumWithThreeValues;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class EnumBasedValueGeneratorTest {

  private EnumBasedValueGenerator unitUnderTest;

  @Mock
  private Random randomMock;

  @BeforeMethod
  public void setUp() {
    initMocks(this);
    unitUnderTest = new EnumBasedValueGenerator(randomMock);
  }

  @Test
  public void shouldObtainEnumValue() {

    // when
    EnumWithOneValue value = unitUnderTest.generate(EnumWithOneValue.class);

    // then
    assertThat(value, is(EnumWithOneValue.ONE_VALUE));
  }

  @Test
  public void shouldObtainRandomEnumValue() {
    // given
    when(randomMock.nextInt(3)).thenReturn(2);

    // when
    EnumWithThreeValues value = unitUnderTest.generate(EnumWithThreeValues.class);

    // then
    assertThat(value, is(EnumWithThreeValues.VALUE_THREE));
  }
}
