package Multithreading.RW_Scenario;

public class Shared {
    public double value;
    public boolean changed = false;

    public static void main(String[] args) {
        Shared share = new Shared();

        for (int i = 1; i <= 5; i++)
            new Reader(share).start();

        for (int i = 2; i <= 3; i++)
            new Writer(share, i).start();
    }
}
