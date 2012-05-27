package nz.co.adzehill.beanmatchers;

import java.lang.reflect.Modifier;

class DefaultTypeBasedValueGenerator implements TypeBasedValueGenerator {

    private final ValueGeneratorRepository valueGeneratorRepository;
    private final TypeBasedValueGenerator nonFinalTypeBasedValueGenerator;
    private final TypeBasedValueGenerator enumBasedValueGenerator;

    public DefaultTypeBasedValueGenerator(ValueGeneratorRepository valueGeneratorRepository,
                                          TypeBasedValueGenerator nonFinalTypeBasedValueGenerator,
                                          TypeBasedValueGenerator enumBasedValueGenerator) {
        this.valueGeneratorRepository = valueGeneratorRepository;
        this.nonFinalTypeBasedValueGenerator = nonFinalTypeBasedValueGenerator;
        this.enumBasedValueGenerator = enumBasedValueGenerator;
    }

    public <T> T generate(Class<T> type) {
        ValueGenerator<T> generator = valueGeneratorRepository.retrieveValueGenerator(type);
        if (generator != null) {
            return generator.generate();
        }
        if (!Modifier.isFinal(type.getModifiers())) {
            return nonFinalTypeBasedValueGenerator.generate(type);
        }
        if (type.isEnum()) {
            return enumBasedValueGenerator.generate(type);
        }
        throw new BeanMatchersException("Could not create a test value of type " + type.getName());
    }
}
