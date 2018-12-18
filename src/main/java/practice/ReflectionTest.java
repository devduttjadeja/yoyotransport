package practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ReflectionClass {

	
	static {
		
		System.out.println("I am inside static block");
		
	}
	
	
	
	/**
	 * constructor
	 */
	public ReflectionClass() {
		System.out.println("in constructor of ReflectionClass");
	}

	/**
	 * Method with no parameter
	 */
	public void methodNoPara() {
		System.out.println("in methodNoPara() of ReflectionClass ");
	}

}

public class ReflectionTest {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String... a) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {

		// step 1, class is loaded load 'ReflectionClass' at runtime
		Class cls = Class.forName("practice.ReflectionClass"); /** here if we make mistake in package name or class name we will get ClassNotFoundException */
		
		// step 2, instance is CREATED so it will call constructor of ReflectionClass
		Object object = cls.newInstance();

		// step 3, calling methodNoPara()
		Method method = cls.getMethod("methodNoPara", null);

		method.invoke(object, null);

	}

}

/*
 * OUTPUT
 * 
 * in constructor of ReflectionClass in methodNoPara() of ReflectionClass
 * 
 */