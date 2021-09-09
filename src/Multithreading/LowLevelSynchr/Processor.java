package Multithreading.LowLevelSynchr;

import java.util.LinkedList;
import java.util.Random;

/*
man muss sich immer um Synchronisierung machen, wenn es sich um mehrere Threads handelt
 */

public class Processor {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    //adds
    public void produce() throws InterruptedException{
        int val = 0;
        while(true){
            synchronized (lock){//synchronized on the object on which we want to work on... in this case a dummy
              //every object has an lock/mutex-->aquire first and then use it- only one Thread
                while(list.size()==LIMIT){
                    //we call it on the Object, that THIS obj is waiting
                    //when the "waiting"-Modus ends we check again whether the list is full or not
                    lock.wait();
                }
                //add first then +1
                list.add(val++);
                lock.notify();
            }
        }
    }

    //removes
    public void consume() throws InterruptedException{
        Random random = new Random();
        while (true){
            synchronized (lock){ // kein anderer kann den kritischen bereich eintreten
                while (list.isEmpty()){
                    lock.wait();
                }
                System.out.printf("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println(", Value is: " + value);
                //Object wakes up the on it waiting thread
                lock.notify();
            }
            //0-999
            Thread.sleep(random.nextInt(1000));
        }
    }
}
