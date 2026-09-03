public class ThreadPriority {
    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getPriority());
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//        System.out.println(Thread.currentThread().getPriority());

        System.out.println(Thread.currentThread().getName()+" : Hello!");
        Thread one = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+" Hello From One!");
        });
        Thread two = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+" Hello From Two!");
        });
        Thread three = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+" Hello From Three!");
        });
        Thread four = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+" Hello From four!");
        });

        four.setPriority(Thread.MAX_PRIORITY);
        three.setPriority(Thread.MIN_PRIORITY);

        one.start();
        two.start();
        three.start();
        four.start();
    }
}
