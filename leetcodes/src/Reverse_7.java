public class Reverse_7 {
    //    给定一个 32 位有符号整数，将整数中的数字进行反转。
//    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
//    输入: 120
//    输出: 21
    public int reverse(int x) {

        long temp1;

        if ((x != Math.pow(-2, 31)) && (x != (Math.pow(2, 31) - 1))) {
            StringBuilder bd = new StringBuilder(String.valueOf(Math.abs(x)));
            temp1 = Long.parseLong((bd.reverse().toString()));

            if ((temp1 > Math.pow(-2, 31)) && (temp1 < Math.pow(2, 31) - 1)) {


                return x > 0 ? (int) temp1 : -(int) temp1;
            }

        }
        return 0;


    }

    public static void main(String args[]) {
        Reverse_7 re = new Reverse_7();
        System.out.println(re.reverse(1534236469));

    }
}
