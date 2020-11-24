package en.maths;

public class SubtractProductAndSum_1281 {
//    给定整数n，返回其每个位数上的数字乘积与数字之和的差值


    public int subtractProductAndSum(int n) {

        int sum = 0, cj = 1;

//        对 n 进行 除10求余，得到每位上的数字
        while(n > 0){
            sum += n % 10;
            cj = cj * (n % 10);

            n = n / 10;
        }

        return cj - sum;

    }

    public int subtractProductAndSum1(int n){
        String str = String.valueOf(n);
        Integer p = 1, sum = 0;

        for(int i = 0; i < str.length(); i ++){
            Integer v = Integer.valueOf(String.valueOf(str.charAt(i)));

            p = p * v;
            sum = sum + v;
        }
        return p - sum;
    }

}
