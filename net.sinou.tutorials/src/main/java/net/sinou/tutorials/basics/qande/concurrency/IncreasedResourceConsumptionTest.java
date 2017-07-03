package net.sinou.tutorials.basics.qande.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple basic class to observe side effect of intense multi-threading as
 * described by Jenkov:
 * 
 * A thread needs some resources from the computer in order to run. Besides CPU
 * time a thread needs some memory to keep its local stack. It may also take up
 * some resources inside the operating system needed to manage the thread. Try
 * creating a program that creates 100 threads that does nothing but wait, and
 * see how much memory the application takes when running.
 * 
 * @see http://tutorials.jenkov.com/java-concurrency/costs.html
 */
public class IncreasedResourceConsumptionTest {

	static FairLock lock;

	public static void main(String[] args) {

		IncreasedResourceConsumptionTest irct = new IncreasedResourceConsumptionTest();
		IncreasedResourceConsumptionTest.lock = irct.new FairLock();
		for (int i = 0; i < 100; i++)
			irct.new MyThread(("T." + i)).start();
	}

	private class MyThread extends Thread {

		public MyThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			try {
				doSynchronized();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void doSynchronized() throws InterruptedException {
			lock.lock();
			// System.out.println("Before waiting in " + MyThread.this.getName());
			System.out.print("Basic waiting in " + MyThread.this.getName() + ": ");
			for (int i = 0; i < 100000000; i++)
				if (i%1000000 == 0)
					System.out.print(".");
			System.out.print("\n");
			lock.unlock();
		}
	}

	private class FairLock {
		private boolean isLocked = false;
		private Thread lockingThread = null;
		private List<QueueObject> waitingThreads = new ArrayList<QueueObject>();

		public void lock() throws InterruptedException {
			QueueObject queueObject = new QueueObject();
			boolean isLockedForThisThread = true;
			synchronized (this) {
				waitingThreads.add(queueObject);
			}

			while (isLockedForThisThread) {
				synchronized (this) {
					isLockedForThisThread = isLocked || waitingThreads.get(0) != queueObject;
					if (!isLockedForThisThread) {
						isLocked = true;
						waitingThreads.remove(queueObject);
						lockingThread = Thread.currentThread();
						return;
					}
				}
				try {
					queueObject.doWait();
				} catch (InterruptedException e) {
					synchronized (this) {
						waitingThreads.remove(queueObject);
					}
					throw e;
				}
			}
		}

		public synchronized void unlock() {
			if (this.lockingThread != Thread.currentThread()) {
				throw new IllegalMonitorStateException("Calling thread has not locked this lock");
			}
			isLocked = false;
			lockingThread = null;
			if (waitingThreads.size() > 0) {
				waitingThreads.get(0).doNotify();
			}
		}
	}

	public class QueueObject {

		private boolean isNotified = false;

		public synchronized void doWait() throws InterruptedException {
			while (!isNotified) {
				this.wait();
			}
			this.isNotified = false;
		}

		public synchronized void doNotify() {
			this.isNotified = true;
			this.notify();
		}

		public boolean equals(Object o) {
			return this == o;
		}
	}

}
