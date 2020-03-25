public class Lock1 implements  Runnable {

  @Override
  public void run() {

    System.out.println("Lock1 runing");
    synchronized (DeadLockTest1.obj1){
      System.out.println("Lock1 lock  obj1");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (DeadLockTest1.obj2){
        System.out.println("Lock1 lock obj2");
      }
    }

  }
}
