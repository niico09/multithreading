package thread.termination.example1;

public class Main {
    public static void main(String[] args) {

        var thread = new Thread(new BlockingTask());
        thread.start();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            // Do something very important
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                // We've been interrupted: no more crunching.
                System.out.println("Exiting blocking thread");
            }
        }
    }
}
