package en.maths;

public class IsBoomerang_1037 {

//    给定列表中的三组点，如果三组点可以连城一条直线，则返回false, 否则返回true

//    运用数学公式，计算斜率，如果斜率都相等，则说明在一条线上，否则不在一条线上
    public boolean isBoomerang(int[][] points) {

        int Ax = points[0][0];
        int Ay = points[0][1];
        int Bx = points[1][0];
        int By = points[1][1];
        int Cx = points[2][1];
        int Cy = points[2][2];

        if( Bx == Ax && By == Ay) {
            return false;
        }
        if(Cx == Ax && Cy == Ay){
            return false;
        }
        if(Cx == Bx && Cy == By){
            return false;
        }

        double dydx1;
        double dydx2;

        if((Bx - Ax) == 0){
            dydx1 = Double.MAX_VALUE;
        }else{
            dydx1 = (double) (By - Ay) / (double)(Bx - Ax);
        }

        if((Cx - Ax) == 0){
            dydx2 = Double.MAX_VALUE;
        }else{
            dydx2 = (double)(Cy - Ay) / (double)(Cx - Ax);
        }

        return dydx1 != dydx2;

    }

//    (y2-y1)/(x2-x1) = (y3-y2)/(x3-x2)

    public boolean isBoomerang1(int [][] points){
        int diffx01 = points[0][0] - points[1][0];
        int diffy01 = points[0][1] - points[1][1];

        int diffx02 = points[0][0] - points[2][0];
        int diffy02 = points[0][1] - points[2][1];

        return
                !(diffx01 == 0 && diffy01 == 0)
                && !(diffx02 == 0 && diffy02 == 0)
                && !(diffx01 == diffx02 && diffy01 == diffy02)
                && diffx01 * diffy02 != diffy01 * diffx02;

    }

    public boolean isBoomerang2(int [][] points){
        int x1,y1,x2,y2,x3,y3;
        x1 = points[0][0];
        y1 = points[0][1];

        x2 = points[1][0];
        y2 = points[1][1];

        x3 = points[2][0];
        y3 = points[2][1];

        return !((y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1));


    }


}


