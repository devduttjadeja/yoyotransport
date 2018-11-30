package practice.thread.volatil.example;

public class MyClass {

	static int x = 0, y = 0;

	static void method1() {
		x++;
		
		try {
			Thread.sleep(1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// when x value is updated by thread-1 and then thread-1 goes to sleep for 1 sec
		// at that time thread-2 will execute method-2 and display value as x=1 and y=0 so there is a difference 
		// we can over come this issue by declaring x ,y as VOLATILE 
		
		/*
		 * Volatile members are never cached in CPU by jvm, they are always read from main memory i.e. from stack where variable lives
		 * 
		 * Let’s discuss a scenario where non-volatile variable is used :
			int x=0;  // Let’s say we have variable x with value 0, in main memory value of x is 0 and in cache value of x is also 0.
			x++;  //increment done by thread1, so now in main memory  value of x is 1 but  VALUE IS NOT UPDATED IN CACHE, so value of x in cache is still 0.
			Now, lets say thread2 try to read that value, as value is cached, it will read read value from cache only, so value read of x will be 0 (but actual value of x is 1), which of course is a synchronization problem.

			Let’s discuss a scenario where volatile variable is used :
			int x=0;  // Let’s say we have variable x with value 0, in main memory value of x is 0 and it’s not cached (as volatile variables are not cached).
			x++;  //increment done by thread1, so now in main memory  value of x is 1 and it’s not cached.
			Now, lets say thread2 try to read that value, as value is not cached, it will read read value from main memory, so value read of x will be 1 (and actual value of x is 1), we have solved synchronization problem.
		 * 
		 * 
		 */
		
		
		y++;
	}

	static void method2() {
		System.out.println("x=" + x + " y=" + y);
	}

	public static void main(String[] args) {

		Thread thread1 = new Thread() {
			
			public void run() {
				
				for (int i = 0; i < 10; i++) {
					method1();
				}

			}
		};

		Thread thread2 = new Thread() {
			
			public void run() {
				
				for (int i = 0; i < 10; i++) {
					method2();
				}

			}
		};

		thread1.start();
		thread2.start();

	}
}
