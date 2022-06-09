package Exercise56_65;

import java.util.ArrayList;
import java.util.Random;

public class Exercise60 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        int min = 1;
        int max = 100;
        Random r = new Random();

        for (int i = 0; i < 100; i++) {
            int value = r.nextInt(max - min + 1) + min;
            numbers.add(value);
        }

        boolean found = false;

        for (int j = 0; j < 100; j++) {
            if (numbers.get(j) == 77) {
                System.out.println("インデックス" + j + "が77です。");
                found = true;
                break;
            }
        }

        if (found == false) {
            System.out.println("含まれていない。");
        }
    }
}
