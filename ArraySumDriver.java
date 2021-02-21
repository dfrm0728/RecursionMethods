import java.util.Arrays;

/**
 * Driver that tests a generic method sumOfArray recursively.
 * @author David Rodriguez
 *
 */
public class ArraySumDriver {
	private final static int ARRAY_SIZE = 6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int index = 0;

		Integer[] myArray = new Integer[ARRAY_SIZE];
		
		myArray[index++] = 13;
		myArray[index++] = 5;
		myArray[index++] = 12;
		myArray[index++] = 6;
		
		int sum = sumOfArray(myArray, 3);
		
		System.out.println("Sum int array "+Arrays.toString(myArray)+" up to 3rd index:");
		System.out.println(sum);
		
		myArray[index++] = 7;
		myArray[index++] = 1;
		
		sum = sumOfArray(myArray, 5);
		System.out.println("Sum int array "+Arrays.toString(myArray)+" up to 5th index:");
		System.out.println(sum);
		
		Double[] arr2 = new Double[5];
		arr2[0]=1.5;
		arr2[1]=3.0;
		arr2[2]=5.0;
		
		System.out.println("Sum double array "+Arrays.toString(arr2)+" up to 2nd index:");
		System.out.println(sumOfArray(arr2,2));
		
		
	}
	
	/**
	 * Recursive method for generating sum of values in array
	 * @param arr array of Number objects(Integer[],Double[],Float[],Long[]...) .Will not work with primitive type like int[]
	 * @param num index of array to sum all previous index values (including num)
	 * @return sum of array values
	 */
	@SuppressWarnings("unchecked")
	public static <N extends Number> N sumOfArray(N[] arr, int num) {
		
		//Non generic solution is easy: 
		// -If index is 0, return that index value.
		// -else return arr[0] + sumOfArray(arr, num-1)
			if(num==0){ return (N) arr[num];}
			
			else {
				//In order to implement this to any array of generic Numbers
				//You cannot add a generic value together, T + T, or N + N (you get error, + is undefined for types..)
				//So we need to check the instance type of what is inside the array, and get the type value in order to be able to add them.
				//Then we save it to an Object type and finally cast it to the (T) type of input array.
				Object result = new Object();
				
				if(arr[0] instanceof Integer) {
					result = arr[num].intValue() + sumOfArray(arr,num-1).intValue();
				}
				if(arr[0] instanceof Double) {
					result = arr[num].doubleValue() + sumOfArray(arr,num-1).doubleValue();
				}
				if(arr[0] instanceof Long) {
					result = arr[num].longValue() + sumOfArray(arr,num-1).longValue();
				}
				if(arr[0] instanceof Float) {
					result = arr[num].floatValue() + sumOfArray(arr,num-1).floatValue();
				}
				if(arr[0] instanceof Short) {
					result = arr[num].shortValue() + sumOfArray(arr,num-1).shortValue();
				}
				if(arr[0] instanceof Byte) {
					result = arr[num].byteValue() + sumOfArray(arr,num-1).byteValue();
				}
				return (N) result;
			} 
	
	}
	
}