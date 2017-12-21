package net.sinou.tutorials.basics.qande.concurrency;

public class FirstHop {

	private static final String smallTalks[] = { "Hello", "How are you?", "Fine and you? ", "Fine, thanks" };

	private static class SimpleRunnable implements Runnable {
		@Override
		public void run() {
			try {
				for (int i = 0; i < smallTalks.length; i++) {
					Thread.sleep(1000);
					System.out.println("Thread " + Thread.currentThread().getId() + " - " + smallTalks[i]);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		(new Thread(new SimpleRunnable())).run();
		(new Thread(new SimpleRunnable())).run();
		(new Thread(new SimpleRunnable())).run();
		(new Thread(new SimpleRunnable())).run();
		(new Thread(new SimpleRunnable())).run();
	}
}
