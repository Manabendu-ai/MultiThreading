import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndSubmit {
    public static void main(String[] args) {
        /**
         * Difference between callable and runnable.
         * callable is similar to runnable but callable return a result and runnable doesn't
         * callable return us an object of Future<T>.
         * Future is a generic class where the results are obtained after a certain time in the future.
         * In callable the exceptions are retained whereas in runnable the exceptions are not retained.
         *
         * submit() method: it is similar to execute() but it takes a callable object and return a future object.
         */
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future<Integer>> res = new ArrayList<>();
        for(int i = 1; i<15; i++){
            int num = i;
            Future<Integer> submit = service.submit(
                    () -> num + 10
            );
            res.add(submit);
        }

        // getting the result from the future object
        System.out.println("result: ");
        for(Future<Integer> num : res){
            try{
                int n = num.get();
                System.out.print(n+" ");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println();
    }
}
