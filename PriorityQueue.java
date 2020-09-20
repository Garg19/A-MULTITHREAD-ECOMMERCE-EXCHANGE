
public class PriorityQueue<V> implements QueueInterface<V>{

    private NodeBase<V>[] queue;
    private int capacity, currentSize;
	
 
	public PriorityQueue(int capacity) {    
    this.capacity = capacity;
    this.currentSize = 0;
    queue = new NodeBase[capacity];
   
    }

    public int size() {
    return currentSize;
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
   	    if(currentSize==0)
   	    {	queue[0] = node;}
   	    else if(node.getPriority()<queue[currentSize-1].getPriority())
   	    	{queue[currentSize]=node;}
   	    else
   	    {
   	    	int i;
   	    	for(i=0;i<currentSize;i++)
   	    	{
   	    		if(node.getPriority()>queue[i].getPriority())
   	    			break;
   	    	}
   	    	for(int j = currentSize-1;j>=i;j--)
   	    	{
   	    		queue[j+1] = queue[j];
   	    	}
   	    	queue[i] = node;
   	    		
   	    }
   	    currentSize++;
   	  }
    
    }
    public NodeBase<V> dequeue() {
    if(currentSize>0)
    {
    	currentSize--;
    	
    }
    return queue[currentSize];
    }

    public void display () {
	if (this.isEmpty()) {
            System.out.println("Queue is empty");
	}
	for(int i=0; i<currentSize; i++) {
            //queue[i].show();
	}
    }
}

