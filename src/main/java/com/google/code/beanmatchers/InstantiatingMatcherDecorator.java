package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static com.google.code.beanmatchers.BeanOperations.instantiateBean;

public class InstantiatingMatcherDecorator<T> extends TypeSafeMatcher<Class<T>> {

  private final Matcher<T> delegateMatcher;

  public InstantiatingMatcherDecorator(Matcher<T> matcher) {
    this.delegateMatcher = matcher;
  }

  @Override
  protected boolean matchesSafely(Class<T> beanType) {
    T beanInstance = instantiateBean(beanType);
    return delegateMatcher.matches(beanInstance);
  }

  @Override
  protected void describeMismatchSafely(Class<T> beanType, Description mismatchDescription) {
    T beanInstance = instantiateBean(beanType);
    delegateMatcher.describeMismatch(beanInstance, mismatchDescription);
  }

  public void describeTo(Description description) {
    delegateMatcher.describeTo(description);
  }
}
