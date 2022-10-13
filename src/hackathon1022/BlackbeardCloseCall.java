package hackathon1022;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BlackbeardCloseCall {
	static int[] answerArr = new int[24];
	static int sccanerNum =0;

	public static void main(String[] args){
		System.out.println("逆黒髭危機一髪！");
		makeArr();
		//0～24の間でランダムな値を生成(当たりを生成)	
		Random rnd = new Random();
		int answerNum = rnd.nextInt(24);
		System.out.println(answerNum);


		for (int i=0;i<24;) {
			//sccanerNumの初期化
			sccanerNum = 0;
			Scanner scanner = new Scanner(System.in);

			//コンソールから数値受け取り
			System.out.println("1から24の数値を入力してください:");
			sccanerNum = scanner.nextInt();

			//25以上or0以下の数値を入力された場合
			if(sccanerNum > 25 || sccanerNum < 1) {
				System.out.println(Arrays.toString(answerArr));
				System.out.println("1から24の数値を指定してください");
				continue;
				//すでに入力された値の場合
			}else if(answerArr[sccanerNum-1] == 0) {
				System.out.println(Arrays.toString(answerArr));
				System.out.println("すでに指定された値です。もう一度打ち込んでください。");
				continue;
			}

			//入力された値と黒髭の値が同じな場合
			if (sccanerNum == answerNum) {
				System.out.println("あたり！！");
				System.out.println((i+1)+"回目で当たりました");
				break;
				//ハズレの値を入力された場合;
			}else {
				System.out.println("もう一回");
				//answerArr(黒髭の穴)の指定された値に0を代入
				answerArr[sccanerNum-1] = 0;
				System.out.println(Arrays.toString(answerArr));
				i++;
				System.out.println("残り " +(24-i)+" 穴");
				continue;
			}
		}
	}

	//40個(黒髭の穴)を作る処理
	static int[] makeArr() {
		for (int i = 0; i<24; i++) {
			answerArr[i] = i+1;
		}
		System.out.println(Arrays.toString(answerArr));
		return answerArr;
	}
}
