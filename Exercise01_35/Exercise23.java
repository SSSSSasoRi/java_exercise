package Exercise01_35;

public class Exercise23 {
    public static void main(String[] args) {
        String str = "Good!";
        int n = 5;
        repeat(str, n);
    }

    public static void repeat(String str, int n) {
        if (n <= 0) {
            return;
        }
        System.out.print(str);
        repeat(str, --n);
    }
}
