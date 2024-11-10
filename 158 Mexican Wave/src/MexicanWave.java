//Волна (известная как мексиканская волна в англоязычном мире за пределами Северной Америки) является примером
//метахронного ритма, достигаемого на переполненном стадионе, когда последовательные группы зрителей ненадолго встают,
//кричат и поднимают руки. Сразу после вытягивания в полный рост зритель возвращается в обычное сидячее положение.
//В результате волна стоящих зрителей проходит сквозь толпу, хотя отдельные зрители никогда не отходят от своих мест.
//На многих больших аренах толпа рассаживается по непрерывному кругу по всему спортивному полю, поэтому волна может
//непрерывно перемещаться по арене; при несмежном расположении сидений волна может вместо этого отражаться взад и
//вперед через толпу. Когда щель в посадке узкая, волна иногда может проходить через нее. Обычно на арене в любой
//момент времени присутствует только один гребень волны, хотя иногда возникают одновременные волны, вращающиеся в противоположных направлениях. (Источник Википедия)
//Task
//In this simple kata, your task is to create a function that turns a string into a Mexican wave.
//You will be given a string, and you must return that string as an array, where a capital letter represents a
//standing person.
//Rules
//1. The input string will always be lowercase, but may be empty.
//2. If a character in the string is a space, skip it as if it were empty space.
//Example
//wave("hello") => {"Hello", "hEllo", "heLlo", "helLo", "hellO"}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MexicanWave {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(wave("hello world")));
        System.out.println(Arrays.toString(waveByStreamApi("hello world")));
    }

    public static String[] wave(String str) {

        List<String> wordsList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);

            sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));

            if (sb.charAt(i) != ' ') {
                wordsList.add(sb.toString());
            }
        }

        return wordsList.toArray(new String[0]);
    }

    public static String[] waveByStreamApi(String str) {
        return IntStream.range(0, str.length())
                .filter(i -> str.charAt(i) != ' ')
                .mapToObj(i -> {
                    StringBuilder sb = new StringBuilder(str);

                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));

                    return sb.toString();
                })
                .toArray(String[]::new);
    }
}
