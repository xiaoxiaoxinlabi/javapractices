package en.maths;

public class LargestTriangleArea_812 {

//    有一个列表点，返回可以组成面积最大的三角形的点



    public double largestTriangleArea(int[][] points) {

        double max = 0.0;
        for(int i = 0; i < points.length - 2; i ++){
            for(int j = i + 1; j < points.length-1;j ++){
                for(int k = j + 1; k < points.length; k++){
                    max = Math.max(max, areaCal(points[i],points[j],points[k]));
                }
            }
        }
        return max;

    }

    private double areaCal(int [] p1, int [] p2, int[] p3){
        return Math.abs(p1[0] * (p2[1]-p3[1])+ p2[0] * (p3[1]-p1[1]) + p3[0] * (p1[1] - p2[1]))/2.0;
    }

    //    根据数据公式推导
//    ar1es = (ab * ac)*1/2
//    area = 1/2|(xb-xa)(yc-ya) - (xc-xa)(yb-ya)|
//    area = 1/2|xayb + xbyc + xcya -xayc-xcyb-xbya|

    public double largestTriangleArea1(int [][] points){
       double maxArea = 0.0f;
       if(points == null || points.length == 0){
           return maxArea;
       }
       for(int i = 0; i < points.length; ++i){
           for(int j = i + 1; j < points.length; ++j){
               for(int k = j + 1; k < points.length; ++k){
                   maxArea = Math.max(maxArea, 0.5 * Math.abs(
                           (points[j][0] - points[i][0]) * (points[k][1] - points[i][1])-
                           (points[k][0] - points[i][0]) * (points[j][1] - points[i][1])));
               }
           }
       }
       return maxArea;
    }

    public double largestTriangleArea2(int [][] points){
        double res = 0.0f;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j ++){
                for(int k = 0; k < points.length; k++){
                    double area = calarea(points[k][1],points[k][0], points[j][1], points[j][0],points[i][1],points[i][0]);
                    res = Math.max(area, res);
                }
            }
        }
        return res;
    }

    private double calarea(int y2, int x2, int y1, int x1, int y0, int x0){
        return Math.abs(x0*(y1-y2) + x1*(y2-y0) + x2*(y0-y1))*0.5;
    }


}
