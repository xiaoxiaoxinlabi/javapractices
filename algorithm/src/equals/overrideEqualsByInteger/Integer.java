package equals.overrideEqualsByInteger;

public class Integer {
  private final int value;


  public Integer(int value){
    this.value = value;
  }

  @Override
  public boolean equals(Object obj){

    if (obj instanceof Integer){
      return value == ((Integer)obj).intValue();
    }

    return false;

  }

  public int intValue(){
    return value;
  }

}
