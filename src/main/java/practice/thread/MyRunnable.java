package practice.thread;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("Thread-1"))
			method1();
		else
			method2();
	}

	synchronized void method1() { /* SYNCHRONIZED methods acquires OBJECT LEVEL LOCK*/
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method1() started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method1() ended");
	}

	static synchronized void method2() { /* STATIC SYNCHRONIZED methods acquires CLASS LEVEL LOCK */
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method2() started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " in static synchronized void method2() ended");
	}

}
