package Exercise36_55;

public class Exercise41 {
    public static void main(String[] args) {
        int n = 25;
        System.out.println("九九の表を" + n + "段まで出力します：");
        superKuku(n);
    }

    public static void superKuku(int n) {
        if (n < 31 && n > 0) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    System.out.print(i * j);
                    System.out.print("|");
                }
                System.out.println("");
                System.out.println(
                        "--------------------------------------------------------------------------------------------------------------------|");
            }
        } else {
            System.out.println("ERROR：容量不足のため、出力不能。");
        }
    }
}
