
/*
 * The CountingSort class will sort any integer array in order n time
 * using counting sort
 */
public class CountingSort {

	/*
	 * max will loop through the parameter array and will return its
	 * largest value
	 */
	public static int max(int[] array){
		int max = array[0];
		int currentInt;
		for(int index = 0; index < array.length; index++){
			currentInt = array[index];
			if(array[index] > max){
				max = currentInt;
			}
		}
		return max;
	}
	
	/* 
	 * countingSort() will implement counting sort for the parameter array
	 * and will store the result inside array
	 */
	public static int[] countingSort(int[] array){
		/* 
		 * creating a count array that will hold the amount of times
		 * each value occurs
		 */
		int countLength = max(array);
		int count[] = new int[countLength];
		final int OFFSET = 1;
		for(int index = 0; index < array.length; index++){
			count[array[index]-OFFSET]++;
		}
		/*
		 * since we know how many time each value occurs, we can sort the array
		 */
		int arrayIndex = 0;
		int countIndex = 0;
		int numTimes;
		while(arrayIndex < array.length){
			numTimes = count[countIndex];
			while(numTimes > 0){
				array[arrayIndex] = countIndex+OFFSET;
				arrayIndex++;
				numTimes--;
			}
			countIndex++;
		}
		return array;
	}
	
	/* 
	 * method printArray will print all values in the parameter array
	 * separated by commas and in between curly brackets
	 */
	public static void printArray(int[] array){
		System.out.print("{"+array[0]+", ");
		int stoppingPoint = array.length-1;
		for(int index = 1; index < stoppingPoint; index++){
			System.out.print(array[index]+", ");
		}
		System.out.println(array[stoppingPoint]+"}");
	}
	
	/*
	 * test tests the functionality of countingSort by printing out both
	 * the sorted and unsorted versions of all arrays in doubleArray
	 */
	public static void test(int[][] doubleArray){
		int[] currentArray = doubleArray[0];
		for(int index = 0; index < doubleArray.length; index++){
			currentArray = doubleArray[index];
			System.out.print("The sorted version of the array\n\t");
			printArray(currentArray);
			System.out.print("is\n\t");
			printArray(countingSort(currentArray));
			System.out.println();
		}
	}
	
}
