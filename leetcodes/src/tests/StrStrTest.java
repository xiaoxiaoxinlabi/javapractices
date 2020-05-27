package tests;

public class StrStrTest {

//    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0 || haystack.length() == 0) return 0;

        if (haystack.length() < needle.length()) return -1;

        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            boolean successFlag = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {

                    successFlag = false;
                    break;

                }
            }
            if (successFlag) {
                return i;
            }
        }
        return -1;

    }



    public int strStr1(String haystack, String needle) {

        if (!haystack.contains(needle)){
            return -1;
        }

        for (int i = 0; i <= haystack.length(); i ++){

            if (haystack.substring(0,i).contains(needle)){

                return (i - needle.length());
            }

        }

     return 0;
    }


//    方法一：子串逐一比较 - 线性时间复杂度
//    直接的方法 - 沿着字符换逐步移动滑动窗口，将窗口内的子串与 needle 字符串比较。
    public int strStr2(String haystack, String needle){
        int lenN = needle.length(), lenH = haystack.length();

        for(int start = 0; start < lenH - lenN+1; ++start){
            if(haystack.substring(start, start + lenN).equals(needle)){
                return start;
            }
        }

        return -1;


    }



    public static void main(String[] args) {

        StrStrTest st = new StrStrTest();
        String haystack = "hello", needle = "lo";
        System.out.println(st.strStr1(haystack, needle));


    }
}
