//Given an array of N integers, you need to find how many times you need to add the smallest numbers in the array,
//until their sum is greater than or equal to K.
//Notes:
//The list size is at least 3.
//All numbers will be positive.
//Numbers may appear more than once (there may be duplicates).
//The threshold K will always be reachable.
//minSteps({1, 10, 12, 9, 2, 3}, 6) ==> return (2)
//Explanation:
//We add the two smallest elements (1+2), their sum is 3.
//Then we add the next smallest number (3+3), so the sum becomes 6.
//The result is now greater than or equal to 6. Therefore, the output is (2), i.e. it requires
//(2) operations.
//minSteps({8, 9, 4, 2}, 23) ==> return (3)
//Explanation:
//We add the two smallest elements (4+2), their sum is 6.
//Then we add the next smallest number (6 + 8), so the sum becomes 14.
//Now we add the next smallest number (14 + 9), so the sum becomes 23.
//Now the result is greater than or equal to 23. Therefore, the output is (3), i.e. it requires (3)
//operations.
//minSteps({19,98,69,28,75,45,17,98,67}, 464) ==> return (8)
//Explanation:
//We add the two smallest elements (19+17), their sum is 36.
//Then we add the next smallest number (36 + 28), so the sum becomes 64.
//We need to keep doing this until the sum is greater than or equal to K (in this case 464),
//which will take 8 steps.

import java.util.Arrays;

public class Kata {
    public static void main(String[] args) {
        System.out.println(minimumSteps(new int[]{1, 10, 12, 9, 2, 3}, 6)); //2
        System.out.println(minimumSteps(new int[]{8, 9, 4, 2}, 23)); //3
        System.out.println(minimumSteps(new int[]{19, 98, 69, 28, 75, 45, 17, 98, 67}, 464)); //8
        System.out.println(minimumSteps(new int[]{4, 6, 3}, 7)); //1
        System.out.println(minimumSteps(new int[]{10, 9, 9, 8}, 17)); //1
    }

    public static int minimumSteps(int[] numbers, int k) {
        Arrays.sort(numbers);
        int sum = 0;
        int count = 0;

        for (int number : numbers) {
            sum += number;
            count++;
            if (sum >= k) {
                break;
            }
        }
        return count - 1;
    }
}
