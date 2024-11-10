//Everything we eat is water and dry matter.
//Let's start with an example:
//John bought some potatoes: they weigh 100 kilograms. The potatoes contain water and dry matter.
//The water content is 99 percent of the total mass. He thinks they are too wet, so he puts them in the oven
//at a low temperature so they lose some water.
//When they come out, the water content is only 98%.
//What is the total weight in kilograms (water content plus dry matter) coming out of the oven?
//
//He finds 50 kilograms and thinks he's mistaken: "So much weight lost for such a small change in water content!"
//Can you help him?
//Problem
//Write a functional potato using:
//
//int parameter p0 - initial water percentage -
//int parameter w0 - initial weight -
//int parameter p1 - final water percentage -
//The potato should return the final weight coming out of the oven w1, truncated as an integer.
//Example:
//potatoes(99, 100, 98) --> 50

public class Potatoes {
    public static void main(String[] args) {
        System.out.println(potatoes(99, 100, 98)); //50
        System.out.println(potatoes(82, 127, 80)); //114
        System.out.println(potatoes(93, 129, 91)); //100
    }

    public static int potatoes(int p0, int w0, int p1) {
        return (int) Math.floor(w0 * (100 - p0) / (100 - p1));
    }
}
