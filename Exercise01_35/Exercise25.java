package Exercise01_35;

public class Exercise25 {
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        int n = str.indexOf("g");
        int m = str.indexOf("k");
        String result = str.substring(n, m + 1);
        System.out.println(result);
    }
}
