package LengthOfLastWord;

public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int i = 0;
        if (!s.contains(" ")) return s.length();
        for (int j = s.length()-1; j >= 0 ; j--) {
            i++;
            if (s.charAt(j) == ' ') {
                break;
            }
        }
        return i-1;
    }
}
