import java.util.Arrays;

public class CanConstruct_383 {

//  给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
//实例
//  canConstruct("a", "b") -> false
//  canConstruct("aa", "ab") -> false
//  canConstruct("aa", "aab") -> true
//  为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次


    public static boolean canConstruct1(String ransomNote, String magazine){

//      首先，是判定magazine的长度是否小于ransom，如果小于那么一定是false
      if(magazine.length() < ransomNote.length()){
        return false;
      }
      int caps[] = new int[27];
      for(char c : ransomNote.toCharArray()){
//        在magazine 中从指定的index （caps[c-'a'] ）遍历 字符 c, 查找 c 第一次出现的索引
        int index = magazine.indexOf(c, caps[c - 'a']);
//        如果index == -1则表示在magazine中从caps指定的遍历位置开始没有找到一样的字符
        if(index == -1){
          return false;
        }
        caps[c - 97] = index + 1;
      }
      return true;

    }

    public static boolean canConstruct2(String ransomNote, String magazine){
      char [] r = ransomNote.toCharArray();
      char [] m = magazine.toCharArray();
//      转换数组之后，在排序
      Arrays.sort(r);
      Arrays.sort(m);
//      用指针i指向r[]的第一个字符
//      用j指向m的第一个字符
      int i = 0, j = 0;
      while(i < r.length && j < m.length){
//        m中当前字符不能拿来构成r[i]，尝试用m中的下一个字符j++
        if(r[i] > m[j]){
          j++;
//          m中当前字符已经验证过无法构成r[i]而m中当前元素及后续元素都比r[i]大，所以r[i]这个字符找不到可以构建的，答案就是return false
        }else if(r[i] < m[j]){
          return false;
        }else{
          i++;
          j++;
        }
      }
      return i == r.length;
    }

}
