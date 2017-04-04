public class printXTimes{
	public static void main(String[] args){
		if (args.length != 2){
			System.out.println("Usage: java printXTimes string x");
		}
		else {
			for (int i = 0; i <Integer.parseInt(args[1]); i++){
				System.out.println(args[0]);
			}
		}
	}
}
