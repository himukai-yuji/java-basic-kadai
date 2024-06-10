package kadai_018;

public class KatoHanako_Chapter18 extends Kato_Chapter18 {
	 public void setGivenName() {
		 this.givenName="花子";
	}
	 //コンストラクタ（初期化処理）
	 public KatoHanako_Chapter18(){
		setGivenName();
	}
	 //抽象メソッドに具体的な処理
	 void eachIntroduce() {
		 System.out.println("趣味は読書です");
	 }
}