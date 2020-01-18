package Decorator;

public class Cream extends  Food{

  private Food food;

  public Cream(Food food){
    this.food = food;
  }

  @Override
  public String make() {
//    return super.make();
    return food.make() + "+ 奶油";
  }
}
