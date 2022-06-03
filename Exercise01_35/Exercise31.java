package Exercise01_35;

public class Exercise31 {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] reverse = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            reverse[i] = array[array.length - 1 - i];
            System.out.println(reverse[i]);
        }
    }
}
