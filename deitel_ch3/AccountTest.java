package java_I_ch3;

public class AccountTest {

	public static void main(String[] args) {
		Account account1 = new Account("Jane Green", 500);
		Account account2 = new Account("John Blue", 600);
		
		System.out.printf("account1 name is: %s%n", account1.getName());
		System.out.printf("account2 name is: %s%n", account2.getName());
		
		account1.withdraw(250);
		System.out.printf("account1's balance is " + account1.getBalance() + "\n");
		account1.withdraw(2050);
	}

}
