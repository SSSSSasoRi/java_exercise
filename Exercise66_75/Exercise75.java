package Exercise66_75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Exercise75 {
	public static void main(String[] args) {
		System.out.println("SQLを入力してください：");
		Scanner scan = new Scanner(System.in);
		String sql = scan.nextLine();
		scan.close();

		SQLExcutor sqlExcutor = new SQLExcutor();
		sqlExcutor.run(sql);
	}
}

class SQLExcutor {
	private HashSet<String> columnSet = new HashSet<>();
	private HashSet<String> tableSet = new HashSet<>();
	private HashMap<String, ArrayList<String>> tableData = new HashMap<>();
	private String sqlCorrect = "SQLは正しいです。";
	private String errorWrongSelect = "SELECT句が正しくありません。";
	private String errorWrongSelectArg = "SELECT句の引数が正しくありません。";
	private String errorWrongFrom = "FROM句が正しくありません。";
	private String errorWrongFromArg = "FROM句の引数が正しくありません。";
	private String errorWrongWhere = "WHERE句が正しくありません。";
	private String errorWrongWhereArg = "WHERE句の引数が正しくありません。";

	public SQLExcutor(String[] column, String[] table) {
		for (String value : column) {
			columnSet.add(value.toLowerCase());
			tableData.put(value, new ArrayList<>());
		}
		for (String value : table) {
			tableSet.add(value.toLowerCase());
		}
	}

	public SQLExcutor() {
		this(new String[] { "no", "lesson", "term", "result" }, new String[] { "kenshu" });
	}

	public void buildTable() {
		tableData.get("no").addAll(Arrays.asList("1", "2", "3", "4", "5"));
		tableData.get("lesson").addAll(Arrays.asList("sql", "sql", "java", "java", "python"));
		tableData.get("term").addAll(Arrays.asList("前期", "後期", "前期", "後期", "通年"));
		tableData.get("result").addAll(Arrays.asList("80", "85", "70", "75", "60"));
	}

	public void run(String sql) {
		// まずSQL文をチェックする
		ParseResult result = check(sql);
		if (result.checkResult) {
			// SQL文が正しい場合、必要なデータを検索する
			buildTable();
			ArrayList<Integer> index = new ArrayList<>();
			for (int i = 0; i < tableData.get("no").size(); i++) {
				index.add(i);
			}
			for (HashMap.Entry<String, String> entry : result.conditions.entrySet()) {
				index = filter(index, entry.getKey(), entry.getValue());
			}
			// 検索結果を出力する
			for (String column : result.columns) {
				System.out.print(column + "\t");
			}
			System.out.println();
			for (Integer i : index) {
				for (String column : result.columns) {
					System.out.print(tableData.get(column).get(i) + "\t");
				}
				System.out.println();
			}
		}
	}

	public ArrayList<Integer> filter(ArrayList<Integer> index, String column, String value) {
		ArrayList<Integer> res = new ArrayList<>();
		for (Integer i : index) {
			if (tableData.get(column).get(i).equals(value)) {
				res.add(i);
			}
		}
		return res;
	}

	public ParseResult check(String sql) {
		ParseResult result = new ParseResult();

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
			return result;
		}
		// SELECT句以降に引数が存在しない場合
		if (part.length == 1 || part[1].equals("from")) {
			System.out.println(errorWrongSelectArg);
			return result;
		} else {
			// SELECT句の引数に指定された項目が、カラムに存在しない場合
			String[] column = part[1].split(",");
			for (String value : column) {
				if (!columnSet.contains(value)) {
					System.out.println(errorWrongSelectArg);
					return result;
				}
				// カラムに存在する場合、ParseResultに追加する
				result.columns.add(value);
			}
		}
		// SELECT句の引数以降にFROM句が存在しない場合
		if (part.length == 2 || !part[2].equals("from")) {
			System.out.println(errorWrongFrom);
			return result;
		}
		// FROM句の引数が存在しない、またはテーブル名ではない場合
		if (part.length == 3 || !tableSet.contains(part[3])) {
			System.out.println(errorWrongFromArg);
			return result;
		}
		// FROM句の引数以降が存在する場合、その次に出てくる値がWHEREではない場合
		if (part.length >= 5) {
			if (!part[4].equals("where")) {
				System.out.println(errorWrongWhere);
				return result;
			} else {
				// WHERE句の引数が存在しない場合
				if (part.length == 5) {
					System.out.println(errorWrongWhereArg);
					return result;
				}
				// WHERE句の引数をチェックする
				for (int i = 5; i < part.length; i++) {
					// 条件式をチェックする
					if (i % 2 == 1) {
						if (checkCondition(part[i]) == false) {
							System.out.println(errorWrongWhereArg);
							return result;
						}
						// 条件式が正しい場合、ParseResultに追加する
						String[] arrCondition = part[i].split("=");
						result.conditions.put(arrCondition[0],
								arrCondition[1].substring(1, arrCondition[1].length() - 1));
					} else {
						// ANDをチェックする
						if (!part[i].equals("and")) {
							System.out.println(errorWrongWhereArg);
							return result;
						}
					}
				}
				// WHERE句の最後がANDである場合
				if (part[part.length - 1].equals("and")) {
					System.out.println(errorWrongWhereArg);
					return result;
				}
			}
		}
		System.out.println(sqlCorrect);
		result.checkResult = true;
		return result;
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

class ParseResult {
	public boolean checkResult = false;
	public ArrayList<String> columns = new ArrayList<>();
	public HashMap<String, String> conditions = new HashMap<>();
}
