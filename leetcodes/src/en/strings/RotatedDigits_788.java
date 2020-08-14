package en.strings;

public class RotatedDigits_788 {

//    给定一个正数N ，从1，到N 找出 旋转180度之后还是数字的数字
    public int rotatedDigits1(int N){
        int count = 0;
        for(int i = 1; i <= N; i++){
            boolean b = check(i);
            if(b){
                count++;
            }
        }
        return count;
    }

    private boolean check(int n){
        String str = Integer.toString(n);
        char [] arr = str.toCharArray();
        int f1 = 0;
        int f2 = 0;
        for(char c:arr){
            if(c == '2' || c == '5' || c == '6' || c == '9'){
                f1 = 1;
            }
            if(c == '3' || c == '4' || c == '7'){
                f1 = 0;
                break;
            }
        }
        if(f1 == 0){
            return false;
        }
        return true;
    }
}
