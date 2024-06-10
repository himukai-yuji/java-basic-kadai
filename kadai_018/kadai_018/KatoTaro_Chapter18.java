package kadai_018;

public class KatoTaro_Chapter18 extends Kato_Chapter18 {
	 public void setGivenName() {
		 this.givenName="太郎";
	}
	 //コンストラクタ（初期化処理）
	 public KatoTaro_Chapter18(){
		setGivenName();
	}
	 //抽象メソッドに具体的な処理
	 void eachIntroduce() {
		 System.out.println("私はJavaが得意です");
	 }
}
