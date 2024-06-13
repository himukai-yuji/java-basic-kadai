package kadai_021;

public class DictionaryExec_Chapter21 {

	public static void main(String[] args) {
        // Dictionary_Chapter21のインスタンスを作成
        Dictionary_Chapter21 dictionary = new Dictionary_Chapter21();
        
        // 検索する単語の配列を定義
        String[] wordsToSearch = {"apple", "banana", "grape","orange"};
        
        // searchArrayメソッドを呼び出します
        dictionary.searchArray(wordsToSearch);
    }
}