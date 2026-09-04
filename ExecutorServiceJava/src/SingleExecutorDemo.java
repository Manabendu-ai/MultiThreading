import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecutorDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            service.execute(new Task(i));
        }
        service.shutdown();
        /*
        The executor service internal working:
        The thread pool has the task(0)-->task(n) stored in a queue in a sequential way.
        Now in singleThreadExecutor there is only one thread in the Thread pool so
        that will execute all the tasks sequentially.
        Exceptionally in any case the thread got destroyed then the executor service will recreate the
        thread and complete all the execution.

         */
    }
}

class Task implements Runnable{
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task with id: "+this.taskId+" being executed by Thread "+Thread.currentThread().getName());
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}