package Exercise01_35;

public class Exercise15 {
    public static void main(String[] args) {
        String target = "lemon";
        String str = "apple orange banana grape lemon watermelon";
        if (str.contains(target)) {
            System.out.println("「" + target + "」は" + str.indexOf(target) + "文字目にあります。");
        } else {
            System.out.println("「" + str + "」には「" + target + "」が含まれていません。");
        }
    }
}
