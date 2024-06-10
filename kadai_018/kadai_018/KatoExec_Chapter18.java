package kadai_018;

public class KatoExec_Chapter18 extends KatoHanako_Chapter18 {
	public static void main(String[] args) {

		KatoTaro_Chapter18 taro = new KatoTaro_Chapter18();
		taro.setGivenName();
		taro.execIntroduce();
		
		KatoIchiro_Chapter18 ichiro = new KatoIchiro_Chapter18();
		ichiro.execIntroduce();

		KatoHanako_Chapter18 hanako = new KatoHanako_Chapter18();
		hanako.execIntroduce();

	}

}

