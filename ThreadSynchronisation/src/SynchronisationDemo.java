public class SynchronisationDemo {

    private static int counter = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter value: "+counter);
        /**
         We have created a counter variable and incrementing it with two thread t1 and t2 each of them running till 10000.
         But we see that the output not 20000. The reason for this behavior is non-atomic operation.

         See our main task it to increment the counter variable:
         counter = counter + 1
         But under the hood it is actually in three steps:
         1) load the variable from the memory : counter
         2) inccrement the actual count : counter + 1
         3) assigning back to the counter : counter = counter + 1
         So suppose if the Thread t1 loads the counter varaible first,
         It sees that the value is 0 and then increments to 1 and assigns back.
         But in between of this operation Thread 2 also might pick the counter variable at 0 and incr and assogn back.
         Therefore, there lies an inconsistency among the values.
         counter = 0; incrementValue = 1; <- Thread One
         counter = 0; incrementValue = 1; <- Thread Two

         This is called race condition, in technical terms.
         When we have a shared resource, and multiple thread working on the same shared resource and these kind of scenarios
         lead to inconsistency which is called race condition.
         */


    }
}
