package Exercise01_35;

public class Exercise17 {
    public static void main(String[] args) {
        String str = "This is just a sample string.";
        int cnt = 0;
        char target;
        for (int i = 0; i < str.length(); i++) {
            target = str.charAt(i);
            if (target == 's') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
