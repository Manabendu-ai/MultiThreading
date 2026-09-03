public class SequentialExecution {
    /**
     Let's demonstrate a sequential execution of a java program.
     */

    private static void  demo1(){
        for (int i = 0; i<5; i++){
            System.out.println("From demo 1: "+i);
        }
    }

    private static void  demo2(){
        for (int i = 0; i<5; i++){
            System.out.println("From demo 2: "+i);
        }
    }

    public static void main(String[] args) {
        demo1();
        demo2();
    }

    /**
     Observation:
     Wee see that the demo1() method executes first and then demo2().
     This is a single thread program. The main thread is executing demo1 and demo2 methods in a sequential manner.
     */
}
