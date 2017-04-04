import java.util.Arrays;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] toShow = new int[args.length];
		int toAddInt;
		String toAddStr;
		for (int f = 0; f < toShow.length; f++){
			toShow[f] = -1;
		}
		Arrays.sort(toShow);
		for (int j = 0; j < args.length; j++){
			toAddStr = args[j];
			toAddInt = Integer.parseInt(toAddStr);
			if (Arrays.binarySearch(toShow, toAddInt) < 0){
				toShow[j] = toAddInt;
			}
		}

                System.out.println();
		for (int a = 0; a < toShow.length; a++){
			if (toShow[a] != -1){
				System.out.printf("%d ", toShow[a]);
			}
		}

	}

}
