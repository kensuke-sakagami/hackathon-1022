package hackathon1022;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class make123Hackathon {
	static int[][] make123Arr = new int[3][3];
	static String start = null;
	static LocalTime time;
	static int choiceDirectionNum;
	static int directionNum;
	static int upDownSideNum;
	static int count;


	public static void main(String[] args) {
		System.out.println("作れ123!");

		System.out.println("指定入力値以外を入力すると1になります");
		makeArr();

		Scanner scanner = new Scanner(System.in);
		
		boolean jud = true;

		//多次元配列の表示
		System.out.println(Arrays.toString(make123Arr[0]));
		System.out.println(Arrays.toString(make123Arr[1]));
		System.out.println(Arrays.toString(make123Arr[2]));
		//処理が完了するまで繰り返し処理
		while (jud) {
			//変数を初期化
			directionNum = 0;
			upDownSideNum = 0;
			choiceDirectionNum = 0;

			//現在のカウントを表示
			System.out.println("現在 "+count+" 周目");


			System.out.println("下記の入力案内にしたがってください");
			System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");

			//縦方向or横どちらにするか選ぶ;
			System.out.println("縦方向(上下)か横方向(左右)どちらに動かしますか?");
			System.out.println("縦方向(上下):1 横方向(左右):2 を入力");
			choiceDirectionNum = scanner.nextInt();
			//1,2以外の値が入力されたら強制的に1
			if(!(choiceDirectionNum == 1 || choiceDirectionNum == 2)) {
				choiceDirectionNum = 1;
			}

			//縦方向に動かす場合
			if(choiceDirectionNum == 1) {
				System.out.println("横:左から1,2,3 行目を動かす 1行目:1 2行目:2 3行目:3 を入力");
				//方向の値を受け取り
				directionNum = scanner.nextInt();
				//1から3以外の数字が打ち込まれたら強制的に1に
				if(!(directionNum == 1 || directionNum == 2 || directionNum == 3 )) {
					directionNum = 1;
				}

				System.out.println("上下どちらに動かしますか？");
				System.out.println("上方向:1 下方向:2");
				upDownSideNum = scanner.nextInt();
				//1,2以外の値が入力されたら強制的に1
				if(!(upDownSideNum == 1 || upDownSideNum == 2)) {
					upDownSideNum = 1;
				}

				changeSide(directionNum, upDownSideNum);	
				//横方向に動かす場合
			}else {
				System.out.println("縦:上から1,2,3 列目を動かしますか？"); 
				System.out.println("1列目:1 2列目:2 3列目:3 を入力");
				//方向の値を受け取り
				directionNum = scanner.nextInt();
				//1から3以外の数字が打ち込まれたら強制的に1に
				if(!(directionNum == 1 || directionNum == 2 || directionNum == 3 )) {
					directionNum = 1;
				}
				System.out.println("左右どちらに動かしますか？");
				System.out.println("左方向:1 右方向:2");
				upDownSideNum = scanner.nextInt();
				//1,2以外の値が入力されたら強制的に1
				if(!(upDownSideNum == 1 || upDownSideNum == 2)) {
					upDownSideNum = 1;
				}

				changeUpDown(directionNum, upDownSideNum);
			}

			count +=1;
			jud = check123();

			//123が揃った時に表示する
			if (jud == false) {
				System.out.println("1,2,3揃いました！！");
				System.out.println("揃うまでに "+count+" 周かかりました");
			}
			//多次元配列の表示
			System.out.println(Arrays.toString(make123Arr[0]));
			System.out.println(Arrays.toString(make123Arr[1]));
			System.out.println(Arrays.toString(make123Arr[2]));
			System.out.println("----------------------------------");
		}
		scanner.close();
	}

	//ランダムな配列を作る処理
	static int[][] makeArr() {
		boolean w = true;
		while(w) {
			for(int i=1; i<10;) {
				Random rnd = new Random();
				int verticalNum = rnd.nextInt(3);
				int besideNum= rnd.nextInt(3);
				if (make123Arr[verticalNum][besideNum] == 0) {
					make123Arr[verticalNum][besideNum] = i;
					i++;
				}
			}
			w = !(check123());
		}
		return make123Arr;
	}


	//縦方向を指定されたときのメソッド
	//指定された高さの列を左右どちらに動かすか
	static void changeUpDown(int directionNum, int upDownSideNum) {
		//値を動かしたときに避難する用の数値
		//最初に更新した値を保存
		int num = 0;
		num = make123Arr[directionNum-1][0];

		//左に動かす(upDownSideNumに1を指定された場合)
		if(upDownSideNum == 1) {
			make123Arr[directionNum-1][0] = make123Arr[directionNum-1][1];
			make123Arr[directionNum-1][1] = make123Arr[directionNum-1][2];
			make123Arr[directionNum-1][2] = num;
			//右に動かす(upDownSideNumに2を指定された場合)	
		}else {
			make123Arr[directionNum-1][0] = make123Arr[directionNum-1][2];
			make123Arr[directionNum-1][2] = make123Arr[directionNum-1][1];
			make123Arr[directionNum-1][1] = num;
		}
	}

	//横方向を指定された時のメソッド
	//指定された列を上下どちらに動かすか
	static void changeSide(int directionNum, int upDownSideNum) {
		//値を動かしたときに避難する用の数値
		//最初に更新した値を保存
		int num = 0;
		num = make123Arr[0][directionNum-1];

		//上に動かす(upDownSideNumに1を指定された場合)
		if(upDownSideNum == 1) {
			make123Arr[0][directionNum-1] = make123Arr[1][directionNum-1];
			make123Arr[1][directionNum-1] = make123Arr[2][directionNum-1];
			make123Arr[2][directionNum-1] = num;
			//下に動かす(upDownSideNumに2を指定された場合)	
		}else {
			make123Arr[0][directionNum-1] = make123Arr[2][directionNum-1];
			make123Arr[2][directionNum-1] = make123Arr[1][directionNum-1];
			make123Arr[1][directionNum-1] = num;
		}
	}

	//縦or横or斜めに1,2,3か3,2,1の順番ができたことを判別するメソッド
	static boolean check123() {
		//123の順番で揃っていない場合trueを返す
		boolean check = true;
		//123の順番で並んでいないかを判別する処理
		//123で並ぶ=足したら6になることが
		//一定の箇所(4角)に1があるとクリアにはならないためそれも踏まえる
		if(make123Arr[0][0]+make123Arr[0][1]+make123Arr[0][2] == 6 ||
				make123Arr[1][0]+make123Arr[1][1]+make123Arr[1][2] == 6 ||
				make123Arr[2][0]+make123Arr[2][1]+make123Arr[2][2] == 6 ||
				make123Arr[0][0]+make123Arr[1][0]+make123Arr[2][0] == 6 ||
				make123Arr[0][1]+make123Arr[1][1]+make123Arr[2][1] == 6 ||
				make123Arr[0][2]+make123Arr[1][2]+make123Arr[2][2] == 6 ||
				make123Arr[0][0]+make123Arr[1][1]+make123Arr[2][2] == 6 ||
				make123Arr[0][2]+make123Arr[1][1]+make123Arr[2][0] == 6 ) {
			if(!(make123Arr[0][0] == 2 || make123Arr[0][2] == 2 ||
					make123Arr[2][0] == 2 || make123Arr[2][2] == 2)) {
				check = false;
			}
		}
		return check;
	}
}
