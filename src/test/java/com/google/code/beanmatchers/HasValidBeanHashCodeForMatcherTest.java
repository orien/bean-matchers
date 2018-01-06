package com.google.code.beanmatchers;

import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.code.beanmatchers.data.TestBeanWithOneProperty;
import com.google.code.beanmatchers.data.TestBeanWithPropertyThatDoesNotInfluenceHashCode;
import org.hamcrest.Description;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HasValidBeanHashCodeForMatcherTest {

  private HasValidBeanHashCodeForMatcher unitUnderTest;

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
  public void beanWithValidHashCodeShouldMatch() {
    // given
    Class beanType = TestBeanWithOneProperty.class;
    unitUnderTest = new HasValidBeanHashCodeForMatcher(valueGeneratorMock, "field1");

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void beanWithPropertyNotInfluencingHashCodeShouldNotMatch() {
    // given
    unitUnderTest = new HasValidBeanHashCodeForMatcher(valueGeneratorMock, "property");
    Class beanType = TestBeanWithPropertyThatDoesNotInfluenceHashCode.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(false));
  }

  @Test
  public void beanWithPropertyNotInfluencingHashCodeShouldBeDiagnosed() {
    // given
    unitUnderTest = new HasValidBeanHashCodeForMatcher(valueGeneratorMock, "property");
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
  public void beanWithPropertyNotInfluencingHashCodeShouldMatchIfBadPropertyIsNotIncluded() {
    // given
    unitUnderTest = new HasValidBeanHashCodeForMatcher(valueGeneratorMock);
    Class beanType = TestBeanWithPropertyThatDoesNotInfluenceHashCode.class;

    // when
    boolean match = unitUnderTest.matches(beanType);

    // then
    assertThat(match, is(true));
  }

  @Test
  public void shouldDescribeExpectationForExcludedProperties() {
    // given
    unitUnderTest = new HasValidBeanHashCodeForMatcher(valueGeneratorMock, "property");

    // when
    unitUnderTest.describeTo(descriptionMock);

    // then
    verify(descriptionMock).appendText("bean with the properties ");
    verify(descriptionMock).appendValue(singletonList("property"));
    verify(descriptionMock).appendText(" influencing hashCode");
  }
}
