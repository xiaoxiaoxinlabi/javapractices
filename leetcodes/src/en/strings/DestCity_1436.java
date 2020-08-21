package en.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DestCity_1436 {

//    您将获得数组路径，其中path [i] = [cityAi，cityBi]表示存在从cityAi到cityBi的直接路径。返回目标城市，即没有任何路径传到另一个城市的城市。
//    可以确保路径图形成一条没有任何循环的线，因此，将只有一个目标城市。

//    Example 1:
//
//    Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
//    Output: "Sao Paulo"
//    Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".


    public String destCity(List<List<String>> paths) {

        HashSet<String> from = new HashSet();
//        先将list中的get(0) 装进set中
        for(List<String> pair : paths){
            from.add(pair.get(0));
        }
//        在循环遍历list，如果不存在的get(1)这就是要找到的值
        for(List<String> pair : paths){
            if(!from.contains(pair.get(1))){
                return pair.get(1);
            }
        }

        return null;

    }

    public String destCity1(List<List<String>> paths){
//        将list按照key，value的形式装进map中
        HashMap<String, String> city = new HashMap();
        for(int i = 0; i < paths.size(); i ++){
            city.put(paths.get(i).get(0),paths.get(i).get(1));
        }
//        定义一个原始值，即list中的第一个组的第一个值
        String source = paths.get(0).get(0);
        String res = "";
//        如果map中包含该值，则继续遍历，直到不包含为止
        while(city.containsKey(source)){
            source = city.get(source);
            res = source;
        }
        return res;
    }

    public String destCity2(List<List<String>> paths){
        Map<String, Integer> map = new HashMap();
        for(List<String> list: paths){
            if(map.containsKey(list.get(0))){
                map.remove(list.get(0));
            }else{
                map.put(list.get(0),0);
            }

            if(map.containsKey(list.get(1))){
                map.remove(list.get(1));
            }else{
                map.put(list.get(1),1);
            }
        }
        for(Map.Entry<String, Integer> m : map.entrySet()){
            if(m.getValue() == 1){
                return m.getKey();
            }
        }
        return null;
    }


}
