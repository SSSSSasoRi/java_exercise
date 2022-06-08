package Exercise56_65;

import java.util.Random;
import java.util.Scanner;

public class Exercise57 {
    public static void main(String[] args) {
        int totalMoney = 100;
        Scanner scan = new Scanner(System.in);

        while (totalMoney > 0) {
            System.out.println("賭け金を入力してください（現在の所持金：" + totalMoney + "）：");
            String input = scan.nextLine();

            if (input.equals("end")) {
                System.out.println("ゲーム終了");
                break;
            }

            int money = Integer.valueOf(input);
            System.out.println("「半」か「丁」かを選択してください：");
            String guess = scan.nextLine();

            if (money > totalMoney) {
                System.out.println("所持金以上の金額は賭けられません。");
            } else {
                if (totalMoney > 0) {
                    totalMoney -= money;
                    if (guess.equals(roll())) {
                        totalMoney += money * 2;
                        System.out.println("当たり！");
                        System.out.println("現在の所持金：" + totalMoney);
                    } else {
                        System.out.println("残念…");
                        System.out.println("現在の所持金：" + totalMoney);
                    }
                }
            }
        }
        scan.close();
    }

    static String roll() {
        int r = new Random().nextInt(2);
        String result;
        if (r == 0) {
            result = "丁";
        } else {
            result = "半";
        }
        return result;
    }
}
