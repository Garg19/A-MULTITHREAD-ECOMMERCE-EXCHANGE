# A-MULTITHREAD-ECOMMERCE-EXCHANGE
NAME - AAKASH GARG

The Code is concerned with the application of the data structure queue and priority queue and also requires the handling of many process at a single time with the help of the THREADS by proper synchronisation of the methods that deal with shared material. The synchronisation is achieved with the help of lock and conditions as required. In this , we have to make a buyer seller platform with the help of threads and locks and queues. As the seller are of different priorities, we have assigned an object a priority which basically represents the priority of the seller. The objects with highest priority will be bought by buyers always which is implemented with the help of priority queue .

The classes that are present in the assignment are:-

# BASES 
In this class , all the required interfaces and methods are provided.It include the run method required by the thread when start is called in the main.It also include buyer and seller interface that implements runnable class so that the threads can be created for the buyer and seller objects.

# Item
In this class, the details of an item is stored ie (price and name) and also contains method to get the values of name and price.It also contain a To string method which return the item details in a string.

# Node
As the items are of different priorities, we need a object that store a particular object and its priority. Hence node class is defined which has two variable priority and the object itself. It also contain return methods for returning the values of the variables.

# Queue
This class represent a data structure with certain methods and return types. It is based on the principle of First In First Out(FIFO) like any real queue.We have implemented it with the help of an array by using array member function. It contains methods like

Size - returns the size of the queue with the help of a variable size which stores the size of queue.

Is empty - return true if queue is empty or false otherwise

Is full -  return true if queue is full or false otherwise by comparing current size with the max length(capacity)

Enqueue -  It add a element in the queue at the back and increases the size by 1 in O(1) complexity

Dequeue - It removes an element from the front of the queue and shift all elements by 1 place and decreases the size by 1 in O(n) complexity

# PriorityQueue
This class is also a queue which return the max priority element when dequeue is called. It is also implemented with array and its member functions.It contains methods like

Size - returns the size of the queue with the help of a variable size which stores the size of queue

Is empty - return true if queue is empty or false otherwise\

Is full -  return true if queue is full or false otherwise by comparing current size with the max length(capacity)

Enqueue - In this method , we have inserted elements in a sorted way by comparing the priority of current node and the node present in the queue and inserted it at the right place and increases the size by 1 in O(n) complexity

Dequeue - In this, we have returned the highest priority element in O(1) complexity as it is already sorted

Display - this is to check the elements of the queue that they are in correct order or not

# Buyer
This is a class which represents a buyer thread by implementing the runnable interface.Through this class, we can represent a buyer as a thread which contains a synchronised method 
Buy - As this method is operated by various threads at same time, we need that our shared resources are accessed by only one thread only at a time for the proper functioning so we have used a lock which is given as a parameter to the buyer class which ensures that only one thread can access the lock and the shared resources at a time.When the catalog is empty, we have used a condition that is also given as a parameter that if catalog is empty all the buyer thread should go in a waiting state by calling await method and also when a buyer buys a thing successfully it notifies all the waiting seller threads which are waiting due to full condition by signal all method to do the sell method as now the catalog is not full. Each of these threads go to to sleep for a fixed sleep time which is given after completing their method.  

# Seller
This is a class which represents a seller thread by implementing the runnable interface.Through this class, we can represent a seller as a thread which contains a synchronised method
Sell - Similarly like the buy method, We have the lock and the conditions for proper synchronisation. If the catalog is full , we have a condition which makes a thread go in waiting state by await method and if the catalog is not full then after selling the thing we will notify all the empty condition waiting buyer threads that are waiting due to the condition that catalog is empty as the catalog is not empty after selling operation.Each of these threads go to to sleep for a fixed sleep time which is given after completing their method.  

# Assignment2main
This is the main class that is using all the the classes defined and hence implementing the task required. It has a Bufferfilereader that is reading the input file and adding all the elements in a ArrayList. We have to add elements from the array list to our queue named inventory. Then we have to create the buyer and seller objects by passing the global arguments to both the buyer and seller object.
In this we have the same lock and same conditions which are passed in buyer class so that the threads of buyers and sellers are also properly synchronised.If same lock and condition are not passed then the buyers will be synchronised in themselves and sellers in themselves but they both mutually will not get synchronised. 
Then we have created the threads of the buyer and seller object and started the threads.

All the classes and functions defined are properly working . I have tested the priority queue and all the enqueue and dequeue methods are giving correct result.The threads are synchronised properly and all lock, conditions are working properly.

