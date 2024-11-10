//Numbers ending in zeros are boring.
//They might be funny in your world, but not here.
//Get rid of them. Only the ending ones.
//1450 -> 145
//960000 -> 96
//1050 -> 105
//-1050 -> -105
//Just the zero is fine, don't worry about it. Poor guy anyway

public class NoBoring {
    public static void main(String[] args) {

        System.out.println(noBoringZeros(1450)); //145
        System.out.println(noBoringZeros(960000)); //96
        System.out.println(noBoringZeros(1050)); //105
        System.out.println(noBoringZeros(-1050)); //-105
        System.out.println("_____________");

        System.out.println(noBoringZeros2(1450)); //145
        System.out.println(noBoringZeros2(960000)); //96
        System.out.println(noBoringZeros2(1050)); //105
        System.out.println(noBoringZeros2(-1050)); //-105
        System.out.println("_____________");

        System.out.println(noBoringZeros3(1450)); //145
        System.out.println(noBoringZeros3(960000)); //96
        System.out.println(noBoringZeros3(1050)); //105
        System.out.println(noBoringZeros3(-1050)); //-105
        System.out.println("_____________");

        System.out.println(noBoringZeros4(1450)); //145
        System.out.println(noBoringZeros4(960000)); //96
        System.out.println(noBoringZeros4(1050)); //105
        System.out.println(noBoringZeros4(-1050)); //-105
    }

    public static int noBoringZeros(int n) {
        if (n == 0) {
            return n;
        }
        while (n % 10 == 0) {
            n /= 10;
        }

        return n;
    }

    public static int noBoringZeros2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n % 10 != 0) {
            return n;
        } else {
            return noBoringZeros(n / 10);
        }
    }

    public static int noBoringZeros3(int n) {
        return n == 0 || n % 10 != 0 ? n : noBoringZeros(n / 10);
    }

    public static int noBoringZeros4(int n) {
        while (n % 10 == 0 && n != 0) {
            n /= 10;
        }

        return n;
    }
}
