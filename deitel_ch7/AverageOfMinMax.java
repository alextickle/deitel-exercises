public class AverageOfMinMax {

	public static void main(String[] args) {
		if (args.length == 0){
			System.out.println("Usage: java AverageOfMinMax double ...");
		}
		
		else{
			double[] doubleArgs = new double[args.length];
			for (int i = 0; i < args.length; i++){
				doubleArgs[i] = Double.parseDouble(args[i]);
			}
			System.out.println(averageMinMax(doubleArgs));
		}
	}
	
	public static double averageMinMax(double[] anArray){
		double max = anArray[0];
		double min = anArray[0];
		for (double i: anArray){
			if (i > max){
				max = i;
			}
			else if (i < min){
				min = i;
			}
		}
		return (max + min)/2.0;
	}

}

