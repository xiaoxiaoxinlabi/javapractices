package equals.overrideEqualsByDate;

public class Date {

  private  final  int month ;
  private  final int day ;
  private  final int year ;

  public Date(int m, int d, int y){

    month = m;
    day = d;
    year = y;

  }

  public int month(){
    return month;
  }
  public int day(){
    return day;
  }

  public int year(){
    return year;
  }

//  重写toString方法
  @Override
  public String toString(){

    return month() + "/" + day() + "/" + year();
  }

//  重写equals 方法
  @Override
  public boolean equals(Object x){
//    如果对象的引用和参数对象的引用相同，返回true;
    if (this == x){
      return true;
    }
//    如果参数为空（null），根据约定返回 false
    if (x == null){
      return false;
    }

//    如果两个对象的类不同，则返回false
    if (this.getClass() != x.getClass()){
      return false;
    }

//    将参数对象的类型从Object 转换成具体的对象类型
    Date that = (Date)x;

//    如果任意实例变量的值不相同，返回false
    if (this.day != that.day){
      return false;
    }
    if (this.month != that.month){
      return false;
    }
    if (this.year != that.year){
      return false;

    }
    return true;
  }



}
