package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static com.google.code.beanmatchers.BeanOperations.noArgsConstructor;

public class HasValidBeanConstructorMatcher extends TypeSafeDiagnosingMatcher<Class> {

  @Override
  protected boolean matchesSafely(Class item, Description mismatchDescription) {
    try {
      noArgsConstructor(item);
      return true;
    } catch (BeanMatchersException e) {
      mismatchDescription
          .appendText("bean of type ")
          .appendValue(item.getName())
          .appendText(" does not have a no-args constructor");
      return false;
    }
  }

  public void describeTo(Description description) {
    description.appendText("bean class with a valid no-args constructor");
  }
}
