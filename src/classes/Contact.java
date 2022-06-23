package classes;

import java.io.Serializable;

public class Contact extends Person implements Comparable<Contact> {
	String MobilePhone;
	String HomePhone;
	
	
	public Contact(String name, String familyName, String mobilePhone, String homePhone) {
		super(name, familyName);
		MobilePhone = mobilePhone;
		HomePhone = homePhone;
	}


	@Override
	public int compareTo(Contact other) {
		return MobilePhone.compareTo(other.MobilePhone);
	}

	public String getMobilePhone() {
		return MobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}


	public String getHomePhone() {
		return HomePhone;
	}


	public void setHomePhone(String homePhone) {
		HomePhone = homePhone;
	}


	@Override
	public String toString() {
		return super.toString()+ "\t" +  HomePhone + "\t" + MobilePhone ;
	}
	

}
