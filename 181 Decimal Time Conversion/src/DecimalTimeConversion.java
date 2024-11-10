//Write two functions, one to convert standard time to decimal, and one to convert decimal time to standard time.
//There are 100 minutes (or 10,000 seconds) in decimal time, but its duration is the same as in standard time. Thus,
//a decimal minute consists of 36 standard seconds, which is 1/100 of an hour.
//Work hours are usually rounded to whole decimal minutes. Thus, one standard minute is equal to 0.02 decimal hours,
//and two standard minutes are equal to 0.03 decimal hours, and so on.
//toIndustrial(time) should accept either the time in minutes as an integer or a string in the format "h:mm".
//Minutes will always have two digits in tests (e.g. "0:05"); hours may be longer.
//Returns a double value representing decimal hours (e.g. 1.75 for 1 hour 45 minutes). Round to two decimal places,
//don't just truncate!
//toNormal(time) should be a double representing a decimal time in hours. Returns a string representing the standard
//time in "h:mm" format.
//There will be no seconds in the tests. We'll ignore them for the purposes of this kata.
//Flavor text (click to expand)
//Calculating with units of time can be confusing because we're used to thinking in decimal in everyday
//use. However, an hour is made up of sixty minutes, each of which is made up of sixty seconds.
//When working with multiple records of measured time — such as in a work time record — it can be difficult to
//get the totals right. The natural algorithm would seem to be to add the hours and minutes separately,
//then divide the minutes by 60 to get the extra full hours and remaining minutes.
//In Germany, some companies use decimal time (German: "Industriezeit") to record working hours, which makes it much
//easier to count multiple entries.

import java.text.DecimalFormat;

public class DecimalTimeConversion {

    public static final DecimalFormat MINUTES = new DecimalFormat("00");

    public static void main(String[] args) {
        System.out.println(toIndustrial(1)); //0.02
        System.out.println(toIndustrial(2)); //0.03
        System.out.println(toIndustrial(105)); //1.75
        System.out.println(toIndustrial("0:03")); //0.05
        System.out.println(toIndustrial("0:04")); //0.07
        System.out.println(toIndustrial("1:45")); //1.75
        System.out.println(toNormal(1.75)); //1:45
        System.out.println(toNormal(0.33)); //0:20
        System.out.println("_________________________");

        System.out.println(toIndustrial2(1)); //0.02
        System.out.println(toIndustrial2(2)); //0.03
        System.out.println(toIndustrial2(105)); //1.75
        System.out.println(toIndustrial2("0:03")); //0.05
        System.out.println(toIndustrial2("0:04")); //0.07
        System.out.println(toIndustrial2("1:45")); //1.75
        System.out.println(toNormal2(1.75)); //1:45
        System.out.println(toNormal2(0.33)); //0:20
    }

    public static double toIndustrial(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        double industrialHours = hours + (minutes / 60.0);
        return Math.round(industrialHours * 100) / 100.0;
    }

    public static double toIndustrial(int time) {
        int hours = time / 60;
        int minutes = time % 60;
        double industrialHours = hours + (minutes / 60.0);
        return Math.round(industrialHours * 100) / 100.0;
    }

    public static String toNormal(double time) {
        int hours = (int) time;
        int minutes = (int) Math.round((time - hours) * 60);
        return hours + ":" + String.format("%02d", minutes);
    }


    public static double toIndustrial2(int time) {
        return Math.round(time * 1.66667) / 100.;
    }

    public static double toIndustrial2(String time) {
        return Integer.parseInt(time.split(":")[0]) + toIndustrial2(Integer.parseInt(time.split(":")[1]));
    }

    public static String toNormal2(double time) {
        return String.format("%d:%02d", (int) time, (int) Math.round(time / .0166667) % 60);
    }
}
