package Matrixes;

import Vectors.*;

public class Matrix3f implements Matrix<Matrix3f, Vector3f> {

    private final float[][] elements;

    public Matrix3f(float[][] elements) {
        if (elements.length != 3 || elements[0].length != 3) {
            throw new IllegalArgumentException("Матрица должна быть 3x3");
        }
        this.elements = new float[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(elements[i], 0, this.elements[i], 0, 3);
        }
    }

    @Override
    public void changeElement(int row, int column, float value) throws IndexOutOfBoundsException {
        if (row > 3 || column > 3) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы матрицы");
        }
        elements[row - 1][column - 1] = value;
    }

    @Override
    public void changeRow(int row, float[] values) throws IllegalArgumentException {
        if (values.length != 3 || row > 3) {
            throw new IllegalArgumentException("Вы вышли за пределы матрицы");
        }
        for (int i = 0; i < 3; i++) {
            elements[row - 1][i] = values[i];
        }
    }

    @Override
    public void changeColumn(int column, float[] values) throws IllegalArgumentException {
        if (values.length != 3 || column > 3) {
            throw new IllegalArgumentException("Вы вышли за пределы матрицы");
        }
        for (int i = 0; i < 3; i++) {
            elements[i][column - 1] = values[i];
        }
    }

    public static Matrix3f setZero() {
        return new Matrix3f(new float[][] {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
    }

    public static Matrix3f setIdentity() {
        return new Matrix3f(new float[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        });
    }

    @Override
    public Matrix3f add(Matrix3f second) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.elements[i][j] + second.elements[i][j];
            }
        }
        return new Matrix3f(result);
    }

    @Override
    public void addToMe(Matrix3f other) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                elements[i][j] += other.elements[i][j];
            }
        }
    }

    @Override
    public Matrix3f subtract(Matrix3f second) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = this.elements[i][j] - second.elements[i][j];
            }
        }
        return new Matrix3f(result);
    }

    @Override
    public void subtractFromMe(Matrix3f other) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                elements[i][j] -= other.elements[i][j];
            }
        }
    }

    @Override
    public Vector3f multiplyByVector(Vector3f vector) {
        float[] result = new float[3];
        for (int i = 0; i < 3; i++) {
            result[i] = elements[i][0] * vector.getX() +
                        elements[i][1] * vector.getY() +
                        elements[i][2] * vector.getZ();
        }
        return new Vector3f(result[0], result[1], result[2]);
    }

    @Override
    public Matrix3f matrixProduct(Matrix3f other) {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = elements[i][0] * other.elements[0][j] +
                               elements[i][1] * other.elements[1][j] +
                               elements[i][2] * other.elements[2][j];
            }
        }
        return new Matrix3f(result);
    }

    @Override
    public Matrix3f transpose() {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = elements[i][j];
            }
        }
        return new Matrix3f(result);
    }

    @Override
    public void transposeMe() {
        float[][] result = new float[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = elements[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                elements[i][j] = result[i][j];
            }
        }
    }

    @Override
    public float findDeterminant() {
        return elements[0][0]*elements[1][1]*elements[2][2] +
                        elements[0][1]*elements[1][2]*elements[2][0] +
                        elements[1][0]*elements[2][1]*elements[0][2] -
                        elements[0][2]*elements[1][1]*elements[2][0] -
                        elements[0][1]*elements[1][0]*elements[2][2] -
                        elements[0][0]*elements[1][2]*elements[2][1];
    }

    @Override
    public Matrix3f findInverseMatrix() throws IllegalArgumentException {
        float determinant = findDeterminant();

        if (determinant - 0 < epsilon_matrix) {
            throw new IllegalArgumentException("Матрица не имеет обратной матрицы (определитель равен нулю)");
        }

        float[][] inverse = new float[3][3];

        // Вычисляем алгебраические дополнения
        inverse[0][0] = minor(0, 0) * 1;
        inverse[0][1] = minor(0, 1) * -1;
        inverse[0][2] = minor(0, 2) * 1;

        inverse[1][0] = minor(1, 0) * -1;
        inverse[1][1] = minor(1, 1) * 1;
        inverse[1][2] = minor(1, 2) * -1;

        inverse[2][0] = minor(2, 0) * 1;
        inverse[2][1] = minor(2, 1) * -1;
        inverse[2][2] = minor(2, 2) * 1;

        Matrix3f inverseMatrix = new Matrix3f(inverse).transpose();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverseMatrix.elements[i][j] /= determinant;
            }
        }

        return inverseMatrix;
    }

    private float minor(int row, int col) {
        float[][] minorMatrix = new float[2][2];
        int minorRow = 0;

        for (int i = 0; i < 3; i++) {
            if (i == row) continue;
            int minorCol = 0;
            for (int j = 0; j < 3; j++) {
                if (j == col) continue;
                minorMatrix[minorRow][minorCol++] = elements[i][j];
            }
            minorRow++;
        }
        return determinantOf2x2(minorMatrix);
    }

    private float determinantOf2x2(float[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
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

}
