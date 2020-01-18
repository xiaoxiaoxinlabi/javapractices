package hash.hashcode.overrideHashCodeByString;

public final class String {

//  Cache the hash code for string
  private int hash;   //Default to 0

//  the value is used for character storage
  private final char value[];

  public String(){
    this.value = new char[0];
  }

//  Returns a hash code for this string. The hash code for a
  public int hashCode(){
    int h = hash;
    if(h == 0 && value.length > 0){
      char val[] = value;


//      就是以31为权，每一位为字符的ASCII值进行运算，用自然溢出来等效取模。
//      哈希计算公式可以计为s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
      for (int i = 0; i < value.length; i ++){
        h = 31 * h + val[i];
      }
      hash = h;
    }
    return h;
  }

}
