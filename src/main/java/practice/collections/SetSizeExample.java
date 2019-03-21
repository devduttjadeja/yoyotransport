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
		hs.add(new Employee()); // all the new Employee() is treated as same object
		hs.add(new Employee()); // because equals() & hashcode() are overriden in Employee class 
		hs.add(new Employee()); //
		
		System.out.println(hs.size()); // total size of hs = 4 because all new Employee() are treated as same objects
		
	}
	
	
}
