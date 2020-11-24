package en.maths;

public class CheckStraightLine_1232 {

//    给您一个数组坐标，coordinates [i] = [x，y]，其中[x，y]代表一个点的坐标。检查这些点是否在XY平面上成直线。


    public boolean checkStraightLine(int[][] coordinates) {

        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];

        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        int zx = x1 - x0;
        int zy = y1 - y0;

        for(int i = 0; i < coordinates.length; i ++){
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            if(zx * (y - y1) != zy * (x - x1)){
                return false;
            }
        }
        return true;

    }
}
