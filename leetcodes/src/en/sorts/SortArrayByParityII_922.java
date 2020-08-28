package en.sorts;

public class SortArrayByParityII_922 {

//    给定一个数组，数组的一般元素为奇数，一半为偶数，对数组进行排序使得奇数索引对应奇数元素，偶数索引对应偶数元素
//    Example 1:
//
//    Input: [4,2,5,7]
//    Output: [4,5,2,7]
//    Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

    public int[] sortArrayByParityII(int[] A) {

        int [] odd = new int[A.length/2];
        int [] even = new int[A.length/2];
        int m = 0,n = 0;
        for(int i = 0; i < A.length; i ++){
            if(A[i] % 2 == 0){
                odd[m++] = A[i];

            }else{
                even[n++] = A[i];
            }
        }

        for(int i = 0; i < A.length; i ++){
            if(i % 2 == 0){
//                A[i] = odd[i/2];
                A[i] = odd[--m];
            }else{
//                A[i] = even[i/2];
                A[i] = even[--n];
            }
        }
        return A;
    }

    public int [] sortArrayByParityII1(int [] A){

        int even = 0, odd = 1;
        int N = A.length;

        while(even < N && odd < N){
            if((A[even]&1) == 0){
                even+=2;

            }else if((A[odd] & 1) == 1){

                odd+=2;
            }else{
                swap(A,even,odd);
            }
        }
        return A;
    }
    private void swap(int [] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] sortArrayByParityII2(int [] A){
        int n = A.length, tmp;
        for(int i = 0, j = 1; j >= 1 && i < n-1;){
            if(A[i]%2 != 0){
                if(A[j]%2 != 0){
                    j+=2;
                    continue;
                }
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
                i+=2;
                j+=2;
                continue;
            }
            i+=2;
        }
        return A;
    }
}
