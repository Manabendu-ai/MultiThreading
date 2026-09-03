public class DaemonUserThreadDemo {
    public static void main(String[] args) {
        Thread bgThread = new Thread(new DaemonHelper());
        Thread userThread = new Thread(new UserThread());

        bgThread.setDaemon(true);
        bgThread.start();
        userThread.start();
        /**

         Here is the flow of what exactly happened:
         The userThread has a sleep time of 5 sec. So it was not assigned to any of the cpu.
         The Daemon thread kept running in the background for the first 5 second, then when userThread resumed and completed
         it execution and got terminated, The daemon thread also got terminated instantly because there was no other thread left
         for execution.

         */
    }
}

class DaemonHelper implements Runnable{

    @Override
    public void run() {
        int count = 0;
        while(count < 500){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon helper running...");
        }

    }
}

class UserThread implements Runnable{

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User Thread Done With Execution!");
    }
}