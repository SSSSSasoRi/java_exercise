package Exercise01_35;

public class Exercise24 {
    public static void main(String[] args) {
        String str = "Welcome to the World of Computers!";
        String strAfter = str.replaceAll(" ", "");
        System.out.println(strAfter);

        /*
         * trimメソッド：前後の半角スペースや改行、タブを削除
         * stripメソッド：前後の全角、半角のスペースや改行、タブを削除
         */

        String str1 = "　　こんにちは。　　";
        String str2 = "  こんにちは。  ";
        String str1_trim = str1.trim();
        String str1_strip = str1.strip();
        System.out.println(str1_trim);
        System.out.println(str1_strip);

        String str2_trim = str2.trim();
        String str2_strip = str2.strip();
        System.out.println(str2_trim);
        System.out.println(str2_strip);
    }
}
