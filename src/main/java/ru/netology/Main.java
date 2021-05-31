package ru.netology;

public class Main {
    private static final int COUNT_OF_THREADS = 4;

    public static void main( String[] args ) throws InterruptedException {
        ThreadGroup groupOfThreads = new ThreadGroup("groupOfThreads");
        System.out.println("----- Создание потоков -----");
        for (int i = 1; i <= COUNT_OF_THREADS; i++) {
            Thread someThread = new MessageSenderThread(groupOfThreads, ("Поток_" + i));
            someThread.start();
        }
        Thread.sleep(10000);
        groupOfThreads.interrupt();
        System.out.println("----- Завершение работы потоков -----");
    }
}
