package com.wilson.threading;

public class Application {
    public static void main(String[] args) {

        Task taskRunner = new Task();
        taskRunner.start(); // invoke the run() method from this object
        // with this position, we can see that multithreaded programs run the program simultaneously
        // and they don't wait until the previous program completes to run
        // kita akan lihat, looping-an di atas belum selesai, namun print hello di bawah akan di jalankan

        System.out.println("Hello there.."); // print ini akan duluan, karena utk print looping di atas memerlukan beberapa waktu
        // taskRunner.start(); // this is illegal because Thread can be called once

        Task taskRunner2 = new Task();
        taskRunner2.start(); // ketika di print, maka akan kejar2an bergantian dengan looping taskRunner object
    }
}

class Task extends Thread {

    // override abstract method run() from runnable, because Thread implement runnable interface
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("number: " + i);
        }
    }
}