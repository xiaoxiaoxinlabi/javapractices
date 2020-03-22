package tests;

public class PlusOneTest {
    public int[] plusOne(int [] digits){

        for (int i = digits.length - 1; i >= 0; i --){

            if (digits[i] < 9){
                digits[i] ++;
                return digits;

            }else {
                digits[i] = 0;
            }
        }

        int newDigits [] = new int [digits.length + 1];
        newDigits[0] = 1;
        return newDigits;


    }


    public static void main(String[] args) {

        int [] arr = {9,9,9};

        PlusOneTest plusOneTest = new PlusOneTest();
        int []  newArr = plusOneTest.plusOne(arr);
        for (int i: newArr){
            System.out.println(i);
        }



    }
}
