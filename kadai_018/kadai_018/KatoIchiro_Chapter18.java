package kadai_018;

public class KatoIchiro_Chapter18 extends Kato_Chapter18 {
	 public void setGivenName() {
		 this.givenName="一郎";
	}
	 //コンストラクタ（初期化処理）
	 public KatoIchiro_Chapter18(){
		setGivenName();
	}
	 //抽象メソッドに具体的な処理
	 void eachIntroduce() {
		 System.out.println("好きな食べ物はリンゴです");
	 }
}