package Vectors;

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
        if (scalar - 0 < epsilon) {
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
        if (scalar - 0 < epsilon) {
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
        if (length - 0 < epsilon) {
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
}
