package Matrixes;

import Vectors.Vector4f;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Objects;

public class Matrix4f implements Matrix<Matrix4f, Vector4f> {
    private final float[][] elements;

    public Matrix4f (float x11, float x12, float x13, float x14,
                     float x21, float x22, float x23, float x24,
                     float x31, float x32, float x33, float x34,
                     float x41, float x42, float x43, float x44) {
        this.elements = new float[][] {
                {x11, x12, x13, x14},
                {x21, x22, x23, x24},
                {x31, x32, x33, x34},
                {x41, x42, x43, x44}
        };
    }

    public Matrix4f(float[][] elements) throws IndexOutOfBoundsException {
        if (elements.length != 4 || elements[0].length != 4) {
            throw new IndexOutOfBoundsException("Матрица должна быть 4x4");
        }
        this.elements = new float[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(elements[i], 0, this.elements[i], 0, 4);
        }
    }

    @Override
    public void changeElement(int row, int column, float value) throws IndexOutOfBoundsException {
        if (row > 4 || column > 4) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы матрицы");
        }
        elements[row - 1][column - 1] = value;
    }

    @Override
    public void changeRow(int row, float[] values) throws IndexOutOfBoundsException {
        if (values.length != 4 || row > 4) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы матрицы");
        }
        for (int i = 0; i < 4; i++) {
            elements[row - 1][i] = values[i];
        }
    }

    @Override
    public void changeColumn(int column, float[] values) throws IndexOutOfBoundsException {
        if (values.length != 4 || column > 4) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы матрицы");
        }
        for (int i = 0; i < 4; i++) {
            elements[i][column - 1] = values[i];
        }
    }

    public static Matrix4f setZero() {
        return new Matrix4f(new float[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });
    }

    public static Matrix4f setIdentity() {
        return new Matrix4f(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        });
    }

    @Override
    public Matrix4f add(Matrix4f second) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.elements[i][j] + second.elements[i][j];
            }
        }
        return new Matrix4f(result);
    }

    @Override
    public Matrix4f subtract(Matrix4f second) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = this.elements[i][j] - second.elements[i][j];
            }
        }
        return new Matrix4f(result);
    }

    @Override
    public void addToMe(Matrix4f other) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                elements[i][j] += other.elements[i][j];
            }
        }
    }

    @Override
    public void subtractFromMe(Matrix4f other) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                elements[i][j] -= other.elements[i][j];
            }
        }
    }

    @Override
    public Vector4f multiplyByVector(Vector4f vector) {
        float[] result = new float[4];
        for (int i = 0; i < 4; i++) {
            result[i] = elements[i][0] * vector.getX() +
                    elements[i][1] * vector.getY() +
                    elements[i][2] * vector.getZ() +
                    elements[i][3] * vector.getW();
        }
        return new Vector4f(result[0], result[1], result[2], result[3]);
    }

    @Override
    public Matrix4f matrixProduct(Matrix4f other) {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = elements[i][0] * other.elements[0][j] +
                        elements[i][1] * other.elements[1][j] +
                        elements[i][2] * other.elements[2][j] +
                        elements[i][3] * other.elements[3][j];
            }
        }
        return new Matrix4f(result);
    }

    @Override
    public Matrix4f transpose() {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[j][i] = elements[i][j];
            }
        }
        return new Matrix4f(result);
    }

    @Override
    public void transposeMe() {
        float[][] result = new float[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                result[j][i] = elements[i][j];
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                elements[i][j] = result[i][j];
            }
        }
    }

    @Override
    public float findDeterminant() {
        return elements[0][0] * minor(0, 0) -
                elements[0][1] * minor(0, 1) +
                elements[0][2] * minor(0, 2) -
                elements[0][3] * minor(0, 3);
    }

    @Override
    public Matrix4f findInverseMatrix() throws ArithmeticException {
        float determinant = findDeterminant();
        if (Math.abs(determinant) < epsilon_matrix) {
            throw new ArithmeticException("Матрица не имеет обратной матрицы (определитель равен нулю)");
        }

        float[][] inverse = new float[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                float sign = ((i + j) % 2 == 0) ? 1 : -1;
                inverse[j][i] = sign * minor(i, j);
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                inverse[i][j] /= determinant;

                if (Math.abs(inverse[i][j]) < epsilon_matrix) {
                    inverse[i][j] = 0.0f;
                }
            }
        }

        return new Matrix4f(inverse);
    }


    private float minor(int row, int col) {
        float[][] minorMatrix = new float[3][3];
        int minorRow = 0, minorCol;

        for (int i = 0; i < 4; i++) {
            if (i == row) continue;
            minorCol = 0;
            for (int j = 0; j < 4; j++) {
                if (j == col) continue;
                minorMatrix[minorRow][minorCol++] = elements[i][j];
            }
            minorRow++;
        }

        return determinantOf3x3(minorMatrix);
    }

    private float determinantOf3x3(float[][] matrix) {
        return  matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1]) -
                matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]) +
                matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (float[] row : elements) {
            sb.append("[ ");
            for (float value : row) {
                sb.append(value).append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix4f matrix4f)) return false;
        return Objects.deepEquals(elements, matrix4f.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(elements);
    }
}
