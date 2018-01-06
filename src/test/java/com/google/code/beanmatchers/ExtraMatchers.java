package com.google.code.beanmatchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.mockito.Mockito;

public final class ExtraMatchers {
  private ExtraMatchers() {
  }

  public static <T> Matcher<T> mock() {
    return new BaseMatcher<T>() {
      public boolean matches(Object o) {
        return Mockito.mockingDetails(o).isMock();
      }

      public void describeTo(Description description) {
        description.appendText("mock");
      }
    };
  }

}
