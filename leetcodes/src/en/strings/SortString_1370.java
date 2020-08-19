package en.strings;

public class SortString_1370 {
//    给定一个字符串s。您应该使用以下算法对字符串重新排序：
//    1.从s中选择最小的字符，并将其附加到结果中。
//    2.从s中选择一个大于最后一个追加字符的最小字符，并将其追加。
//    3.重复步骤2，直到您无法选择更多字符。
//    4.从s中选择最大的字符，并将其附加到结果中。
//    5.从s中选择比最后添加的字符小的最大字符，然后将其添加。
//    6.重复步骤5，直到您不能选择更多的字符。
//    重复步骤1到6，直到从中选择所有字符。

//    在每个步骤中，如果最小字符或最大字符出现多次，则可以选择任何出现的字符并将其附加到结果中。
//    使用此算法对s排序后返回结果字符串。

    public String sortString(String s) {

            char [] c = new char[s.length()];
            int cindex = 0;
            int [] a = new int[26];

            for(int i = 0; i < s.length(); i ++){
                a[s.charAt(i) - 'a']++;
            }
            while(cindex < s.length()){
                for(int i = 0; i < a.length; i ++){
                    if(a[i] != 0){
                        c[cindex++] = (char)(i+'a');
                        a[i]--;
                    }
                }
                for(int i = a.length-1; i >= 0; i--){
                    if(a[i] != 0){
                        c[cindex++] = (char)(i+'a');
                        a[i]--;
                    }
                }
            }
            return new String(c);

    }
    public String sortString1(String s){
        StringBuilder res = new StringBuilder();
        int arr[] = new int[26];
        int total = s.length();
//        统计字符串中的每个字符出现次数
        for(char c : s.toCharArray()){
            arr[c - 'a']++;
        }
        while(total > 0){
//            定义两个指针，分别指向头和尾
            int smallest = 0, largest = 25;
//            如果头指针小于26 并且arr[smallest] == 0 ,则一直遍历、
            while(smallest < 26 && arr[smallest] == 0){
                smallest++;
            }
            while(smallest<26){
//                如果当前值不为 0
                if(arr[smallest] != 0){
                    res.append((char)('a'+smallest));
                    arr[smallest]--;
                    total--;
                }
                smallest++;
            }
            while(largest >= 0 && arr[largest] == 0){
                largest--;
            }
            while (largest >= 0){
                if(arr[largest] != 0){
                    res.append((char)('a'+largest));
                    arr[largest]--;
                    total--;
                }
                largest--;
            }
        }
        return res.toString();
    }

}
