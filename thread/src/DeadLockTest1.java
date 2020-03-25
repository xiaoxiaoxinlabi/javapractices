public class DeadLockTest1 {

//  思路
//  1，是创建两个字符串a和b，
//  2，再创建两个线程A和B，
//  3，让每个线程都用synchronized锁住字符串
//  4，（A先锁a，再去锁b；B先锁b，再锁a），
//  5，如果A锁住a，B锁住b，A就没办法锁住b，B也没办法锁住a，这时就陷入了死锁。,
  public static String obj1 ="obj1";
  public static String obj2 = "obj2";

  public static void main(String [] args){
    Thread a = new Thread(new Lock1());
    Thread b = new Thread(new Lock2());
    a.start();

//    如果我们只运行Lock1呢？修改一下main函数，把线程b注释掉。 破坏死锁
//    b.start();


  }



}
