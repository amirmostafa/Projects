
public class SynchronizedCounter {
	private int c = 0;

	public synchronized void increment() {
		int register = c;
    	register = register+1;
   	c = register;

	}

	public synchronized void decrement() {
		int register = c;
    	register = register-1;
   	c = register;

	}

	public synchronized int value() {
		return c;
	}
}
