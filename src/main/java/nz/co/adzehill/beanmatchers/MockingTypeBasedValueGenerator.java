package nz.co.adzehill.beanmatchers;

import static org.mockito.Mockito.mock;

class MockingTypeBasedValueGenerator implements TypeBasedValueGenerator {

    public <T> T generate(Class<T> type) {
        return mock(type);
    }
}
