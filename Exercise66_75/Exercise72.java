package Exercise66_75;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exercise72 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1：貸出処理を行う");
        System.out.println("2：返却処理を行う");
        System.out.println("3：利用料金計算を行う");
        int input = scan.nextInt();

        // 1:貸出処理を行う
        if (input == 1) {
            System.out.println("貸し出すタイトルを入力してください：");
            String title = scan.next();

            File csv = new File("C:/Users/User/Desktop/rental.csv");
            HashMap<String, String> rentalMap = getRentalMap(csv);

            if (!rentalMap.containsKey(title)) {
                System.out.println("存在しないタイトルです。");
            }

            if (rentalMap.containsKey(title) && rentalMap.get(title) != null) {
                System.out.println("貸出中のタイトルです。");
            }

            if (rentalMap.containsKey(title) && rentalMap.get(title) == null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Calendar cal = Calendar.getInstance();
                rentalMap.replace(title, sdf.format(cal.getTime()));
                writeCSV("C:/Users/User/Desktop/rental.csv", rentalMap);
                // 返却期限を設定する
                cal.add(Calendar.DAY_OF_MONTH, 7);
                Date deadline = cal.getTime();
                System.out.println("貸出処理を実施しました。返却期限は" + sdf.format(deadline) + "です。");
            }

            // 2：返却処理を行う
        } else if (input == 2) {
            System.out.println("返却するタイトルを入力してください：");
            String title = scan.next();

            File csv = new File("C:/Users/User/Desktop/rental.csv");
            HashMap<String, String> rentalMap = getRentalMap(csv);

            if (!rentalMap.containsKey(title)) {
                System.out.println("存在しないタイトルです。");
            }

            if (rentalMap.containsKey(title) && rentalMap.get(title) == null) {
                System.out.println("現在貸し出されていないタイトルです。");
            }

            if (rentalMap.containsKey(title) && rentalMap.get(title) != null) {
                // 延滞日数を算出する
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date date = new Date();
                String today = sdf.format(date);
                try {
                    int ret = differenceDays(today, rentalMap.get(title));
                    if (ret <= 7) {
                        System.out.println("返却処理を実施しました。0日間延滞しています。");
                    } else {
                        System.out.println("返却処理を実施しました。" + (ret - 7) + "日間延滞しています。");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                rentalMap.replace(title, null);
                writeCSV("C:/Users/User/Desktop/rental.csv", rentalMap);
            }

            // 3：利用料金計算を行う
        } else if (input == 3) {
            System.out.println("利用料金を計算するタイトルを入力してください：");
            String title = scan.next();

            File csv = new File("C:/Users/User/Desktop/rental.csv");
            HashMap<String, String> rentalMap = getRentalMap(csv);

            if (!rentalMap.containsKey(title)) {
                System.out.println("存在しないタイトルです。");
            }

            if (rentalMap.containsKey(title) && rentalMap.get(title) == null) {
                System.out.println("現在貸し出されていないタイトルです。");
            }

            if (rentalMap.containsKey(title) && rentalMap.get(title) != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Date date = new Date();
                String today = sdf.format(date);
                try {
                    int ret = differenceDays(today, rentalMap.get(title));
                    if (ret <= 7) {
                        int cost = 100;
                        System.out.println("現在の利用料金は" + cost + "円です。");
                    } else {
                        int cost = 100 + (ret - 7) * 100;
                        System.out.println("現在の利用料金は" + cost + "円です。");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        } else {
            System.out.println("無効な入力値です。終了します。");
        }
        scan.close();
    }

    // 日付の差を取得する
    public static int differenceDays(String strDate1, String strDate2) throws ParseException {
        Date date1 = DateFormat.getDateInstance().parse(strDate1);
        Date date2 = DateFormat.getDateInstance().parse(strDate2);
        return differenceDays(date1, date2);
    }

    public static int differenceDays(Date date1, Date date2) {
        long datetime1 = date1.getTime();
        long datetime2 = date2.getTime();
        long one_date_time = 1000 * 60 * 60 * 24;
        long diffDays = (datetime1 - datetime2) / one_date_time;
        return (int) diffDays;
    }

    // データ変更した後のHashMapをファイルに書き込む（上書き）
    public static void writeCSV(String filePath, HashMap<String, String> rentalMap) {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (HashMap.Entry<String, String> entry : rentalMap.entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey());
                sb.append(",");
                if (entry.getValue() != null) {
                    sb.append(entry.getValue());
                }
                sb.append("\n");
                writer.write(sb.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // ファイルを読み込んで、HashMapで格納する
    public static HashMap<String, String> getRentalMap(File csv) {
        HashMap<String, String> rentalMap = new HashMap<>();
        try {
            BufferedReader textFile = new BufferedReader(new FileReader(csv));
            String lineDta = "";
            while ((lineDta = textFile.readLine()) != null) {
                List<String> work = Arrays.asList(lineDta.split(","));
                if (work.size() == 2) {
                    rentalMap.put(work.get(0), work.get(1));
                } else {
                    rentalMap.put(work.get(0), null);
                }
            }
            textFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rentalMap;
    }
}
