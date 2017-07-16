package com.google.code.beanmatchers;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BeanMatchersExceptionTest {

  @Test
  public void canCreateExceptionWithMessage() {
    // given
    String message = "test message";

    // when
    BeanMatchersException exception = new BeanMatchersException(message);

    // then
    assertThat(exception.getMessage(), is(message));
  }

  @Test
  public void canCreateExceptionWithCause() {
    // given
    Throwable cause = new Exception("test");

    // when
    BeanMatchersException exception = new BeanMatchersException(cause);

    // then
    assertThat(exception.getCause(), is(cause));
  }

  @Test
  public void canCreateExceptionWithMessageAndCause() {
    // given
    String message = "test message";
    Throwable cause = new Exception("test");

    // when
    BeanMatchersException exception = new BeanMatchersException(message, cause);

    // then
    assertThat(exception.getMessage(), is(message));
    assertThat(exception.getCause(), is(cause));
  }
}
