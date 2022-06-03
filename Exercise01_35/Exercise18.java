package Exercise01_35;

public class Exercise18 {
    public static void main(String[] args) {
        String str = "あいうえおかきくけこさしすせそたちつてと";
        char startChar = 'か';
        int indexStart = str.indexOf(startChar);
        int indexEnd = indexStart + 5;
        System.out.println(str.charAt(indexEnd));
    }
}
