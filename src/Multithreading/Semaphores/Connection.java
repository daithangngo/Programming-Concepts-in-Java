package Multithreading.Semaphores;

import java.util.concurrent.Semaphore;

public class Connection {
  private static Connection instance = new Connection();
  private int connections = 0;
  //to make a connection one must aquire one connection
  //fair--> true : FIFO , false: does not matter
  //1 permit is the same like a lock
  //true- dann fifo-Prinzip
  //Semaphore haben keine fixe Größe. man kann die nach oben verändern
  private Semaphore sem = new Semaphore(10);

  public static Connection getInstance() {
    return instance;
  }

  public void connect(){
    try {
      sem.acquire();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try{
      doConnect();
    }finally{
      sem.release();
    }
  }

  //we make 2 methods like that because if the doConnect throws an Exception that we still can release()
  public void doConnect()  {
    synchronized (this) {
      connections++;
      System.out.println("Current connections: " + connections);
    }
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //we dont need the connection anymore, so we disconnect
    synchronized (this) {
      connections--;
    }
  }
}
