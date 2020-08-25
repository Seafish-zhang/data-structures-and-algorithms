package leetcode3;

import java.util.ArrayList;
import java.util.List;

public class LeetCode211 {

    public static void main(String[] args) {
        SearchWord searchWord = new SearchWord();
        searchWord.addWord("bad");
        searchWord.addWord("dad");
        searchWord.addWord("mad");
        System.out.println(searchWord.search("pad"));
        System.out.println(searchWord.search("bad"));
        System.out.println(searchWord.search(".ad"));
        System.out.println(searchWord.search("b.."));
    }

    private static class SearchWord {
        private List<String> wordList = new ArrayList<>();

        private void addWord(String word) {
            this.wordList.add(word);
        }

        private boolean search(String str) {
            for (String s : wordList) {
                if (str.length() != s.length()) {
                    continue;
                }
                for (int i = 0; i < s.length(); i++) {
                    if (str.charAt(i) != '.' && str.charAt(i) != s.charAt(i)) {
                        break;
                    }
                    if (i == s.length() - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
