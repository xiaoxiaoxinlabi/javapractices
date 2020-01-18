package adapter;

public class VotageAdapter {

  public void changeVoltage(){

    System.out.println("正在充电。。。。");
    System.out.println("原始电压" + Phone.v + "v") ;
    System.out.println("经过变压器转换之后的电压：" + (Phone.v - 200) + "v");
  }

}
