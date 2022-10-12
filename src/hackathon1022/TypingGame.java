package hackathon1022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypingGame {
	static int corectCount = 0;
	static int mistakeCount = 0;
	static List<String> mistakeList = new ArrayList<>();
	static String inputValue;
	static List<String> gameValueList = new ArrayList<>();
	static List<String> gameValueEngList = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("タイピングゲーム");
		System.out.println("ボタンを押すと始まります");

		//Listに文字列の追加
		setgameValueList();
		//スタートの入力
		Scanner scanner = new Scanner(System.in);
		String start = scanner.next();

		boolean startBol = false;
		if (start != null) {
			startBol = true;
		}

		for(int i=0; startBol || i<10; i++) {
			inputValue = null;
			String gameValue = null;
			String gameEngValue = null;

			gameValue = gameValueList.get(i);
			gameEngValue = gameValueEngList.get(i);
			System.out.println(i + 1 + " 問目"); 
			System.out.println(gameValue);
			System.out.println(gameEngValue);
			inputValue = scanner.next();
			checkInputValue(inputValue, gameEngValue, gameValue );

			if(i == 9) {
				System.out.println("正解数は "+corectCount+ "です");
				System.out.println("間違った数は "+mistakeCount+" です");
				System.out.println("間違った問題は以下の問題です");
				for(int j=0; j<mistakeList.size();j++) {
					System.out.println(mistakeList.get(j));
				}
				startBol = false;
			}
			System.out.println("------------------------------");
		}
	}	
	static final String GAME1 = "こんばんは";
	static final String GAME1ENG = "konbanha";

	static final String GAME2 = "おはよう";
	static final String GAME2ENG = "ohayou";

	static final String GAME3 = "ファミリーマート";
	static final String GAME3ENG = "famiri-ma-to";

	static final String GAME4 = "コンフォリアしんじゅく";
	static final String GAME4ENG = "konforiasinzyuku";

	static final String GAME5 = "ミッキーマウス";
	static final String GAME5ENG = "mikki-mausu";

	static final String GAME6 = "すーあんこう";
	static final String GAME6ENG = "su-ankou";

	static final String GAME7 = "バスケットボール";
	static final String GAME7ENG = "basukettobo-ru";

	static final String GAME8 = "スナガカンタ は おされ ばんちょう";
	static final String GAME8ENG = "sunagakantahaosarebantyou";

	static final String GAME9 = "セブンイレブン の あげもの うますぎ";
	static final String GAME9ENG = "sebunirebunnnoagemonoumasugi";

	static final String GAME10 = "このゲーム の さくせいしゃ は サカガミケンスケ (がみけん) です";
	static final String GAME10ENG = "konoge-munosakuseisyahasakagamikensuke(gamiken)desu";



	//判別するメソッド 
	static void checkInputValue(String inputValue, String GAMEENG, String GAME) {
		String value = inputValue.replaceAll("　| ","");

		if (value.equals(GAMEENG) ) {
			corectCount += 1;
			System.out.println("正解！！");
		}else {
			mistakeCount += 1;
			mistakeList.add(GAME);
			System.out.println("失敗");
		}
	}

	//配列に問題の文字列をセットする関数	
	static void setgameValueList() {
		gameValueList.add(GAME1);
		gameValueList.add(GAME2);
		gameValueList.add(GAME3);
		gameValueList.add(GAME4);
		gameValueList.add(GAME5);
		gameValueList.add(GAME6);
		gameValueList.add(GAME7);
		gameValueList.add(GAME8);
		gameValueList.add(GAME9);
		gameValueList.add(GAME10);

		gameValueEngList.add(GAME1ENG);
		gameValueEngList.add(GAME2ENG);
		gameValueEngList.add(GAME3ENG);
		gameValueEngList.add(GAME4ENG);
		gameValueEngList.add(GAME5ENG);
		gameValueEngList.add(GAME6ENG);
		gameValueEngList.add(GAME7ENG);
		gameValueEngList.add(GAME8ENG);
		gameValueEngList.add(GAME9ENG);
		gameValueEngList.add(GAME10ENG);
	}

}
