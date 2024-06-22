package IndexOfTheFirstOccurrence;

public class Main {
    public static void main(String[] args) {
        String haystack = "mississipi";
        String needle = "issip";
        System.out.println(strStr(haystack,needle));
    }

//    public static int strStr(String haystack, String needle) {
//        int haystackLength = haystack.length();
//        int needleLength = needle.length();
//
//        for (int i = 0; i <= haystackLength - needleLength; i++) {
//            if (haystack.substring(i, i + needleLength).equals(needle)) {
//                return i;
//            }
//        }
//        return -1;
//    }
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
