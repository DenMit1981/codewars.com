//I will give you an integer. Give me back a shape that is as long and wide as the integer.
//The integer will be a whole number between 1 and 50.
//Example
//n = 3, so I expect a 3x3 square back just like below as a string:
//+++
//+++
//+++

public class Kata {
    public static void main(String[] args) {
        System.out.println(generateShape(3));
        System.out.println(generateShape(7));
    }

    public static String generateShape(int n) {
        StringBuilder shape = new StringBuilder();

        for (int i = 0; i < n; i++) {
            shape.append("+".repeat(n)).append("\n");
        }

        return shape.substring(0, shape.lastIndexOf("\n"));
    }
}
