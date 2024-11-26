package Matrixes;

import Vectors.Vector;

public interface Matrix<T extends Matrix<T, V>, V extends Vector<V>>{

    void add(T other);
    void subtract(T other);

    V multiplyByVector(V vector);
    T matrixProduct(T other);

    T transpose();
    float findDeterminant();
    T findInverseMatrix();
}
