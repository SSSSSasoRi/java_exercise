package Exercise56_65;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise64 {
    public static void main(String[] args) {
        int[][] card = makeCard();

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String input = scan.nextLine();

            if (input.equals("end")) {
                break;
            }

            if (input.equals("")) {
                for (int i = 0; i < card[0].length; i++) {
                    for (int j = 0; j < card.length; j++) {
                        System.out.print(card[j][i] + "\t");
                    }
                    System.out.println();
                }
            } else {
                int number = Integer.parseInt(input);
                for (int i = 0; i < card[0].length; i++) {
                    for (int j = 0; j < card.length; j++) {
                        if (number == card[j][i]) {
                            card[j][i] = 0;
                            System.out.print(card[j][i] + "\t");
                        } else {
                            System.out.print(card[j][i] + "\t");
                        }
                    }
                    System.out.println();
                }
            }

            int bingo = countBingoOfRow(card) + countBingoOfColumn(card) + countBingoOfDiagonal(card);
            int leach = countLeachOfRow(card) + countLeachOfColumn(card) + countLeachOfDiagonal(card);
            System.out.println("ビンゴ：" + bingo);
            System.out.println("リーチ：" + leach);
        }
        scan.close();
    }

    static int countBingoOfRow(int[][] card) {
        int result = 0;
        for (int i = 0; i < card.length; i++) {
            int cnt = 0;
            for (int j = 0; j < card[0].length; j++) {
                if (card[j][i] == 0) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                result++;
            }
        }
        return result;
    }

    static int countBingoOfColumn(int[][] card) {
        int result = 0;
        for (int i = 0; i < card.length; i++) {
            int cnt = 0;
            for (int j = 0; j < card[0].length; j++) {
                if (card[i][j] == 0) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                result++;
            }
        }
        return result;
    }

    static int countBingoOfDiagonal(int[][] card) {
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < card.length; i++) {
            if (card[i][i] == 0) {
                cnt++;
            }
        }
        if (cnt == 5) {
            result++;
        }
        cnt = 0;
        for (int i = 0; i < card.length; i++) {
            if (card[i][card.length - 1 - i] == 0) {
                cnt++;
            }
        }
        if (cnt == 5) {
            result++;
        }
        return result;
    }

    static int countLeachOfRow(int[][] card) {
        int result = 0;
        for (int i = 0; i < card.length; i++) {
            int cnt = 0;
            for (int j = 0; j < card[0].length; j++) {
                if (card[j][i] == 0) {
                    cnt++;
                }
            }
            if (cnt == 4) {
                result++;
            }
        }
        return result;
    }

    static int countLeachOfColumn(int[][] card) {
        int result = 0;
        for (int i = 0; i < card.length; i++) {
            int cnt = 0;
            for (int j = 0; j < card[0].length; j++) {
                if (card[i][j] == 0) {
                    cnt++;
                }
            }
            if (cnt == 4) {
                result++;
            }
        }
        return result;
    }

    static int countLeachOfDiagonal(int[][] card) {
        int result = 0;
        int cnt = 0;
        for (int i = 0; i < card.length; i++) {
            if (card[i][i] == 0) {
                cnt++;
            }
        }
        if (cnt == 4) {
            result++;
        }
        cnt = 0;
        for (int i = 0; i < card.length; i++) {
            if (card[i][card.length - 1 - i] == 0) {
                cnt++;
            }
        }
        if (cnt == 4) {
            result++;
        }
        return result;
    }

    static int[][] makeCard() {
        int[][] card = new int[5][5];
        int start = 1;
        int len = 15;
        ArrayList<Integer> arr;
        for (int i = 0; i < 5; i++) {
            // カードを一列ずつ生成する
            arr = makeNumberArray(start, start + len - 1);
            for (int j = 0; j < 5; j++) {
                card[i][j] = arr.get(j);
            }
            start += len;
        }
        // 真ん中のフリースポットを0にする
        card[2][2] = 0;
        return card;
    }

    static ArrayList<Integer> makeNumberArray(int min, int max) {
        // minからmaxまでの整数を5つランダムに生成する
        ArrayList<Integer> pool = new ArrayList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            pool.add(i);
        }
        Collections.shuffle(pool);
        for (int j = 0; j < 5; j++) {
            ret.add(pool.get(j));
        }
        return ret;
    }
}
