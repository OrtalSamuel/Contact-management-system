package classes;

import java.io.Serializable;

public abstract class Person implements Serializable {
	
	private String name;
	private String familyName;
	
	public Person(String name, String familyName) {
		this.name = name;
		this.familyName = familyName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String toString() {
		
		return  familyName + "\t" + name;
		
	}
	

	
	
}
