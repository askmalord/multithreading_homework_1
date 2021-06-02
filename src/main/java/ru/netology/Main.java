package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        List<Callable<Integer>> listOfTasks = new ArrayList<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 5; i++) {
            Callable<Integer> task = new MyCallable();
            listOfTasks.add(task);
        }
        System.out.println("----- Получение результатов -----");
        List<Future<Integer>> result = threadPool.invokeAll(listOfTasks);
//        int someResult = threadPool.invokeAny(listOfTasks);
        System.out.println("----- Результаты получены, вывод на экран -----");
//        System.out.println(someResult);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Result: " + result.get(i).get());
        }
        threadPool.shutdown();
    }
}
