package Exercise56_65;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise62 {
    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("")) {
                System.out.println(bingo.makeNumber());
            }
        }
        scan.close();
    }
}

class Bingo {
    private ArrayList<Integer> pool = new ArrayList<>();
    private int start = 1;
    private int len = 75;

    public int makeNumber() {
        if (pool.isEmpty()) {
            for (int i = start; i < start + len; i++) {
                pool.add(i);
            }
            start = start + len;
        }
        Collections.shuffle(pool);
        int num = pool.get(pool.size() - 1);
        pool.remove(pool.size() - 1);
        return num;
    }
}
