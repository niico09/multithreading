package thread.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] argss) {

        List<Long> inputNumbers = Arrays.asList(1000L, 3435L, 35435L, 2324L, 4656L, 23L, 5556L);
        List<FactorialThreads> threads = new ArrayList<>();

        for (long inputNumber : inputNumbers) {
            threads.add(new FactorialThreads(inputNumber));
        }

        for (Thread thread : threads) {
            thread.setDaemon(Boolean.TRUE);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThreads factorialThread = threads.get(i);
            if (Boolean.TRUE.equals(factorialThread.isFinished())) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }

    private static class FactorialThreads extends Thread {
        private long inputNumber;
        private long result;
        private boolean isFinished = false;

        public FactorialThreads(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public long factorial(long n) {
            if (n == 0) {
                return 1;
            }
            return n * factorial(n - 1);
        }

        public long getResult() {
            return result;
        }

        public Boolean isFinished() {
            return isFinished;
        }
    }
}
