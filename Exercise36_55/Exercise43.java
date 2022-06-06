package Exercise36_55;

public class Exercise43 {
    public static void main(String[] args) {
        int max = 4;
        String spot = "●";
        for (int i = 0; i < max; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(spot);
            }
            System.out.println("\n");
        }
    }
}