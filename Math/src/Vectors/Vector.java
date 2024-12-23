package Vectors;

import java.util.Scanner;

public interface Vector<T> {
    float epsilon = 1e-7f;
    Scanner scanner = new Scanner(System.in);

    boolean isEqual(T other);
    default boolean isLengthEqual(Vector<T> other) {
        return (Math.abs(length() - other.length()) < epsilon);
    }

    void addToMe(T other);
    void subtractFromMe(T other);

    T add(T second);
    T subtract(T second);

    void multiplyByScalar(float scalar);
    void divideByScalar(float scalar) throws ArithmeticException;

    T multiplyByScalarWithCreation(float scalar);
    T divideByScalarWithCreation(float scalar) throws ArithmeticException;

    float length();

    void normalize();

    float scalarMultiplication(T other);
}
