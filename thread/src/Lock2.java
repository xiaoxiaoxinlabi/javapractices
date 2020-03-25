public class Lock2 implements  Runnable {

  @Override
  public void run() {
    System.out.println("Lock2 running");
    synchronized (DeadLockTest1.obj2){
      System.out.println("Lock2 lock obj2");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (DeadLockTest1.obj1){
        System.out.println("Lock2 lock obj1");
      }
    }
  }
}
