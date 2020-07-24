package jihe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList {

//  有序列表
//  List的行为和数组几乎完全相同：List内部按照放入元素的先后顺序存放，每个元素都可以通过索引确定自己的位置，List的索引和数组一样，从0开始。

//   允许添加重复元素

//  实现List 接口主要有两种方式
//      1，通过数组（即ArrayList的实现方式）来实现
//      2，通过“链表”（即LinkedList）来实现


  public static void arrayListTest(){

    List<Character> list = new ArrayList();
    String str = "123456789";

//    插入元素
    for(int i = 0; i <str.length(); i ++){
      list.add(str.charAt(i));
    }

//    add方法添加的元素在末尾
    list.add('a');
    list.add('b');
    list.add('a');

    System.out.println(list.toString());

//    在索引i 处设置值, 替换原来的值， 索引必须存在，否则报异常
    list.set(0, 'd');
    System.out.println(list.toString());
//    在索引i 处 插入值, 原来位置上的值向后挪动
    list.add(1,'g');
    System.out.println(list.toString());

    List<Character>list_ad = new ArrayList<Character>();
    list_ad.add('啊');

    list.addAll(list_ad);
    System.out.println(list.toString());

//    删除某个索引位置上的元素； 实际上是把指定索引后面的元素依次往前挪一个位置
//    list.remove(2);

    System.out.println("遍历list==for 循环配合 get(i)");

    for(int i = 0; i < list.size(); i ++){
      System.out.print(list.get(i)+ " ");
    }

    System.out.println("遍历list iterator");

    for(Iterator<Character> it = list.iterator(); it.hasNext();){

      System.out.print(it.next()+ " ");

    }

    System.out.println("遍历list foreach");


    for(Character res: list){
      System.out.print(res+ " ");
    }





  }

  public static void LinkedListTest(){
//    在LinkedList中，它的内部每个元素都指向下一个元素：




  }






  public static void main(String [] args){
    arrayListTest();


  }


}
