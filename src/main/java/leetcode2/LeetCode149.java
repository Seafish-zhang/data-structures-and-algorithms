package leetcode2;

import java.util.HashMap;
import java.util.Map;

public class LeetCode149 {

    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(1, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(3, 3);
        System.out.println(maxPointOneLine(points));
        points = new Point[6];
        points[0] = new Point(1, 1);
        points[1] = new Point(3, 2);
        points[2] = new Point(5, 3);
        points[3] = new Point(4, 1);
        points[4] = new Point(2, 3);
        points[5] = new Point(1, 4);
        System.out.println(maxPointOneLine(points));
    }

    /**
     * 同一条直线上最多的点.
     *
     * @param points 点数组
     * @return 同一条直线上最多的点数
     */
    private static int maxPointOneLine(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private static int generateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return generateGCD(b, a % b);
        }
    }


    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
