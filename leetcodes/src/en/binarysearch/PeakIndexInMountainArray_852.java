package en.binarysearch;

public class PeakIndexInMountainArray_852 {

//    如果满足以下条件，我们将数组arr称为山：
//    arr.length >= 3
//    there exists some i with 0 < i < arr.length - 1 such that:
//      arr[0] < arr[1] < ... arr[i-1] < arr[i]
//      arr[i] > arr[i+1] > ... > arr[arr.length - 1]

//    给定一个数组，返回索引 i 使得 满足以下条件
//     arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

    public int peakIndexInMountainArray(int[] arr) {

        int left = 0, right = arr.length;

        while(left < right){
            int mid = left + (right - left)/2;

            if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            }else {
                right = mid ;
            }
        }
        return left;

    }

    public int peakIndexInMountainArray1(int [] arr){
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] > arr[i+1]){
                return i;
            }
        }
        return -1;
    }
}
