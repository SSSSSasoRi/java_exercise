package Exercise01_35;

public class Exercise28 {
    public static void main(String[] args) {
        String[] array1 = { "apple", "orange", "banana" };
        String[] array2 = { "リンゴ", "オレンジ", "バナナ" };
        int len = array1.length + array2.length;
        String[] array3 = new String[len];

        // System.arraycopy(コピー元配列, コピー元配列のコピー開始位置, コピー先配列, コピー先配列の開始位置, コピーの個数)
        System.arraycopy(array1, 0, array3, 0, array1.length);
        System.arraycopy(array2, 0, array3, array1.length, array2.length);

        for (int i = 0; i < len; i++) {
            System.out.println(array3[i]);
        }
    }
}
