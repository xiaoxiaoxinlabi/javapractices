package search;

public class BinarySearch{
	
	public int binarySearch(int [] arr , int num){
		
		int low = 0;
		int high = arr.length - 1;
		
		while (low <= high){
			
			int mid = low + (high - low) / 2;
			
			if (num > arr[mid]){
				
				low = mid + 1;
			}else if (num < arr[mid]){
				
				high = mid - 1;
			}
			else{
				
				return mid;
			}
		}

		
		
		return -1;
		
		
	
	}
	
	
	public static void main(String [] args){
		
		BinarySearch b = new BinarySearch();
		
		
		int [] arr = {1,2,3,4,5,6,8,9};
		
		System.out.println(b.binarySearch(arr, 1));


		
		
		
	}
	
	
	
	
}