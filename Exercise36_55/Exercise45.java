package Exercise36_55;

import java.util.Scanner;

public class Exercise45 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        double n;

        System.out.println("比較したい10個の整数を入力してください：");

        for (int i = 1; i < 11; i++) {
            System.out.print(i + "つ目の数字：");
            n = scan.nextDouble();

            if (n < min) {
                min = n;
            } else if (n > max) {
                max = n;
            }
        }

        System.out.println("最大値は" + max + "です。");
        System.out.println("最小値は" + min + "です。");
        scan.close();
    }
}
