package thread.creation.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        var thread = new ThreadOk().getCorrectThread();

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");

        thread.sleep(10000);

        var secondThread = ThreadExceptions.getErrorThread();
        secondThread.start();

        secondThread.sleep(10000);

        var thirdThread = new ThreadInterface();
        thirdThread.start();

    }
}
