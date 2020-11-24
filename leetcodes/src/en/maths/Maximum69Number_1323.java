package en.maths;

import java.util.ArrayList;
import java.util.Collections;

public class Maximum69Number_1323 {

//    给定一个仅由数字6和9组成的正整数num。
//    返回最多更改一位可获得的最大数字（6变为9，而9变为6）。

    public int maximum69Number (int num) {
        int index = -1, head = 0, number = num;

//        index 用来判断是否包含6
        while(number > 0){

            if(number % 10 == 6){
                index = head;

            }
            number = number / 10;
            head++;
        }
        return (index == 1) ? num : (num + 3 * (int)(Math.pow(10,index)));

    }

    public int maximum69Number1(int num){
        char [] strs = String.valueOf(num).toCharArray();
        for(int i = 0; i < strs.length; i ++){
            if(strs[i] == '6'){
                strs[i]= '9';
                return Integer.parseInt(strs.toString());
            }
        }
        return num;
    }

    public int maximum69Number2(int num){
        ArrayList<Integer> list = new ArrayList();
        while(num > 0){
            int last_digit = num % 10;
            num /= 10;
            list.add(last_digit);
        }
        Collections.reverse(list);
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(Integer i : list){
            if(i == 6 && flag == true){
                i = 9;
                flag = false;
            }
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    public int maximum69Number3(int num){
        int count = 0, n = num;
        while(n > 0){
            n = n / 10;
            count ++;
        }
        int [] arr = new int[count];
        while(num > 0){
            arr[count - 1] = num % 10;
            num = num / 10;
            count--;
        }
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == 9){
                continue;
            }else{
                arr[i] = 9;
                break;
            }
        }
        int newNum = arr[0];
        for(int i = 1; i < arr.length; i ++){
            newNum = newNum * 10 + arr[i];
        }
        return newNum;
    }
}
