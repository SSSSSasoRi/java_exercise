package Exercise01_35;

public class Exercise33 {
    public static void main(String[] args) {
        int[] array = { 100, 2, 10, 5, 1 };
        int n = 1;
        switch (n) {
            case 1:
                int add = 0;
                for (int i = 0; i < array.length; i++) {
                    add += array[i];
                }
                System.out.println("配列同士で足し算した結果：" + add);
            case 2:
                int sub = array[0];
                for (int i = 1; i < array.length; i++) {
                    sub -= array[i];
                }
                System.out.println("配列同士で引き算した結果：" + sub);
            case 3:
                int mul = 1;
                for (int i = 0; i < array.length; i++) {
                    mul *= array[i];
                }
                System.out.println("配列同士で掛け算した結果：" + mul);
            case 4:
                double div = array[0];
                for (int i = 1; i < array.length; i++) {
                    div /= array[i];
                }
                System.out.println("配列同士で割り算した結果：" + div);
        }
    }
}
