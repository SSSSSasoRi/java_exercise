package Exercise66_75;

import java.util.Scanner;

public class Exercise73 {
	public static void main(String[] args) {
		System.out.println("SQLを入力してください：");
		Scanner scan = new Scanner(System.in);
		String sql = scan.nextLine();
		scan.close();

		SQLChecker sqlChecker = new SQLChecker();
		sqlChecker.check(sql);
	}
}
