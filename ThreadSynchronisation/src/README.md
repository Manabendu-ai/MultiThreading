## Let's understand Synchronisation Deeper!

In Java each object is associated with a monitor which is a mutual exclusion mechanism used for synchronization.
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