//Write a simple parser that will parse and run Deadfish.
//Deadfish has 4 commands, each 1 character long:
//i increments the value (initially 0)
//d decrements the value
//s squares the value
//o prints the value to the return array
//Illegal characters should be ignored.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeadFish {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(parse("iiispdoso"))); //[8, 64]
        System.out.println(Arrays.toString(parse("iiisdosodddddisop"))); //[8, 64, 3600]
    }

    public static int[] parse(String data) {
        int cipher = 0;

        List<Integer> cipherList = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            cipher = getCipher(data.charAt(i), cipher, cipherList);
        }

        return cipherList.stream().mapToInt(Integer::intValue).toArray();

        //return getArrayFromList(cipherList);
    }

    private static int getCipher(char c, int cipher, List<Integer> cipherList) {
        switch (c) {
            case 'i':
                cipher++;
                break;
            case 'd':
                cipher--;
                break;
            case 's':
                cipher *= cipher;
                break;
            case 'o':
                cipherList.add(cipher);
                break;
            default:
                break;
        }

        return cipher;
    }

    private static int[] getArrayFromList(List<Integer> list) {
        int[] arr = new int[list.size()];
        int i = 0;

        for (Integer element : list) {
            arr[i++] = element;
        }

        return arr;
    }

    private static int[] getArrayFromListByArraysSet(List<Integer> list) {
        int[] result = new int[list.size()];
        Arrays.setAll(result, list::get);

        return result;
    }
}
