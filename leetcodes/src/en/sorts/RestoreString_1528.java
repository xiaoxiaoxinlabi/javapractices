package en.sorts;

public class RestoreString_1528 {

//    给定一个字符串s和一个相同长度的整数数组索引。
//    字符串s将被重新排列，以使第ith个位置的字符移动到重新排列的字符串中的index [i]。
//    返回改组后的字符串。

//    Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
//    Output: "leetcode"
//    Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

//    Input: s = "abc", indices = [0,1,2]
//    Output: "abc"
//    Explanation: After shuffling, each character remains in its position.

//    Example 5:
//
//    Input: s = "art", indices = [1,0,2]
//    Output: "rat"


    public static String restoreString(String s, int[] indices) {

        char [] ret = new char[s.length()];

        for(int i = 0; i < indices.length; i ++){
//           int idx = indices[i];
//           char c = s.charAt(i);
//           ret[idx] = c;
            ret[indices[i]] = s.charAt(i);
        }

//        return new String(ret);
        return String.valueOf(ret);


    }

    public String restoreString1(String s, int [] indices){
        StringBuilder res = new StringBuilder();
        int i = 0, n = s.length();
        while(i < n){
            if(indices[i] != i){
                int index = indices[i];
                int temp = indices[index];
//                交换字符
                char ch = res.charAt(index);
                res.setCharAt(index, res.charAt(i));

//                交换indices
                indices[index] = indices[i];
                indices[i] = temp;
            }else{
                i++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args){
        String str = "codeleet";
        int[] arr = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString(str,arr));
    }
}
