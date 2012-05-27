package nz.co.adzehill.beanmatchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.mockito.internal.util.MockUtil;

public final class ExtraMatchers {
    private ExtraMatchers() {
    }

    public static <T> Matcher<T> mock() {
        return new BaseMatcher<T>() {
            public boolean matches(Object o) {
                return new MockUtil().isMock(o);
            }

            public void describeTo(Description description) {
                description.appendText("mock");
            }
        };
    }

}
