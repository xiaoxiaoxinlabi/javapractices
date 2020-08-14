package en.strings;

public class FindLUSlength_521 {


//    给定两个字符串，您需要找到这两个字符串中非共同子序列。最长的非共同子序列定义为这些字符串之一的最长子序列，并且此子序列不应是另一字符串的任何子序列。
//
//    子序列是一种序列，可以通过删除一些字符而不改变其余元素的顺序来从一个序列中得出。琐碎地，任何字符串都是其自身的子序列，而空字符串则是任何字符串的子序列。
//
//    输入将是两个字符串，并且输出必须是最长的不常见子序列的长度。如果最长的不常见子序列不存在，则返回-1。

    public int findLUSlength1(String a, String b){
        if(a.length() != b.length()){
            return Math.max(a.length(), b.length());
        }
        return !a.equals(b) ? a.length(): -1;
    }
}
