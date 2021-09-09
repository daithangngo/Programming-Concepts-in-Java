package Multithreading.ThreadPool2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable {
  private int id;

  public Processor(int id) {
    this.id = id;
  }

  public void run() {
    System.out.println("Starting: " + id);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Completed: " + id);
  }
}

public class App {
  public static void main(String[] args){

    ExecutorService executor = Executors.newFixedThreadPool(2);
    // threadpool is like having a number of workers in a factory
    // when work done, then start on a new task

    for (int i = 0; i < 5; i++) {
      // we give them new tasks
      executor.submit(new Processor(i));
    }
    // will wait until all the threads had been doing their work and then it will terminate
    executor.shutdown();
    System.out.println("All tasks submitted.");

    try{
      executor.awaitTermination(10, TimeUnit.DAYS);
    }catch (InterruptedException e){
      e.printStackTrace();
    }

    System.out.println("All taks completed");
  }
}
