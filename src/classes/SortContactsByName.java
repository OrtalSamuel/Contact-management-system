package classes;

import java.util.Comparator;

public class SortContactsByName implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		String fullName1 = c1.getName() + " " + c1.getFamilyName();
		String fullName2 = c2.getName() + " " + c2.getFamilyName();
		return fullName1.compareTo(fullName2);
	}
}
