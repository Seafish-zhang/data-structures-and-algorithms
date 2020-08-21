package leetcode2;

public class LeetCode165 {

    public static void main(String[] args) {
        System.out.println(compareVersion("1", "1"));
        System.out.println(compareVersion("1.0.1", "1.0"));
        System.out.println(compareVersion("1.2", "1.0.9"));
        System.out.println(compareVersion("1.9.1", "1.9.2"));
    }

    /**
     * 比较版本大小
     *
     * @param version1 版本1
     * @param version2 版本2
     * @return 比较结果
     */
    private static int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i1 = 0;
        int i2 = 0;
        while (i1 <= split1.length - 1 && i2 <= split2.length - 1) {
            if (Integer.parseInt(split1[i1]) > Integer.parseInt(split2[i2])) {
                return 1;
            } else if (Integer.parseInt(split1[i1]) < Integer.parseInt(split2[i2])) {
                return -1;
            } else {
                i1++;
                i2++;
            }
        }
        if (i1 < split1.length) {
            return 1;
        } else if (i2 < split2.length) {
            return -1;
        } else {
            return 0;
        }

    }
}
