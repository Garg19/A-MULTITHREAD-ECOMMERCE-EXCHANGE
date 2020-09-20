
public class Queue<V> implements QueueInterface<V>{

 
    private NodeBase<V>[] queue;
    private int capacity, currentSize, front, rear;
	
  
	public Queue(int capacity) {    
    	this.capacity = capacity;
        this.currentSize = 0;
        queue = new NodeBase[capacity]; 
        front=0;
        rear=0;
    }

    public int size() {
    return  currentSize;
    }

    public boolean isEmpty() {
    return (currentSize==0);
    }
	
    public boolean isFull() {
    return (currentSize==capacity);
    }

    public void enqueue(Node<V> node) {
    	if(currentSize<capacity)
    	{
    		for(int i=currentSize-1;i>=0;i--)
    		{
    			queue[i+1] = queue[i];
    		}
    		queue[0]=node;
    		currentSize++;
    		rear++;
    	}
    	
    }

    public NodeBase<V> dequeue() {
    	
    	 if(currentSize>0)
         currentSize--;
    	 return queue[currentSize];
    	
    }
   
}

