package com.google.code.beanmatchers;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.code.beanmatchers.data.*;
import org.hamcrest.Description;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HasToStringDescribingPropertiesExcludingMatcherTest {

  private HasToStringDescribingPropertiesExcludingMatcher unitUnderTest;

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
  public void beanWithValidToStringShouldMatch() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithOneProperty.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void beanWithoutClassNameInToStringShouldNotMatch() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithToStringMissingClassName.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithoutClassNameInToStringShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithToStringMissingClassName.class;

    // when
    unitUnderTest.matchesSafely(beanType, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithToStringMissingClassName.class.getName());
    verify(descriptionMock).appendText(" had an invalid toString() method. ");
    verify(descriptionMock).appendText("It did not produce the bean class name: ");
  }

  @Test
  public void beanWithoutPropertyNameInToStringShouldNotMatch() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithToStringMissingPropertyName.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithoutPropertyNameInToStringShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithToStringMissingPropertyName.class;

    // when
    unitUnderTest.matchesSafely(beanType, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithToStringMissingPropertyName.class.getName());
    verify(descriptionMock).appendText(" had an invalid toString() method. ");
    verify(descriptionMock).appendText("It did not produce the property name ");
    verify(descriptionMock).appendValue("propertyNameMissingInToString");
  }

  @Test
  public void beanWithoutPropertyNameInToStringShouldMatchIfPropertyIsExcluded() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock, "propertyNameMissingInToString");
    Class beanType = TestBeanWithToStringMissingPropertyName.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void beanWithoutPropertyValueInToStringShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithToStringMissingPropertyValue.class;

    // when
    unitUnderTest.matchesSafely(beanType, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithToStringMissingPropertyValue.class.getName());
    verify(descriptionMock).appendText(" had an invalid toString() method. ");
    verify(descriptionMock).appendText("It did not produce the value for property ");
    verify(descriptionMock).appendValue("propertyValueMissingInToString");
  }

  @Test
  public void beanWithoutArrayPropertyValueInToStringShouldNotMatch() {
    // given
    when(valueGeneratorMock.generate(String[].class)).thenReturn(new String[]{"test", "string", "array"});
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithToStringMissingArrayPropertyValue.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithoutPropertyValueInToStringShouldNotMatch() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithToStringMissingPropertyValue.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithoutPropertyValueInToStringShouldMatchIfPropertyIsExcluded() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock, "propertyValueMissingInToString");
    Class beanType = TestBeanWithToStringMissingPropertyValue.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void shouldDescribeExpectation() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock);

    // when
    unitUnderTest.describeTo(descriptionMock);

    // then
    verify(descriptionMock).appendText("bean with toString() describing class name and all properties");
  }

  @Test
  public void shouldDescribeExpectationForExcludedProperties() {
    // given
    unitUnderTest = new HasToStringDescribingPropertiesExcludingMatcher(valueGeneratorMock, "excludedProperty");

    // when
    unitUnderTest.describeTo(descriptionMock);

    // then
    verify(descriptionMock).appendText("bean with toString() describing class name and all properties excluding ");
    verify(descriptionMock).appendValue(singletonList("excludedProperty"));
  }
}
