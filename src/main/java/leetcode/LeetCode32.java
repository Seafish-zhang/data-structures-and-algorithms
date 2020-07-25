package leetcode;


import java.util.Stack;

public class LeetCode32 {

  public static void main(String[] args) {
    System.out.println(longestBracket("()()"));
    System.out.println(longestBracket(")()())"));
    System.out.println(longestBracket("(()()"));
    System.out.println(longestBracket("(()()()()())"));
    System.out.println(longestBracket("))()())()())()()()"));
  }


  private static int longestBracket(String str) {
    int maxLong = 0;
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      // 当前最大值已经大于或者等于剩下字符串长度
      if (maxLong >= str.length() - 1) {
        //直接退出循环，因为再大也不会超过当前有效值了
        break;
      }
      int thisIndex = i;
      for (int j = 0; j < str.length(); j++) {
        if (str.charAt(j) == '(') {
          stack.push(str.charAt(j));
        } else {
          // 为空则说明“）”优先于“（”,无效，重置开始坐标
          if (stack.isEmpty()) {
            thisIndex = j + 1;
          } else {
            stack.pop();
            maxLong = Math.max(maxLong, j - thisIndex + 1 - stack.size());
          }
        }
      }
    }
    return maxLong;
  }
}
