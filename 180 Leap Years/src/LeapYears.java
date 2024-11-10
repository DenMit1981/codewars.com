//In this kata you simply have to determine whether a given year is a leap year or not. If you don't know the rules,
//here they are:
//years that are divisible by 4 are leap years
//but years that are multiples of 100 are not leap years
//but years that are multiples of 400 are leap years
//Additional notes:
//Only valid years (positive integers) will be checked, so you don't need to check them.

public class LeapYears {
    public static void main(String[] args) {
        System.out.println(isLeapYear(2020)); //true
        System.out.println(isLeapYear(2000)); //true
        System.out.println(isLeapYear(2015)); //false
        System.out.println(isLeapYear(2100)); //false
    }

    public static boolean isLeapYear(int year) {
        if (year >= 400) {
            return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        }
        if (year >= 100) {
            return year % 4 == 0 && year % 100 != 0;
        }
        return year % 4 == 0;
    }
}
