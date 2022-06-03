package Exercise01_35;

public class Exercise07 {
    public static void main(String[] args) {
        int[] array = { 21, 86, 93, 5, -16, 140 };
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        System.out.println("偶数の合計は" + sum + "です。");
    }
}
