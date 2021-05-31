package ru.netology;

public class MessageSenderThread extends Thread{

    public MessageSenderThread(ThreadGroup groupOfThreads, String name) {
        super(groupOfThreads, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2000);
                System.out.format("%s шлет сообщение\n", getName());
            }
        } catch (InterruptedException e) {

        } finally {
            System.out.printf("%s: Работа завершена\n", getName());
        }
    }
}
