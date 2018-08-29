package practice.thread;

class TicketBooking implements Runnable {
	int ticketsAvailable = 1;

	public void run() {

		System.out.println("Waiting to book ticket for : " + Thread.currentThread().getName());

		/*
		 * synchronized (this) = OBJECT LEVEL LOCK 
		 * synchronized (TicketBooking.class) = CLASS LEVEL LOCK i.e no other synchronized method or block of this class 
		 * can be accessed by no thread while there is lock on this class
		 */

		synchronized (this) {
			if (ticketsAvailable > 0) {
				System.out.println("Booking ticket for : " + Thread.currentThread().getName());

				// Let's say system takes some time in booking ticket (here we have taken 1
				// second time)
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}

				ticketsAvailable--;
				System.out.println("Ticket BOOKED for : " + Thread.currentThread().getName());
				System.out.println("currently ticketsAvailable = " + ticketsAvailable);
			} else {
				System.out.println("Ticket NOT BOOKED for : " + Thread.currentThread().getName());
			}

		} // End synchronization block

	}

}