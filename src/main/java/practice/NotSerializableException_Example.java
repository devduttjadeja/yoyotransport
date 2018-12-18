package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class MyClass {} // here java.io.NotSerializableException is thrown as MyClass do not implement Serializable 

class Student implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Integer id;
    private MyClass myClass;
    
    public Student(Integer id) {
           this.id = id;
           myClass=new MyClass();
    }
 
    @Override
    public String toString() {
           return "Employee [id=" + id + "]";
    }
 
}

public class NotSerializableException_Example {

	public static void main(String[] args) {
		 
		Student object1 = new Student(8);

        try {
        	FileOutputStream fout = new FileOutputStream("ser.txt");
        	ObjectOutputStream oout = new ObjectOutputStream(fout);
               System.out.println("Serialization process has started, serializing objects...");
               oout.writeObject(object1);
               System.out.println("Object Serialization completed.");
               fout.close();
      oout.close();
        
        } catch (IOException  e) {
               e.printStackTrace();
        }

 }
	
}
