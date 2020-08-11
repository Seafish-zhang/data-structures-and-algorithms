package leetcode;

public class LeetCode3 {

    public static void main(String[] args) {
        System.out.println(changeToZshape("PAYPALISHIRING", 3));
        System.out.println();
        System.out.println(changeToZshape("DSRWFSFWRQDWQ", 4));
    }

    /**
     * Z字形变换.
     *
     * @param ori    源字符串
     * @param rowNum Z形行数
     * @return 返回Z形逐字合并字符串
     */
    private static String changeToZshape(String ori, int rowNum) {
        if (rowNum < 3) {
            return ori;
        }
        // 每组数目，用row*row算一组，按照Z形状一共可存放 3* rowNum - 2个数据
        int groupNum = rowNum + rowNum - 2;

        int length = ori.length();
        // 算出总共组数
        int groupCount;
        if (length < rowNum) {
            groupCount = 1;
        } else {
            int remain = length - rowNum;
            groupCount = 1 + (length - rowNum) / groupNum;
            if (remain % groupNum != 0) {
                groupCount += 1;
            }

        }
        if (length % groupCount != 0) {
            // 超出一组数目
            groupCount += 1;
        }
        // 每组rouNum列.
        Character[][] strArrays = new Character[rowNum][rowNum * groupCount];
        for (int i = 0; i < length; i++) {
            //所在组下标
            if ((i + 1) <= rowNum) {
                strArrays[i][0] = ori.charAt(i);
            } else {
                int groupIndex = (i + 1 - rowNum) / groupNum;
                int i2 = (i + 1 - rowNum) - (groupIndex * groupNum);
                int x, y;
                if (i2 <= rowNum - 2) {
                    x = i2;
                    y = rowNum - i2 - 1;
                } else {
                    x = rowNum - 1;
                    y = (i2 + 1) - rowNum;
                }
                strArrays[y][x + groupIndex * (rowNum - 1)] = ori.charAt(i);
            }
        }
        return printArray(strArrays);
    }

    private static String printArray(Character[][] chars) {
        StringBuilder all = new StringBuilder();
        for (Character[] aChar : chars) {
            StringBuilder s = new StringBuilder();
            for (Character character : aChar) {
                if (character == null) {
                    s.append("   ");
                } else {
                    all.append(character);
                    s.append(" ").append(character).append(" ");
                }
            }
            System.out.println(s);
        }
        return all.toString();
    }
}
