package en.maths;

import javax.print.attribute.EnumSyntax;
import java.util.*;

public class PowerfulIntegers_970 {
//    给定两个正整数x和y，对于某些整数i> = 0和j> = 0的整数，如果该整数等于x ^ i + y ^ j，则该整数是强大的。
//    返回值小于或等于bound的所有强整数的列表。
//    您可以按任何顺序返回答案。在您的答案中，每个值最多应出现一次。



    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        int i = 1, j = 1;
        ArrayList<Integer> res = new ArrayList();

        while(i <= bound){
           while(j <= bound){
               int n = i + j;
               if(n <= bound){
                   if(!res.contains(n)){
                       res.add(n);
                   }
               }
               j = j * y;
               if(y == 1){
                   break;
               }

           }
           j = 1;
           i = i * x;
           if(x == 1){
               break;
           }


        }
        return res;

    }

    public List<Integer> powerfulIntegers1(int x, int y, int bound){

        List<Integer> res = new ArrayList();
        dfs(x,y,0,0,bound,res);
        return res;
    }

    private void dfs(int x, int y, int i, int j, int bound,List<Integer> res){
        int sum = (int)Math.pow(x,i) + (int)Math.pow(y,j);

        if(sum > bound || res.contains(sum)){
            return ;
        }
        if(sum == bound){
            res.add(sum);
            return;
        }
        res.add(sum);

        dfs(x,y,i + 1, j, bound, res);
        dfs(x, y, i, j + 1, bound, res);
        dfs(x, y, i + 1, j + 1, bound, res);
    }

    public List<Integer> powerfulIntegers2(int x, int y, int bound){
        Set<Integer> ans = new HashSet();
        int a = 1, b = 1; //a=x^i  b=y^j

        //iterate through i
        while((a + b) <= bound){
            //iterate through j
            while((a + b) <= bound){
                ans.add(a + b);
                b= b * y;
                if(y == 1){
                    break;
                }
            }
            b = 1;
            a = a * x;
            if(x == 1){
                break;
            }
        }
        return new ArrayList<>(ans);
    }

    public List<Integer> powerfulIntegers3(int x, int y, int bound){
        List<Integer> numList = new ArrayList();

        for(int i = 1; i < bound; i = i * x){
            for(int j = 1; j < bound; j = j * y){
                int n = i + j;
                if(n <= bound){
                    if(!numList.contains(n)){
                        numList.add(n);
                    }
                }
                if(y == 1){
                    break;
                }
            }
            if(x == 1){
                break;
            }
        }
        Collections.sort(numList);
        return numList;
    }

    public List<Integer> powerfulIntegers4(int x, int y, int bound){
        List<Integer> list = new ArrayList<>();
        //we use i/j <= 19 here because 2^19 + 2^19 exceeds the limit of bound
        //and solves the case where x/y is 1
        for(int i = 0; i <= 19 && Math.pow(x, i) < bound ; i ++){
            for(int j = 0; j <= 19 && Math.pow(y, j) < bound; j++){
                int res = (int)(Math.pow(x,i) + Math.pow(y, j));

                if(res <= bound){
                    if(!list.contains(res)){
                        list.add(res);
                    }
                }
            }
        }
        return list;
    }

}
