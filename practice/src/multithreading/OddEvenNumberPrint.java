package multithreading;

public class OddEvenNumberPrint {
	static class test implements Runnable {
		volatile int x = 0;

		@Override
		public void run() {
			synchronized (this) {
				while(x<10) {

					this.notify();
					x++;
					System.out.println(Thread.currentThread().getName() + " " + x);
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				this.notifyAll();
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {
		test t1 = new test();
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);
		thread1.setName("one");
		thread2.setName("two");
		thread2.start();
		thread1.start();
	}

}
