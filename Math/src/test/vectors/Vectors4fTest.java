package test.vectors;

import static org.junit.jupiter.api.Assertions.*;

import Vectors.Vector3f;
import Vectors.Vector4f;
import org.junit.jupiter.api.Assertions;
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
    void isLengthEqualTest() {
        boolean result = v1.isLengthEqual(v2);
        Assertions.assertTrue(result);
    }

    @Test
    void testAddWithCreation() {
        Vector4f result = v1.add(v2);
        assertEquals(5.0, result.getX(), 1e-7);
        assertEquals(5.0, result.getY(), 1e-7);
        assertEquals(5.0, result.getZ(), 1e-7);
        assertEquals(5.0, result.getW(), 1e-7);
    }

    @Test
    void testAdd() {
        v1.addToMe(v2);
        assertEquals(5.0, v1.getX(), 1e-7);
        assertEquals(5.0, v1.getY(), 1e-7);
        assertEquals(5.0, v1.getZ(), 1e-7);
        assertEquals(5.0, v1.getW(), 1e-7);
    }

    @Test
    void testSubtractWithCreation() {
        Vector4f result = v1.subtract(v2);
        assertEquals(-3.0, result.getX(), 1e-7);
        assertEquals(-1.0, result.getY(), 1e-7);
        assertEquals(1.0, result.getZ(), 1e-7);
        assertEquals(3.0, result.getW(), 1e-7);
    }

    @Test
    void testSubtract() {
        v1.subtractFromMe(v2);
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
    void testMultiplyingVectorByScalarWithCreation() {
        Vector4f res = v1.multiplyByScalarWithCreation(2);
        assertEquals(2.0, res.getX(), 1e-7);
        assertEquals(4.0, res.getY(), 1e-7);
        assertEquals(6.0, res.getZ(), 1e-7);
        assertEquals(8.0, res.getW(), 1e-7);
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
    void testDividingVectorByScalarWithCreation() {
        Vector4f res = v1.divideByScalarWithCreation(2);
        assertEquals(0.5, res.getX(), 1e-7);
        assertEquals(1.0, res.getY(), 1e-7);
        assertEquals(1.5, res.getZ(), 1e-7);
        assertEquals(2.0, res.getW(), 1e-7);
    }

    @Test
    void testGetLength() {
        float length = v1.length();
        assertEquals( (float) Math.sqrt(30), length, 1e-7);
    }

    @Test
    void testNormalize() {
        v1.normalize();
        assertEquals((float) 1/Math.sqrt(30), v1.getX(), 1e-7);
        assertEquals((float) 2/Math.sqrt(30), v1.getY(), 1e-7);
        assertEquals((float) 3/Math.sqrt(30), v1.getZ(), 1e-7);
        assertEquals((float) 4/Math.sqrt(30), v1.getW(), 1e-7);
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
