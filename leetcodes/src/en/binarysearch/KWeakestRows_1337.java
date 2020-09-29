package en.binarysearch;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.Collectors;

public class KWeakestRows_1337 {

//    给定一个矩阵 m *n ，其中每行中的1（代表士兵）和0（代表平民）
//    返回矩阵中每行 的1 的个数 从少到多的k行的索引; 如果 i 行 和j 行的 1 的数量一致，并且 i < j 则返回 i


//    Input: mat =
//            [[1,1,0,0,0],
//            [1,1,1,1,0],
//            [1,0,0,0,0],
//            [1,1,0,0,0],
//            [1,1,1,1,1]],
//    k = 3
//    Output: [2,0,3]

    public static int[] kWeakestRows(int[][] mat, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < mat.length; i ++){
           map.put(i, Arrays.stream(mat[i]).sum());
        }

        List<Map.Entry<Integer,Integer>> e = map.entrySet().stream()
                .sorted((o1,o2) -> o1.getValue().compareTo(o2.getValue())).collect(Collectors.toList());
        int [] res = new int[k];
        for(int i = 0; i < k; i ++){
            res[i] = e.get(i).getKey();
        }

        return res;


    }

    public int [] kWeakestRows1(int[][] mat, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int countOnes = 0;
        for(int i = 0; i < mat.length; i ++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    countOnes++;
                }
            }
            map.put(i, countOnes);
            countOnes = 0;
        }
        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int [] res = new int[k];
        int index = 0;
        for(Map.Entry<Integer,Integer> e : list){
            res[index++] = e.getKey();
            if(index >= k){
                break;
            }
        }
        return res;
    }

    public int [] kWeakestRows2(int [][] mat, int k){
        int m = mat.length, n = mat[0].length;
        List<Integer>[] bucket = new List[n+1];
        for(int i = 0; i < m; i ++){
            int count = 0;
            for(int j = 0; j < n && mat[i][j] > 0; j++){
                count++;
            }
            if(bucket[count] == null){
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(i);
        }
        int [] ans = new int[k];
        int index = 0;
        for(int i = 0; index < k&& i <= n; i++){
            if(bucket[i] == null){
                continue;
            }
            for(int j = 0; index < k && j < bucket[i].size(); j++){
                ans[index++] = bucket[i].get(j);
            }
        }
        return ans;
    }

    public int[] kWeakestRows3(int[][]mat, int k){
//        数组 a 统计每行有几个i
        int [] a = new int[mat.length];
        for(int i = 0; i < mat.length; i ++){
            int cnt = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    cnt++;
                }
            }
            a[i] = cnt;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < a.length; i ++){
            int min = Integer.MAX_VALUE;
            int index = -1;
//            找到数值最小的索引，将其添加到 list中
            for(int j = 0;j < a.length; j++){
                if(a[j] < min){
                    min = a[j];
                    index = j;
                }
            }
            list.add(index);
            a[index]=Integer.MAX_VALUE;
        }
        int [] ans = new int[k];
        for(int i = 0; i < k; i ++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int[] kWeakestRows4(int[][]mat, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int [] arr = new int[k];
//        遍历数组，将 索引与出现的1 的个数存放近map中
        for(int i = 0; i < mat.length; i ++){
            int cnt = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    cnt++;
                }
            }
            list.add(cnt);
            map.put(i,cnt);
        }

//        将 出现的次数存入list中
        Collections.sort(list);
        int size = map.size();
//        遍历map,如果 map中key对应的value 与 list中对应的value 想等，则将其添加到 结果集中，然后将对应位置上的值删除
        for(int m = 0; m < k; m++){
            for(int n = 0; n < size; n++){
                if(map.get(n) == list.get(m)){
                    arr[m] = n;
                    map.remove(n);
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String [] args){
        int [][] mat = {{1,1,0,0,0},
            {1,1,1,1,0},
            {1,0,0,0,0},
            {1,1,0,0,0},
            {1,1,1,1,1}};

        kWeakestRows(mat,3);



    }
}
