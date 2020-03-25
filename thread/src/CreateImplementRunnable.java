public class CreateImplementRunnable implements Runnable {

  @Override
  public void run() {
    for(int i = 0; i < 10; i ++){
      System.out.println("implement runnable is running" + i);
    }
  }
}
