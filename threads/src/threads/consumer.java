class consumer extends Thread {

	buffer buf;
	String name;

	public consumer(String name1,buffer buf) {
		this.buf = buf;
		name=name1;
	}

	public void run() {
		for (int i = 1; i <= 50; i++)
			System.out.println(name+" "+buf.consume());
	}

}
