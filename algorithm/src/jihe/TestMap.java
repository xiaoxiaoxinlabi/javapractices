package jihe;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

//  基于键值对

//  map --put: 增加元素

  public static void main(String [] args){
    Map<Integer, Integer> map = new HashMap();
    int [] arr = {1,2,3,4,5,6,7};

    for(int i = 0 ; i <arr.length; i ++){
      map.put(i, arr[i]);
    }

    //  getOrDefault(Object key, V defaultValue)：返回指定键所映射到的值；如果此映射不包含键的映射关系，则返回defaultValue。


    System.out.println(map.getOrDefault(8,4));


//    get(Object key)： 返回指定键所映射到的值；如果此映射不包含键的映射关系，则返回null。
    System.out.println(map.get(8));

    System.out.println("放入相同key之前"+map.values());

//    Map中不存在重复的key，因为放入相同的key，只会把原有的key-value对应的value给替换掉。
    map.put(1,33);
    System.out.println(map.put(1,33));

    System.out.println("放入相同key之后"+map.values());

//    在一个Map中，虽然key不能重复，但value是可以重复的：
    System.out.println("不同key放入相同的值之前"+map.values());
    map.put(9,10);
    map.put(10,10);
    System.out.println("不同key放入相同的值之后"+map.values());

    map.put(7,777);


//    遍历map

//    遍历key:要遍历key可以使用for each循环遍历Map实例的keySet()方法返回的Set集合，它包含不重复的key的集合：

    for(Integer key: map.keySet()){
      System.out.print("key 的值: "+key + " ");
    }

//    遍历value：使用for each 循环遍历 values() ，值重复
    for(Integer value: map.values()){
      System.out.print("value 的值： "+value +" ");
    }

//    同时遍历key和value可以使用for each循环遍历Map对象的entrySet()集合，它包含每一个key-value映射：

    for(Map.Entry<Integer, Integer> res: map.entrySet()){
      System.out.println("key="+res.getKey() + "; value =" + res.getValue());
    }




  }






}
