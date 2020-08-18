package leetcode2;

import leetcode.LeetCode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode126 {
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> wordChain = wordChain("hit", "cog", wordList);
        LeetCode49.printlnDoubleList(wordChain);
        System.out.println(min);
        System.out.println();
        min = Integer.MAX_VALUE;
        wordChain = wordChain("hat", "cag", wordList);
        LeetCode49.printlnDoubleList(wordChain);
        System.out.println(min);
    }

    /**
     * 单词接龙.
     * <p>每次转换只能改变一个字母</p>
     * <p>转换过程中的中间单词必须是字典中的单词</p>
     * <p>如果不存在这样的转换序列，返回一个空列表</p>
     * <p>每次转换只能改变一个字母</p>
     *
     * @param begin    开始单词
     * @param end      结束单词
     * @param wordList 单词字典
     * @return 接龙结果列表
     */
    private static List<List<String>> wordChain(String begin, String end, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(end)) {
            // 字典表中没有对应单词,直接返回空列表
            return result;
        }
        List<String> current = new ArrayList<>();
        List<Integer> usedIndexList = new ArrayList<>();
        current.add(begin);
        chain(result, current, begin, end, wordList, usedIndexList);
        return result;
    }

    private static void chain(List<List<String>> result, List<String> current, String prev,
                              String target, List<String> wordList, List<Integer> usedIndexList) {
        // 递归终止条件
        if (target.equals(prev)) {
//            current.add(target);
            result.add(new ArrayList<>(current));
            min = Math.min(min, current.size());
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            if (usedIndexList.contains(i)) {
                continue;
            }
            String newWord = wordList.get(i);
            // 一次只能替换一个字符
            if (compare(newWord, prev) == 1) {
                current.add(newWord);
                usedIndexList.add(i);
                chain(result, current, newWord, target, wordList, usedIndexList);
                usedIndexList.remove(usedIndexList.size() - 1);
                current.remove(newWord);
            }
        }
    }

    private static int compare(String ori, String target) {
        if (ori.length() != target.length()) {
            return -1;
        }
        int diff = 0;
        for (int i = 0; i < ori.length(); i++) {
            if (ori.charAt(i) != target.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
