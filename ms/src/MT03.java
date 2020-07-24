import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class MT03 {

//  找出数组中的两个数的和等于一个常数N
//  [1,3,4,6,2,5]
//  [[1,6],[3,4],[2,5]]


  public static void fun1(int[] arr, int n) {

    Arrays.sort(arr);

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      for (int k = arr.length - 1; k >= 0; k--) {
        if (arr[i] + arr[k] == n) {
          if (!map.containsKey(arr[i]) && !map.containsValue(arr[i])) {

            map.put(arr[i], arr[k]);

          }

        }
      }
    }

    int[][] res = new int[map.size()][2];
    int m = 0;
    System.out.print("[");
    for (Map.Entry re : map.entrySet()) {
      System.out.print("[" + re.getKey() + "," + re.getValue() + "] ");

      res[m][0] = (int) re.getKey();
      res[m][1] = (int) re.getValue();
      m++;

    }
    System.out.print("]");

//    for (int p = 0; p < res.length; p++) {
//
//      for (int k = 0; k < res[p].length; k++) {
//
//         System.out.print(res[p][k] + "  ");
//       }
//      }

  }

//采用二分查找，快排思想；从左右两边开始比较
  public static void expectSum_bySort(int[] arr, int expectSum) {

    StringBuilder sb = new StringBuilder().append("[");
    if (arr == null || arr.length == 0) {
      return;
    }
    Arrays.sort(arr);
    int left = 0, right = arr.length - 1;

    while (left < right) {
      if (arr[left] + arr[right] > expectSum) {
        right--;
      } else if (arr[left] + arr[right] < expectSum) {
        left++;
      } else//equal
      {
        sb.append("[" + arr[left] + " , " + arr[right] + "],");

        left++;
        right--;
      }
    }

    System.out.println(sb.replace(sb.length() - 1, sb.length(), "]").toString());

  }



  public static void expectSum_bysort2(int [] arr, int target){

    List<List<Integer>> ans = new ArrayList<>();

    if(arr == null || arr.length == 0){
      return ;
    }
    Arrays.sort(arr);
    int left = 0, right = arr.length - 1;
    while(left < right){
      if(arr[left] + arr[right] > target){
        right--;
      }else  if(arr[left] + arr[right] < target){
        left++;
      }else{
        ans.add(Arrays.asList(arr[left], arr[right]));
        left++;
        right--;
      }
    }
    System.out.println(ans);
  }

  public static void expectSum_bySet(int[] arr, int expectSum) {

    if (arr == null || arr.length == 0) {
      return;
    }

    HashSet<Integer> intSets = new HashSet<Integer>(arr.length);
    StringBuilder res = new StringBuilder().append("[");


    int suplement;
    for (int i = 0; i < arr.length; i ++) {
      suplement = expectSum - arr[i];
//      如果set不包含suplement，则将arr[i] 添加到set中
      if (!intSets.contains(suplement)) {
        intSets.add(arr[i]);
      } else {

        res.append("["+arr[i] + " , " + suplement+"]," );

      }
    }
    System.out.println(res.replace(res.length() - 1, res.length(), "]").toString());
  }




  public static void main(String[] args) {

    int[] arr = {1, 3, 4, 6, 2, 5, 3};
    expectSum_bysort2(arr, 7);


  }


}
