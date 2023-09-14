package dat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ConcurrentTask
{
    void run() {
        // Simulate some computation
        try {
            Thread.sleep(1000); // Simulate 1 second of work
            System.out.println("ConcurrentTask done with 1000 ms sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Exercise9
{
    public static void main(String[] args) {
        // Using CompletableFuture
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> new ConcurrentTask().run());
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> new ConcurrentTask().run());

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2);
        allFutures.thenRun(() -> System.out.println("All CompletableFuture tasks completed."));

        // Using ExecutorService
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> new ConcurrentTask().run());
        executorService.submit(() -> new ConcurrentTask().run());

        executorService.shutdown();
        System.out.println("All ExecutorService tasks submitted.");
    }
}
