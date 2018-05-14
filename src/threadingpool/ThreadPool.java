package threadingpool;
import java.util.concurrent.LinkedBlockingQueue;


public class ThreadPool {
	private int nThreads;
	private ThreadManager[] threads;
	private LinkedBlockingQueue queue;

	// constructor
	public ThreadPool(int nThreads) {
		this.nThreads = nThreads;  						// number of total threads
		this.queue = new LinkedBlockingQueue();  		// tasks queue
		this.threads = new ThreadManager[nThreads]; 	// threads queue

		// initialize the thread pool
		for (int i = 0; i < nThreads; i++) {
			threads[i] = new ThreadManager();
			threads[i].start();
		}
	}
	
	// executor
	public void execute(Runnable task) {
		synchronized (queue) {
			queue.add(task);
			queue.notify();
		}
	}


	private class ThreadManager extends Thread {
		public void run() {
			Runnable task;

			while (true) {
				// all threads are waiting here
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					task = (Runnable) queue.poll();
				}
				// run the task
				task.run();	
			}
		}
	}
}