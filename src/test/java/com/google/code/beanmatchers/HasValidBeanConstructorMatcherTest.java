package com.google.code.beanmatchers;

import com.google.code.beanmatchers.data.TestBeanWithOneProperty;
import com.google.code.beanmatchers.data.TestBeanWithoutNoArgsConstructor;
import org.hamcrest.Description;
import org.mockito.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class HasValidBeanConstructorMatcherTest {

    private HasValidBeanConstructorMatcher unitUnderTest;

    @Mock
    private Description descriptionMock;

    @BeforeMethod
    public void setUp() {
        unitUnderTest = new HasValidBeanConstructorMatcher();
        initMocks(this);
        when(descriptionMock.appendText(anyString())).thenReturn(descriptionMock);
        when(descriptionMock.appendValue(any())).thenReturn(descriptionMock);
    }

    @Test
    public void beanWithNoArgsConstructorShouldMatch() {
        // given
        Class beanType = TestBeanWithOneProperty.class;

        // when
        boolean match = unitUnderTest.matches(beanType);

        // then
        assertThat(match, is(true));
    }

    @Test
    public void beanWithoutNoArgsConstructorShouldNotMatch() {
        // given
        Class beanType = TestBeanWithoutNoArgsConstructor.class;

        // when
        boolean match = unitUnderTest.matches(beanType);

        // then
        assertThat(match, is(false));
    }

    @Test
    public void beanWithInvalidGetterShouldBeDiagnosed() {
        // given
        Class beanType = TestBeanWithoutNoArgsConstructor.class;

        // when
        unitUnderTest.matchesSafely(beanType, descriptionMock);

        // then
        verify(descriptionMock).appendText("bean of type ");
        verify(descriptionMock).appendValue(TestBeanWithoutNoArgsConstructor.class.getName());
        verify(descriptionMock).appendText(" does not have a no-args constructor");
    }

    @Test
    public void shouldDescribeExpectation() {
        // when
        unitUnderTest.describeTo(descriptionMock);

        // then
        verify(descriptionMock).appendText("bean class with a valid no-args constructor");
    }
}
