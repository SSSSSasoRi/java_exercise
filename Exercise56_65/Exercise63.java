package Exercise56_65;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise63 {
    public static void main(String[] args) {
        int[][] card = makeCard();
        for (int i = 0; i < card[0].length; i++) {
            for (int j = 0; j < card.length; j++) {
                System.out.print(card[j][i] + "\t");
            }
            System.out.println();
        }
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
