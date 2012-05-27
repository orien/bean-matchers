package nz.co.adzehill.beanmatchers;

public class EnumBasedValueGenerator implements TypeBasedValueGenerator {

    public <T> T generate(Class<T> type) {
        return type.getEnumConstants()[0];
    }
}
