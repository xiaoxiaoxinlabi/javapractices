public class Test37 {
//【程序37】题目：有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。


  public static void fun(int n){

    boolean [] man = new boolean [n];
    for(int i = 0; i < man.length; i ++){
      man[i] = true;
    }
    int t = 0, len = man.length;
    while(len > 1){
      for(int i = 0; i < man.length; i++){
        if(man[i] == true){
          t++;
          if(t == 3){
//            重置
            t = 0;
//            去掉此人
            man[i] = false;
//            人数减1
            len--;
          }
        }
      }
    }
    for(int i = 0; i < man.length; i ++){
      if(man[i]){
        System.out.println("原来被剩下的人数"+(i+1));
      }
    }

  }

}
