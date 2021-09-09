package Multithreading.RW_Scenario;

class Writer extends Thread {
    //genau ein gemeinsames Objekt, dass geteilt wird.
    //beim Problem von Aufgabe Fabrik, haben beide Threads unabhängig voneinander gearbeitet- deswegen 2 locks
    private final Shared share;
    private final int n;
    public Writer(Shared s, int n) {
        share = s;
        this.n = n;
    }

    public void run() {
        for(int i = 1; i<=n; i++){
            synchronized (share){
                while (share.changed) {
                    try {
                        share.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                share.value = n;
                share.changed = true;
                notifyAll();
            }
        }
        }
}