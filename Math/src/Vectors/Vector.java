package Vectors;

public interface Vector<T> {
    float epsilon = 1e-7f;

    boolean isEqual(T other);

    void addToMe(T other);
    void subtractFromMe(T other);

    T add(T second);
    T subtract(T second);

    void multiplyByScalar(float scalar);
    void divideByScalar(float scalar) throws ArithmeticException;

    float length();

    void normalize();

    float scalarMultiplication(T other);
}
