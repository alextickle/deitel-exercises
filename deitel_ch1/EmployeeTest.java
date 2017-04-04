package java_I;
public class EmployeeTest {
    
    public static void main(String args[]){
    	Employee a = new Employee("Benjamin", "Bernanke", 1234.56);
    	Employee b = new Employee("Paul", "Volker", 2345.67);
        
    	System.out.println(a.getFirstName() + " " + a.getLastName() + "'s yearly salary: " + a.getMonthlySalary() * 12);
    	System.out.println(b.getFirstName() + " " + b.getLastName() + "'s yearly salary: " + b.getMonthlySalary() * 12);
    	
        System.out.println("Giving raises...");
        a.setMonthlySalary(a.getMonthlySalary() * 1.1);
        b.setMonthlySalary(b.getMonthlySalary() * 1.1);
        
    	System.out.println(a.getFirstName() + " " + a.getLastName() + "'s yearly salary: " + a.getMonthlySalary() * 12);
    	System.out.println(b.getFirstName() + " " + b.getLastName() + "'s yearly salary: " + b.getMonthlySalary() * 12);
        
    	
    	System.out.println("Attempting to set a negative salary value...");
        a.setMonthlySalary(-3455);
    	System.out.println(a.getFirstName() + " " + a.getLastName() + "'s yearly salary: " + a.getMonthlySalary() * 12);
    }
    
}
