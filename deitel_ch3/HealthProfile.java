package java_I_ch3;

public class HealthProfile {
	private String last;
	private String first;
	private Boolean gender;
	private int height;
	private int weight;
	
	public HealthProfile(String last, String first, Boolean gender, int height, int weight){
		this.last = last;
		this.first = first;
		this.gender = gender;
		if (height > 0){
			this.height = height;
		}
		if (weight > 0){
			this.weight = weight;
		}
	}
	
	public String getLast(){
		return last;
	}
	
	public void setLast(String last){
		this.last = last;
	}
	
	public String getFirst(){
		return first;
	}
	
	public void setFirst(String first){
		this.first = first;
	}
	
	public Boolean getGender(){
		return gender;
	}
	
	public void setGender(Boolean gender){
		this.gender = gender;
	}
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public void showData(){
		System.out.printf("First name: %s%n", first);
		System.out.printf("First name: %s%n", last);
		if (gender){
			System.out.println("Gender: Male");
		}
		else{
			System.out.println("Gender: Female");
		}
		System.out.printf("Weight: %d%n", weight);
		System.out.printf("Height: %d%n", height);
	}
	
	
}
