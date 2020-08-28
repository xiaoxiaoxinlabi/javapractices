package en.sorts;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class AllCellsDistOrder_1030 {

//    给定一个具有R行和C列的矩阵，它们的单元格具有整数坐标（r，c），其中0 <= r <R和0 <= c <C.
//            另外，我们在该矩阵中给了一个坐标为（r0，c0）的单元格。
//    返回矩阵中所有单元的坐标，按其从（r0，c0）的最小距离到最大距离的距离排序。
//    在此，两个单元（r1，c1）和（r2，c2）之间的距离是曼哈顿距离，| r1-r2 |。 + | c1-c2 |。 （您可以按照满足此条件的任何顺序返回答案。）
//    Example 1:
//
//    Input: R = 1, C = 2, r0 = 0, c0 = 0
//    Output: [[0,0],[0,1]]
//    Explanation: The distances from (r0, c0) to other cells are: [0,1]

//    Example 2:
//
//    Input: R = 2, C = 2, r0 = 0, c0 = 1
//    Output: [[0,1],[0,0],[1,1],[1,0]]
//    Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
//    The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.


    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] res = new int [R*C][2];
        int count = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                res[count++] = new int[]{i,j};
            }
        }
        Arrays.sort(res, Comparator.comparingInt(a -> Math.abs(a[0] - r0) + Math.abs(a[1] - c0)));
        return res;

    }

    public int [][] allCellsDistOrder1(int R, int C, int r0, int c0){
        int [][] res = new int[R*C][2];
        res[0] = new int[]{r0,c0};
        int place = 1;
        int maxDist = Math.max((R-1-r0),r0) + Math.max((C-1-c0),c0);
        for(int i = 1;i <= maxDist; i ++){
            for(int r = 0;r < R; r++){
                for(int c = 0; c < C; c++){
                    if((Math.abs(r-r0)+Math.abs(c-c0)) == i){
                        res[place][0]=r;
                        res[place][1]=c;
                        place++;
                    }
                }
            }
        }
        return res;
    }

    public int [][] allCellsDistOrder2(int R, int C, int r0, int c0){
//        定义数组用来存放值
        int [][] answer = new int[R*C][];
        Queue<int[]> q = new LinkedList<>();

        boolean [][]visited = new boolean[R][C];

        int r = r0, c = c0, aIndex = 0;

        q.add(new int[]{r,c});
        visited[r][c] = true;
        while (q.size() != 0){
            int [] temp = q.poll();
            r = temp[0];
            c = temp[1];
            answer[aIndex] = new int[]{r,c};
            aIndex++;

//            moving up
            if(r-1>=0 && visited[r-1][c] == false){
                q.add(new int[]{r-1,c});
                visited[r-1][c] = true;
            }

//            moving down
            if(r+1 < R && visited[r+1][c] == false){
                q.add(new int[]{r+1,c});
                visited[r+1][c] = true;
            }

//            moving left
            if(c-1>=0 && visited[r][c-1] == false){
                q.add(new int[]{r,c-1});
                visited[r][c-1]=true;
            }

//            moving right

            if(c+1 < C && visited[r][c+1] == false){
                q.add(new int[]{r,c+1});
                visited[r][c+1]=true;
            }

        }
        return answer;
    }

    public int[][]allCellsDistOrder3(int R, int C, int r0, int c0){
        int[][]res = new int[R*C][2];
        int idx = 0;
        for(int i = 0; i < R; i ++){
            for(int j = 0; j < C; j++){
                res[idx][0]=i;
                res[idx][1]=j;
                idx++;
            }
        }
        Arrays.sort(res,(o1,o2) -> Math.abs(o1[0]-r0)+Math.abs(o1[1]-c0) - (Math.abs(o2[0]-r0)+Math.abs(o2[1]-c0)));
        return res;
    }
}
