package com.google.code.beanmatchers;

import java.lang.reflect.Modifier;

class DefaultTypeBasedValueGenerator implements TypeBasedValueGenerator {

    private final ValueGeneratorRepository valueGeneratorRepository;
    private final TypeBasedValueGenerator nonFinalTypeBasedValueGenerator;
    private final TypeBasedValueGenerator enumBasedValueGenerator;
    private final TypeBasedValueGenerator arrayValueGenerator;

    public DefaultTypeBasedValueGenerator(ValueGeneratorRepository valueGeneratorRepository,
                                          TypeBasedValueGenerator nonFinalTypeBasedValueGenerator,
                                          TypeBasedValueGenerator enumBasedValueGenerator,
                                          TypeBasedValueGenerator arrayValueGenerator) {
        this.valueGeneratorRepository = valueGeneratorRepository;
        this.nonFinalTypeBasedValueGenerator = nonFinalTypeBasedValueGenerator;
        this.enumBasedValueGenerator = enumBasedValueGenerator;
        this.arrayValueGenerator = arrayValueGenerator;
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
        if (type.isArray()) {
            return arrayValueGenerator.generate(type);
        }
        throw new BeanMatchersException("Could not create a test value of type " + type.getName());
    }
}
