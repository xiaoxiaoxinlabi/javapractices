package en.hashTable;

public class IslandPerimeter_463 {

// 给定第x行坐标网格表示一张地图，其中网格[i][j] = 1表示土地，网格[i][j] = 0表示水。
//网格单元水平/垂直连接(不是对角线)。网格完全被水包围，并且只有一个岛(即一个或多个连接的陆地单元)。
//岛上没有“湖”，这意味着岛上的水与周围的水没有连接。一个单元是边长为1的正方形。网格是矩形的，宽度和高度不超过100。确定岛屿的周长。
//    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//    Output: 16
//    Explanation: The perimeter is the 16 yellow stripes in the image above.
//    Example 2:
//
//    Input: grid = [[1]]
//    Output: 4
//    Example 3:
//
//    Input: grid = [[1,0]]
//    Output: 4
    
//    先将所有的为1 的加起来，如果遇到前面，或者左边为1 则减去2
    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
                    perimeter += 4;

                    if(i > 0 && grid[i-1][j] == 1){
                        perimeter -= 2;
                    }
                    if(j > 0 && grid[i][j-1] == 1){
                        perimeter -= 2;
                    }
                }
            }
        }

        return perimeter;
    }

    public int islandPerimeter1(int[][]grid){
        int rows = grid.length, cols = grid[0].length;
        int islands = 0, neighbours = 0;
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                if(grid[i][j] == 1){
                    islands++;

                    if(i < rows - 1 && grid[i + 1][j] ==1){
                        neighbours++;
                    }
                    if(j < cols - 1 && grid[i][j + 1] ==1){
                        neighbours++;
                    }
                }


            }
        }
        return 4 * islands - 2 * neighbours;
    }

    public int islandPerimeter2(int [][] grid){
        int count = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(grid[i][j] == 1){
//                    top
                    if(i == 0 || grid[i - 1][j] == 0){
                        continue;
                    }

//                    bottom
                    if(i == grid.length - 1 || grid[i + 1][j] == 0){
                        count++;
                    }
//                    left
                    if(j == 0 || grid[i][j - 1] == 1){
                        count++;
                    }

//                    right
                    if(j == grid[i].length - 1 || grid[i][j + 1] == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
