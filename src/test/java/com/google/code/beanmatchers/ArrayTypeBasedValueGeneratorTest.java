package com.google.code.beanmatchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArrayTypeBasedValueGeneratorTest {

  @InjectMocks
  private TypeBasedValueGenerator unitUnderTest;

  @Mock
  private TypeBasedValueGenerator valueGeneratorMock;

  @BeforeMethod
  public void setUp() {
    unitUnderTest = new ArrayTypeBasedValueGenerator();
    initMocks(this);
  }

  @Test
  public void canCreateArray() {
    // given
    when(valueGeneratorMock.generate(Integer.TYPE)).thenReturn(4);

    // when
    int[] value = unitUnderTest.generate(int[].class);

    // then
    assertThat(value, is(notNullValue()));
  }

  @Test
  public void arrayShouldHaveAtLeastOneElement() {
    // given
    when(valueGeneratorMock.generate(String.class)).thenReturn("test");

    // when
    String[] value = unitUnderTest.generate(String[].class);

    // then
    assertThat(value, is(not(emptyArray())));
    assertThat(value[0], is("test"));
  }
}
