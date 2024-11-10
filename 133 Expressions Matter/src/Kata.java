//Given three integers a ,b ,c, return the largest number obtained after inserting the following operators
//and parentheses: +, *, ()
//In other words, try each combination of a,b,c with [*+()] and return the largest value obtained.
//Example
//With the numbers 1, 2 and 3, here are some ways to place the signs and parentheses:
//1 * (2 + 3) = 5
//1 * 2 * 3 = 6
//1 + 2 * 3 = 7
//(1 + 2) * 3 = 9
//So the largest value you can get is 9.
//Notes
//The digits are always positive.
//The numbers range from 1 to 10.
//You can use the same operation more than once.
//You don't have to include all the signs and parentheses.
//Repeated digits are possible.
//You can't swap the operands. For example, in this example you can't get (1 + 3) * 2 = 8.

public class Kata {
    public static void main(String[] args) {
        System.out.println(expressionsMatter(1, 2, 3)); //9
        System.out.println(expressionsMatter(2, 1, 2)); //6
        System.out.println(expressionsMatter(1, 1, 1)); //3
        System.out.println(expressionsMatter(5, 1, 3)); //20
        System.out.println(expressionsMatter(6, 7, 1)); //48
        System.out.println(expressionsMatter(9, 7, 2)); //126
        System.out.println(expressionsMatter(10, 5, 6)); //300
        System.out.println();

        System.out.println(expressionsMatter2(1, 2, 3)); //9
        System.out.println(expressionsMatter2(2, 1, 2)); //6
        System.out.println(expressionsMatter2(1, 1, 1)); //3
        System.out.println(expressionsMatter2(5, 1, 3)); //20
        System.out.println(expressionsMatter2(6, 7, 1)); //48
        System.out.println(expressionsMatter2(9, 7, 2)); //126
        System.out.println(expressionsMatter2(10, 5, 6)); //300
    }

    public static int expressionsMatter(int a, int b, int c) {
        int max1 = getMax(a, getMax(b, c));
        int max2 = getMax(getMax(a, b), c);

        return Math.max(max1, max2);
    }

    private static int getMax(int x1, int x2) {
        return x1 == 1 || x2 == 1 ?
                (x1 + x2) : x1 * x2;
    }

    public static int expressionsMatter2(int a, int b, int c) {
        int max = a * b * c; //(max==largest)

        if (a * (b + c) > max)
            max = a * (b + c);

        if (a + b + c > max)
            max = a + b + c;

        if (a + b * c > max)
            max = a + b * c;

        if ((a + b) * c > max)
            max = (a + b) * c;

        return max;
    }
}
