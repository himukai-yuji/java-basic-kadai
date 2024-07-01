package kadai_026;

public class JyankenExec_Chapter26 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
	// Dictionary_Chapter21のインスタンスを作成
	   Jyanken_Chapter26 saisyohaGu = new Jyanken_Chapter26();
	   
	   String janken = saisyohaGu.getmyChoice();
	   
	   String aitenote = saisyohaGu.getRandom();
	   
	   saisyohaGu.playGame(janken,aitenote);
	        
	}
}
