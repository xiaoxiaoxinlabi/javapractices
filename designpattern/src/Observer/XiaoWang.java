package Observer;

public class XiaoWang implements  Person {

  private String name = "小王";

  public XiaoWang(){}


  @Override
  public void getMessage(String s) {

    System.out.println(name + "接到了电话啦，电话内容是：" + s);
  }
}
