package Observer;

import java.util.ArrayList;
import java.util.List;

public class XiaoMei {

  List<Person> personList = new ArrayList<Person>();

  public XiaoMei(){}

  public void addPerson(Person person){

    personList.add(person);
  }

  public void notifyPerson(){

    for (Person p: personList){

      p.getMessage("你们过来吧，谁先过来就能陪我玩游戏");



    }
  }

}
