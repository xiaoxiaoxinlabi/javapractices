public class CreateExtendThread extends Thread{

  @Override
  public void run(){
    for(int i = 0; i < 10; i ++){
      System.out.println("runing " + i);
    }
  }

  public static void main(String [] args){
    CreateExtendThread c = new CreateExtendThread();
    c.start();

    for(int i = 0; i < 10; i ++){
      System.out.println("main" + i);
    }
  }

}
