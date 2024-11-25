package Vectors;

public class Vector3f implements Vector<Vector3f> {
    public float x;
    public float y;
    public float z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    @Override
    public boolean isEqual(Vector3f other) {
        return Math.abs(x - other.x) < epsilon &&
                Math.abs(y - other.y) < epsilon &&
                Math.abs(z - other.z) < epsilon;
    }

    public static Vector3f addAndCreate(Vector3f first, Vector3f second) {
        return new Vector3f(
                first.x + second.x,
                first.y + second.y,
                first.z + second.z
        );
    }

    @Override
    public void add(Vector3f other) {
        x += other.x;
        y += other.y;
        z += other.z;
    }

    public static Vector3f subtractAndCreate(Vector3f first, Vector3f second) {
        return new Vector3f(
                first.x - second.x,
                first.y - second.y,
                first.z - second.z
        );
    }

    @Override
    public void subtract(Vector3f other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
    }

    @Override
    public void multiplyByScalar(float scalar) {
        x = Math.round(x * scalar * 10.0f) / 10.0f;
        y = Math.round(y * scalar * 10.0f) / 10.0f;
        z = Math.round(z * scalar * 10.0f) / 10.0f;
    }

    @Override
    public void divideByScalar(float scalar) throws ArithmeticException {
        if (scalar == 0) {
            throw new ArithmeticException("Деление на 0");
        }
        x = Math.round(x / scalar * 10.0f) / 10.0f;
        y = Math.round(y / scalar * 10.0f) / 10.0f;
        z = Math.round(z / scalar * 10.0f) / 10.0f;
    }

    @Override
    public float length() {
        float length = (float) Math.sqrt(
                        Math.pow(x, 2) +
                        Math.pow(y, 2) +
                        Math.pow(z, 2)
        );
        return Math.round(length * 10.0f) / 10.0f;
    }

    @Override
    public void normalize() {
        float length = length();
        if (length == 0) {
            throw new ArithmeticException("Длина равна 0, невозможно нормализовать вектор");
        }
        x = Math.round(x / length * 10.0f) / 10.0f;
        y = Math.round(y / length * 10.0f) / 10.0f;
        z = Math.round(z / length * 10.0f) / 10.0f;
    }

    @Override
    public float scalarMultiplication(Vector3f other) {
        return (x * other.x +
                y * other.y +
                z * other.z);
    }

    public Vector3f vectorProduct(Vector3f other) {
        return new Vector3f(
                y * other.z - z * other.y,
                z * other.x - x * other.z,
                x * other.y - y * other.x);
    }

    @Override
    public String toString() {
        return "Vector3f(" + x + ", " + y + ", " + z + ")";
    }
}
