Bean Matchers
=============

[![Maven Central](https://img.shields.io/maven-central/v/com.google.code.bean-matchers/bean-matchers.svg)](https://search.maven.org/search?q=g:com.google.code.bean-matchers%20AND%20a:bean-matchers)
[![License](https://img.shields.io/github/license/orien/bean-matchers.svg)](https://github.com/orien/bean-matchers/blob/main/LICENSE)
[![Build Status](https://github.com/orien/bean-matchers/workflows/Build/badge.svg?branch=main)](https://github.com/orien/bean-matchers/actions?query=workflow%3ABuild+branch%3Amain)
[![Codecov](https://img.shields.io/codecov/c/github/orien/bean-matchers.svg)](https://codecov.io/gh/orien/bean-matchers)

* [JavaBeans Spec](https://www.oracle.com/java/technologies/javase/javabeans-spec.html)
* [JavaBeans Tutorial](https://docs.oracle.com/javase/tutorial/javabeans/)
* [JavaBeans Wikipedia Entry](https://en.wikipedia.org/wiki/JavaBeans)
* [Project Documentation](https://orien.io/bean-matchers/)
* [Google Code project page (archived)](https://code.google.com/archive/p/bean-matchers/)

Beans are prevalent in our Java world, however these simple structures are commonly
untested. Over the course of a project they can be inflicted with copy and paste errors,
`hashCode`, `equals` and `toString` methods fall out of sync as new properties are added.

Enter Bean Matchers. The Bean Matchers project provides a series of Hamcrest matchers for
testing Java beans. This provides an easy way to gain confidence that your beans are
correct without needing to consume time writing explicit tests for each property. Ensure
a no-args constructor exist. Getters and setters are correctly defined for each property.
Properties are compared in `equals`, influence the generated `hashCode`, and are present
in the output of the `toString` method.

Special attention has been given to the readability of these matchers. It is important
that our tests describe the intent of the code being tested.

Bean Matchers is released under the [3-Clause BSD License](https://opensource.org/licenses/BSD-3-Clause).

Quick Start
-----------

1. Add the Bean Matchers dependency to your Maven project
   (Check the [Central Repository](https://search.maven.org/search?q=g:com.google.code.bean-matchers%20AND%20a:bean-matchers)
   for the latest version):

   ```xml
   <dependency>
      <groupId>com.google.code.bean-matchers</groupId>
      <artifactId>bean-matchers</artifactId>
      <version>0.13</version>
      <scope>test</scope>
   </dependency>
   ```

2. Test your bean:

   ```java
   import static com.google.code.beanmatchers.BeanMatchers.*;
   import static org.hamcrest.CoreMatchers.allOf;
   import static org.hamcrest.MatcherAssert.assertThat;

   public class MyBeanTest {

       // One big test
       @Test
       public void testBean() {
           assertThat(MyBean.class, allOf(
                   hasValidBeanConstructor(),
                   hasValidGettersAndSetters(),
                   hasValidBeanHashCode(),
                   hasValidBeanEquals(),
                   hasValidBeanToString()
           ));
       }

       // Individual, well named tests

       @Test
       public void shouldHaveANoArgsConstructor() {
           assertThat(MyBean.class, hasValidBeanConstructor());
       }

       @Test
       public void gettersAndSettersShouldWorkForEachProperty() {
           assertThat(MyBean.class, hasValidGettersAndSetters());
       }

       @Test
       public void allPropertiesShouldInfluenceHashCode() {
           assertThat(MyBean.class, hasValidBeanHashCode());
       }

       @Test
       public void allPropertiesShouldBeComparedDuringEquals() {
           assertThat(MyBean.class, hasValidBeanEquals());
       }

       @Test
       public void allPropertiesShouldBeRepresentedInToStringOutput() {
           assertThat(MyBean.class, hasValidBeanToString());
       }

   }
   ```

Testing the No-Args Constructor
-------------------------------

Ensures a bean has a working no-args constructor.
```java
assertThat(BeanToTest.class, hasValidBeanConstructor());
```

Testing Getters and Setters
---------------------------

Matchers for ensuring what is stored using a setter is what is obtained using the related getter.

Ensure all properties on the bean have working getters and setters.
```java
assertThat(BeanToTest.class, hasValidGettersAndSetters());
```

Ensure that the property named `testOnlyThisProperty` has a working getter and setter.
```java
assertThat(BeanToTest.class, hasValidGettersAndSettersFor("testOnlyThisProperty"));
```

Ensure that all properties on the bean except the property named `dontTestPropertyWithThisName` has working getters and setters.
```java
assertThat(BeanToTest.class, hasValidGettersAndSettersExcluding("dontTestPropertyWithThisName"));
```

These matchers test a bean instance.
```java
assertThat(new BeanToTest(), isABeanWithValidGettersAndSetters());

assertThat(new BeanToTest(), isABeanWithValidGettersAndSettersFor("testOnlyThisProperty"));

assertThat(new BeanToTest(), isABeanWithValidGettersAndSettersExcluding("dontTestPropertyWithThisName"));
```

Testing the hashCode Method
---------------------------

Matchers for ensuring properties influence the generated hash code. This is tested by setting the property with one value and comparing the generated hash code with that produced when the property is set with a different value. If the values differ we infer the hash code is correctly influenced by the property.

Ensure that all properties on the bean influence the produced hash code.
```java
assertThat(BeanToTest.class, hasValidBeanHashCode());
```

Ensure that the property named `propertyInfluencingHashCode` influences the produced hash code.
```java
assertThat(BeanToTest.class, hasValidBeanHashCodeFor("propertyInfluencingHashCode"));
```

Ensure that all properties on the bean except the property named `propertyNotInfluencingHashCode` influences the produced hash code.
```java
assertThat(BeanToTest.class, hasValidBeanHashCodeExcluding("propertyNotInfluencingHashCode"));
```

Testing the equals Method
-------------------------

Matchers for ensuring properties are compared during the equals operation. Ensure the method accounts for the same instance, a null instance, instance of differing type and null properties.

Ensure all properties on the bean are compared during the equals method.
```java
assertThat(BeanToTest.class, hasValidBeanEquals());
```

Ensure the property named `testOnlyThisProperty` on the bean is compared during the equals method.
```java
assertThat(BeanToTest.class, hasValidBeanEqualsFor("testOnlyThisProperty"));
```

Ensure all the properties on the bean is compared during the equals method except the property named `dontTestPropertyWithThisName`.
```java
assertThat(BeanToTest.class, hasValidBeanEqualsExcluding("dontTestPropertyWithThisName"));
```

Testing the toString Method
---------------------------

Matchers for ensuring the bean class name and properties are included in toString output.

Ensure all properties on the bean are included in the string value.
```java
assertThat(BeanToTest.class, hasValidBeanToString());
```

Ensure the string value includes includes the property named `propertyInToString`. Any other properties on the bean are not tested.
```java
assertThat(BeanToTest.class, hasValidBeanToStringFor("propertyInToString"));
```

Ensure the string value includes all properties on the bean except the property named `propertyNotInToString`.
```java
assertThat(BeanToTest.class, hasValidBeanToStringExcluding("propertyNotInToString"));
```

Generating Property Values
--------------------------

The Bean Matchers library generates values to populate beans while performing various tests. Out of the box Bean Matchers will generate random values for properties of primitive, array and enum type. It will delegate to [Mockito](https://site.mockito.org) to create a mock for non-final types. For final types, one can implement and register a [ValueGenerator](https://github.com/orien/bean-matchers/blob/main/src/main/java/com/google/code/beanmatchers/ValueGenerator.java) to generate random values.

For example say we have defined a value type:
```java
public final class MyCustomValueType {
    private final String value;

    public MyCustomValueType(String value) {
        this.value = value;
    }
    ...
}
```

We have a bean with a property of our value type:
```java
public class MyBean {
    private MyCustomValueType property;

    public MyCustomValueType getProperty() {
        return property;
    }

    public void setProperty(MyCustomValueType property) {
        this.property = property;
    }
    ...
}
```

To test this bean we need to register a ValueGenerator that can generate random values to populate the bean with:
```java
BeanMatchers.registerValueGenerator(new ValueGenerator<MyCustomValueType>() {
        public MyCustomValueType generate() {
            return new MyCustomValueType(StringUtils.randomString());
        }
    }, MyCustomValueType.class);
```

