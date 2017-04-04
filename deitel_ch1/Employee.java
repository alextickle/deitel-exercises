package java_I;
public class Employee {
	private String firstName;
	private String lastName;
	private double monthlySalary;
	
	public Employee(String first, String last, double salary){
		firstName = first;
		lastName = last;
		if (salary >= 0){
			monthlySalary = salary;
		}
		else{
			monthlySalary = 0.0;
	}
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public double getMonthlySalary(){
		return monthlySalary;
	}
	
	public void setFirstName(String first){
		firstName = first;
	}
	
	public void setLastName(String last){
		lastName = last;
	}
	
	public void setMonthlySalary(double salary){
		if (salary > 0){
		monthlySalary = salary;
		}
	}
}
