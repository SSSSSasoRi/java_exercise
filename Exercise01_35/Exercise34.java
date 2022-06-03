package Exercise01_35;

import java.util.ArrayList;

public class Exercise34 {
    public static void main(String[] args) {
        int[] array = { 1, 32, 3, 67, -4, 70, 22, 5, 8 };
        ArrayList<Integer> listOdd = new ArrayList<>();
        ArrayList<Integer> listEven = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                listOdd.add(array[i]);
            } else {
                listEven.add(array[i]);
            }
        }
        Integer[] arrOdd = listOdd.stream().toArray(Integer[]::new);
        Integer[] arrEven = listEven.stream().toArray(Integer[]::new);

        System.out.println("奇数配列の要素数は" + arrOdd.length + "です。");
        System.out.println("偶数配列の要素数は" + arrEven.length + "です。");
    }
}
