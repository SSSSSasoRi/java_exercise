package Exercise56_65;

import java.util.Random;
import java.util.Scanner;

public class Exercise56 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("")) {
                roll();
            }
        }
        scan.close();
    }

    static void roll() {
        int r = new Random().nextInt(2);
        if (r == 0) {
            System.out.println("丁！");
        } else {
            System.out.println("半！");
        }
    }
}
