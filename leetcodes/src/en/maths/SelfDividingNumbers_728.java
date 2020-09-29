package en.maths;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers_728 {

//    自除数是一个数字，它包含的每个数字都可以整除
//    例如，128,包含的数字（1，2，8），因为128％1 == 0、128％2 == 0和128％8 == 0。
//    另外，自除数不允许包含数字零。
//    给定上下限，输出所有可能的自除数的列表，如果可能的话，包括边界。
//    Example 1:
//    Input:
//    left = 1, right = 22
//    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> list = new ArrayList<>();

        for(int i = left; i <= right;  i++){
            int tmp = i;
            boolean isOk = true;

            while(tmp != 0){
                int lastDigit = tmp % 10;
                if(lastDigit == 0 || i % lastDigit != 0){
                    isOk = false;
                    break;
                }
                tmp/=10;
            }
            if(isOk){
                list.add(i);
            }
        }
        return list;

    }

    public List<Integer> selfDividingNumbers1(int left, int right){
        List<Integer> list = new ArrayList();
        for(int i = left; i <= right; i ++){
//            将数字转换为字符串
            String number = Integer.toString(i);
            boolean flag = false;
//            遍历字符串，如果当前字符为 0 ，则停止（不能包含0）
            for(int j = 0; j < number.length(); j ++){
                if(number.charAt(j) == '0'){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                int curr = i;
//                遍历数字，计算该数字的余数（即数字的个位数）
                while(i == 0){
                    int a = i % 10;
//                    如果该数字，对个位数求余后，不能整数，则跳珠循环
                    if(curr % a != 0){
                        break;
                    }
//                    否则，在计算该数字的十位数
                    i = i / 10;
                }
//                当i为 0 时，将其添加到 list中
                if(i == 0){
                    list.add(curr);
                    i = curr;
                }
            }

        }
        return list;
    }

    public List<Integer> selfDividingNumbers2(int left, int right){
        List<Integer> list = new ArrayList();
        for(int i = left; i <= right; i ++){
            if(i <= 9){
                list.add(i);
            }else{
                int j = i;

                while(true){
                    if((j % 10 == 0) || (i %(j%10)) !=0){
                        break;
                    }
                    if(j < 10){
                        list.add(i);
                        break;
                    }
                    j = j / 10;
                }
            }
        }
        return list;
    }

    public List<Integer> selfDividingNumbers3(int left, int right){
        List<Integer> res = new ArrayList();
        for(int i = left; i <= right; i ++){
            if(isSelfDevided(i)){
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDevided(int n){
        int temp = n;
        while(temp > 0){
            int dig = temp % 10;
            if(dig == 0 || n % dig != 0){
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }


}
