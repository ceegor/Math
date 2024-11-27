package test.matrixes;

import Matrixes.Matrix3f;
import Vectors.Vector3f;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Matrix3fTest {
    @Test
    public void testAdd() {
        Matrix3f m1 = new Matrix3f(new float[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix3f m2 = new Matrix3f(new float[][] {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });

        Matrix3f expected = new Matrix3f(new float[][] {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10}
        });

        m1.addToMe(m2);

        Assertions.assertEquals(expected.toString(), m1.toString());
    }

    @Test
    public void testAddWithCreation() {
        Matrix3f m1 = new Matrix3f(new float[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix3f m2 = new Matrix3f(new float[][] {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });

        Matrix3f expected = new Matrix3f(new float[][] {
                {10, 10, 10},
                {10, 10, 10},
                {10, 10, 10}
        });

        Matrix3f sum = m1.add(m2);

        Assertions.assertEquals(expected.toString(), sum.toString());
    }

    @Test
    public void testSubtract() {
        Matrix3f m1 = new Matrix3f(new float[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix3f m2 = new Matrix3f(new float[][] {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });

        Matrix3f expected = new Matrix3f(new float[][] {
                {-8, -6, -4},
                {-2, 0, 2},
                {4, 6, 8}
        });

        m1.subtractFromMe(m2);

        Assertions.assertEquals(expected.toString(), m1.toString());
    }

    @Test
    public void testSubtractWithCreation() {
        Matrix3f m1 = new Matrix3f(new float[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix3f m2 = new Matrix3f(new float[][] {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });

        Matrix3f expected = new Matrix3f(new float[][] {
                {-8, -6, -4},
                {-2, 0, 2},
                {4, 6, 8}
        });

        Matrix3f difference = m1.subtract(m2);

        Assertions.assertEquals(expected.toString(), difference.toString());
    }

    @Test
    public void testMultiplyMatrixByVector() {
        Matrix3f matrix = new Matrix3f(new float[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Vector3f vector = new Vector3f(1, 1, 1);
        Vector3f expected = new Vector3f(6, 15, 24); // 1*(1+2+3), 1*(4+5+6), 1*(7+8+9)

        Assertions.assertEquals(expected.getX(), matrix.multiplyByVector(vector).getX(), 1e-7);
        Assertions.assertEquals(expected.getY(), matrix.multiplyByVector(vector).getY(), 1e-7);
        Assertions.assertEquals(expected.getZ(), matrix.multiplyByVector(vector).getZ(), 1e-7);
    }

    @Test
    public void testMatrixProduct() {
        Matrix3f m1 = new Matrix3f(new float[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix3f m2 = new Matrix3f(new float[][] {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        });

        Matrix3f expected = new Matrix3f(new float[][] {
                {30, 24, 18},
                {84, 69, 54},
                {138, 114, 90}
        });

        Assertions.assertEquals(expected.toString(), m1.matrixProduct(m2).toString());
    }

    @Test
    public void testTranspose() {
        Matrix3f matrix = new Matrix3f(new float[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        Matrix3f expected = new Matrix3f(new float[][] {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        });

        Assertions.assertEquals(expected.toString(), matrix.transpose().toString());
    }

    @Test
    public void testFindDeterminant() {
        Matrix3f matrix = new Matrix3f(new float[][] {
                {1, 2, 3},
                {0, 1, 4},
                {5, 6, 0}
        });

        float expectedDeterminant = 1;
        Assertions.assertEquals(expectedDeterminant, matrix.findDeterminant(), 1e-7);
    }

    @Test
    public void testFindInverseMatrix() {
        Matrix3f matrix = new Matrix3f(new float[][] {
                {1, 2, 3},
                {0, 1, 4},
                {5, 6, 0}
        });

        Matrix3f expectedInverse = new Matrix3f(new float[][] {
                {-24, 18, 5},
                {20, -15, -4},
                {-5, 4, 1}
        });

        Assertions.assertEquals(expectedInverse.toString(), matrix.findInverseMatrix().toString());
    }

    @Test
    public void testSetZero() {
        Matrix3f expected = Matrix3f.setZero();
        Assertions.assertEquals(expected.toString(), Matrix3f.setZero().toString());
    }

    @Test
    public void testSetIdentity() {
        Matrix3f expected = Matrix3f.setIdentity();
        Assertions.assertEquals(expected.toString(), Matrix3f.setIdentity().toString());
    }
}
