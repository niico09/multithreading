package thread.creation.example;

public class ThreadExceptions {

    public static Thread getErrorThread(){
        Thread thread =  new Thread(() -> {
            throw new RuntimeException("Intentional Exception");
        });

        thread.setName("Misbehaving thread");
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("A critical error happened in thread " + t.getName()
                    + " the error is " + e.getMessage());
        });

        return thread;

    }

}
