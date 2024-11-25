package Vectors;

public interface Vector<T> {
    float epsilon = 1e-7f;

    boolean isEqual(T other);

    void add(T other);
    void subtract(T other);

    void multiplyByScalar(float scalar);
    void divideByScalar(float scalar) throws ArithmeticException;

    float length();

    void normalize();

    float scalarMultiplication(T other);
}
