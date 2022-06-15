package Exercise66_75;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exercise70 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1：貸出処理を行う");
		int input = scan.nextInt();

		if (input == 1) {
			System.out.println("貸し出すタイトルを入力してください：");
			String title = scan.next();

			// レンタルリストを読み込んで、HashMapで格納する
			HashMap<String, String> rentalMap = new HashMap<>();
			File csv = new File("C:/Users/User/Desktop/rental.csv");
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

			if (!rentalMap.containsKey(title)) {
				System.out.println("存在しないタイトルです。");
			}

			if (rentalMap.containsKey(title) && rentalMap.get(title) != null) {
				System.out.println("貸出中のタイトルです。");
			}

			if (rentalMap.containsKey(title) && rentalMap.get(title) == null) {
				// HashMapを更新して、ファイルに書き込む
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Calendar cal = Calendar.getInstance();
				rentalMap.replace(title, sdf.format(cal.getTime()));
				writeCSV("C:/Users/User/Desktop/rental.csv", rentalMap);
				// 返却期限を設定する
				cal.add(Calendar.DAY_OF_MONTH, 7);
				Date deadline = cal.getTime();
				System.out.println("貸出処理を実施しました。返却期限は" + sdf.format(deadline) + "です。");
			}
		} else {
			System.out.println("無効な入力値です。終了します。");
		}
		scan.close();
	}

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
}
