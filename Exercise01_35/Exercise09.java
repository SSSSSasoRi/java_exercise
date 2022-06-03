package Exercise01_35;

public class Exercise09 {
    public static void main(String[] args) {
        int a = 3;
        int b = 100;
        int sum = 0;
        for (int i = 1; i <= b; i++) {
            sum += a * i;
            if (sum <= b) {
                continue;
            } else {
                System.out.println(a * i);
                break;
            }
        }
    }
}
