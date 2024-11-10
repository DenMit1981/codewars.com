//There is a waiting room with N chairs arranged in a row. The chairs are numbered sequentially from 1 to N.
//The first one is closest to the entrance (which is also the exit).
//For some reason, people choose a chair in the following way
//Find a seat as far away from other people as possible
//Find a seat as close to the exit as possible
//All chairs must be occupied before the first person is served
//This is what it looks like for 10 chairs and 10 patients
//Chairs 1 2 3 4 5 6 7 8 9 10
//Patients 1 7 5 8 3 9 4 6 10 2
//Your task is to find the number of the chair of the last patient.
//Input: number of chairs N, an integer greater than 2.
//Output: a positive integer, the number of the chair of the last patient.

public class Kata {
    public static void main(String[] args) {
        System.out.println(lastChair(10)); //9
    }

    public static int lastChair(int n) {
        int a = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 0; j--) {
                a = i - j;
            }
            System.out.print(a + " ");
        }
        System.out.println();
        return a;
    }
}
