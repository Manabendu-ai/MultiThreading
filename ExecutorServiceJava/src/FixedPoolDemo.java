public class FixedPoolDemo {
}

class Work implements Runnable {
    private final int workId;

    public Work(int workId) {
        this.workId = workId;
    }

    @Override
    public void run() {
        System.out.println("Task with id: " + this.workId + " being executed by Thread " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}