package equals.overrideEqualsByString;

public class String {
//  The value is used for character storage.
  private final char  value[];

  public String(){
    this.value = new char[0];
  }

  @Override
  public boolean equals(Object anObject){

    if (this == anObject){
      return true;
    }
    if (anObject instanceof  String){
      String anotherString = (String) anObject;
      int n = value.length;

      if (n == anotherString.value.length){

        char v1[] = value;
        char v2[] = anotherString.value;
        int i = 0;

        while(n-- != 0){
          if (v1[i] != v2[i]){
            return false;
          }
          i ++;
          return true;
        }
      }
    }
   return false;
  }

}
