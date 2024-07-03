package PascalsTraingle2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println();
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        ret.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);

            for (int j = 1; j < ret.size(); j++) {
                current.add(ret.get(i-1) + ret.get(i));
            }

            current.add(1);
            ret = current;
            }
        return ret;
    }
}
