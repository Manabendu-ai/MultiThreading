public class ScheduledExecutorDemo {
}

class ProbeTask implements Runnable{

    @Override
    public void run() {
        System.out.println("Probing endpoints for updates...");
    }
}