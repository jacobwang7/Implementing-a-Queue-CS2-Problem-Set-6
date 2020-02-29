import java.util.Random;

public class RealQueueCA<T> implements RealQueue<T> {

    // static variables
    // Here we're saying the maximum size of the real queue is 10.
    int CAPACITY = 10;

    // instance variables
    T[] storage;    // you need an array to store the real queue
    int front;      // index of the front
    int tail;       // index of the tail
    int size;       // size of the real queue
    int middle;
    // constructor
    public RealQueueCA() {
      // You want to create an array, but you aren't allowed to
      // create an array of a generic type, so this is a way around that.
      // Create an array of Objects that you then cast to type T
      @SuppressWarnings("unchecked")
      T[] temp = (T[]) new Object[CAPACITY];
      this.storage = temp;
      this.size = 0;
    }


    // Interface methods
    public void enqueue(T item) {
      if (size == CAPACITY) {
        System.out.println("Queue is full.");
        return;
      }

      // otherwise, if there is room to add something...
      System.out.println("Enqueuing " + item.toString());

      // if the queue is not empty...
      if (!isEmpty()) {
        // increment the tail, and wrap around if necessary
        tail = (tail+1);
      }

      // and if the queue is empty, set both front and tail to 0
      else {
        front = 0;
        tail = 0;
      }

      // enter the item into the queue and increment size
      storage[tail % CAPACITY] = item;
      size++;

    }

    public T dequeue() {
      if (isEmpty()) return null;

      // Get the front element.
      T toreturn = storage[front % CAPACITY];
      System.out.println("Dequeueing " + toreturn.toString());
      storage[front % CAPACITY] = null; // (just so my toString() words nicely)

      // Move front forward 1 and wrap around if necessary
      front = (front+1);

      // Decrement size.
      size--;

      // and if the queue is now empty, reset both front and tail to 0
      if (isEmpty()) {
        tail = 0;
        front = 0;
      }

      // return the saved out front element
      return toreturn;

    }


    public T getFront() {
    if (isEmpty()) {
        return null;
      }
      return storage[front % CAPACITY];
    }

    public void merge(RealQueue rq2) {
      //Finds the middle index
      int index = this.tail + this.getSize() + 1;
      int mid = index/2;

    //if rq2 isn't empty, generate a random number and if it's greater than 0.5,
    //increase storage and shifts over all elements from the middle onwards once
    while (rq2.getSize() > 0) {
    double rand = Math.random();
    if (rand > 0.5) {
      for (int i = mid; i < this.tail; i++) {
    this.storage[i % CAPACITY] = this.storage[i % CAPACITY + 1];
  }
  //Adds the value of rq2 into rq1
 T value = (T) rq2.dequeue();
 this.storage[mid % CAPACITY] = value;
 this.size++;

} //if the generated number isn't greater than 0.5, move over to the next index
  else {
  mid = mid + 1;
}

}
}
  //middle is first person you ask
  //

    public boolean isEmpty(){
    return (size ==0);
    }

    public int getSize(){
    return size;
    }

    public String toString() {
  //  String s = "";
  //  s += storage[i]
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<storage.length; i++) {
      sb.append(storage[i] + " ");
      }
    return sb.toString();
    }
    // Optional additional methods
    // Feel free to create any methods you need or want.

    public static void main (String[] args) {
      RealQueue<String> q1 = new RealQueueCA<String>();
      RealQueue<String> q2 = new RealQueueCA<String>();
      RealQueue<String> rq1 = new RealQueueLL<String>();
      RealQueue<String> rq2 = new RealQueueLL<String>();
      System.out.println("Before merging:");
      rq1.enqueue("cat");
      rq1.enqueue("dog");
      rq1.enqueue("mouse");
      System.out.println("queue 1: " + rq1);
      rq2.enqueue("red");
      rq2.enqueue("blue");
      rq2.enqueue("green");
      System.out.println("queue 2: " + rq2);
      rq1.merge(rq2);
      System.out.println("After merging:");
      System.out.println("final queue 1: " + rq1);

      System.out.println("");

      RealQueue<String> rq3 = new RealQueueLL<String>();
      RealQueue<String> rq4 = new RealQueueLL<String>();
      System.out.println("Before merging:");
      rq3.enqueue("cat");
      rq3.enqueue("dog");
      rq3.enqueue("mouse");
      System.out.println("queue 1: " + rq3);
      System.out.println("queue 2: " + rq4);
      rq3.merge(rq4);
      System.out.println("After merging:");
      System.out.println("Final queue 1: " + rq3);

      System.out.println("");

      RealQueue<String> rq5 = new RealQueueLL<String>();
      RealQueue<String> rq6 = new RealQueueLL<String>();
      System.out.println("Before merging:");
      System.out.println("queue 1: " + rq5);
      rq6.enqueue("red");
      rq6.enqueue("blue");
      rq6.enqueue("green");
      System.out.println("queue 2: " + rq6);
      rq5.merge(rq6);
      System.out.println("After merging:");
      System.out.println("Final queue 1: " + rq5);




    }

}
