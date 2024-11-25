package test.vectors;

import Vectors.Vector3f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vectors3fTest {
    @Test
    void sum() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        v1.add(v2);
        Assertions.assertEquals(5.0, v1.getX(), 1e-7);
        Assertions.assertEquals(7.0, v1.getY(), 1e-7);
        Assertions.assertEquals(9.0, v1.getZ(), 1e-7);
    }

    @Test
    void sumWithCreation() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);
        Vector3f sum = Vector3f.addAndCreate(v1, v2);
        Assertions.assertEquals(5.0, sum.getX(), 1e-7);
        Assertions.assertEquals(7.0, sum.getY(), 1e-7);
        Assertions.assertEquals(9.0, sum.getZ(), 1e-7);
    }

    @Test
    void subtract() {
        Vector3f v1 = new Vector3f(5, 7, 9);
        Vector3f v2 = new Vector3f(2, 3, 4);
        v1.subtract(v2);
        Assertions.assertEquals(3.0, v1.getX(), 1e-7);
        Assertions.assertEquals(4.0, v1.getY(), 1e-7);
        Assertions.assertEquals(5.0, v1.getZ(), 1e-7);
    }

    @Test
    void subtractWithCreation() {
        Vector3f v1 = new Vector3f(5, 7, 9);
        Vector3f v2 = new Vector3f(2, 3, 4);
        Vector3f difference = Vector3f.subtractAndCreate(v1, v2);
        Assertions.assertEquals(3.0, difference.getX(), 1e-7);
        Assertions.assertEquals(4.0, difference.getY(), 1e-7);
        Assertions.assertEquals(5.0, difference.getZ(), 1e-7);
    }

    @Test
    void multiplyByScalar() {
        Vector3f v = new Vector3f(1, 2, 3);
        v.multiplyByScalar(2);
        Assertions.assertEquals(2.0, v.getX(), 1e-7);
        Assertions.assertEquals(4.0, v.getY(), 1e-7);
        Assertions.assertEquals(6.0, v.getZ(), 1e-7);
    }

    @Test
    void divideByScalar() {
        Vector3f v = new Vector3f(6, 9, 12);
        v.divideByScalar(3);
        Assertions.assertEquals(2.0, v.getX(), 1e-7);
        Assertions.assertEquals(3.0, v.getY(), 1e-7);
        Assertions.assertEquals(4.0, v.getZ(), 1e-7);
    }

    @Test
    void divideByZeroThrowsException() {
        Vector3f v = new Vector3f(1, 2, 3);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            v.divideByScalar(0);
        });
    }

    @Test
    void getLength() {
        Vector3f v = new Vector3f(3, 4, 12);
        float length = v.length();

        Assertions.assertEquals(13.0, length, 1e-7);
    }

    @Test
    void normalize() {
        Vector3f v = new Vector3f(3, 4, 12);
        v.normalize();

        Assertions.assertEquals(0.2, v.getX(), 1e-7);
        Assertions.assertEquals(0.3, v.getY(), 1e-7);
        Assertions.assertEquals(0.9, v.getZ(), 1e-7);
    }

    @Test
    void normalizeZeroVectorThrowsException() {
        Vector3f v = new Vector3f(0, 0, 0);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            v.normalize();
        });
    }

    @Test
    void scalarMultiplication() {
        Vector3f v1 = new Vector3f(2, 3, 4);
        Vector3f v2 = new Vector3f(5, 6, 7);

        float result = v1.scalarMultiplication(v2);
        Assertions.assertEquals(56.0, result, 1e-7);
    }

    @Test
    void vectorProduct() {
        Vector3f v1 = new Vector3f(1, 2, 3);
        Vector3f v2 = new Vector3f(4, 5, 6);

        Vector3f crossProduct = v1.vectorProduct(v2);
        Assertions.assertEquals(-3.0, crossProduct.getX(), 1e-7);
        Assertions.assertEquals(6.0, crossProduct.getY(), 1e-7);
        Assertions.assertEquals(-3.0, crossProduct.getZ(), 1e-7);
    }
}
