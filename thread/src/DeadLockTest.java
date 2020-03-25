public class DeadLockTest {

//  可以采用跟踪资源分配和进程状态的算法来检测死锁，大多数方法通过防止四种Coffman条件中的一种发生来预防死锁，
//  尤其是循环等待：每个进程必须等待另一个进程持有的资源，而该进程又等待第一个进程释放资源。
//
//  死锁
//  设计思想：
//
//      1.设置两个线程A，B，设置两个资源标记对象a,b,
//      2.用A去锁住a,用B去锁住b，使a，b都被占有，
//      3.这时再用A去锁b，表示A目前需要b资源，因b目前被B占有，此时A无法锁住b
//      4.同理，用B去锁a，B也无法去锁住a，形成死锁，A,B陷于无限等待，形成死锁


//破坏死锁的方法，注释掉一个线程



  public static Object a = new Object();
  public static Object b = new Object();

  public static void main(String [] args){

    DeadLockTest d = new DeadLockTest();
    d.setDeadLock();


  }

  private void setDeadLock(){
    Thread A = new Thread(new Runnable() {
      @Override
      public void run() {
        threadA();
      }
    });

    Thread B = new Thread(new Runnable() {
      @Override
      public void run() {
        threadB();
      }
    });

    A.start();
//    B.start(); 注释掉B线程，让A线程运行
  }


  protected void threadA(){
    synchronized(DeadLockTest.a){
      System.out.println("A keep a");
      try {
//        留出时间让B线程锁住b
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized(DeadLockTest.b){
        System.out.println("A got b");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }
  }

  protected void threadB(){

    synchronized(DeadLockTest.b){
      System.out.println("B keep b");
      try {
//        留出时间让B线程锁住a
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (DeadLockTest.a){
        System.out.println("B got a");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }


}
