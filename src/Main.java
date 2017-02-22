import java.util.Arrays;
public class Main {
	//A random permutation of the numbers from 1 to 20
	static int[] intArray = {15, 8, 19, 7, 1, 13, 12, 20, 3, 14, 18, 5, 11, 6, 16, 4, 17, 10, 9, 2};
	
	
	public static void main(String[] args){
		long startTime = System.nanoTime();
		
		insertionSortRecursive(intArray, 1);
		
		long endTime = System.nanoTime();
		System.out.println("RUNTIME: " + (endTime - startTime) + "ns");
	}
	
	
	/**
	 * 
	 * @param a, the array to be sorted
	 * @param endIndex, 
	 * @result sorts a in ascending order, assuming that indices 0 to endIndex - 1 (inclusive) are already
	 * 			sorted
	 * 		   prints the contents of the array every time it is changed
	 * 
	 * AVERAGE RUNTIME (GUESS AFTER 5 TRIES): 6344516ns
	 */
	public static void insertionSortRecursive(int[] a, int endIndex){
		//This is necessary to deal with the base case, because we are steadily increasing endIndex
		if(endIndex >= a.length) return;
		
		//this for loop puts element at endIndex in the correct position
		for(int i = endIndex; i > 0; i--){
			if (a[i] >= a[i-1]){
				break;
			}
			else{
				int temp = a[i];
				a[i] = a[i-1];
				a[i-1] = temp;
				System.out.println(Arrays.toString(a));
			}
		}
		
		//Now we perform the method on 
		insertionSortRecursive(a, endIndex + 1);
	}
	
	/**
	 * 
	 * @param a, the int array to be sorted in ascending order
	 * @result sorts the array a in ascending order
	 * 		   prints the array after every change
	 */
	public static void insertionSortIterative(int[] a){
		for(int i = 1; i < a.length; i++){
			
			//puts a[i] in the correct position
			for(int j = i; j > 0; j--){
				if (a[j] >= a[j-1]){
					break;
				}
				else{
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
					System.out.println(Arrays.toString(a));
				}
			}
		}
	}
	
	/**
	 * 
	 * @param a, the int array to be sorted in ascending order
	 * @param endIndex
	 * @result sorts the array a in ascending order, assuming that indices 0 to endIndex - 1 are already
	 * 			sorted
	 * 		   prints the array after every change
	 */
	public static void selectionSortRecursive(int[] a, int endIndex){
		if(endIndex >= a.length) return;
		
		
		int indexToSwap = endIndex;//the index of the element you want to swap with endIndex
		for(int i = endIndex; i < a.length; i++){
			if(a[i] < a[indexToSwap]){
				indexToSwap = i;
			}
		}//Now, indexToSwap is correct
		
		//Swaps the elements at indexToSwap and endIndex
		int temp = a[indexToSwap];
		a[indexToSwap] = a[endIndex];
		a[endIndex] = temp;
		
		System.out.println(Arrays.toString(a));
		
		selectionSortRecursive(a, endIndex + 1);
	}
	
	/**
	 * 
	 * @param a, the int array to be sorted in ascending order
	 * @result sorts the array a in ascending order
	 * 		   prints the array after every change
	 */
	public static void selectionSortIterative(int[] a){
		//i represents the index you are swapping with the smallest in the rest of the array
		for(int i = 1; i < a.length; i++){
			
			int indexToSwap = i;//the index of the element you want to swap with i
			for(int j = i; j < a.length; j++){
				if(a[j] < a[indexToSwap]){
					indexToSwap = j;
				}
			}//Now, indexToSwap is correct
			
			//Swaps the elements at i and indexToSwap
			int temp = a[indexToSwap];
			a[indexToSwap] = a[i];
			a[i] = temp;
			
			System.out.println(Arrays.toString(a));
		}
	}
	
}
