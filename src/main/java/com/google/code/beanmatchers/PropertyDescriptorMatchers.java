/**
 * $Id$ <br/>
 * $HeadURL$ <br/>
 */

package com.google.code.beanmatchers;

import java.beans.PropertyDescriptor;

import org.hamcrest.Matcher;
import org.hamcrest.core.AllOf;
import org.mockito.ArgumentMatcher;

/**
 * @author $Author$
 * @since $Date$
 * @version $Revision$
 *
 */

public class PropertyDescriptorMatchers {

    private static class WithGetter extends ArgumentMatcher<PropertyDescriptor> {

        @Override
        public boolean matches(Object argument) {
            return (argument instanceof PropertyDescriptor) && ((PropertyDescriptor) argument).getReadMethod() != null;
        }
    }

    private static class WithSetter extends ArgumentMatcher<PropertyDescriptor> {

        @Override
        public boolean matches(Object argument) {
            return (argument instanceof PropertyDescriptor) && ((PropertyDescriptor) argument).getWriteMethod() != null;
        }
    }

    public static final Matcher<PropertyDescriptor> WITH_GETTER = new WithGetter();

    public static final Matcher<PropertyDescriptor> WITH_SETTER = new WithSetter();

    public static final Matcher<PropertyDescriptor> WITH_GETTER_AND_SETTER = AllOf.allOf(WITH_GETTER, WITH_SETTER);
}
