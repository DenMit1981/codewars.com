//Enough is enough!
//Alice and Bob have been on holiday. They have both taken lots of pictures of the places they have visited and now they
//want to show Charlie their entire
//collection. However, Charlie doesn't like these sessions because the motif usually repeats.
//He doesn't like looking at the Eiffel Tower 40 times. He tells them that he will only sit through the session if
//they show the same motif no more than N times. Luckily, Alice and Bob can encode the motif as a
//number. Can you help them remove the numbers so that their list contains each number only up to N times,
//without reordering?
//
//Problem
//Given a list and a number, create a new list containing each number lst no more than N times, without reordering.
//For example, if the input number is 2 and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], discard the next
//[1,2] since that will result in 1 and 2 being 3 times in the result, and then take 3, which will result in
//[1,2,3,1,2,3]. With the list [20,37,20,21] and the number 1, the result will be [20,37,21].

import java.util.*;

public class EnoughIsEnough {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(deleteNth(new int[]{20, 37, 20, 21}, 1)));
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3)));
        System.out.println(Arrays.toString(deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3)));
        System.out.println(Arrays.toString(deleteNth(new int[]{}, 5)));

        System.out.println(Arrays.toString(deleteNth2(new int[]{20, 37, 20, 21}, 1)));
        System.out.println(Arrays.toString(deleteNth2(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3)));
        System.out.println(Arrays.toString(deleteNth2(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3)));
        System.out.println(Arrays.toString(deleteNth2(new int[]{}, 5)));

        System.out.println(Arrays.toString(deleteNth3(new int[]{20, 37, 20, 21}, 1)));
        System.out.println(Arrays.toString(deleteNth3(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3)));
        System.out.println(Arrays.toString(deleteNth3(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3)));
        System.out.println(Arrays.toString(deleteNth3(new int[]{}, 5)));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (elements == null || elements.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> numbers = new ArrayList<>();

        for (Integer element : elements) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
            if (map.get(element) <= maxOccurrences)
                numbers.add(element);
        }

        return numbers.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static int[] deleteNth2(int[] elements, int maxOcurrences) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return Arrays.stream(elements)
                .filter(i -> {
                    map.merge(i, 1, Integer::sum);
                    return map.get(i) <= maxOcurrences;
                })
                .toArray();
    }

    public static int[] deleteNth3(int[] elements, int maxOcurrences) {
        List<Integer> list = new ArrayList<>();

        for (int element : elements) {
            if (Collections.frequency(list, element) < maxOcurrences) {
                list.add(element);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
