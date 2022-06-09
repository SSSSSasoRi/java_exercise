package Exercise56_65;

import java.util.Random;

public class Exercise59 {
    public static void main(String[] args) {
        int r1 = new Random().nextInt(100);
        int r2 = new Random().nextInt(100);
        int r3 = new Random().nextInt(100);

        if (r1 == 0) {
            System.out.println("サイコロ A がこぼれた！");
        } else {
            rollDice();
        }

        if (r2 == 0) {
            System.out.println("サイコロ B がこぼれた！");
        } else {
            rollDice();
        }

        if (r3 == 0) {
            System.out.println("サイコロ C がこぼれた！");
        } else {
            rollDice();
        }
    }

    static void rollDice() {
        int face = roll();
        switch (face) {
            case 1:
                one();
                break;
            case 2:
                two();
                break;
            case 3:
                three();
                break;
            case 4:
                four();
                break;
            case 5:
                five();
                break;
            case 6:
                six();
                break;
        }
    }

    static int roll() {
        int min = 1;
        int max = 6;
        Random r = new Random();
        int value = r.nextInt(max - min + 1) + min;
        return value;
    }

    static void one() {
        System.out.println("+---+");
        System.out.println("|   |");
        System.out.println("| O |");
        System.out.println("|   |");
        System.out.println("+---+");
    }

    static void two() {
        System.out.println("+---+");
        System.out.println("|  O|");
        System.out.println("|   |");
        System.out.println("|O  |");
        System.out.println("+---+");
    }

    static void three() {
        System.out.println("+---+");
        System.out.println("|O  |");
        System.out.println("| O |");
        System.out.println("|  O|");
        System.out.println("+---+");
    }

    static void four() {
        System.out.println("+---+");
        System.out.println("|O O|");
        System.out.println("|   |");
        System.out.println("|O O|");
        System.out.println("+---+");
    }

    static void five() {
        System.out.println("+---+");
        System.out.println("|O O|");
        System.out.println("| O |");
        System.out.println("|O O|");
        System.out.println("+---+");
    }

    static void six() {
        System.out.println("+---+");
        System.out.println("|O O|");
        System.out.println("|O O|");
        System.out.println("|O O|");
        System.out.println("+---+");
    }
}
