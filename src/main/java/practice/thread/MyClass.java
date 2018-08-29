package practice.thread;

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class MyClass {

	public static void main(String args[]) throws InterruptedException {

		/*---------------------  Runnable  Example      ----------------------------------*/

		MyRunnable myRunnable1 = new MyRunnable();
		MyRunnable myRunnable2 = new MyRunnable();

		Thread thread1 = new Thread(myRunnable1, "Thread-1");
		Thread thread2 = new Thread(myRunnable1, "Thread-2");

		/*
		 * here when Thread-1 is in static synchronized method1() it must be holding
		 * lock on class class’s object and will release lock on class’s class object
		 * only when it exits static synchronized method1(). So, Thread-2 will have to
		 * wait for Thread-1 to release lock on class’s class object so that it could
		 * enter static synchronized method2()
		 */
		thread1.start();
		Thread.sleep(1000);// Just to ensure Thread-1 starts before Thread-2
		thread2.start();

		Thread currentThread = thread2.currentThread();
		System.out.println(currentThread); // Thread[main,5,main]

		/*---------------------  Thread  Example      ----------------------------------*/

		MyThread myThread3 = new MyThread();
		MyThread myThread4 = new MyThread();

		Thread thread3 = new Thread(myThread3, "Thread-3");
		Thread thread4 = new Thread(myThread4, "Thread-4");

		thread3.start();
		Thread.sleep(1000);// Just to ensure Thread-1 starts before Thread-2
		thread4.start();
		/* thread4.start(); /* Exception in thread "main" java.lang.IllegalThreadStateException when we
						     * again try to call start() method
						     */
							 
		
		/*---------------------  TicketBooking   Example      ----------------------------------*/
		
		TicketBooking obj1=new TicketBooking();
		TicketBooking obj2=new TicketBooking();
		
        Thread thread5=new Thread(obj1,"Passenger1 Thread");
        Thread thread6=new Thread(obj2,"Passenger2 Thread");
        
        thread5.start();
        thread6.start();

	}

}
