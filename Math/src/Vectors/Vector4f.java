package Vectors;

public class Vector4f implements Vector<Vector4f> {
    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    @Override
    public boolean isEqual(Vector4f other) {
        return Math.abs(x - other.x) < epsilon &&
                Math.abs(y - other.y) < epsilon &&
                Math.abs(z - other.z) < epsilon &&
                Math.abs(w - other.w) < epsilon;
    }

    public static Vector4f addAndCreate(Vector4f first, Vector4f second) {
        return new Vector4f(
                first.x + second.x,
                first.y + second.y,
                first.z + second.z,
                first.w + second.w
        );
    }

    @Override
    public void add(Vector4f other) {
        x += other.x;
        y += other.y;
        z += other.z;
        w += other.w;
    }

    public static Vector4f subtractAndCreate(Vector4f first, Vector4f second) {
        return new Vector4f(
                first.x - second.x,
                first.y - second.y,
                first.z - second.z,
                first.w - second.w
        );
    }

    @Override
    public void subtract(Vector4f other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
        w -= other.w;
    }

    @Override
    public void multiplyByScalar(float scalar) {
        x = Math.round(x * scalar * 10.0f) / 10.0f;
        y = Math.round(y * scalar * 10.0f) / 10.0f;
        z = Math.round(z * scalar * 10.0f) / 10.0f;
        w = Math.round(w * scalar * 10.0f) / 10.0f;
    }

    @Override
    public void divideByScalar(float scalar) throws ArithmeticException {
        if(scalar == 0){
            throw new ArithmeticException("Деление на 0");
        }
        x = Math.round(x / scalar * 10.0f) / 10.0f;
        y = Math.round(y / scalar * 10.0f) / 10.0f;
        z = Math.round(z / scalar * 10.0f) / 10.0f;
        w = Math.round(w / scalar * 10.0f) / 10.0f;
    }

    @Override
    public float length() {
        float length = (float) Math.sqrt(
                Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2) + Math.pow(w, 2)
        );
        return Math.round(length * 10.0f) / 10.0f;
    }

    @Override
    public void normalize() {
        double length = length();
        if (length == 0) {
            throw new ArithmeticException("Длина равна 0, невозможно нормализовать вектор");
        }
        x = Math.round(x / length * 10f) / 10f;
        y = Math.round(y / length * 10f) / 10f;
        z = Math.round(z / length * 10f) / 10f;
        w = Math.round(w / length * 10f) / 10f;
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
}
