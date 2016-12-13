class buffer {

	private int size = 5;  // the buffer bound

	private Object store[] = new Object[size];
	private int inptr = 0;
	private int outptr = 0;

	semaphore spaces = new semaphore(size);//producer buffer=size
	semaphore elements = new semaphore(0);//consumer buffer=0;

	public void produce(Object value) {
		spaces.P();//wait producer btna2s value mn el producer
		store[inptr] = value;
		inptr = (inptr + 1) % size;
		elements.V();//wake up consumer w tzawdha 3l consumer t2olo en feh waiting
	}

	public Object consume() {
		Object value;
		elements.P();//wait consumer btna2s mn el elements y3ni 3mlt consume
		value = store[outptr];
		outptr = (outptr + 1) % size;
		spaces.V();//wake up producer w hna bt2ol lel producer ana fadet makan
		return value;
	}
}
