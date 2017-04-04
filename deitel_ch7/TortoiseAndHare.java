import java.util.Timer;
import java.util.TimerTask;

public class TortoiseAndHare {
	
	static int harePos = 1;
	static int tortoisePos = 1;
	static double seconds = 0.5;
	static int turtleMove;
	static int hareMove;
	static int random;
	static String[] raceCourse = new String[70];

	public static void main(String[] args) {
		System.out.println("Bang! And they're off!");
		Timer timer = new Timer();
		
		// declare updateRaceTask
		class updateRaceTask extends TimerTask {
	        public void run() {
	        	if (tortoisePos == 70 || harePos == 70){
	        		timer.cancel();
	        		printResult();
	        		return;
	        	}
	        	moveTortoise();
	        	moveHare();
	        	updateRaceCourse();
	        	displayRaceCourse();
	        }
	    }
		timer.scheduleAtFixedRate(new updateRaceTask(), (int) (seconds * 1000), (int) (seconds * 1000));
	}
	
	public static void printResult(){
		if (harePos > tortoisePos){
			System.out.println("Hare wins!");
		}
		else if (tortoisePos > harePos){
			System.out.println("Tortoise wins!");
		}
		else {
			System.out.println("It's a tie?!");
		}
	}
	
	public static void clearRaceCourse(){
		for (int i = 0; i < raceCourse.length - 1; i++){
			raceCourse[i] = " ";
		}
		raceCourse[raceCourse.length - 1] = "|";
	}
	
	public static void updateRaceCourse(){
		clearRaceCourse();
		if (tortoisePos == harePos){
			raceCourse[tortoisePos - 1] = "*";
		}
		else {
			raceCourse[tortoisePos - 1] = "T";
			raceCourse[harePos - 1] = "H";
		}
			
	}
	
	public static void displayRaceCourse(){
		for (String pos: raceCourse){
			System.out.print(pos);
		}
		System.out.println();
	}
	
	public static void moveTortoise(){
		random = (int) Math.floor(Math.random() * 10);
		if (random <= 5){
			tortoisePos += 3;
		}
		else if (random <= 7){
			tortoisePos -= 6;
		}
		else{
			tortoisePos += 1;
		}
		if (tortoisePos < 1){
			tortoisePos = 1;
		}
		else if (tortoisePos > 70){
			tortoisePos = 70;
		}
	}
	
	public static void moveHare(){
		random = (int) Math.floor(Math.random() * 10);
		switch (random){
			case 1: 
				break;
			case 2:
				break;
			case 3:
				harePos += 9;
				break;
			case 4:
				harePos += 9;
				break;
			case 5:
				harePos -= 12;
				break;
			case 6:
				harePos += 1;
				break;
			case 7:
				harePos += 1;
				break;
			case 8:
				harePos += 1;
				break;
			case 9:
				harePos -= 2;
				break;
			case 10:
				harePos -= 2;
				break;
		}
		if (harePos < 1){
			harePos = 1;
		}
		else if (harePos > 70){
			harePos = 70;
		}
	}
}
