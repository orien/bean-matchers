package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.*;
import org.hamcrest.Description;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HasValidBeanEqualsForMatcherTest {

  private HasValidBeanEqualsForMatcher unitUnderTest;

  @Mock
  private TypeBasedValueGenerator valueGeneratorMock;

  @Mock
  private Object valueOne;

  @Mock
  private Object valueTwo;

  @Mock
  private Description descriptionMock;

  @BeforeMethod
  public void setUp() {
    initMocks(this);
    when(valueGeneratorMock.generate(Object.class)).thenReturn(valueOne, valueTwo, valueOne, valueTwo);
    when(descriptionMock.appendText(anyString())).thenReturn(descriptionMock);
    when(descriptionMock.appendValue(any())).thenReturn(descriptionMock);
  }

  @Test
  public void beanWithValidEqualsShouldMatch() {
    // given
    Class beanType = TestBeanWithOneProperty.class;
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "field1");

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void beanWithEqualsNotHandlingSamePropertyValuesShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "property");
    Class beanType = TestBeanWithEqualsThatDoesNotHandleSamePropertyValues.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithPropertyNotInfluencingEqualsShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "propertyNotComparedInEquals");
    Class beanType = TestBeanWithPropertyThatDoesNotInfluenceEquals.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithPropertyNotInfluencingEqualsShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "propertyNotComparedInEquals");
    Class bean = TestBeanWithPropertyThatDoesNotInfluenceEquals.class;

    // when
    unitUnderTest.matchesSafely(bean, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithPropertyThatDoesNotInfluenceEquals.class.getName());
    verify(descriptionMock).appendText(" had property ");
    verify(descriptionMock).appendValue("propertyNotComparedInEquals");
    verify(descriptionMock).appendText(" not compared during equals operation");
  }

  @Test
  public void beanWithPropertyNotInfluencingEqualsShouldMatchIfBadPropertyIsNotIncluded() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "propertyComparedInEquals");
    Class beanType = TestBeanWithPropertyThatDoesNotInfluenceEquals.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void beanWithEqualsNotHandlingThisNullPropertyShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "property");
    Class beanType = TestBeanWithEqualsThatDoesNotHandleThisNullProperty.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithEqualsNotHandlingThatNullPropertyShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "property");
    Class beanType = TestBeanWithEqualsThatDoesNotHandleThatNullProperty.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithEqualsNotHandlingNullPropertyShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "property");
    Class beanType = TestBeanWithEqualsThatDoesNotHandleThisNullProperty.class;

    // when
    unitUnderTest.matchesSafely(beanType, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithEqualsThatDoesNotHandleThisNullProperty.class.getName());
    verify(descriptionMock).appendText(" had property ");
    verify(descriptionMock).appendValue("property");
    verify(descriptionMock).appendText(" not handling null during equals operation");
  }

  @Test
  public void beanWithEqualsNotHandlingSameInstanceShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithEqualsThatDoesNotHandleSameInstance.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithEqualsNotHandlingSameInstanceShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithEqualsThatDoesNotHandleSameInstance.class;

    // when
    unitUnderTest.matchesSafely(beanType, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithEqualsThatDoesNotHandleSameInstance.class.getName());
    verify(descriptionMock).appendText(" did not correctly identify same instance during equals operation");
  }

  @Test
  public void beanWithEqualsNotHandlingNullValueShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithEqualsThatDoesNotHandleNullValue.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithEqualsNotAccountingNullValueShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithEqualsThatDoesNotAccountForNullValue.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithEqualsNotHandlingNullValueShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithEqualsThatDoesNotHandleNullValue.class;

    // when
    unitUnderTest.matchesSafely(beanType, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithEqualsThatDoesNotHandleNullValue.class.getName());
    verify(descriptionMock).appendText(" did not correctly identify null value during equals operation");
  }

  @Test
  public void beanWithEqualsNotHandlingDifferingTypeShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithEqualsThatDoesNotHandleDifferingType.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithEqualsNotHandlingDifferingTypeShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithEqualsThatDoesNotHandleDifferingType.class;

    // when
    unitUnderTest.matchesSafely(beanType, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithEqualsThatDoesNotHandleDifferingType.class.getName());
    verify(descriptionMock).appendText(" did not correctly identify differing type during equals operation");
  }

  @Test
  public void shouldDescribeExpectationForExcludedProperties() {
    // given
    unitUnderTest = new HasValidBeanEqualsForMatcher(valueGeneratorMock, "property");

    // when
    unitUnderTest.describeTo(descriptionMock);

    // then
    verify(descriptionMock).appendText("bean with the properties ");
    verify(descriptionMock).appendValue(singletonList("property"));
    verify(descriptionMock).appendText(" compared in equals");
  }
}
