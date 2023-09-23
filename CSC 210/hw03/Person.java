package hw03;

public class Person {
	
	String name;
	String address;
	String phoneNum;
	String emailAdd;
	
	Person(){}
	Person(String name,String address,String phoneNum,String emailAdd){
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		this.emailAdd = emailAdd;
	}
	
	public String toString() {
		return String.format("Person: %s%n",name);
	}

}
