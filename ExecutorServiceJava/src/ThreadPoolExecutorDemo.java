import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5)
        );

        for(int i =0; i<=5; i++){
            int taskId = i;
            executor.execute(
                    ()-> {
                        System.out.println("TaskID: " + taskId + " is performed by " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }

        executor.shutdown();
    }
}
