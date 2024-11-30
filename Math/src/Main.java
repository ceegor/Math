import Vectors.*;
import Matrixes.*;


public class Main {
    public static void main(String[] args) {
        Vector2f vec1 = new Vector2f(2,2);
        Vector3f res = vec1.addOneDimension();
        System.out.println(res.toString());
    }
}
