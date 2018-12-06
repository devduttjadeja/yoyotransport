package practice.thread.waitnotify.producer.consumer.example;

import java.util.ArrayList;

/* Producer is producing, Producer will allow consumer to
 * consume only when 10 products have been produced (i.e. when production is over).
 */
class Producer implements Runnable {

	ArrayList<Integer> sharedQueue;

	Producer() {
		sharedQueue = new ArrayList<Integer>();
	}

	@Override
	public void run() {

		synchronized (this) {
			for (int i = 1; i <= 10; i++) { // Producer will produce 10 products
				sharedQueue.add(i);
				System.out.println("Producer is still Producing, Produced : " + i);

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
			System.out.println("Production is over, consumer can consume.");
			this.notify(); // Production is over, notify consumer thread so that consumer can consume.
		}
	}

}

class Consumer extends Thread {
	Producer prod;

	Consumer(Producer obj) {
		prod = obj;
	}

	public void run() {
		/*
		 * consumer will wait till producer is producing.
		 */
		synchronized (this.prod) {

			System.out.println("Consumer waiting for production to get over.");
			try {
				this.prod.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		/* production is over, consumer will start consuming. */
		int productSize = this.prod.sharedQueue.size();
		for (int i = 0; i < productSize; i++)
			System.out.println("Consumed : " + this.prod.sharedQueue.remove(0) + " ");

	}

}

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class ProducerConsumerWithWaitNotify {
	public static void main(String args[]) throws InterruptedException {

		Producer prod = new Producer();
		Consumer cons = new Consumer(prod);

		Thread prodThread = new Thread(prod, "prodThread");
		Thread consThread = new Thread(cons, "consThread");

		consThread.start(); // start consumer thread.
		Thread.sleep(100); // This minor delay will ensure that consumer thread starts before producer
							// thread.
		prodThread.start(); // start producer thread.

	}

}

/*
 * OUTPUT
 * 
 * Consumer waiting for production to get over. Producer is still Producing,
 * Produced : 1 Producer is still Producing, Produced : 2 Producer is still
 * Producing, Produced : 3 Producer is still Producing, Produced : 4 Producer is
 * still Producing, Produced : 5 Producer is still Producing, Produced : 6
 * Producer is still Producing, Produced : 7 Producer is still Producing,
 * Produced : 8 Producer is still Producing, Produced : 9 Producer is still
 * Producing, Produced : 10 Production is over, consumer can consume. Consumed :
 * 1 Consumed : 2 Consumed : 3 Consumed : 4 Consumed : 5 Consumed : 6 Consumed :
 * 7 Consumed : 8 Consumed : 9 Consumed : 10
 * 
 */
