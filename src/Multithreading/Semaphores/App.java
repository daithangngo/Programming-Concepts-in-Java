package Multithreading.Semaphores;

import java.util.concurrent.*;

public class App {
  public static void main(String[] args) throws InterruptedException {
    // maintains a number of available permits
    // Semaphore with one 1 permit is like a lock
    // control access to result

    ExecutorService executor = Executors.newCachedThreadPool();

    for (int i = 0; i < 200; i++) {
      executor.submit(() -> Connection.getInstance().connect());
    }
    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.DAYS);
  }
}
