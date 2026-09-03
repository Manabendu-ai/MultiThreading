public class ThreadPriority {
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//        System.out.println(Thread.currentThread().getPriority());

        System.out.println(Thread.currentThread().getName()+" Hello!");

        Thread one = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" Hello From One!");
        }, "TH-1");

        Thread two = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" Hello From Two!");
        },"TH-2");

        Thread three = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" Hello From Three!");
        }, "TH-3");

        Thread four = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" Hello From Four!");
        }, "TH-4");

        four.setPriority(Thread.MAX_PRIORITY);
        three.setPriority(Thread.MIN_PRIORITY);

        one.start();
        two.start();
        three.start();
        four.start();

        /**
         Note : The output order may vary because thread scheduling depends on the JVM and the underlying operating system.
         So it is not guaranteed that the threads will execute in the order of priority which is set to them.
         */
    }
}
