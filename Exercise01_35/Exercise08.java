package Exercise01_35;

public class Exercise08 {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        System.out.println(a + "を" + b + "乗した結果は" + result + "です。");
    }
}
