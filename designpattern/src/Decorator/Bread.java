package Decorator;

public class Bread extends  Food {

  private Food basicFood;

  public Bread(Food basicFood){
    this.basicFood = basicFood;
  }


  @Override
  public String make() {
    return basicFood.make() + "+ 面包";
  }
}
