package Exercise36_55;

import java.util.Scanner;

public class Exercise42 {
    public static void main(String[] args) {
        int[][][] locker = new int[][][] {
                { { 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 1, 1, 1 },
                        { 1, 1, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 }, { 0, 1, 1, 1 } },
                { { 1, 1, 0, 0 }, { 1, 0, 1, 0 }, { 0, 1, 0, 1 }, { 0, 0, 1, 1 }, { 1, 0, 0, 1 }, { 0, 1, 1, 0 },
                        { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 } },
                { { 1, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 0, 0 }, { 0, 0, 1, 0 }, { 1, 1, 1, 0 },
                        { 0, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 } },
                { { 1, 0, 0, 0 }, { 1, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 0, 1 },
                        { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 0, 0, 0 } },
                { { 0, 0, 0, 1 }, { 1, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 1, 1, 1 },
                        { 0, 0, 0, 1 }, { 1, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 1, 1, 0 } } };

        System.out.println("ロッカーの識別番号を入力してください：");
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            int i = Character.getNumericValue(input.charAt(0));
            int j = Character.getNumericValue(input.charAt(1));
            int k = Character.getNumericValue(input.charAt(2));

            if (locker[i][j][k] == 1) {
                System.out.println(input + "のロッカーは使用中です。");
            } else {
                System.out.println(input + "のロッカーは使用できます。");
            }
        }
        scan.close();
    }
}
