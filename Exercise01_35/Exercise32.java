package Exercise01_35;

public class Exercise32 {
    public static void main(String[] args) {
        int[] array = { 12, 35, -4, 888, 9 };
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double avg = sum / array.length;
        System.out.println(avg);
    }
}
