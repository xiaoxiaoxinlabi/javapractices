package en.strings;

import java.util.ArrayList;
import java.util.List;

public class IsPathCrossing_1496 {


//    给定一个字符串路径，其中path [i] ='N'，'S'，'E'或'W'，每个代表分别向北，向南，向东或向西移动一个单位。您从2D平面上的原点（0，0）开始，然后在path指定的路径上行走。
//    如果路径在任意点相交，即在任何时候您位于先前访问过的位置，则返回True。否则返回False
//    Input: path = "NES"
//    Output: false
//    Explanation: Notice that the path doesn't cross any point more than once.

//    Input: path = "NESWW"
//    Output: true
//    Explanation: Notice that the path visits the origin twice.


//    将每次的挪动的路径都添加到list中，如果list中存在该值，则将说明回到过原点，则返回true
    public boolean isPathCrossing(String path) {

        int nc = 0, ec = 0;
        List<String> record = new ArrayList();
        record.add("00");
        for(int i = 0; i < path.length(); i++){
            char c = path.charAt(i);
            if(c == 'N'){
                nc++;
            }else if(c == 'S'){
                nc--;
            }else if(c == 'E'){
                ec++;
            }else if(c == 'W'){
                ec--;
            }
            String temp = nc +""+ec;
            if(record.contains(temp)){
                return true;
            }else{
                record.add(temp);
            }
        }
        return false;


    }
}
