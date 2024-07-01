package kadai_026;

import java.util.HashMap;
import java.util.Scanner;

public class Jyanken_Chapter26 {
	//自分の手を入力するメソッド
	public String getmyChoice() {
		System.out.println("自分のじゃんけんの手を入力しましょう");
		System.out.println("グーはrockのrを入力しましょう");
		System.out.println("チョキはscissorsのsを入力しましょう");
		System.out.println("パーはpaperのpを入力しましょう");
		//Scannerクラスのオブジェクト作成
		Scanner scanner = new Scanner(System.in);
		while(true) {
			//入力したものを取得
			String push = scanner.next();
			//if文、入力されたものが正しいのかどうか
			if ((push.equals("r")) || (push.equals("s")) || (push.equals("p"))) {
				scanner.close();
				return push;
			} 
			else {
				System.out.println("「r,s,p」のいずれかを入力してください。");
				continue;
			}			
		}
	}
	//対戦相手のじゃんけんの手をランダムで表示するメソッド
	public String getRandom(){
		String[] janken = {"r","s","p"};
		
		String te = janken[(int)Math.floor(Math.random() * 3)];
		return te;
	}
		
	//じゃんけんを行うメソッド
	public void playGame(String myChoice,String yourChoice){
				
		HashMap<String,String> jankenForm = new HashMap<String,String>();

		jankenForm.put("r","グー");
		jankenForm.put("s","チョキ");
		jankenForm.put("p","パー");
		
		//お互いのじゃんけんの手を表示
		
		System.out.println("自分の手は"+jankenForm.get(myChoice)+"相手の手は"+jankenForm.get(yourChoice));
		//じゃんけん式の分岐
		if (myChoice.equals(yourChoice)) {
			System.out.println("あいこです");
		} else if (myChoice == "r" && yourChoice == "p") {
			System.out.println("自分の負けです");
		} else if (myChoice == "r" && yourChoice == "s") {
			System.out.println("自分の勝ちです");
		} else if (myChoice == "s" && yourChoice == "r") {
			System.out.println("自分の負けです");
		} else if (myChoice == "s" && yourChoice == "p") {
			System.out.println("自分の勝ちです");
		} else if (myChoice == "p" && yourChoice == "s") {
			System.out.println("自分の負けです");
		} else if (myChoice == "p" && yourChoice == "r") {
			System.out.println("自分の勝ちです");
		}
	}
}

	
