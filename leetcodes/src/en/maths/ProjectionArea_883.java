package en.maths;

public class ProjectionArea_883 {

//    在N * N网格上，我们放置一些与x，y和z轴轴向对齐的1 * 1 * 1立方体。
//    每个值v = grid [i] [j]表示放置在网格单元（i，j）顶部的v个立方体的塔。
//    现在，我们查看这些多维数据集在xy，yz和zx平面上的投影。
//    投影就像阴影一样，将我们的3维图形映射到2维平面。
//    在这里，当我们从顶部，正面和侧面看立方体时，我们正在查看“阴影”。
//    返回所有三个投影的总面积。

    public int projectionArea(int[][] grid) {

        int [] row = new int[grid.length];
        int [] col = new int[grid[0].length];
        int n = grid.length;
        int count = 0;

        for(int i = 0; i < n; i ++){
            int minr = 0;
            int minc = 0;

            for(int j = 0; j < n; j ++){
                if(grid[i][j] == 0){
                    count++;
                }
                minr = Math.max(grid[i][j],minr);
                minc = Math.max(grid[j][i],minc);
            }

            row[i] = minr;
            col[i] = minc;
        }
        int ans = 0;
        for(int i : row){
            ans+=i;
        }
        for(int i : col){
            ans+=i;
        }
        ans = ans + n * n - count;
        return ans;

    }
}
