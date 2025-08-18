package Recursion;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abc";
        String ans = reverseString(str,0,str.length());
        System.out.println(ans);

    }

    private static String reverseString(String str, int index, int n) {
        if(index >= n) {
            return "";
        }
        return reverseString(str, index + 1, n) + str.charAt(index);
    }
}
