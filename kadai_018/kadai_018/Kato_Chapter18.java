package kadai_018;

abstract public class Kato_Chapter18 {
	 public String familyName="加藤";//姓を表すフィールド
	 public String givenName;//名を表すフィールド
	 public String address="東京都中野区〇×";//住所を表すフィールド
	 
	//共通の紹介を出力 
	public void commonIntroduce() {
		System.out.println("名前は"+this.familyName+this.givenName+"です");
		System.out.println("住所は"+this.address+"です");
	}
	//個別の紹介を出力（抽象メソッド）
	abstract void eachIntroduce() ;
	//紹介を実行する
	public void execIntroduce() {
		commonIntroduce();
		eachIntroduce();
	}
}