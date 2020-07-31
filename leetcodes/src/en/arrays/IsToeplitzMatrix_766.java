package en;

import java.util.HashMap;
import java.util.Map;

public class IsToeplitzMatrix_766 {

//  如果从左上角到右下角的每个对角线都具有相同的元素，则矩阵为Toeplitz。
//
//  现在给定一个M x N矩阵，当且仅当矩阵是Toeplitz时，才返回True
//  Example 1:
//
//  Input:
//  matrix = [
//      [1,2,3,4],
//      [5,1,2,3],
//      [9,5,1,2]
//      ]
//  Output: True
//  Explanation:
//  In the above grid, the diagonals are:
//      "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
//  In each diagonal all elements are the same, so the answer is True.

//  Input:
//  matrix = [
//      [1,2],
//      [2,2]
//      ]
//  Output: False
//  Explanation:
//  The diagonal "[1, 2]" has different elements.

  public boolean isToeplitzMatrix1(int [][] arr){

    Map<Integer, Integer> groups = new HashMap();
    for(int r = 0; r < arr.length; ++r){
      for(int c = 0; c< arr[0].length; ++c){
        if(!groups.containsKey(r-c)){
          groups.put(r-c, arr[r][c]);
        }else if(groups.get(r-c)!=arr[r][c]){
          return false;
        }
      }
    }
    return true;

  }

//  观察矩阵发现，对角线的值之间的索引相差1：即： [0][0]-->[1][1]-->[2][2]

  public boolean isToeplitzMatrix2(int [][] arr){

    for(int r = 0; r< arr.length-1; r++){
      for(int c = 0; c < arr[0].length-1; c++){
        if(r > 0 && c > 0 && arr[r+1][c+1] !=arr[r][c]){
          return false;
        }
      }

    }
    return true;
  }

}
