package Matrixes;

import Vectors.Vector;

public interface Matrix<T extends Matrix<T, V>, V extends Vector<V>>{

    void changeElement(int row, int column, float value);
    void changeRow(int row, float[] values);
    void changeColumn(int column, float[] values);

    void addToMe(T other);
    void subtractFromMe(T other);

    T add(T other);
    T subtract(T other);

    V multiplyByVector(V vector);
    T matrixProduct(T other);

    T transpose();
    float findDeterminant();
    T findInverseMatrix();
}
