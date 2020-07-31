public class IsLongPressedName_925 {

//  你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
//  你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
//  示例 1：
//
//  输入：name = "alex", typed = "aaleex"
//  输出：true
//  解释：'alex' 中的 'a' 和 'e' 被长按。
//  示例 2：
//
//  输入：name = "saeed", typed = "ssaaedd"
//  输出：false
//  解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样

  public boolean isLongPressedName1(String name, String typed) {
    char[] c1 = name.toCharArray();
    char[] c2 = typed.toCharArray();
    int p1 = 0, p2 = 0;
    while (p1 < c1.length && p2 < c2.length) {
      if (c1[p1] == c2[p2]) {
        p1++;
        p2++;
      } else {
        if (p1 >= 1 && c2[p2] == c1[p1 - 1]) {
          p2++;
        } else {
          return false;
        }
      }
    }
      while (p2 < c2.length) {
        if (c2[p2] == c1[p1 - 1]) {
          p2++;
        } else {
          return false;
        }
      }



    return p1 == c1.length;
  }
}
