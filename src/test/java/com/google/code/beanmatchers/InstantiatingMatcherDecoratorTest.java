package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.TestBeanWithOneProperty;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class InstantiatingMatcherDecoratorTest {

  private InstantiatingMatcherDecorator unitUnderTest;

  @Mock
  private Matcher matcherMock;

  @Mock
  private Description descriptionMock;

  @BeforeMethod
  public void setUp() {
    initMocks(this);
  }

  @Test
  public void shouldInstantiateBeanAndDelegate() {
    // given
    Class beanType = TestBeanWithOneProperty.class;

    // when
    unitUnderTest = new InstantiatingMatcherDecorator(matcherMock);
    unitUnderTest.matches(beanType);

    // then
    verify(matcherMock).matches(any(TestBeanWithOneProperty.class));
  }

  @Test
  public void shouldReturnDelegatesResponse() {
    // given
    Class beanType = TestBeanWithOneProperty.class;
    when(matcherMock.matches(anyObject())).thenReturn(true);

    // when
    unitUnderTest = new InstantiatingMatcherDecorator(matcherMock);
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void shouldDelegateDescribingMismatch() {
    // given
    Class beanType = TestBeanWithOneProperty.class;

    // when
    unitUnderTest = new InstantiatingMatcherDecorator(matcherMock);
    unitUnderTest.describeMismatch(beanType, descriptionMock);

    // then
    verify(matcherMock).describeMismatch(any(TestBeanWithOneProperty.class), eq(descriptionMock));
  }

  @Test
  public void shouldDelegateDescription() {
    // when
    unitUnderTest = new InstantiatingMatcherDecorator(matcherMock);
    unitUnderTest.describeTo(descriptionMock);

    // then
    verify(matcherMock).describeTo(descriptionMock);
  }
}
