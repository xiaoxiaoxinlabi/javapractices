package en.maths;

public class DiStringMatch_942 {
//    给定只含"I"（增大）或 "D"（减小）的字符串S令N = S.length。
//    返回[0, 1, ..., N]的任意排列A使得对于所有i = 0,..., N-1，都有：
//
//        如果为I，则索引递增，如果为D 则索引递减
//    如果S[i] == "I"，那么A[i] < A[i+1]
//    如果S[i] == "D"，那么A[i] > A[i+1]



    public int[] diStringMatch(String S) {

        char [] stoChars = S.toCharArray();
        int N = S.length();
        int [] res = new int[N+1];
        int inc = 0;
        int dec = N;

        for(int j = 0; j < N; j ++){
            if(stoChars[j] == 'I'){
                res[j] = inc;
                inc++;
            }else{
                res[j] = dec;
                dec--;
            }

        }
        res[N] = (stoChars[N-1] == 'I')? inc:dec;
        return res;

    }

    public int[] diStringMatch1(String S){
        S = S + "I";
        int [] ans = new int[S.length()];
        int c = 0, left = 0, right = 0;

        while(right < S.length()){

            while(right < S.length() && S.charAt(right) == 'D'){
                right++;
            }
            ans[right] = c++;
            left = right - 1;

            while(left >= 0 && S.charAt(left) == 'D'){
                ans[left--] = c++;
            }
            right++;
        }
        return ans;
    }

    public int[] diStringMatch2(String S){
        int inc = 0, dec = S.length();
        int [] res = new int[S.length() + 1];
        char [] stoArray = S.toCharArray();

        for(int i = 0; i < S.length(); i ++){
            if(stoArray[i] == 'I'){
                res[i] = inc++;
                res[i+1] = inc;
            }else{
                res[i] = dec--;
                res[i+1] = dec;
            }
        }
        return res;
    }

    public int[] diStringMatch3(String S){
        int inc = 0, i = 0, dec = S.length();
        int [] arr = new int[S.length() + 1];
        char [] ch = S.toCharArray();

        for(i = 0; i < ch.length; i ++){
            if(ch[i] == 'I'){
                arr[i] = inc++;
            }else{
                arr[i] = dec--;
            }
        }
        arr[i] = inc;
        return arr;
    }
}
