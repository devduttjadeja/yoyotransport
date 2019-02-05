package practice.collections;

import java.util.HashSet;
import java.util.Set;

import practice.Employee;

public class SetSizeExample {

	
	
	public static void main(String[] args) {
		
		Set hs = new HashSet();
		
		hs.add("devdutt");
		hs.add(new String("devdutt"));
		
		System.out.println(hs.size()); // size = 1
		
		hs.add(new StringBuilder("devdutt"));
		
		System.out.println(hs.size()); // size = 2
		
		// add other type values to set
		
		hs.add(1);
		hs.add(new Employee());
		hs.add(new Employee());
		hs.add(new Employee());
		
		System.out.println(hs.size()); // size = 4 because all new Employee() are treated as same objects
		
	}
	
	
}
