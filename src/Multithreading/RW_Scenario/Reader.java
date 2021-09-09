package Multithreading.RW_Scenario;

public class Reader extends Thread {
    private final Shared share;
    public Reader(Shared s) {
        share = s;
    }
    public void run() {
        synchronized (share){
            while (!share.changed){
                try {
                    share.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(share.value);
            share.changed = false;
            notifyAll();
        }
    }
}
