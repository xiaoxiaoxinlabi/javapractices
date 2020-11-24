package en.maths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HasGroupsSizeX_914 {

//
//    当且仅当您可以选择X> = 2并可以将整个卡片组分成1组或多组卡片时，才返回true，其中：
//    每组都有X张卡片。
//    每组中的所有卡均具有相同的数字。

    public boolean hasGroupsSizeX(int[] deck) {

        int [] count = new int[10000];
        for(int c: deck){
            count[c]++;
        }
        int g = -1;
        for(int i = 0; i < 10000; i ++){
            if(count[i] > 0){
                if(g == -1){
                    g = count[i];
                }else{
                    g = gcd(g, count[i]);
                }
            }

        }
        return g >= 2;
    }

    private int gcd(int x, int y){
        return x == 0 ? y : gcd(y % x, x);
    }

    public boolean hasGroupsSizeX1(int [] deck){
        int n = deck.length;
        Map<Integer, Integer> map = new HashMap();
        for(int card: deck){
            map.put(card, map.getOrDefault(card, 0)+1);
        }

        search: for(int x = 2; x <= n; x++){
            if(n % x == 0){
                for(int v : map.values()){
                    if( v % x != 0){
                        continue search;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean hasGroupsSizeX2(int [] deck){
        Map<Integer, Integer> counts = new HashMap<>();
        for(int card: deck){
            counts.put(card, counts.getOrDefault(card,0)+1);
        }

        ArrayList<Integer> frequencyList = new ArrayList();
        frequencyList.addAll(counts.values());
        int max = frequencyList.get(counts.size()-1);
        if(max <=1){
            return false;
        }
        for(int i = 2; i <= max; i ++){
            boolean flag = true;
            for(int j = 0; j < frequencyList.size(); j ++){
                if(frequencyList.get(j) % i != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;

    }
}
