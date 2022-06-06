package Exercise36_55;

public class Exercise44 {
    public static void main(String[] args) {
        int max = 4;
        String spot = "●";
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {
                System.out.print(spot);
            }
            System.out.println("\n");
        }
    }
}
