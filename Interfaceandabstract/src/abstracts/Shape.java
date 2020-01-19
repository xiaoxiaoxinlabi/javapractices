package abstracts;

public abstract  class Shape {



  private String objectName = " ";

  public  Shape(String name){this.objectName = name;}


//  非抽象方法
  public void moveTo(int x, int y){

    System.out.println(this.objectName + " "  + "has been moved to" + "x = " + x + "  and y =" + y);
  }


//  抽象方法
  public  abstract double area();
  public abstract void draw();






}
