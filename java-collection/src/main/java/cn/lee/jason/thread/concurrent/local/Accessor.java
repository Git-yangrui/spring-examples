package cn.lee.jason.thread.concurrent.local;

import static cn.lee.jason.util.Utils.*;

/**
 * Created by jason on 17/2/26.
 */
public class Accessor implements Runnable {
    private final int id;

    public Accessor(int id) {
        this.id = id;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            ThreadLocalVariableHolder.increment();
            print(this.toString());
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "Accessor{" +
                "id=" + ThreadLocalVariableHolder.getValue() +
                '}';
    }
}