package Vectors;

public class Vector2f implements Vector<Vector2f> {
    public float x;
    public float y;

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

    @Override
    public boolean isEqual(Vector2f other) {
        return Math.abs(x - other.x) < epsilon &&
                Math.abs(y - other.y) < epsilon;
    }

    public static Vector2f addAndCreate(Vector2f first, Vector2f second) {
        return new Vector2f(
                first.x + second.x,
                first.y + second.y
        );
    }

    @Override
    public void add(Vector2f other) {
        x += other.x;
        y += other.y;
    }

    public static Vector2f subtractAndCreate(Vector2f first, Vector2f second) {
        return new Vector2f(
                first.x - second.x,
                first.y - second.y
        );
    }

    @Override
    public void subtract(Vector2f other) {
        x -= other.x;
        y -= other.y;
    }

    @Override
    public void multiplyByScalar(float scalar) {
        x = Math.round(x * scalar * 10.0f) / 10.0f;
        y = Math.round(y * scalar * 10.0f) / 10.0f;
    }

    @Override
    public void divideByScalar(float scalar) throws ArithmeticException {
        if (scalar == 0) {
            throw new ArithmeticException("Деление на 0");
        }
        x = Math.round(x / scalar * 10.0f) / 10.0f;
        y = Math.round(y / scalar * 10.0f) / 10.0f;
    }

    @Override
    public float length() {
        float length = (float) Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
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
    }

    @Override
    public float scalarMultiplication(Vector2f other) {
        return (x * other.x + y * other.y);
    }

    @Override
    public String toString() {
        return "Vector2f(" + x + "," + y + ")";
    }
}
