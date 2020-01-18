package adapter;

public class Phone {

  public static final int v = 220;

  private VotageAdapter adapter;

  public void change(){

    adapter.changeVoltage();
  }

  public void setAdapter(VotageAdapter adapter){

    this.adapter = adapter;

  }

}
