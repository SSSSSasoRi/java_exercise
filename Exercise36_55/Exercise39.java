package Exercise36_55;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise39 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LocalDate date = LocalDate.now();

        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                System.out.println("処理終了");
                break;
            }
            if (input.equals("")) {
                date = printDate(date);
            }
        }
        scan.close();
    }

    private static LocalDate nextFriday(LocalDate from) {
        int d = DayOfWeek.FRIDAY.getValue() - from.getDayOfWeek().getValue();
        return from.plusDays(d <= 0 ? d + 7 : d);
    }

    private static LocalDate nextFridayThe13th(LocalDate from) {
        LocalDate date = nextFriday(from);
        return date.getDayOfMonth() == 13 ? date : nextFridayThe13th(date);
    }

    public static LocalDate printDate(LocalDate from) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日（E）");
        date = nextFridayThe13th(from);
        System.out.println(dtf.format(date));
        return date;
    }
}
