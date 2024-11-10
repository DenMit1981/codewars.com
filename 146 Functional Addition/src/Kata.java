//Create a function add(n)/Add(n) that returns a function that always adds n to any number.
//Note for Java: The return type and methods have not been provided to make things a little more difficult.
//...returnType addOne = Kata.add(1);
//addOne.method(3) => 4

import java.util.function.IntUnaryOperator;

public class Kata {
    public static void main(String[] args) {
        System.out.println(add(3).applyAsInt(5)); //8
    }

    public static IntUnaryOperator add(int n) {
        return x -> x + n;
    }
}
