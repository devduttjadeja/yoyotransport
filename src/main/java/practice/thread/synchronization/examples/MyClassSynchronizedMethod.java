package practice.thread.synchronization.examples;

/*
 * https://www.javamadesoeasy.com/2015/03/synchronization-blocks-and-methods.html
 */

class MyRunnable1 implements Runnable {
    
    public void run() {
           method1(); 
           
    }
    
    public synchronized void method1(){
    	
           for(int i=0;i<5;i++){
                  System.out.println(i+" "+Thread.currentThread().getName()+" is executing");
                 
                  synchronized(this) { // YES we can have synchronized block in synchronized method()
                	  
                	  try {
                          Thread.sleep(500);
                    } catch (InterruptedException e) {e.printStackTrace(); }
                	  
                  }
                  
           }
           
    }
 
}
 
public class MyClassSynchronizedMethod {
	
    public static void main(String args[]) throws Exception {
 
           MyRunnable1 obj = new MyRunnable1();
           
           Thread t1 = new Thread(obj,"Thread-1");  //Thread-1 on obj.
           Thread t2 = new Thread(obj,"Thread-2");  //Thread-2 on obj.
           
           t1.start();
           t2.start();
 
 
    }
}
