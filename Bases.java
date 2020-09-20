

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


abstract class NodeBase<V> {
    protected int priority; 
    protected V value;	
    public abstract int getPriority();
    public abstract V getValue();	
    public void show() {
	System.out.println(this.getPriority());
    }
}


interface QueueInterface<V> {
    public int size(); 
    public boolean isEmpty(); 
    public boolean isFull();  
    public void enqueue(Node<V> item); 
    public NodeBase<V> dequeue(); 
}


abstract class BuyerBase<V> implements Runnable {
    protected PriorityQueue<V> catalog; 
    protected Lock lock; 
    protected Condition full, empty; 
    private int sleepTime; 
    private int iteration; 
    
    public abstract void buy() throws InterruptedException; 
    
 
    public void run() {
        for(int i=0;i<this.iteration;i++) {
            try {
                buy();
                Thread.sleep(this.sleepTime);
            } catch (Exception e) {  e.printStackTrace(); }
	}
    }

   
    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    
    public void setIteration(int iteration) {
        this.iteration = iteration;
    }
}


abstract class SellerBase<V> implements Runnable {
    protected PriorityQueue<V> catalog; 
    protected Lock lock; 
    protected Condition full, empty;
    private int sleepTime; 
    protected Queue<V> inventory; 
    
    public abstract void sell() throws InterruptedException; 
    
 
    public void run() {
    	 
        while(inventory.isEmpty()!=true) {
            try {
                sell();
	    } catch (Exception e) {  e.printStackTrace(); }
	}
    }


    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }
}
