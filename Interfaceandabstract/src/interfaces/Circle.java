package interfaces;

public class Circle implements  Shape {

  private double pi = 3.14;
  private int radius ;


  public Circle(int radius){

    this.radius = radius;
  }

  @Override
  public double area() {
    return   (double)((pi * radius * radius) /2);
  }

  @Override
  public void draw() {

    System.out.println("Circle has been drawn ");

  }
}
