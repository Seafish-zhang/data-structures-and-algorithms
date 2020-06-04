package algorithms.string;

/**
 * Description:
 *
 * @author zhy
 * @date 2020/6/4
 */
public class StringMatch {

  public static void main(String[] args) {
    String a = "aax1245aaavaaadaac";
    String b = "aaav";
    System.out.println(bfMatch(a, b));
    System.out.println(rkMatch(a, b));
  }

  /**
   * RK算法，假设只匹配字母，所以d等于26.
   *
   * @param string  主串
   * @param pattern 模式串
   * @return 开始索引
   */
  private static int rkMatch(String string, String pattern) {
    int size1 = string.length();
    int size2 = pattern.length();
    //哈希时需要用到进制计算，这里只涉及26个字母所以使用26进制
    int d = 26;
    //防止hash之后的值超出int范围，对最后的hash值取模
    //q取随机素数，满足q*d < INT_MAX即可
    int q = 144451;
    //str子串的hash值
    int strCode = string.charAt(0) - 'a';
    //pattern的hash值
    int patternCode = pattern.charAt(0) - 'a';
    //d的size2-1次幂，hash计算时，公式中会用到
    int h = 1;

    //计算sCode、pCode、h
    for (int i = 1; i < size2; i++) {
      patternCode = (d * patternCode + pattern.charAt(i) - 'a') % q;
      //计算str第一个子串的hash
      strCode = (d * strCode + string.charAt(i) - 'a') % q;
      h = (h * d) % q;
    }
    //最大需要匹配的次数
    int frequency = size1 - size2 + 1;
    //字符串开始匹配，对patternCode和strCode开始比较，并更新strCode的值
    for (int i = 0; i < frequency; i++) {
      if (strCode == patternCode) {
        // 增强比较，hash值一样并不能完全确保字符串一致
        String strSub = string.substring(i, i + pattern.length());
        if (strSub.equals(pattern)) {
          return i;
        }
      }
      //更新strCode的值，即计算str[i+1,i+m-1]子串的hashCode
      strCode = ((strCode - h * (string.charAt(i) - 'a')) * d + string.charAt(i + size2) - 'a');
    }
    return -1;
  }

  /**
   * BF算法.
   *
   * @param string  主串
   * @param pattern 模式串
   * @return 开始索引
   */
  private static int bfMatch(String string, String pattern) {
    char[] mArr = string.toCharArray();
    char[] nArr = pattern.toCharArray();
    int i = 0, j = 0;
    while (i < mArr.length && j < nArr.length) {
      if (mArr[i] == nArr[j]) {
        i++;
        j++;
      } else {
        i = i - j + 1;
        j = 0;
      }
    }
    if (j == nArr.length) {
      return i - j;
    } else {
      return -1;
    }
  }

}
