package Multithreading.ThreadPool;

import java.util.concurrent.BlockingQueue;

//Implementation of the "Thread's Main-method"
//nimmt tasks aus der Queue raus und bearbeitet sie
public class PoolThreadRunnable implements Runnable {

    //zu laufender Thread, auszuführende Aufgaben/tasks, isStopped-Flag
    private Thread        thread    = null;
    private BlockingQueue taskQueue = null;
    private boolean       isStopped = false;

    public PoolThreadRunnable(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        this.thread = Thread.currentThread();
        while(!isStopped()){
            try{
                //durch Casten bekommt man Zugriff auf dessen Objektmethoden
                //take->entfernt den Kopf der Queue und liefert ein Runnable zurück
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            } catch(Exception e){
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        //break pool thread out of dequeue() call.
        this.thread.interrupt();
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}