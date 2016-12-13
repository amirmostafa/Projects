class Counter implements Runnable{

	private String name; // Counter Name
	public Counter(String name){
		this.name = name;
	}
	public void run() {
		for (int i = 0; i < 10; ++i){
			System.out.println(name + ": " + i);
			Thread.yield();
		}
		
	}
	
}

public class TestThread {
	public static void main(String[] args) {
		Thread counter1 = new Thread(new Counter("C1"));
		Thread counter2 = new Thread(new Counter("C2"));
		counter1.start();
		counter2.start();
		
	}
}
