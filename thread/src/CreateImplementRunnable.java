public class CreateImplementRunnable implements Runnable {

  @Override
  public void run() {
    for(int i = 0; i < 10; i ++){
      System.out.println("implement runnable is running" + i);
    }
  }

  public static void main(String [] args){

    Thread t = new Thread(new CreateImplementRunnable());
    t.start();

    for(int i = 0; i <10; i ++){
      System.out.println("main:" + i);
    }
  }
}
