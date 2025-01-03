package Vectors;

import java.util.Objects;

public class Vector4f implements Vector<Vector4f> {
    private float x;
    private float y;
    private float z;
    private float w;

    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4f(Vector3f vec, float w) {
        this.x = vec.getX();
        this.y = vec.getY();
        this.z = vec.getZ();
        this.w = w;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getW() {
        return w;
    }

    public Vector2f deleteTwoDimensions() {
        return new Vector2f(x, y);
    }

    public Vector3f deleteOneDimension() {
        return new Vector3f(x, y, z);
    }

    @Override
    public boolean isEqual(Vector4f other) {
        return Math.abs(x - other.x) < epsilon &&
                Math.abs(y - other.y) < epsilon &&
                Math.abs(z - other.z) < epsilon &&
                Math.abs(w - other.w) < epsilon;
    }

    @Override
    public void addToMe(Vector4f other) {
        x += other.x;
        y += other.y;
        z += other.z;
        w += other.w;
    }

    @Override
    public void subtractFromMe(Vector4f other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
        w -= other.w;
    }

    @Override
    public Vector4f add(Vector4f second) {
        return new Vector4f(
                this.x + second.x,
                this.y + second.y,
                this.z + second.z,
                this.w + second.w
        );
    }

    @Override
    public Vector4f subtract(Vector4f second) {
        return new Vector4f(
                this.x - second.x,
                this.y - second.y,
                this.z - second.z,
                this.w - second.w
        );
    }

    @Override
    public void multiplyByScalar(float scalar) {
        x *= scalar;
        y *= scalar;
        z *= scalar;
        w *= scalar;
    }

    @Override
    public void divideByScalar(float scalar) throws ArithmeticException {
        if(Math.abs(scalar) < epsilon){
            throw new ArithmeticException("Деление на 0");
        }
        multiplyByScalar(1/scalar);
    }

    @Override
    public Vector4f multiplyByScalarWithCreation(float scalar) {
        return new Vector4f(x*scalar, y*scalar, z*scalar, w*scalar);
    }

    @Override
    public Vector4f divideByScalarWithCreation(float scalar) throws ArithmeticException {
        if (Math.abs(scalar) < epsilon) {
            throw new ArithmeticException("Деление на 0");
        }
        return multiplyByScalarWithCreation(1/scalar);
    }


    @Override
    public float length() {
        return (float) Math.sqrt(
                x * x + y * y + z * z + w * w
        );
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
    public float scalarMultiplication(Vector4f other) {
        return (x * other.x +
                y * other.y +
                z * other.z +
                w * other.w);
    }

    @Override
    public String toString() {
        return "Vector4f(" + x + ", " + y + ", " + z + ", " + w + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector4f vector4f)) return false;
        return Float.compare(x, vector4f.x) == 0 && Float.compare(y, vector4f.y) == 0 && Float.compare(z, vector4f.z) == 0 && Float.compare(w, vector4f.w) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z, w);
    }
}
