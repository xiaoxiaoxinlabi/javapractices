public class XiaomiTest02 {

//  数组翻转

  public static void reversearr(int [] arr){

    for(int i = 0; i < arr.length/2; i ++){
      int tmp = arr[i];
      arr[i] = arr[arr.length -1 -i];
      arr[arr.length-1-i] = tmp;
    }

  }



  public static void main(String [] args){

    int [] arr = {1,2,3,4,5,6};
    for(int  re: arr){
      System.out.println(re);
    }


    reversearr(arr);
    for(int  re: arr){
      System.out.println(re);
    }


  }
}
