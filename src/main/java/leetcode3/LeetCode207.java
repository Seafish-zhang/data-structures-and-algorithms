package leetcode3;

import java.util.*;

public class LeetCode207 {

    public static void main(String[] args) {
        canFinish(2, new int[][]{{0, 1}}).forEach(System.out::print);
        System.out.println();
        canFinish(3, new int[][]{{0, 1}, {1, 2}}).forEach(System.out::print);
        System.out.println();
        canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}).forEach(System.out::print);
        System.out.println();
        canFinish(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}).forEach(System.out::print);


    }

    /**
     * 课程表
     *
     * @param courseNum  课程数
     * @param coursePrev 前置课程要求
     * @return 完成所有课程的课程顺序
     */
    private static List<Integer> canFinish(int courseNum, int[][] coursePrev) {
        int[] indegree = new int[courseNum];

        for (int[] prev : coursePrev) {
            // 如果有课程需求，有一个就得+1
            indegree[prev[0]]++;
        }

        // 没有前置课程需求的课程列表
        Set<Integer> zeroDegree = new HashSet<>();
        for (int i = 0; i < courseNum; i++) {
            if (indegree[i] == 0) {
                zeroDegree.add(i);
            }
        }

        if (zeroDegree.isEmpty()) {
            // 全部都有前置要求，循坏了
            return new ArrayList<>();
        }
        List<Integer> courseSort = new ArrayList<>();
        while (!zeroDegree.isEmpty()) {
            Iterator<Integer> iterator = zeroDegree.iterator();
            Integer course = iterator.next();
            courseSort.add(course);
            // 去除这个课程，相当于假设学习了这个课程
            zeroDegree.remove(course);
            // 遍历判断，如果有前置需要学习了本课程的课程都可以前置课程数-1，即减去这个课程
            for (int[] prev : coursePrev) {
                if (prev[1] == course) {
                    indegree[prev[0]]--;
                    // 如果为0了，所以也可以学习这个课程
                    if (indegree[prev[0]] == 0) {
                        zeroDegree.add(prev[0]);
                    }
                }
            }
        }

        // 循环完，不冲突情况下应该全部课程的前置课程数都清零，否则说明有冲突，即有循环
        for (int i : indegree) {
            if (i != 0) {
                return new ArrayList<>();
            }
        }
        return courseSort;
    }
}
