package SlidingWIndow;
import java.util.*;
public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        String ans = minWindow(s, t);
        System.out.println(ans);
    }

    public static String minWindow(String s, String t) {
        // base case
        int size = s.length();
        int tSize = t.length();
        if(size < tSize) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+ 1);
        }
        int count = map.size();
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        while(j < size) {
            char jChar = s.charAt(j);
            if(map.containsKey(jChar)) {
                int freq = map.get(jChar);
                if(freq == 1) {
                    count--;
                }
                map.put(s.charAt(j), freq-1);
            }
            if(count == 0) {
                while(i <= j) {
                    if(min > j-i+1) {
                        min = j-i+1;
                        startIndex = i;
                        endIndex = j;
                    }
                    char iChar = s.charAt(i);
                    if(map.containsKey(iChar)) {
                        int freq = map.get(iChar);
                        if(freq == 0) {
                            count++;
                        }
                        map.put(iChar, freq+1);
                        if(count > 0) {
                            i++;
                            break;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        if(startIndex != -1 && endIndex != -1) return s.substring(startIndex, endIndex+1);
        return "";
    }
}
