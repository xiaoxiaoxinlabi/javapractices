package Observer;

public class ObserverTest {

  public static void main(String [] args){

    XiaoMei xiaoMei = new XiaoMei();
    XiaoWang xiaoWang = new XiaoWang();
    XiaoLi xiaoLi = new XiaoLi();

    xiaoMei.addPerson(xiaoWang);
    xiaoMei.addPerson(xiaoLi);
    xiaoMei.notifyPerson();
  }

}
