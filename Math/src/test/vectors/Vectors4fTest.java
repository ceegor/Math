package test.vectors;

import static org.junit.jupiter.api.Assertions.*;
import Vectors.Vector4f;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Vectors4fTest {
    private Vector4f v1;
    private Vector4f v2;

    @BeforeEach
    void setUp() {
        v1 = new Vector4f(1, 2, 3, 4);
        v2 = new Vector4f(4, 3, 2, 1);
    }

    @Test
    void testAddWithCreation() {
        Vector4f result = Vector4f.addAndCreate(v1, v2);
        assertEquals(5.0, result.getX(), 1e-7);
        assertEquals(5.0, result.getY(), 1e-7);
        assertEquals(5.0, result.getZ(), 1e-7);
        assertEquals(5.0, result.getW(), 1e-7);
    }

    @Test
    void testAdd() {
        v1.add(v2);
        assertEquals(5.0, v1.getX(), 1e-7);
        assertEquals(5.0, v1.getY(), 1e-7);
        assertEquals(5.0, v1.getZ(), 1e-7);
        assertEquals(5.0, v1.getW(), 1e-7);
    }

    @Test
    void testSubtractWithCreation() {
        Vector4f result = Vector4f.subtractAndCreate(v1, v2);
        assertEquals(-3.0, result.getX(), 1e-7);
        assertEquals(-1.0, result.getY(), 1e-7);
        assertEquals(1.0, result.getZ(), 1e-7);
        assertEquals(3.0, result.getW(), 1e-7);
    }

    @Test
    void testSubtract() {
        v1.subtract(v2);
        assertEquals(-3.0,v1.getX(), 1e-7);
        assertEquals(-1.0,v1.getY(), 1e-7);
        assertEquals(1.0, v1.getZ(), 1e-7);
        assertEquals(3.0, v1.getW(), 1e-7);
    }

    @Test
    void testMultiplyingVectorByScalar() {
        v1.multiplyByScalar(2);
        assertEquals(2.0, v1.getX(), 1e-7);
        assertEquals(4.0, v1.getY(), 1e-7);
        assertEquals(6.0, v1.getZ(), 1e-7);
        assertEquals(8.0, v1.getW(), 1e-7);
    }

    @Test
    void testDividingVectorByScalar() {
        v1.divideByScalar(2);
        assertEquals(0.5, v1.getX(), 1e-7);
        assertEquals(1.0, v1.getY(), 1e-7);
        assertEquals(1.5, v1.getZ(), 1e-7);
        assertEquals(2.0, v1.getW(), 1e-7);
    }

    @Test
    void testGetLength() {
        float length = v1.length();
        assertEquals(5.5, length, 1e-7);
    }

    @Test
    void testNormalize() {
        v1.normalize();
        assertEquals(0.2, v1.getX(), 1e-7);
        assertEquals(0.4, v1.getY(), 1e-7);
        assertEquals(0.5, v1.getZ(), 1e-7);
        assertEquals(0.7, v1.getW(), 1e-7);
    }

    @Test
    void testScalarMultiplication() {
        float result = v1.scalarMultiplication(v2);
        assertEquals(20.0, result, 1e-7);
    }

    @Test
    void testIsEqual() {
        Vector4f v3 = new Vector4f(1, 2, 3, 4);
        assertTrue(v1.isEqual(v3));
        assertFalse(v1.isEqual(v2));
    }
}
