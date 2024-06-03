public class Car_Chapter15 {
		//フィールド作成
		private int gear = 1;//1速から5速
		private int speed = 10;//速度
		//コンストラクタ」（初期化処理）
		public Car_Chapter15() {
		}
		//メソッド（ギアの値により速度が変える）
		public void gearChange(int aftergear) {
			this.gear=aftergear;
			switch(this.gear) {
			case 1->this.speed=10;
			case 2->this.speed=20;
			case 3->this.speed=30;
			case 4->this.speed=40;
			case 5->this.speed=50;
			default->this.speed=10;
			}
		}

	//【メソッド】ギアチェンジ後の表示
		public void run () {
			System.out.println("ギア１から"+this.gear+"に切り替えました");
			System.out.println("速度は時速"+this.speed+"Kmです");
		}
}
