import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Buyer<V> extends BuyerBase<V> {
    public Buyer (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, int iteration) {
    
    	setSleepTime(sleepTime);
    	setIteration(iteration);
    	this.catalog=catalog;
    	this.empty=empty;
    	this.full=full;
    	this.lock=lock;
    }
    public void buy() throws InterruptedException {
	try {
           
		lock.lock();
		while(catalog.isEmpty())
		{empty.await();}
		
		NodeBase<V> n = catalog.dequeue();
		full.signalAll();;
	    System.out.print("Consumed "); 
            n.show(); 
	} catch (Exception e) {
            e.printStackTrace();
	} finally {
           lock.unlock();
	}
    }
}
