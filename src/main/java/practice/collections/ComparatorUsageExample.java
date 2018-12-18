package practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
 
class Employee implements Comparator<Employee>,Comparable<Employee>{
    String name;
    String id;
   
    public Employee() {}
   
    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }
   
    @Override
    public int compare(Employee obj1, Employee obj2) {
       //sort Employee on basis of name(ascending order)
       return obj1.name.compareTo(obj2.name);
    }
   
	@Override
	public int compareTo(Employee o) {
		//sort Employee on basis of id (ascending order)
		return this.id.compareTo(o.id);
	}
   
	
	@Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id  + '}';
    }
   
}
 
 
/**
 * @author AnkitMittal
 * Copyright (c), AnkitMittal JavaMadeSoEasy.com
 * Main class
 */
public class ComparatorUsageExample {
    public static void main(String[] args) {
 
        Employee emp1=new Employee("sam","4");
        Employee emp2=new Employee("amy","2");
        Employee emp3=new Employee("brad","1");

        ArrayList<Employee> list=new ArrayList<Employee>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
      
        System.out.println("list Before sorting : \n"+list);
 
        Collections.sort(list ,new Employee());
 
        Collections.sort(list); // to use this list must be "Comparable" else compile time error
        
        // using anonymus inner class
        Collections.sort(list, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return 0;
			}
		});
        
        
        System.out.println("\nlist after sorting on basis of name(ascending order) : \n"+list);
       
    }
}
 
