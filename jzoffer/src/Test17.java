public class Test17 {


//  打印从1到最大的n位数
//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999


//  1、针对本题的常规思路，利用pow函数，秒解
//2、假设可能出现大数（本题不可能），转换为大数问题求解
//  本题自己对于大数解法，分别练习了使用char和string两种方式分别进行求解


  public int [] printNumbers(int n){
    int num = (int) Math.pow(10,n);
    int [] arr = new int[num-1];
    for(int i = 0; i < arr.length; i ++){
      arr[i]=i+1;
    }
    return arr;
  }





}
