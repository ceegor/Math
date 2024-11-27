package test.matrixes;

import Matrixes.Matrix4f;
import Vectors.Vector4f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Matrix4fTest {
    @Test
    public void testAdd() {
        Matrix4f m1 = new Matrix4f(new float[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Matrix4f m2 = new Matrix4f(new float[][] {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        });

        Matrix4f expected = new Matrix4f(new float[][] {
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17}
        });

        m1.addToMe(m2);

        Assertions.assertEquals(expected.toString(), m1.toString());
    }

    @Test
    public void testAddWithCreation() {
        Matrix4f m1 = new Matrix4f(new float[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Matrix4f m2 = new Matrix4f(new float[][] {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        });

        Matrix4f expected = new Matrix4f(new float[][] {
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17},
                {17, 17, 17, 17}
        });

        Matrix4f sum = m1.add(m2);

        Assertions.assertEquals(expected.toString(), sum.toString());
    }

    @Test
    public void testSubtract() {
        Matrix4f m1 = new Matrix4f(new float[][] {
                {10, 20, 30, 40},
                {50, 60, 70, 80},
                {90, 100, 110, 120},
                {130, 140, 150, 160}
        });

        Matrix4f m2 = new Matrix4f(new float[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Matrix4f expected = new Matrix4f(new float[][] {
                {9, 18, 27, 36},
                {45, 54, 63, 72},
                {81, 90, 99, 108},
                {117, 126, 135, 144}
        });

        m1.subtractFromMe(m2);

        Assertions.assertEquals(expected.toString(), m1.toString());
    }

    @Test
    public void testSubtractWithCreation() {
        Matrix4f m1 = new Matrix4f(new float[][] {
                {10, 20, 30, 40},
                {50, 60, 70, 80},
                {90, 100, 110, 120},
                {130, 140, 150, 160}
        });

        Matrix4f m2 = new Matrix4f(new float[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Matrix4f expected = new Matrix4f(new float[][] {
                {9, 18, 27, 36},
                {45, 54, 63, 72},
                {81, 90, 99, 108},
                {117, 126, 135, 144}
        });

        Matrix4f difference = m1.subtract(m2);

        Assertions.assertEquals(expected.toString(), difference.toString());
    }

    @Test
    public void testMultiplyMatrixByVector() {
        Matrix4f matrix = new Matrix4f(new float[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Vector4f vector = new Vector4f(1, 1, 1, 1);
        Vector4f expected = new Vector4f(10, 26, 42, 58); // Sum of each row

        Assertions.assertEquals(expected.getX(), matrix.multiplyByVector(vector).getX(), 1e-7);
        Assertions.assertEquals(expected.getY(), matrix.multiplyByVector(vector).getY(), 1e-7);
        Assertions.assertEquals(expected.getZ(), matrix.multiplyByVector(vector).getZ(), 1e-7);
        Assertions.assertEquals(expected.getW(), matrix.multiplyByVector(vector).getW(), 1e-7);
    }

    @Test
    public void testMatrixProduct() {
        Matrix4f m1 = new Matrix4f(new float[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Matrix4f m2 = new Matrix4f(new float[][] {
                {16, 15, 14, 13},
                {12, 11, 10, 9},
                {8, 7, 6, 5},
                {4, 3, 2, 1}
        });

        Matrix4f expected = new Matrix4f(new float[][] {
                {80, 70, 60, 50},
                {240, 214, 188, 162},
                {400, 358, 316, 274},
                {560, 502, 444, 386}
        });

        Assertions.assertEquals(expected.toString(), m1.matrixProduct(m2).toString());
    }

    @Test
    public void testTranspose() {
        Matrix4f matrix = new Matrix4f(new float[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        Matrix4f expected = new Matrix4f(new float[][] {
                {1, 5, 9, 13},
                {2, 6, 10, 14},
                {3, 7, 11, 15},
                {4, 8, 12, 16}
        });

        Assertions.assertEquals(expected.toString(), matrix.transpose().toString());
    }

    @Test
    public void testFindDeterminant() {
        Matrix4f matrix = new Matrix4f(new float[][] {
                {1, 2, 3, 4},
                {0, 1, 4, 5},
                {5, 6, 0, 0},
                {1, 0, 0, 1}
        });

        float expectedDeterminant = 7;
        Assertions.assertEquals(expectedDeterminant, matrix.findDeterminant(), 1e-7);
    }

    @Test
    public void testFindInverseMatrix() {
        Matrix4f matrix = new Matrix4f(new float[][] {
                {2, 1, 0, 0},
                {3, 2, 0, 0},
                {1, 1, 3, 4},
                {2, -1, 2, 3}
        });

        Matrix4f expectedInverse = new Matrix4f(new float[][] {
                {2, -1, 0, 0},
                {-3, 2, 0, 0},
                {31, -19, 3, -4},
                {-23, 14, -2, 3}
        });

        Assertions.assertEquals(expectedInverse.toString(), matrix.findInverseMatrix().toString());
    }

    @Test
    public void testSetZero() {
        Matrix4f expected = Matrix4f.setZero();
        Assertions.assertEquals(expected.toString(), Matrix4f.setZero().toString());
    }

    @Test
    public void testSetIdentity() {
        Matrix4f expected = Matrix4f.setIdentity();
        Assertions.assertEquals(expected.toString(), Matrix4f.setIdentity().toString());
    }
}
