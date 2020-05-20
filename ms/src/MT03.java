import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        System.out.print("["+re.getKey() +"," + re.getValue()+"] ");

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



  public static void main(String[] args) {

    int[] arr = {1, 3, 4, 6, 2, 5};
    fun1(arr, 7);



  }


}
