package java_I_ch6;

public class MethodOverload {

	// test overloaded square methods
	public static void main(String[] args) {
		System.out.printf("Square of integer 7 is %d%n",  square(7));
		System.out.printf("Square of integer 7 is %d%n",  square(7.5));
	}
	
	// square method with int argument
	public static int square(int intValue){
		System.out.printf("%nCalled square with int argument: %d%n",  intValue);
		return intValue * intValue;
	}
	
	// square method with double argument
	public static double square(double doubleValue){
		System.out.printf("%nCalled square with double argument: %f%n",  doubleValue);
		return doubleValue * doubleValue;
		}
	
	

}
