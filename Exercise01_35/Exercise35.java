package Exercise01_35;

public class Exercise35 {
    public static void main(String[] args) {
        int[] num = { 3, 1, 7, 9, 5 };

        // 配列をバブルソートする
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = num.length - 1; j > i; j--) {
                if (num[j - 1] > num[j]) {
                    int tmp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = tmp;
                }
            }
        }

        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }
}
