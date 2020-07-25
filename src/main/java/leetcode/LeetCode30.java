package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LeetCode30 {

  public static void main(String[] args) {
    wordLink("barfoothefoobarman", new String[]{"foo", "bar"}).forEach(System.out::println);
    System.out.println("=======================");
    wordLink("wordgoodsstudentgoodword", new String[]{"word", "student"})
        .forEach(System.out::println);
    System.out.println("=======================");
    wordLink("ABCDEFGHIJKFGHZHY", new String[]{"FGH", "IJK"}).forEach(System.out::println);
  }

  private static List<Integer> wordLink(String str, String[] words) {
    if (str == null || words == null || str.length() == 0 || words.length == 0) {
      return new ArrayList<>();
    }
    //不考虑顺序，而且要全部匹配，用Map来处理，设置未匹配的value为1
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, 1);
    }

    List<Integer> matchIndexList = new ArrayList<>();
    int wordCount = words.length;

    for (int i = 0; i < str.length(); i++) {
      // 本次匹配开始坐标
      int startIndex = i;
      // 本次循环匹配得到的单词数量
      int matchCount = 0;
      HashMap<String, Integer> colneMap = new HashMap<>(map);
      for (int j = startIndex + 1; j < str.length(); j++) {
        String substring = str.substring(startIndex, j);
        //匹配成功
        if (colneMap.containsKey(substring) && colneMap.get(substring) == 1) {
          //设置value为0
          colneMap.put(substring, 0);
          // 坐标要前移
          startIndex = j;
          matchCount++;
        }

        if (matchCount == wordCount) {
          boolean allMatch = true;
          for (Entry<String, Integer> entry : colneMap.entrySet()) {
            if (entry.getValue() != 0) {
              allMatch = false;
              break;
            }
          }
          if (allMatch) {
            matchIndexList.add(i);
          }
          matchCount = 0;
        }
      }
    }
    return matchIndexList;
  }
}
