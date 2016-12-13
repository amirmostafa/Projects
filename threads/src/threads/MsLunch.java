public class MsLunch extends Thread {
	private static long c1 = 0;
	private static long c2 = 0;
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	String name;
	public MsLunch(String name1) {
		name=name1;
	}

	public void inc1() {
		synchronized (lock1) {
			
			c1++;
			System.out.println("C1= "+c1);
		}
	}

	public void inc2() {
		synchronized (lock2) {
			c2++;
			System.out.println("C2= "+c2);
		}
	}
	public void run(){
		System.out.println("In Thead: "+name);
		inc1();
		inc2();
	}
	public static void main(String[] args) {
		MsLunch m=new MsLunch("A");
		MsLunch m1=new MsLunch("B");
		m.start();
		m1.start();
	}
}
