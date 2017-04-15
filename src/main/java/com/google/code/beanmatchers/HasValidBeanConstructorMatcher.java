package com.google.code.beanmatchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import static com.google.code.beanmatchers.BeanOperations.argConstructor;
import static com.google.code.beanmatchers.BeanOperations.noArgsConstructor;

public class HasValidBeanConstructorMatcher extends TypeSafeDiagnosingMatcher<Class> {

    /**
     * Constructor argument types
     */
    private final Class[] constructorArgumentTypes;

    /**
     * Build matcher with Constructor argument types
     *
     * @param argumentTypes types
     */
    public HasValidBeanConstructorMatcher(Class... argumentTypes) {
        this.constructorArgumentTypes = argumentTypes;
    }

    @Override
    protected boolean matchesSafely(Class item, Description mismatchDescription) {
        try {
            if(constructorArgumentTypes == null || constructorArgumentTypes.length == 0){
                noArgsConstructor(item);
            } else {
                argConstructor(item, constructorArgumentTypes);            }
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
