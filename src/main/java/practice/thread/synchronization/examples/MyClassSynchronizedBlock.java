package practice.thread.synchronization.examples;

/*
 * https://www.javamadesoeasy.com/2015/03/synchronization-blocks-and-methods.html
 */

class MyRunnable implements Runnable {
    
    public void run() {
           
           synchronized (this) {
                  for(int i=0;i<5;i++){
                        System.out.println(i+" "+Thread.currentThread().getName()+" is executing");
                        try {
                               Thread.sleep(500);
                        } catch (InterruptedException e) {e.printStackTrace(); }
                  }
                  
           }
    }
 
}
 
public class MyClassSynchronizedBlock {
	
    public static void main(String args[]) throws Exception {
 
           MyRunnable obj = new MyRunnable();
           
           Thread t1 = new Thread(obj,"Thread-1");  //Thread-1 on obj.
           Thread t2 = new Thread(obj,"Thread-2");  //Thread-2 on obj.
           
           t1.start();
           t2.start();
 
 
    }
}
