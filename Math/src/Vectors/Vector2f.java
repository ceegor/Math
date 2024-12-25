package Vectors;

import java.util.Objects;

public class Vector2f implements Vector<Vector2f> {
    private float x;
    private float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Vector3f addOneDimension() {
        System.out.println("Введите значение z: ");
        float z = scanner.nextFloat();
        return new Vector3f(x, y, z);
    }

    public Vector4f addTwoDimensions() {
        System.out.println("Введите значения z и w: ");
        float z = scanner.nextFloat();
        float w = scanner.nextFloat();
        return new Vector4f(x, y, z, w);
    }

    @Override
    public boolean isEqual(Vector2f other) {
        return Math.abs(x - other.x) < epsilon &&
                Math.abs(y - other.y) < epsilon;
    }

    @Override
    public void addToMe(Vector2f other) {
        x += other.x;
        y += other.y;
    }

    @Override
    public void subtractFromMe(Vector2f other) {
        x -= other.x;
        y -= other.y;
    }

    @Override
    public Vector2f add(Vector2f second) {
        return new Vector2f(
                this.x + second.x,
                this.y + second.y
        );
    }

    @Override
    public Vector2f subtract(Vector2f second) {
        return new Vector2f(
                this.x - second.x,
                this.y - second.y
        );
    }

    @Override
    public void multiplyByScalar(float scalar) {
        x *= scalar;
        y *= scalar;
    }

    @Override
    public void divideByScalar(float scalar) throws ArithmeticException {
        if (Math.abs(scalar) < epsilon) {
            throw new ArithmeticException("Деление на 0");
        }
        multiplyByScalar(1/scalar);
    }

    @Override
    public Vector2f multiplyByScalarWithCreation(float scalar) {
        return new Vector2f(x*scalar, y*scalar);
    }

    @Override
    public Vector2f divideByScalarWithCreation(float scalar) throws ArithmeticException {
        if (Math.abs(scalar) < epsilon) {
            throw new ArithmeticException("Деление на 0");
        }
        return multiplyByScalarWithCreation(1/scalar);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(x * x + y * y);
    }

    @Override
    public void normalize() {
        float length = length();
        if (Math.abs(length) < epsilon) {
            throw new ArithmeticException("Длина равна 0, невозможно нормализовать вектор");
        }
        multiplyByScalar(1/length);
    }

    @Override
    public float scalarMultiplication(Vector2f other) {
        return (x * other.x + y * other.y);
    }

    @Override
    public String toString() {
        return "Vector2f(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector2f vector2f)) return false;
        return Float.compare(x, vector2f.x) == 0 && Float.compare(y, vector2f.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
