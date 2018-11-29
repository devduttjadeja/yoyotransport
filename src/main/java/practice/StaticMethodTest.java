package practice;

class SuperClass {
	static void method() {
		System.out.println("superClass method");
	}
}

class SubClass extends SuperClass {
	static void method() {
		System.out.println("SubClass method");
	}
}

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class StaticMethodTest {

	public static void main(String[] args) {
		SuperClass obj = new SubClass();
		obj.method(); // superClass method : because when method is static it depends on type of reference
						// not type of object
		
		SuperClass.method();
		SubClass.method();
	}

}
