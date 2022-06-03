package Exercise36_55;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Exercise36 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("日付を入力してください：");
        String input = scanner.nextLine();
        searchDate(input);
        scanner.close();
    }

    public static void searchDate(String strDate) throws ParseException {
        // 当日
        Date today = new SimpleDateFormat("yyyy/MM/dd").parse(strDate);
        String strToday = new SimpleDateFormat("M/d(E)").format(today);

        Calendar cal = Calendar.getInstance();

        // 前日
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        String strYesterday = new SimpleDateFormat("M/d(E)").format(cal.getTime());

        // 翌日
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        String strTomorrow = new SimpleDateFormat("M/d(E)").format(cal.getTime());

        System.out.println("検索結果です。↓↓↓");
        System.out.println("前日：" + strYesterday);
        System.out.println("当日:" + strToday);
        System.out.println("翌日：" + strTomorrow);
    }
}
