package Observer;

public class XiaoLi implements  Person {


  private String name = "小李";

  public XiaoLi(){};

  @Override
  public void getMessage(String s) {

    System.out.println(name + "接到电话啦，电话内容是:" + s);
  }
}
