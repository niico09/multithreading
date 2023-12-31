package thread.creation.example;

public class ThreadInterface extends Thread{
    @Override
    public void run(){
        System.out.println("Hello from: " + Thread.currentThread().getName());
    }
}
