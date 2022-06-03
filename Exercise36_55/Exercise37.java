package Exercise36_55;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise37 {
    public static void main(String[] args) throws ParseException {
        String a = "123";
        int b = 456;
        String c = "2022/04/01";
        Date d = new Date();
        stringToInt(a);
        intToString(b);
        stringToDate(c);
        dateToString(d);
    }

    public static void stringToInt(String str) {
        int num = Integer.parseInt(str);
        System.out.println("文字列型から数値型への変換が完成しました。変換結果：" + num);
    }

    public static void intToString(int num) {
        String str = String.valueOf(num);
        System.out.println("数値型から文字列型への変換が完成しました。変換結果：" + str);
    }

    public static void stringToDate(String str) throws ParseException {
        Date date = new SimpleDateFormat("yyyy/MM/dd").parse(str);
        System.out.println("文字列型から日付型への変換が完成しました。変換結果：" + date);
    }

    public static void dateToString(Date date) {
        String str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.sss").format(date);
        System.out.println("日付型から文字列型への変換が完成しました。変換結果：" + str);
    }
}
