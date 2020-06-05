package algorithms.string;

/**
 * Description:
 *
 * @author zhy
 * @date 2020/6/4
 */
public class StringMatch {

  public static void main(String[] args) {
    String a = "aax1245877dsaaaavaaadaac";
    String b = "aavaa";
    System.out.println(bfMatch(a, b));
    System.out.println(rkMatch(a, b));
    System.out.println(bmMatch(a, b));
    System.out.println(bm2Match(a, b));
  }

  private static int bm2Match(String string, String pattern) {
    int size = 256;
    char[] a = string.toCharArray();
    char[] b = pattern.toCharArray();
    int n = string.length();
    int m = pattern.length();
// a,b表示主串和模式串；n，m表示主串和模式串的长度。
    int[] bc = generateBC(size, b, m);
    int[] suffix = new int[m];
    boolean[] prefix = new boolean[m];
    generateGS(b, m, suffix, prefix);
    int i = 0; // j表示主串与模式串匹配的第一个字符
    while (i <= n - m) {
      int j;
      for (j = m - 1; j >= 0; --j) { // 模式串从后往前匹配
        if (a[i + j] != b[j]) {
          break; // 坏字符对应模式串中的下标是j
        }
      }
      if (j < 0) {
        return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
      }
      int x = j - bc[(int) a[i + j]];
      int y = 0;
      if (j < m - 1) { // 如果有好后缀的话
        y = moveByGS(j, m, suffix, prefix);
      }
      i = i + Math.max(x, y);
    }
    return -1;
  }

  // j表示坏字符对应的模式串中的字符下标; m表示模式串长度
  private static int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
    int k = m - 1 - j; // 好后缀长度
    if (suffix[k] != -1) {
      return j - suffix[k] + 1;
    }
    for (int r = j + 2; r <= m - 1; ++r) {
      if (prefix[m - r] == true) {
        return r;
      }
    }
    return m;
  }

  /**
   * BM算法，假设只匹配字母，所以d等于26.
   *
   * @param string  主串
   * @param pattern 模式串
   * @return 开始索引
   */
  private static int bmMatch(String string, String pattern) {
    int size = 256;
    char[] a = string.toCharArray();
    char[] b = pattern.toCharArray();
    int n = string.length();
    int m = pattern.length();
    int[] bc = generateBC(size, b, m);

    int i = 0; // i表示主串和模式串对齐的第一个字符.
    while (i <= n - m) {
      int j;
      // 模式串从后往前匹配
      for (j = m - 1; j >= 0; --j) {
        // 坏字符对应模式串中的下标是j
        if (a[i + j] != b[j]) {
          break;
        }
      }
      if (j < 0) {
        return i; // 匹配成功，返回主串与模式串第一个匹配的字符的位置
      }
      // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
      i = i + (j - bc[(int) a[i + j]]);
    }
    return -1;
  }

  private static int[] generateBC(int size, char[] b, int m) {
    int[] bc = new int[size];
    for (int i = 0; i < size; i++) {
      bc[i] = -1; //初始化
    }
    for (int i = 0; i < m; i++) {
      int ascii = (int) b[i];
      bc[ascii] = i;
    }
    return bc;
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
    int frequency = size1 - size2;
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

  // b表示模式串，m表示长度，suffix，prefix数组事先申请好了
  private static void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
    for (int i = 0; i < m; ++i) { // 初始化
      suffix[i] = -1;
      prefix[i] = false;
    }
    for (int i = 0; i < m - 1; ++i) { // b[0, i]
      int j = i;
      int k = 0; // 公共后缀子串长度
      while (j >= 0 && b[j] == b[m - 1 - k]) { // 与b[0, m-1]求公共后缀子串
        --j;
        ++k;
        suffix[k] = j + 1; //j+1表示公共后缀子串在b[0, i]中的起始下标
      }
      if (j == -1) {
        prefix[k] = true; //如果公共后缀子串也是模式串的前缀子串
      }
    }
  }

}
