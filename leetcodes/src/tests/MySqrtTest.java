package tests;

public class MySqrtTest {

    public int mySqrt(int x){
     if (x == 0)return 0;
     long i = x;
     while(i > x / i){
         i = (i + x / i) / 2;

     }
     return (int)i;


    }

    public int mySqrt1(int x){
        if (x == 0) return 0;
        int start = 0, end = x;
        while(start < end){
            int mid = start + (end - start) / 2;
            if (mid <= x/ mid && (mid + 1) > x / (mid + 1)){
                return mid;
            }else if (mid > x / mid){
                end = mid;
            }else{
                start = mid + 1;
            }

        }
        return start;

    }
    // 满足 某个数V的平方<=给定的X的最大的V
    // 二分查找中的求上界
    public int mySqrt2(int x){
        int left = 1;
        int rigth = x;
        while (left < rigth){
            int mid = rigth - (rigth - left) / 2;
            if (mid > x / mid){// 不能写成mid*mid>x, 因为可能会int溢出
                rigth = mid - 1;
            }else{
                left = mid;
            }
        }

        return rigth;
    }

    public int mySqrt3(int x){

        if (x == 0 || x == 1)return x;
        int i = x / 2;
        while(i > 1){
            if (i <=x / i){
                break;
            }
            i--;
        }
        return i;

    }

    public static void main(String[] args) {
        MySqrtTest mySqrtTest = new MySqrtTest();
        int x = mySqrtTest.mySqrt3(2147395599);
        System.out.println(x);
    }

}

