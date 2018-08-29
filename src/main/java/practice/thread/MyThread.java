package practice.thread;

public class MyThread extends Thread {

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("Thread-1"))
			method1();
		else if(Thread.currentThread().getName().equals("Thread-2"))
			method2();
		else if(Thread.currentThread().getName().equals("Thread-3"))
			method3();
		else if(Thread.currentThread().getName().equals("Thread-4"))
			method4();
	}
	
	
	synchronized void method1() {
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method1() started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method1() ended");
	}

	synchronized void method2() {
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method2() started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method2() ended");
	}
	
	synchronized void method3() {
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method3() started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method3() ended");
	}
	
	synchronized void method4() {
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method4() started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method4() ended");
	}
	
}
