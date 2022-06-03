package Exercise01_35;

public class Exercise20 {
    public static void main(String[] args) {
        String str = "Welcome to the World of Computers!";
        System.out.println(caseReverse(str));
    }

    public static String caseReverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch += 32;
                sb.append(ch);
            } else if (Character.isLowerCase(ch)) {
                ch -= 32;
                sb.append(ch);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
