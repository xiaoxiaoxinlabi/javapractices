package en.hashTable;

import java.util.*;

public class PowerfulIntegers_970 {

//    给定两个正整数x和y，如果某个整数i> = 0和j> = 0等于x ^ i + y ^ j，则该整数是强大的。
//    返回值小于或等于bound的所有强整数的列表。
//    您可以按任何顺序返回答案。在您的答案中，每个值最多应出现一次。
//    Example 1:
//    Input: x = 2, y = 3, bound = 10
//    Output: [2,3,4,5,7,9,10]
//    Explanation:
//            2 = 2^0 + 3^0
//            3 = 2^1 + 3^0
//            4 = 2^0 + 3^1
//            5 = 2^1 + 3^1
//            7 = 2^2 + 3^1
//            9 = 2^3 + 3^0
//            10 = 2^0 + 3^2

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        List<Integer> list = new ArrayList();
        //we use i/j <= 19 here because 2^19 + 2^19 exceeds the limit of bound
        //and solves the case where x/y is 1
        for(int i = 0; i <= 19 && Math.pow(x,i) < bound; i ++){
            for(int j = 0; j <= 19 && Math.pow(y,j) < bound; j ++){
                int res = (int)(Math.pow(x,i) + Math.pow(y,j));
                if(res <= bound){
                    if(!list.contains(res)){
                        list.add(res);
                    }
                }
            }
        }
        return list;
    }

    public  List<Integer> powerfulIntegers1(int x, int y, int bound){
        List<Integer> res = new ArrayList();
        dfs(x,y,0,0,bound,res);
        return res;
    }

    private void dfs(int x, int y, int a, int b, int bound, List<Integer> res){
        int k = (int)(Math.pow(x,a) + Math.pow(y,b));
        if(k > bound || res.contains(k)){
            return;
        }

        if(k == bound){
            res.add(k);
            return;
        }
        res.add(k);
        dfs(x,y,a+1,b,bound,res);
        dfs(x,y,a,b+1,bound,res);
        dfs(x,y,a+1,b+1,bound,res);

    }

    public List<Integer> powerfulIntegers2(int x, int y, int bound){
        Set<Integer> ans = new HashSet();
        int a = 1, b = 1;
        while((a+b) <= bound){
            while((a+b) <= bound){
                ans.add(a+b);
                b *= y;
                if(y == 1){
                    break;
                }
            }
            b = 1;
            a *= x;
            if(x == 1){
                break;
            }
        }
        return new ArrayList(ans);
    }

   public List<Integer> powerfulIntegers3(int x, int y, int bound){

//        如果x/y = 1，则1 的任何次方都等于1，则需要排除1
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < bound; i = x * i){
            for(int j = 1; i+j <= bound; j = y * j){
                set.add(i+j);
                if(y == 1){
                    break;
                }
            }
            if(x == 1){
                break;
            }
        }
        return new ArrayList(set);
   }
}
