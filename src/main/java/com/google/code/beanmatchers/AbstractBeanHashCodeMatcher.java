package com.google.code.beanmatchers;

import static com.google.code.beanmatchers.ValueGenerators.generateTwoDistinctValues;

import java.util.List;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

abstract class AbstractBeanHashCodeMatcher<T> extends TypeSafeDiagnosingMatcher<Class<T>> {
  final TypeBasedValueGenerator valueGenerator;

  AbstractBeanHashCodeMatcher(TypeBasedValueGenerator valueGenerator) {
    this.valueGenerator = valueGenerator;
  }

  protected boolean hashCodeIsInfluencedByProperties(
      JavaBean bean, List<String> properties, Description mismatchDescription) {
    for (String property : properties) {
      if (hashCodeNotInfluencedByProperty(bean, property)) {
        mismatchDescription
            .appendText("bean of type ")
            .appendValue(bean.beanType().getName())
            .appendText(" had a hashCode not influenced by the property ")
            .appendValue(property);
        return false;
      }
    }
    return true;
  }

  private boolean hashCodeNotInfluencedByProperty(JavaBean bean, String property) {
    Class<?> propertyType = bean.propertyType(property);
    DistinctValues values = generateTwoDistinctValues(valueGenerator, propertyType);
    bean.setProperty(property, values.getValueOne());
    int initialHashCode = bean.hashCode();
    bean.setProperty(property, values.getValueTwo());
    int influencedHashCode = bean.hashCode();
    return initialHashCode == influencedHashCode;
  }
}
