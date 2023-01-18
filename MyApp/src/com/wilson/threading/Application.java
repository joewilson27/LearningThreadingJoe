package com.wilson.threading;

public class Application {
    public static void main(String[] args) {

        System.out.println("Starting thread 1");
        Task taskRunner = new Task("Thread-A");
        taskRunner.start(); // invoke the run() method from this object
        // with this position, we can see that multithreaded programs run the program simultaneously
        // and they don't wait until the previous program completes to run
        // kita akan lihat, looping-an di atas belum selesai, namun print hello di bawah akan di jalankan

        //System.out.println("Hello there.."); // print ini akan duluan, karena utk print looping di atas memerlukan beberapa waktu
        // taskRunner.start(); // this is illegal because Thread can be called once

        System.out.println("Starting thread 2");
        Task taskRunner2 = new Task("Thread-B");
        taskRunner2.start(); // ketika di print, maka akan kejar2an bergantian dengan looping taskRunner object
    
        System.out.println("Starting thread 3");
        // create instance of TaskWithRunnable
        TaskWithRunnable taskRunner3 = new TaskWithRunnable("Thread-Runnable-A");
        // create a Thread object instance
        Thread t1 = new Thread(taskRunner3);
        t1.start();


        // Thread with Runnable
        System.out.println("Starting thread 4");
        Thread t2 = new Thread(new Runnable() {

            // override method run() karena ia ada di dalam interface Runnable
            @Override
            public void run() {
                for(int i = 0; i < 1000; i++) {
                    System.out.println("number: " + i + " - " + Thread.currentThread().getName());
                    // by default, getName dari current thread akan mengisi sesuai urutan thread, jika ada 3 thread maka akan ada thread-0 hingga thread-2, dst
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        t2.start();

    }
}

class Task extends Thread {

    String name;

    public Task(String name) {
        this.name = name;
    }

    // override abstract method run() from runnable, because Thread implement runnable interface
    @Override
    public void run() {
        // untuk mengganti nama Threadname
        Thread.currentThread().setName(this.name);

        for(int i = 0; i < 1000; i++) {
            System.out.println("number: " + i + " - " + Thread.currentThread().getName());
            // by default, getName dari current thread akan mengisi sesuai urutan thread, jika ada 3 thread maka akan ada thread-0 hingga thread-2, dst
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
 * Class Thread implemented Runnable interface, so here we are implementing Runnable interface
 * instead of extending Thread class
 * but you have to create a Thread object and put the instance of this class to the object Thread
 */
class TaskWithRunnable implements Runnable {

    String name;

    public TaskWithRunnable(String name) {
        this.name = name;
    }

    // override abstract method run() from runnable, because Thread implement runnable interface
    @Override
    public void run() {
        // untuk mengganti nama Threadname
        Thread.currentThread().setName(this.name);

        for(int i = 0; i < 1000; i++) {
            System.out.println("number: " + i + " - " + Thread.currentThread().getName());
            // by default, getName dari current thread akan mengisi sesuai urutan thread, jika ada 3 thread maka akan ada thread-0 hingga thread-2, dst
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}