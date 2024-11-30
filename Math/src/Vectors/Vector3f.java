package Vectors;

public class Vector3f implements Vector<Vector3f> {
    private float x;
    private float y;
    private float z;

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

    @Override
    public void addToMe(Vector3f other) {
        x += other.x;
        y += other.y;
        z += other.z;
    }

    @Override
    public void subtractFromMe(Vector3f other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
    }

    @Override
    public Vector3f add(Vector3f second) {
        return new Vector3f(
                this.x + second.x,
                this.y + second.y,
                this.z + second.z
        );
    }

    @Override
    public Vector3f subtract(Vector3f second) {
        return new Vector3f(
                this.x - second.x,
                this.y - second.y,
                this.z - second.z
        );
    }

    @Override
    public void multiplyByScalar(float scalar) {
        x *= scalar;
        y *= scalar;
        z *= scalar;
    }

    @Override
    public void divideByScalar(float scalar) throws ArithmeticException {
        if (scalar - 0 < epsilon) {
            throw new ArithmeticException("Деление на 0");
        }
        multiplyByScalar(1/scalar);
    }

    @Override
    public Vector3f multiplyByScalarWithCreation(float scalar) {
        return new Vector3f(x*scalar, y*scalar, z*scalar);
    }

    @Override
    public Vector3f divideByScalarWithCreation(float scalar) throws ArithmeticException {
        if (scalar - 0 < epsilon) {
            throw new ArithmeticException("Деление на 0");
        }
        return multiplyByScalarWithCreation(1/scalar);
    }

    @Override
    public float length() {
        return (float) Math.sqrt(
                        x * x +
                        y * y +
                        z * z
        );
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

    public void vectorProductToMe(Vector3f other) {
        float newX = y * other.z - z * other.y;
        float newY = z * other.x - x * other.z;
        float newZ = x * other.y - y * other.x;
        x = newX;
        y = newY;
        z = newZ;
    }

    @Override
    public String toString() {
        return "Vector3f(" + x + ", " + y + ", " + z + ")";
    }
}
