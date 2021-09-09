package Multithreading.Producer_Consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Threads Producer produce something into a "Store" and Consumer take from it
public class App {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try{
          producer();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try{
          consumer();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }
  // can add and remove items
  // FIFO
  // threadsafe - dont have to worry about thread synchronization
  //no synchronized Blocks needed because it is already taken care of in the import
  private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

  private static void producer() throws InterruptedException {
    Random random = new Random();
    /*for example we have a server where people can text something they want to send. they put it into the queue
    from which other people can take from */
    while (true) {
      //will wait until there is still some space to produce and put into
      queue.put(random.nextInt(100));
    }
  }

  // takes an item and process it
  private static void consumer() throws InterruptedException {
    Random random = new Random();

    while (true) {
      Thread.sleep(100);

      if (random.nextInt(10) == 0) {
        //if there is nothing in the queue, this it will wait patiently until there is one
        Integer value = queue.take();
        System.out.println("Taken value: " + value + ", Queue size is: " + queue.size());
      }
    }
  }
}
