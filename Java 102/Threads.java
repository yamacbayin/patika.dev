import java.util.*;

public class Threads{

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            numbers.add(i);
        }

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        List<Thread> threads = new ArrayList<>();

        int chunkSize = numbers.size() / 4;
        for (int i = 0; i < 4; i++) {
            final int start = i * chunkSize;
            final int end = (i + 1) * chunkSize;

            Thread thread = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    int number = numbers.get(j);
                    if (number % 2 == 0) {
                        synchronized (evenNumbers) {
                            evenNumbers.add(number);
                        }
                    } else {
                        synchronized (oddNumbers) {
                            oddNumbers.add(number);
                        }
                    }
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }


}

