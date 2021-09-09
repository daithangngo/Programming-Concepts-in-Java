package Multithreading.CallableAndFuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

public class App {
  public static void main(String[] args) {
      //Creating a Threadpool
    ExecutorService executor = Executors.newCachedThreadPool();

    // Parameter is the type that we want to return
    Future<Integer> future =
        executor.submit(
                //wir haben hier ein Callable
            () -> {
              Random random = new Random();
              int duration = random.nextInt(4000);
              if (duration > 2000)
                // if we throw an exception here get() will not return. Instead we catch an
                // ExecutionException
                throw new IOException("Sleeping for too long");

              System.out.println("Starting...");

              try {
                Thread.sleep(duration);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }

              System.out.println("Finished...");

              return duration;
            });

    executor.shutdown();

    // dont need awaitsTermination because get() is blocking and will wait as long it cannot returns
    // sth
    try {
      System.out.println("Result is: " + future.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      System.out.println(e.getMessage());
    }
  }
}
