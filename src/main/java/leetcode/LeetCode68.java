package leetcode;

public class LeetCode68 {

    public static void main(String[] args) {
        alignCenter(new String[]{"this", "is", "an", "example", "of", "text", "just"}, 16);
        System.out.println();
        alignCenter(new String[]{"this", "is", "an", "apple", "of", "text", "just"}, 14);
    }

    private static void alignCenter(String[] arr, int maxLength) {
        System.out.println("[");
        int start = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((length + arr[i].length()) > maxLength) {
                printlnArr(arr, start, i - 1, maxLength, length);
                start = i;
                length = 0;
            }
            length += arr[i].length();
            length += 1;
        }

        if (length > 0) {
            printlnArr(arr, start, arr.length - 1, maxLength, length);
        }
        System.out.println("]");
    }

    private static void printlnArr(String[] arr, int start, int end, int maxLength, int length) {
        int wordCount = end - start + 1;
        int blackCount = maxLength - length + wordCount;
        StringBuilder sb = new StringBuilder();
        if (wordCount == 1) {
            sb.append(arr[start]);
            for (int i = 0; i < blackCount; i++) {
                sb.append(" ");
            }
        } else {
            int singleBlankCount = blackCount / (wordCount - 1);
            for (int i = start; i <= end; i++) {
                sb.append(arr[i]);
                for (int j = 0; j < singleBlankCount; j++) {
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
