package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

  public static void main(String[] args) {
    List<String> strings = matchBracketList(4);
    strings.forEach(System.out::println);
  }

  private static List<String> matchBracketList(int n) {
    List<String> bracketList = new ArrayList<>();
    match(bracketList, "", 0, 0, n);
    return bracketList;
  }

  private static void match(List<String> bracketList, String str, int left, int right, int n) {
    if (left < n) {
      match(bracketList, str + "(", left + 1, right, n);
    }
    if (right < left) {
      match(bracketList, str + ")", left, right + 1, n);
    }
    if (right == n) {
      bracketList.add(str);
    }
  }
}
