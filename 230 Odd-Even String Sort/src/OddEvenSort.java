//Given a string s, your task is to return another string such that even-indexed and odd-indexed characters of s
//are grouped and the groups are space-separated. Even-indexed group comes as first,
// followed by a space, and then by the odd-indexed part.
//Examples
//input:    "CodeWars" => "CdWr oeas"
//           ||||||||      |||| ||||
//indices:   01234567      0246 1357
//Even indices 0, 2, 4, 6, so we have "CdWr" as the first group.
//Odd indices are 1, 3, 5, 7, so the second group is "oeas".
//And the final string to return is "CdWr oeas".
//Notes
//Tested strings are at least 8 characters long.

public class OddEvenSort {
    public static void main(String[] args) {
        System.out.println(sortMyString("CodeWars")); //CdWr oeas
    }

    public static String sortMyString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i += 2) {
            sb.append(arr[i]);
        }
        sb.append(" ");
        for (int i = 1; i < arr.length; i += 2) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
