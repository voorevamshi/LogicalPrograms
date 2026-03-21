package com.vmc.interview.Tmobile;
public class SequencePrinter {
    private final int[] oddArray = {1, 3, 5, 7, 9};
    private final int[] evenArray = {2, 4, 6, 8, 10};
    private boolean isOddTurn = true; // Flag to track turn
    private final Object lock = new Object();

    public void printOdd() {
        for (int num : oddArray) {
            synchronized (lock) {
                while (!isOddTurn) {
                    try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
                System.out.println("Odd Thread: " + num);
                isOddTurn = false;
                lock.notify(); // Wake up the Even thread
            }
        }
    }

    public void printEven() {
        for (int num : evenArray) {
            synchronized (lock) {
                while (isOddTurn) {
                    try { lock.wait(); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                }
                System.out.println("Even Thread: " + num);
                isOddTurn = true;
                lock.notify(); // Wake up the Odd thread
            }
        }
    }

    public static void main(String[] args) {
        SequencePrinter printer = new SequencePrinter();

        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}
//https://gemini.google.com/share/1fb89d59ee6b