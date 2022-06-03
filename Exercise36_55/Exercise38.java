package Exercise36_55;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Exercise38 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("日付を入力してください：");
        String inputDate = scanner.nextLine();
        System.out.println("何日後ですか？");
        int n = scanner.nextInt();

        toDate(inputDate, n);
        scanner.close();
    }

    public static void toDate(String str, int n) throws ParseException {
        Date today = new SimpleDateFormat("M/d").parse(str);

        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, n);

        String toDate = new SimpleDateFormat("M/d").format(cal.getTime());
        System.out.println(n + "日後の日付は" + toDate + "です。");
    }
}
