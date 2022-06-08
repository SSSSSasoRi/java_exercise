package Exercise56_65;

import java.util.Random;
import java.util.Scanner;

public class Exercise58 {
    public static void main(String[] args) {
        int totalMoney = 100;
        String userHand;
        Scanner scan = new Scanner(System.in);

        while (totalMoney > 0) {
            System.out.println("賭け金を入力してください（現在の所持金：" + totalMoney + "）：");
            String input = scan.nextLine();

            if (input.equals("end")) {
                System.out.println("ゲーム終了");
                break;
            }

            int money = Integer.valueOf(input);
            if (money > totalMoney) {
                System.out.println("所持金以上の金額は賭けられません。");
            } else {
                totalMoney -= money;
                String computerHand;

                while (true) {
                    System.out.println("出す手を選択してください（グー or チョキ or パー）：");
                    String hand = scan.nextLine();

                    if (hand.equals("グー")) {
                        userHand = "0";
                    } else if (hand.equals("チョキ")) {
                        userHand = "1";
                    } else {
                        userHand = "2";
                    }

                    computerHand = roll();

                    if (!(userHand + computerHand).equals("00") || (userHand + computerHand).equals("11")
                            || (userHand + computerHand).equals("22")) {
                        break;
                    }
                    System.out.println("あいこ");
                }

                if ((userHand + computerHand).equals("01") || (userHand + computerHand).equals("12")
                        || (userHand + computerHand).equals("20")) {
                    totalMoney += money * 2;
                    System.out.println("勝ち！");
                    System.out.println("現在の所持金：" + totalMoney);
                }

                if ((userHand + computerHand).equals("02") || (userHand + computerHand).equals("10")
                        || (userHand + computerHand).equals("21")) {
                    System.out.println("負け…");
                    System.out.println("現在の所持金：" + totalMoney);
                }
            }
        }
        scan.close();
    }

    static String roll() {
        int r = new Random().nextInt(3);
        String result;
        if (r == 0) {
            result = "0";
        } else if (r == 1) {
            result = "1";
        } else {
            result = "2";
        }
        return result;
    }
}
