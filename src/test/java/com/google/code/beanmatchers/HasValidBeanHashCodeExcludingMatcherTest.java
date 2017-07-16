package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.TestBeanWithOneProperty;
import com.google.code.beanmatchers.data.TestBeanWithPropertyThatDoesNotInfluenceHashCode;
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

public class HasValidBeanHashCodeExcludingMatcherTest {

  private HasValidBeanHashCodeExcludingMatcher unitUnderTest;

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
    when(valueGeneratorMock.generate(Object.class)).thenReturn(valueOne, valueTwo);
    when(descriptionMock.appendText(anyString())).thenReturn(descriptionMock);
    when(descriptionMock.appendValue(any())).thenReturn(descriptionMock);
  }

  @Test
  public void beanWithValidHashCodeShouldMatch() {
    // given
    Class beanType = TestBeanWithOneProperty.class;
    unitUnderTest = new HasValidBeanHashCodeExcludingMatcher(valueGeneratorMock);

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void beanWithPropertyNotInfluencingHashCodeShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanHashCodeExcludingMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithPropertyThatDoesNotInfluenceHashCode.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasValidBeanHashCodeExcludingMatcher(valueGeneratorMock);
    Class bean = TestBeanWithPropertyThatDoesNotInfluenceHashCode.class;

    // when
    unitUnderTest.matchesSafely(bean, descriptionMock);

    // then
    verify(descriptionMock).appendText("bean of type ");
    verify(descriptionMock).appendValue(TestBeanWithPropertyThatDoesNotInfluenceHashCode.class.getName());
    verify(descriptionMock).appendText(" had a hashCode not influenced by the property ");
    verify(descriptionMock).appendValue("property");
  }

  @Test
  public void beanWithPropertyNotInfluencingHashCodeShouldMatchIfBadPropertyIsExcluded() {
    // given
    unitUnderTest = new HasValidBeanHashCodeExcludingMatcher(valueGeneratorMock, "property");
    Class beanType = TestBeanWithPropertyThatDoesNotInfluenceHashCode.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void shouldDescribeExpectation() {
    // given
    unitUnderTest = new HasValidBeanHashCodeExcludingMatcher(valueGeneratorMock);

    // when
    unitUnderTest.describeTo(descriptionMock);

    // then
    verify(descriptionMock).appendText("bean with all properties influencing hashCode");
  }

  @Test
  public void shouldDescribeExpectationForExcludedProperties() {
    // given
    unitUnderTest = new HasValidBeanHashCodeExcludingMatcher(valueGeneratorMock, "excludedProperty");

    // when
    unitUnderTest.describeTo(descriptionMock);

    // then
    verify(descriptionMock).appendText("bean with all properties excluding ");
    verify(descriptionMock).appendValue(singletonList("excludedProperty"));
    verify(descriptionMock).appendText(" influencing hashCode");
  }
}
