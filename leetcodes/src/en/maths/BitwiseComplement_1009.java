package en.maths;

public class BitwiseComplement_1009 {

//    每个非负整数N都有一个二进制表示形式。例如，5可以二进制表示为“ 101”，11可以二进制表示为“ 1011”，依此类推。请注意，除了N = 0以外，任何二进制表示形式都没有前导零。
//    二进制表示形式的补码是将每个1更改为0并将0更改为1时所获得的二进制数字。例如，二进制的“ 101”的补码是二进制的“ 010”。
//      将N转换成二进制的补码之后，在转换成十进制,返回其以10为底的值


    public int bitwiseComplement(int N) {

        if(N == 0){
            return 1;
        }
        int tmp = N;
        int count = 0;
        while(tmp > 0){
            tmp >>>= 1;
            count++;
        }
        int mask = (-1) >>> (32-count);
        return (~N) & mask;

    }

    public int bitwiseComplement1(int N){
        String bin = Integer.toBinaryString(N);
        int len = bin.length();
        int std = (int)(Math.pow(2,len))-1;
        return N^std;
    }

    public int bitwiseComplement2(int N) {
        if (N == 0) {
            return 1;
        }
        char ch;
        int num = 0, i = 0;

        while (N > 0) {
            ch = (N % 2) == 1 ? '0' : '1';
            num = num + ((ch == '1') ? (int) Math.pow(2, i) : 0);
            N = N / 2;
            i++;
        }
        return num;

    }


    public int bitwiseComplement3(int N){
        if(N == 0){
            return 1;
        }
        char one = '1', zero = '0';
        String newStr = "", candidates = "01";
        String bin = Integer.toBinaryString(N);

        for(char c : bin.toCharArray()){
            if(candidates.indexOf(c) == 0){
                newStr += String.valueOf(one);
            }else{
                newStr += String.valueOf(zero);
            }
        }


        return Integer.parseInt(newStr,2);

    }

    public int bitwiseComplement4(int N){
        String s = Integer.toBinaryString(N);
        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch == '0'){
                sb.append('1');
            }else{
                sb.append('0');
            }
        }
//        如果方法有两个参数， 使用第二个参数指定的基数，将字符串参数解析为有符号的整数
        return Integer.parseInt(sb.toString(),2);

    }

    public int bitwiseComplement5(int N){
        if(N == 0){
            return 1;
        }
        int tmp = N;
        int cnt = 0;

        while(tmp != 0){
            tmp = tmp / 2;
            cnt ++;
        }
        double total = Math.pow(2,cnt) - 1;
        return (int) total - N;
    }

}
