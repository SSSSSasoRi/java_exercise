package Exercise01_35;

public class Exercise21 {
    public static void main(String[] args) {
        int n = 3;
        int cnt = 0;
        String str = "あいうえおあいうえおあいうえおあいうえおあいうえお";
        char target = 'あ';

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == target && cnt < n) {
                cnt++;
                continue;
            }
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
