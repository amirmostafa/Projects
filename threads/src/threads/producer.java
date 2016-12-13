
class producer extends Thread {

	buffer buf;
	String name;

	public producer(String name1,buffer buf) {
		this.buf = buf;
		name=name1;
	}

	public void run() {
		for (int i = 1; i <= 50; i++){
			
			buf.produce(new Integer(i));
			System.out.println(name+" "+i);
	}

}
}
