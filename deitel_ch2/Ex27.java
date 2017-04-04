package java_I_ch2;

public class Ex27 {

	public static void main(String[] args) {
		String a = "* * * * * * *";
		String b = " * * * * * * *";
		for (int i = 0; i < 8; i++){
			if (i % 2 == 0){
				System.out.println(a);
			}
			else{
				System.out.println(b);
			}
		}
	}

}
