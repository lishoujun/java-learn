package thread;

public class ThreadLearn {
	public static void main(String[] args) {
		LoopAddOneThenSleep laots = new LoopAddOneThenSleep(1);
		Thread t = new Thread(laots);
		System.out.println(t.getState());
		t.start();
		System.out.println("out the thread t");
		System.out.println(t.getState());
		LoopAddOneThenSleep anotherlaots = new LoopAddOneThenSleep(100);
		Thread anothert = new Thread(anotherlaots);
		anothert.start();
	}

}

class LoopAddOneThenSleep implements Runnable {
	int from = 0;
	LoopAddOneThenSleep(int from){
		this.from = from;
	}
	@Override
	public void run() {
		while (true) {
			from++;
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(from);
		}
	}
}
