package tests;

public class MergeTest {

    public void merge(int nums1[],int m, int nums2[],int n){

        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(p >= 0){
            if (i >=0 && j >=0){
                if(nums1[i]>nums2[j]){
                    nums1[p--] = nums1[i--];

                }else{
                    nums1[p--] = nums2[j--];

                }

            }else if (i >=0){
                nums1[p--] = nums1[i--];
            }else{
                nums1[p--] = nums2[j--];
            }

        }

        for (int k = 0; k < nums1.length; k ++){
            System.out.println(nums1[k]);
        }














    }

    public static void main(String [] args){

        MergeTest mergeTest = new MergeTest();
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 ={2,5,6} ;
        mergeTest.merge(nums1,3,nums2,3);


    }
}
