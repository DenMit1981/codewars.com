//In this kata, you will be creating a Java Comparator to sort cats by their weight.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[2];
        cats[0] = new Cat("Lily", 30);
        cats[1] = new Cat("Drake", 15);

        Arrays.sort(cats, new CatWeightComparator());

        System.out.println(Arrays.toString(cats));
    }
}
