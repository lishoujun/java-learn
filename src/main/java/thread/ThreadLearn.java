package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLearn {
	public static void main(String[] args) {
		LoopAddOneThenSleep laots = new LoopAddOneThenSleep(1);
		Thread t1 = new Thread(laots);
		Thread t2 = new Thread(laots);
		Thread t3 = new Thread(laots);
		Thread t4 = new Thread(laots);
		System.out.println(t1.getState());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
//		while (true) {
//			System.out.println(t1.getState());
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}

class LoopAddOneThenSleep implements Runnable {
	int from = 0;
	int end;
	private Lock fromLock = new ReentrantLock();

	LoopAddOneThenSleep(int from) {
		this.from = from;
		this.end = from + 5;
	}

	@Override
	public void run() {
		while (true) {
			fromLock.lock();
			from++;
			System.out.println(Thread.currentThread().getName() + " " + from);
			fromLock.unlock();
			if(from <= end)break;			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
