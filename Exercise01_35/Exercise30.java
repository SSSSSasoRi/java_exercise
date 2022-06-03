package Exercise01_35;

public class Exercise30 {
    public static void main(String[] args) {
        int[][] kuku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                kuku[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(kuku[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
