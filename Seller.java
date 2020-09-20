import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Seller<V> extends SellerBase<V> {
	public int Sleept = 0;
	
    public Seller (int sleepTime, int catalogSize, Lock lock, Condition full, Condition empty, PriorityQueue<V> catalog, Queue<V> inventory) {
    	this.setSleepTime(sleepTime);
    	this.catalog=catalog;
    	this.inventory = inventory;
    	this.empty=empty;
    	this.full=full;
    	this.lock=lock;
    	this.Sleept=sleepTime;
         
    }
    
    public void sell() throws InterruptedException {
	try {
		this.lock.lock();
		while(catalog.isFull())
		{	full.await();}
		if(inventory.isEmpty()!=true)
	    {
			Node<V> nq = (Node<V>)(inventory.dequeue());
			catalog.enqueue(nq);
	
	    }
	    empty.signalAll();
	   
		
	 
	} catch(Exception e) {
            e.printStackTrace();
	} finally {
       
		this.lock.unlock();
		 Thread.sleep(Sleept);
		
	}		
    }
}