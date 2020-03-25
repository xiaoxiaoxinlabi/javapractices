public class CreateThread {

  public static void main(String [] args){
    CreateExtendThread a = new CreateExtendThread();
    a.start();

    Thread b = new Thread(new CreateImplementRunnable());
    b.start();

    for(int i = 0; i < 10; i ++){
      System.out.println("main 主线程： " +i );
    }
  }

}
