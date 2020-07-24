package jihe;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

//  Set用于存储不重复的元素集合


//  Set实际上相当于只存储key、不存储value的Map。我们经常用Set用于去除重复元素。
//
//  将元素添加进Set<E>：boolean add(E e)
//  将元素从Set<E>删除：boolean remove(Object e)
//  判断是否包含元素：boolean contains(Object e)


//  因为放入Set的元素和Map的key类似，都要正确实现equals()和hashCode()方法，否则该元素无法正确地放入Set。
//  最常用的Set实现类是HashSet，实际上，HashSet仅仅是对HashMap的一个简单封装
//

//  Set接口并不保证有序，而SortedSet接口则保证元素是有序的：
//
//  HashSet是无序的，因为它实现了Set接口，并没有实现SortedSet接口；
//  TreeSet是有序的，因为它实现了SortedSet接口。



  public static void main(String [] args){

    Set<String> set = new HashSet<>();


//    添加元素

    System.out.println(set.add("a"));
    System.out.println(set.add("b"));
    System.out.println(set.add("c"));



//    添加重复元素；已经存在的元素；返回false
    System.out.println(set.add("a"));

//    遍历set

    for(String res: set){
      System.out.print(res + " ");
    }

  }
}
