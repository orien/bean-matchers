package nz.co.adzehill.beanmatchers;

/**
 * Generates instances of a specific type.
 *
 * @param <T> The type of value produced.
 */
public interface ValueGenerator<T> {

    /**
     * @return A new instance of random value.
     */
    T generate();
}
