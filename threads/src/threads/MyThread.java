public class MyThread extends Thread {
	private SynchronizedCounter sc;
	private String myName;

	public MyThread(String name, SynchronizedCounter sc) {
		this.sc = sc;
		this.myName = name;
	}

	public void run() {
		sc.increment();
System.out.println("C = " + sc.value() + " in Thread " + myName);
	}



	public static void main(String[] args) {
		SynchronizedCounter count = new SynchronizedCounter();
		MyThread thrA = new MyThread("A", count);
		MyThread thrB = new MyThread("B", count);

		thrA.start();
		thrB.start();
		try {
			thrA.join();
			thrB.join();
		} catch (InterruptedException e) {
			System.out.println("Join interrupted");
		}
	
}
}