package LongestCommonPrefix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight","d"};
        System.out.println(longestCommonPrefix(strs).toString());
    }

//    public static String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) return "";
//
//        StringBuilder sb = new StringBuilder();
//        int minLen = Integer.MAX_VALUE;
//        for (String str : strs) {
//            if (str.length() < minLen) {
//                minLen = str.length();
//            }
//        }
//
//        for (int i = 0; i < minLen; i++) {
//            char c = strs[0].charAt(i);
//            for (int j = 1; j < strs.length; j++) {
//                if (strs[j].charAt(i) != c) {
//                    return sb.toString();
//                }
//            }
//            sb.append(c);
//        }
//        return sb.toString();
//    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        for (int i = 0; i < first.length; i++) {
            if (first[i] != last[i]){
                break;
            } else sb.append(first[i]);
        }
        return sb.toString();
    }
}
