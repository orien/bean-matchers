package nz.co.adzehill.beanmatchers;

import static java.util.UUID.randomUUID;

class StringGenerator implements ValueGenerator<String> {
    public String generate() {
        return randomUUID().toString();
    }
}
