package java_I_ch3;

public class Account {
	private String name;
	private double balance;
	
	public Account(String name, double balance){
		this.name = name;
		if (balance > 0.0){
			this.balance = balance;
		}
	}
	
	public void deposit(double depositAmount){
		balance = balance + depositAmount;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void withdraw(double withdrawAmount){
		if (withdrawAmount < balance){
			balance = balance - withdrawAmount;
		}
		else{
			System.out.println("Insufficient funds");
		}
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
}
