/**
 * Driver to test the calculation of Fibonacci of nth number.
 * Displays comparison of normal recursive approach vs dynamic programming(memoization) 
 * @author David Rodriguez
 *
 */
public class FibonacciDriver {

	//array used to save output values of fib(n) to avoid recalculation
	public static int[] save=new int[50];
	
	public static void main(String[] args) {

		int nth = 45;		//nth number of fibonacci sequence
		long startTime=0;	//used to show execution time
		long endTime=0;
		long totalTime = 0;
	
		
		//------Compute fib of nth number using regular recursion
		//show time taken
		System.out.println("\nComputing fib("+nth+"):");
		
		startTime = System.nanoTime();
		System.out.print(fib(nth));
		endTime=System.nanoTime();
		totalTime = endTime - startTime;
		
		System.out.print(" result in "+totalTime+"ms");
		
		
		//------Compute fibEnhanced on nth number with memoization
		System.out.println("\nComputing Enhanced fib("+nth+"):");
		
		startTime = System.nanoTime();
		System.out.print(fibEnhanced(nth));
		endTime=System.nanoTime();
		totalTime = endTime - startTime;
		
		System.out.print(" result in "+totalTime+"ms");

	}

	/*
	 * Enhanced fibonacci calculation using recursion with dynamic programming.
	 * Recursive approach calls multiple calculations of the same fib(nth) number,
	 * so we save that calculation in an array and check for it's value instead of recomputing.
	 */
	public static int fibEnhanced(int num) {
		
		if(num<=1) { 
			save[num]= num;
			return save[num];
		}
		else { 
			if(save[num]!=0) {
				return save[num];
			}
			else save[num]= fibEnhanced(num-1) + fibEnhanced(num-2);
			return save[num];
		
		}
	}
	
	/**
	 * Normal recursive calculation of fibonacci nth number
	 */
	public static int fib(int num) {
		if(num<=1) return num;
		
		else return fib(num-1) + fib(num-2);
	}
	
	
}
