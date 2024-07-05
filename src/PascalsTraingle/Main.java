package PascalsTraingle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        generate(3);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) return ret;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ret.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = ret.get(i-1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < i; j++) {
                current.add(prev.get(j-1)+prev.get(j));
            }
            current.add(1);
            ret.add(current);
        }
        return ret;
    }
}
