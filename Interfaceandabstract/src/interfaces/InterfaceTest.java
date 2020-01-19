package interfaces;

public class InterfaceTest {

  public static void main(String [] args){

    Rectangle rect = new Rectangle(2,3);
    rect.draw();
    System.out.println("Area of rectangle: " + rect.area());


    Circle circle = new Circle(3);
    circle.draw();
    System.out.println("Area of circle " + circle.area());
  }

}
