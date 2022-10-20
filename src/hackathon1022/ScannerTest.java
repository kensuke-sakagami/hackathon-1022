package hackathon1022;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		//Scannerクラスをインスタンス化
		Scanner scan = new Scanner(System.in);

		System.out.println("下記に文字を入力してください");

		//①画面(コンソール上)に入力された値を格納する
		String str = scan.next();

		System.out.println("入力された値は");
		//②入力された値を表示
		System.out.println(str);

		System.out.println("-------------------------");

		System.out.println("下記に数値を入力してください");
		//①数値を取得
		int num = scan.nextInt();

		System.out.println("入力された値は");
		//②入力された値を表示
		System.out.println(num);

		
		
		//最後にcloseする
		scan.close();
	}

}
