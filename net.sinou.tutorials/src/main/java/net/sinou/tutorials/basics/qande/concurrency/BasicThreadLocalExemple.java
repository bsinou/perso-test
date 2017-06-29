package net.sinou.tutorials.basics.qande.concurrency;

/**
 * Basic usage of thread local as explained by J. Jenkov.
 * 
 * @see http://tutorials.jenkov.com/java-concurrency/threadlocal.html
 */
public class BasicThreadLocalExemple {

	public static class MyRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		@Override
		public void run() {
			threadLocal.set((int) (Math.random() * 100D));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			System.out.println(threadLocal.get());
		}
	}

	public static void main(String[] args) {
		try {

			MyRunnable sharedRunnableInstance = new MyRunnable();

			Thread thread1 = new Thread(sharedRunnableInstance);
			Thread thread2 = new Thread(sharedRunnableInstance);

			thread1.start();
			thread2.start();

			thread1.join();// wait for thread 1 to terminate
			thread2.join(); // wait for thread 2 to terminate
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
