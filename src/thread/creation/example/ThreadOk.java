package thread.creation.example;

public class ThreadOk {

    public Thread getCorrectThread() {
        var thread = new Thread(() -> {
            System.out.println("We are now in the thread" + Thread.currentThread().getName());
            System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
        });

        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        return thread;
    }
}
