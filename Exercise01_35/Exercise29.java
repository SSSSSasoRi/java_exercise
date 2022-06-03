package Exercise01_35;

public class Exercise29 {
    public static void main(String[] args) {
        int[] A = { 1, 3, 5, 7, 9 };
        int[] B = { 2, 4, 6, 8, 10 };
        int[] C = { 11, 22, 33, 44, 55 };
        int[][] S = { A, B, C };

        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S[0].length; j++) {
                System.out.println(S[i][j]);
            }
        }
    }
}
