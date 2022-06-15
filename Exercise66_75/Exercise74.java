package Exercise66_75;

import java.util.HashSet;
import java.util.Scanner;

public class Exercise74 {
	public static void main(String[] args) {
		System.out.println("SQLを入力してください：");
		Scanner scan = new Scanner(System.in);
		String sql = scan.nextLine();
		scan.close();

		SQLChecker sqlChecker = new SQLChecker();
		sqlChecker.check(sql);
	}
}

class SQLChecker {
	private HashSet<String> columnSet = new HashSet<>();
	private HashSet<String> tableSet = new HashSet<>();
	private String sqlCorrect = "SQLは正しいです。";
	private String errorWrongSelect = "SELECT句が正しくありません。";
	private String errorWrongSelectArg = "SELECT句の引数が正しくありません。";
	private String errorWrongFrom = "FROM句が正しくありません。";
	private String errorWrongFromArg = "FROM句の引数が正しくありません。";
	private String errorWrongWhere = "WHERE句が正しくありません。";
	private String errorWrongWhereArg = "WHERE句の引数が正しくありません。";

	public SQLChecker(String[] column, String[] table) {
		for (String value : column) {
			columnSet.add(value.toLowerCase());
		}
		for (String value : table) {
			tableSet.add(value.toLowerCase());
		}
	}

	public SQLChecker() {
		this(new String[] { "no", "lesson", "term", "result" }, new String[] { "kenshu" });
	}

	public void check(String sql) {
		// 入力されたSQL文を小文字に統一して、前後の空白を取り除く
		sql = sql.toLowerCase().trim();
		// カラム名が複数入力された場合、間の空白を取り除き、ひとまとめにする
		sql = sql.replaceAll("\\s*,\\s*", ",");
		// WHERE句が存在する場合、"="前後の空白を取り除き、条件式をひとまとめにする
		sql = sql.replaceAll("\\s*=\\s*", "=");
		// SQL文の各部分を配列で格納する
		String[] part = sql.split("\\s+");

		// SQL文の各部分（配列の各要素）を順番にチェックする
		// 最初に入力された句がSELECTではない場合
		if (part.length == 0 || !part[0].equals("select")) {
			System.out.println(errorWrongSelect);
			return;
		}
		// SELECT句以降に引数が存在しない場合
		if (part.length == 1 || part[1].equals("from")) {
			System.out.println(errorWrongSelectArg);
			return;
		} else {
			// SELECT句の引数に指定された項目が、カラムに存在しない場合
			String[] column = part[1].split(",");
			for (String value : column) {
				if (!columnSet.contains(value)) {
					System.out.println(errorWrongSelectArg);
					return;
				}
			}
		}
		// SELECT句の引数以降にFROM句が存在しない場合
		if (part.length == 2 || !part[2].equals("from")) {
			System.out.println(errorWrongFrom);
			return;
		}
		// FROM句の引数が存在しない、またはテーブル名ではない場合
		if (part.length == 3 || !tableSet.contains(part[3])) {
			System.out.println(errorWrongFromArg);
			return;
		}
		// FROM句の引数以降が存在する場合、その次に出てくる値がWHEREではない場合
		if (part.length >= 5) {
			if (!part[4].equals("where")) {
				System.out.println(errorWrongWhere);
				return;
			} else {
				// WHERE句の引数が存在しない場合
				if (part.length == 5) {
					System.out.println(errorWrongWhereArg);
					return;
				}
				// WHERE句の引数をチェックする
				for (int i = 5; i < part.length; i++) {
					// 条件式をチェックする
					if (i % 2 == 1) {
						if (checkCondition(part[i]) == false) {
							System.out.println(errorWrongWhereArg);
							return;
						}
					} else {
						// ANDをチェックする
						if (!part[i].equals("and")) {
							System.out.println(errorWrongWhereArg);
							return;
						}
					}
				}
				// WHERE句の最後がANDである場合
				if (part[part.length - 1].equals("and")) {
					System.out.println(errorWrongWhereArg);
					return;
				}
			}
		}
		System.out.println(sqlCorrect);
	}

	// WHERE句の引数をチェックするための関数
	public boolean checkCondition(String condition) {
		// 「=」が存在しない場合
		if (!condition.contains("=")) {
			return false;
		} else {
			// 条件式を「=」の前、後2つの部分に分割して、配列で格納する
			String[] arrCondition = condition.split("=");
			// 条件式の形が「A=B」でない場合
			if (arrCondition.length != 2) {
				return false;
			} else {
				// 「=」以降に値が存在しない、またはダブルクォートで囲まれていない場合
				if (arrCondition[1].length() < 2 || !(arrCondition[1].charAt(0) == '"'
						&& arrCondition[1].charAt(arrCondition[1].length() - 1) == '"')) {
					return false;
				}
				// 存在しないカラムを条件指定していた場合
				if (!columnSet.contains(arrCondition[0])) {
					return false;
				}
			}
		}
		return true;
	}
}
