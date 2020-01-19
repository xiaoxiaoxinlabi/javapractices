package abstracts;

public class AbstractTest {

  public static void main(String [] args){
    Shape rect = new Rectangle(2,3,"Rectangle");
    System.out.println("area of rectangle" + rect.area());


    Shape circle = new Circle(2, "Circle");
    System.out.println(circle.area());

    circle.moveTo(2,3);
  }

}
