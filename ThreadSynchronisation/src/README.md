## Let's understand Synchronisation Deeper!

In Java each object is associated with a monitor lock which is a mutual exclusion mechanism used for synchronization.
<br>
When a thread enters into a synchronized block it tries to access the monitor lock(intrinsic lock) associated with the object
on which the synchronization is applied.
<br>
If the lock is available then the thread acquires it proceeds to execute it.
<br>
* If the lock is available : i.e. no other thread is holding the lock 
* If the lock is not available : i.e. another thread is holding the lock and this thread will have to wait until the lock is
    released, during this the thread attempting to enter the synchronized block tries enters into the blocked state.

When a thread exists after executing from the synchronized block it has to release the lock, this allows other threads waiting to
acquire the lock to proceed with there execution.

So this synchronized keyword at the method level uses its own intrinsic lock implicitly

### Problem's associated with synchronized at method level:
* It uses a coarse grained locking.
* i.e. it applies the lock on the entire method body
* the critical section can be of fewer lines inside a method and not the entire method.
* So blocking te entire method which has many lines of code other than critical section makes no sense.
* This leads to reduced concurrency and bottlenecks.
* We lose the fine-grained controls needed in more complex scenario.
* When a subclass is inheriting a synchronized method from its superclass then it must explicitly declare that method as synchronized.
    