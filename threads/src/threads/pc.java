class pc {

	static buffer buf = new buffer();

	public static void main(String[] args) {
		producer P = new producer("Prod",buf);
		consumer C = new consumer("Cons",buf);
		P.start();
		C.start();
	}
}

