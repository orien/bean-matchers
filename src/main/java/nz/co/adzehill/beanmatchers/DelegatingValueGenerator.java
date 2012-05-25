package nz.co.adzehill.beanmatchers;

import java.util.HashMap;
import java.util.Map;

class DelegatingValueGenerator implements TypeBasedValueGenerator {

    private final Map<Class, ValueGenerator> valueGenerators = new HashMap<Class, ValueGenerator>();

    @SuppressWarnings("unchecked")
    public <T> T generate(Class<T> type) {
        return (T) valueGenerators.get(type).generate();
    }

    public <T> void addValueGenerator(ValueGenerator<T> generator, Class<T> type) {
        valueGenerators.put(type, generator);
    }

    public <T> void addValueGenerator(ValueGenerator<T> generator, Class<T>... type) {
        for (Class<T> c : type) {
            addValueGenerator(generator, c);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> ValueGenerator<T> getValueGenerator(Class<T> type) {
        return valueGenerators.get(type);
    }
}
