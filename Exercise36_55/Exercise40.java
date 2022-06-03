package Exercise36_55;

public class Exercise40 {
    public static void main(String[] args) {
        System.out.println("九九の表を出力します：");
        kuku();
    }

    public static void kuku() {
        int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                int result = num[i] * num[j];
                System.out.println(num[i] + "×" + num[j] + "=" + result);
            }
        }
    }
}
