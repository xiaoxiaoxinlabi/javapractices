package hash.hashcode.overrideHashCodeByInteger;

public final class Integer extends Number implements  Comparable<Integer> {

  private final int value;

  public Integer(int value){
    this.value = value;
  }

  @Override
  public int hashCode(){
    return Integer.hashCode(value);
  }

//  return a hash code value for a int value
  public static int hashCode(int value){

    return value;

  }







  @Override
  public int compareTo(Integer o) {
    return 0;
  }

  @Override
  public int intValue() {
    return 0;
  }

  @Override
  public long longValue() {
    return 0;
  }

  @Override
  public float floatValue() {
    return 0;
  }

  @Override
  public double doubleValue() {
    return 0;
  }
}
