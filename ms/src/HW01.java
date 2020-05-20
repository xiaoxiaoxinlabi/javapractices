import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HW01 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("请输入：");
    String str = in.nextLine().toString();
    String[] c = str.split(",");
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < c.length; i++) {

      if (map.containsKey(c[i])) {
        map.put(c[i], map.get(c[i]) + 1);
      } else {
        map.put(c[i], 1);
      }
    }
    int[] res = new int[map.size()];
    int count = 0;
    for (Map.Entry m : map.entrySet()) {
      res[count] = (int) m.getValue();
      System.out.print(m.getValue() +",");

      count++;
    }
    Arrays.sort(res);
    System.out.println("count="+count);

    System.out.print("[");

    for (int k = 0; k < res.length; k++) {

      if(k != res.length-1){
        System.out.print(res[k] +",");
      }else{
        System.out.print(res[k]);
      }

    }

    System.out.println("]");

  }
}
