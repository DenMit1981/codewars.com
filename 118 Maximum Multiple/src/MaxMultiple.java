//Everything we eat is water and dry matter.
//Let's start with an example:
//John bought some potatoes: they weigh 100 kilograms. The potatoes contain water and dry matter.
//The water content is 99 percent of the total mass. He thinks they are too wet, so he puts them in the oven
//at a low temperature so they lose some water.
//When they come out, the water content is only 98%.
//What is the total weight in kilograms (water content plus dry matter) coming out of the oven?
//
//He finds 50 kilograms and thinks he's wrong: "So much weight lost for such a small change in water content!"
//Can you help him?
//Given a divisor and a limit. Find the largest integer N such that
//Conditions:
//1.N is divisible by the divisor
//2.N is less than or equal to the bound
//3.N is greater than 0.
//Notes
//Parameters (divisor, bound) passed to the function are only positive values.
//It is guaranteed that the divisor is found.
//Input >> Output examples
//maxMultiple (2,7) ==> return (6)
//Explanation:
//(6) is divisible by (2) , (6) is less than or equal to the bound (7) , and (6) > 0 .
//
//maxMultiple (10,50) ==> return (50)
//Explanation:
//(50) is divisible by (10) , (50) is less than or equal to the bound of (50) , and (50) > 0 .*
//
//maxMultiple (37,200) ==> return (185)
//Explanation:
//(185) is divisible by (37) , (185) is less than or equal to the bound of (200) , and (185) > 0 .

public class MaxMultiple {
    public static void main(String[] args) {
        System.out.println(maxMultiple(10, 55)); //50
        System.out.println(maxMultiple(2, 7)); //6
        System.out.println(maxMultiple(10, 50)); //50
        System.out.println(maxMultiple(37, 200)); //185
    }

    public static int maxMultiple(int divisor, int bound) {
        int maxMultiNum = bound;

        while (!isConditionsMet(maxMultiNum, divisor, bound)) {
            maxMultiNum--;
        }
        return maxMultiNum;
    }

    private static boolean isConditionsMet(int num, int divisor, int bound) {
        return num <= bound && num > 0 && num % divisor == 0;
    }
}
