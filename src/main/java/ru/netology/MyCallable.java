package ru.netology;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private static final int BOUND_OF_RANDOM_INT = 10;
    private static Random randomLimit = new Random();
    private int limit;
    private static int allCallableTasks = 1;
    private int numberOfTask;

    public MyCallable() {
        this.limit = randomLimit.nextInt(BOUND_OF_RANDOM_INT);
        this.numberOfTask = allCallableTasks++;
    }

    @Override
    public Integer call() throws Exception {
        int countOfMessage = 0;
        for (int i = 0; i < limit; i++) {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " работает над задачей " + numberOfTask);
            countOfMessage++;
        }
        return countOfMessage;
    }
}
