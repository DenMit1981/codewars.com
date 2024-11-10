//This program tests the lifespan of an evaporator containing gas.
//We know the contents of the evaporator (content in ml), the percentage of foam or gas lost each day (evap_per_day)
//and a threshold in percent, above which the evaporator becomes useless.
//All numbers are strictly positive.
//The program reports the n-th day (as an integer) when the evaporator will not be used.
//Example:
//evaporator(10, 10, 5) -> 29
//Note:
//The contents are not really required in the body of the "evaporator" function, you can use them or not,
//as you wish. Some people prefer to reason by contents, some by percentages only. It's up to you,
//but you should leave it as a parameter, because the tests use it as an argument.

public class Evaporator {
    public static void main(String[] args) {
        System.out.println((evaporator(10, 10, 10))); //22
        System.out.println((evaporator(10, 10, 5))); //29
    }

    public static int evaporator(double content, double evap_per_day, double threshold) {
        double lostContentADay;
        double limitContent = content * threshold * 0.01;
        int count = 0;

        while (content > limitContent) {
            lostContentADay = content * evap_per_day * 0.01;
            content = content - lostContentADay;

            count++;
        }
        return count;
    }
}
