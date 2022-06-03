package Exercise01_35;

public class Exercise10 {
    public static void main(String[] args) {
        int x = 2;
        int cnt = 0;
        int total = 20;
        while (cnt < total) {
            if (isPrime(x)) {
                cnt++;
                System.out.println(x);
            }
            x++;
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
