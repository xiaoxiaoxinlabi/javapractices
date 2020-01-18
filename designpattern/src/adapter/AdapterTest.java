package adapter;

public class AdapterTest {

  public static void main(String [] args){

    Phone phone = new Phone();
    VotageAdapter votageAdapter = new VotageAdapter();
    phone.setAdapter(votageAdapter);
    phone.change();
  }

}
