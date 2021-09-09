package Multithreading;

import java.util.Scanner;
class A{
  public static void main(String[] args) throws InterruptedException {
    Processor processor = new Processor();
    Thread t1 = new Thread(
            ()->{
              try {
                processor.produce();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
    );

    Thread t2 = new Thread(
            ()->{
              try {
                processor.consume();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
    );

    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}
public class Processor {

  public void produce() throws InterruptedException {
    synchronized (this) {
      System.out.println("Producer running...");
      wait();
      System.out.println("Resumed.");
    }
  }

  public void consume() throws InterruptedException {
    Scanner scanner = new Scanner(System.in);
    Thread.sleep(2000);

    // we lock this on the same Object like in the produce()
    // this möglich , weil beide Methoden in der selben Klasse sich befindne und wir lock auf die Klasse aufrufen
    synchronized (this) {
      System.out.println("Waiting for return key");
      scanner.nextLine();
      System.out.println("Return key pressed.");
      notify();
      Thread.sleep(5000);
    }
  }

  // produce() will run first, because we set consume()-thread with sleep 2s
  // synchronized- lock- belegt, kein anderer kann darauf zugreifen
  // produce runs, then wait() and it hands over the lock-control- frei
  // nun kann consume() thread darauf zugreifen und lockt es mit synchronized- belegt
  /* scanner waits until the User types in something and in the meanwhile
  it gives back the lock-control with notify()-lock frei
   */

  // jetzt kann produce() darauf zugreifen weil lock frei ist
  // wartet wieder
  // dann ist wieder Thread consume() dran
  /*notify()- wakes up all Threads, but does not reliquish the lock control,
  awakened threads cannot proceed until the current thread reliquishes its control
   */
  // notify() is more efficient if there is only one another thread
  // NOTIFY DOES NOT HAND OVER THE CONTROL
  /*we see theat the Thread in consume() will sleep for 5s and then the synchronized block is finished and
  and we finally give back the control so the produce() can get the lock
   */
}
