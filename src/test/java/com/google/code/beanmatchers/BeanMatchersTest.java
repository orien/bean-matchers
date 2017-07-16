package com.google.code.beanmatchers;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEqualsFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCodeFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToStringExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToStringFor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSettersExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSettersFor;
import static com.google.code.beanmatchers.BeanMatchers.isABeanWithValidGettersAndSetters;
import static com.google.code.beanmatchers.BeanMatchers.isABeanWithValidGettersAndSettersExcluding;
import static com.google.code.beanmatchers.BeanMatchers.isABeanWithValidGettersAndSettersFor;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.code.beanmatchers.data.*;
import org.testng.annotations.Test;

public class BeanMatchersTest {

  @Test
  public void testHasValidBeanConstructor() {
    assertThat(TestBeanWithOneProperty.class, hasValidBeanConstructor());
  }

  @Test
  public void testBeanHasValidGettersAndSettersFor() {
    assertThat(new TestBeanWithOneProperty(), isABeanWithValidGettersAndSettersFor("field1"));
  }

  @Test
  public void testHasValidGettersAndSettersFor() {
    assertThat(TestBeanWithOneProperty.class, hasValidGettersAndSettersFor("field1"));
  }

  @Test
  public void testBeanHasValidGettersAndSettersExcluding() {
    assertThat(new TestBeanWithBadSetter(), isABeanWithValidGettersAndSettersExcluding("badField"));
  }

  @Test
  public void testHasValidGettersAndSettersExcluding() {
    assertThat(TestBeanWithBadSetter.class, hasValidGettersAndSettersExcluding("badField"));
  }

  @Test
  public void testBeanHasValidGettersAndSetters() {
    assertThat(new TestBeanWithManyProperties(), isABeanWithValidGettersAndSetters());
  }

  @Test
  public void testHasValidGettersAndSetters() {
    assertThat(TestBeanWithManyProperties.class, hasValidGettersAndSetters());
  }

  @Test
  public void testHasValidBeanHashCode() {
    assertThat(TestBeanWithManyProperties.class, hasValidBeanHashCode());
  }

  @Test
  public void testHasValidBeanHashCodeFor() {
    assertThat(TestBeanWithPropertyThatDoesNotInfluenceHashCode.class, hasValidBeanHashCodeFor());
  }

  @Test
  public void testHasValidBeanHashCodeExcluding() {
    assertThat(TestBeanWithPropertyThatDoesNotInfluenceHashCode.class, hasValidBeanHashCodeExcluding("property"));
  }

  @Test
  public void testHasValidBeanEquals() {
    assertThat(TestBeanWithManyProperties.class, hasValidBeanEquals());
  }

  @Test
  public void testHasValidBeanEqualsOnNonReflectedEquals() {
    assertThat(TestBeanWithTwoPropertiesAndNonReflectedEquals.class, hasValidBeanEqualsFor("field1", "field2"));
  }

  @Test
  public void testHasValidBeanEqualsExcluding() {
    assertThat(TestBeanWithPropertyThatDoesNotInfluenceEquals.class, hasValidBeanEqualsExcluding("propertyNotComparedInEquals"));
  }

  @Test
  public void testHasValidBeanEqualsFor() {
    assertThat(TestBeanWithPropertyThatDoesNotInfluenceEquals.class, hasValidBeanEqualsFor("propertyComparedInEquals"));
  }

  @Test
  public void testHasValidBeanToString() {
    assertThat(TestBeanWithManyProperties.class, hasValidBeanToString());
  }

  @Test
  public void testHasValidBeanToStringExcluding() {
    assertThat(TestBeanWithToStringMissingPropertyValue.class, hasValidBeanToStringExcluding("propertyValueMissingInToString"));
  }

  @Test
  public void testHasValidBeanToStringFor() {
    assertThat(TestBeanWithToStringMissingPropertyValue.class, hasValidBeanToStringFor());
  }

  @Test(expectedExceptions = BeanMatchersException.class)
  public void shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator() {
    assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), isABeanWithValidGettersAndSetters());
  }

  @Test(dependsOnMethods = "shouldThrowExceptionOnBeanWithPropertyNeedingCustomValueGenerator")
  public void canRegisterCustomValueGenerator() {
    BeanMatchers.registerValueGenerator(new CustomValueGenerator(), ObjectNeedingCustomValueGenerator.class);
    assertThat(new TestBeanWithPropertyNeedingCustomGenerator(), isABeanWithValidGettersAndSetters());
  }
}
