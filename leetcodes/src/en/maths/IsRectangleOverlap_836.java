package en.maths;

public class IsRectangleOverlap_836 {
//    矩阵由列表[x1，y1，x2，y2]表示，其中（x1，y1）是其左下角的坐标，而（x2，y2）是其右上角的坐标。
//    如果两个矩形的相交区域为正，则它们重叠。为了清楚起见，仅在角或边缘接触的两个矩形不重叠。
//    给定两个（与轴对齐的）矩形，返回它们是否重叠。

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

//        rec2[x2] > rec1[x1] && rec2[y2]>rec2[y1] && rec1[x2] > rec2[x1] && rec1[y2]>rec2[y1]

        if((rec2[2] > rec1[0] && rec2[3] > rec1[1]) && (rec1[2] > rec2[0] && rec1[3]>rec2[1])){
            return true;
        }
        return false;
    }

    public boolean isRectangleOverlap1(int [] rec1, int [] rec2){
          int x1 = 0, x2 = 2,y1=1,y2=3;
          if(rec1[x2] > rec2[x1] && rec1[x1] < rec2[x2] && rec1[y2] > rec2[y1] && rec1[y1] < rec2[y2]){
              return true;
          }
          return false;
    }

    public boolean isRectangleOverlap2(int [] rec1, int [] rec2){
        if(Math.max(rec1[0],rec2[0]) < Math.min(rec1[2],rec2[2]) && Math.max(rec1[1],rec2[1]) < Math.min(rec1[3],rec2[3])){
            return true;
        }
        return false;
    }
}
