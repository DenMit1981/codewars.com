//Digital Cypher assigns to each letter of the alphabet unique number. For example:
// a  b  c  d  e  f  g  h  i  j  k  l  m
// 1  2  3  4  5  6  7  8  9 10 11 12 13
// n  o  p  q  r  s  t  u  v  w  x  y  z
//14 15 16 17 18 19 20 21 22 23 24 25 26
//Instead of letters in encrypted word we write the corresponding number, eg. The word scout:
// s  c  o  u  t
//19  3 15 21 20
//Then we add to each obtained digit consecutive digits from the key. For example. In case of key equal to 1939 :
//   s  c  o  u  t
//  19  3 15 21 20
// + 1  9  3  9  1
// ---------------
//  20 12 18 30 21
//
//   m  a  s  t  e  r  p  i  e  c  e
//  13  1 19 20  5 18 16  9  5  3  5
//+  1  9  3  9  1  9  3  9  1  9  3
//  --------------------------------
//  14 10 22 29  6 27 19 18  6  12 8
//Task
//Write a function that accepts str string and key number and returns an array of integers representing encoded str.
//Input / Output
//The str input string consists of lowercase characters only.
//The key input number is a positive integer.
//Example
//Encode("scout",1939);  ==>  [ 20, 12, 18, 30, 21]
//Encode("masterpiece",1939);  ==>  [ 14, 10, 22, 29, 6, 27, 19, 18, 6, 12, 8]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(encode("scout", 1939))); //[20, 12, 18, 30, 21]
        System.out.println(Arrays.toString(encode("masterpiece", 1939))); //[14, 10, 22, 29, 6, 27, 19, 18, 6, 12, 8]

        System.out.println(Arrays.toString(encode2("scout", 1939))); //[20, 12, 18, 30, 21]
        System.out.println(Arrays.toString(encode2("masterpiece", 1939))); //[14, 10, 22, 29, 6, 27, 19, 18, 6, 12, 8]
    }

    public static int[] encode(String message, int key) {
        int[] messageCodeArr = getWordCode(message);
        int[] keyArr = getKeyArrFromKey(key, messageCodeArr);

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < messageCodeArr.length; i++) {
            res.add(messageCodeArr[i] + keyArr[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[] getWordCode(String word) {
        char[] charArr = word.toCharArray();
        int[] result = new int[word.length()];
        int j = 0;

        for (char c : charArr) {
            result[j] = Character.getNumericValue(c);
            result[j] -= 9;
            j++;
        }
        return result;
    }

    private static int[] getKeyArrFromKey(int key, int[] messageCodeArr) {
        String[] keyStringArr = String.valueOf(key).split("");
        int[] keyArr = Arrays.stream(keyStringArr).mapToInt(Integer::parseInt).toArray();

        int size = messageCodeArr.length - keyArr.length;

        List<Integer> keyList = Arrays.stream(keyArr).boxed().collect(Collectors.toList());

        int count = 0;

        for (int i = 0; i < size; i++) {
            if (count == keyArr.length) {
                count = 0;
            }
            keyList.add(keyArr[count]);
            count++;
        }

        return keyList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] encode2(String message, int key) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        int[] charCodes = new int[message.length()];
        String keyStr = Integer.toString(key);
        int keyIterator = 0;
        int keyLength = keyStr.length();
        for (int i = 0; i < message.length(); i++) {
            charCodes[i] = chars.indexOf(message.charAt(i)) + 1;

            if (keyIterator == keyLength) {
                keyIterator = 0;
            }
            charCodes[i] += Character.getNumericValue(keyStr.charAt(keyIterator));
            keyIterator++;
        }
        return charCodes;

    }
}
