package kadai_021;

import java.util.HashMap;

public class Dictionary_Chapter21 {
	//辞書メソッド
	public void searchArray(String[]word) {
	//英単語の辞書として機能するフィールドを定義
	HashMap<String,String>fruit= new HashMap<String,String>();
	//調べた結果を格納
	String result = "";
	//英単語、意味の追加
	fruit.put("apple","りんご");
	fruit.put("peach","もも");
	fruit.put("banana","バナナ");
	fruit.put("lemon","レモン");
	fruit.put("pear","梨");
	fruit.put("kiwi","キウイ");
	fruit.put("strawberry","いちご");
	fruit.put("grape","ぶどう");
	fruit.put("muscut","マスカット");
	fruit.put("cherry","さくらんぼ");
	//繰り返し処理
	for(int i = 0; i<word.length; i++) {
		result = fruit.get(word[i]);
		if(result == null) {
			System.out.println(word[i]+"は辞書に追加されていません");
		}
		else {
			System.out.println(word[i]+"の意味は"+fruit.get(word[i]));
		}
	}
	}
}
