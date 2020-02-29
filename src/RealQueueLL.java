import java.util.Random;

public class RealQueueLL<T> implements RealQueue<T> {

  // instance variables
  Node front;
  Node tail;
  int size;

  // Node inner class
  // Remember: this is a doubly linked list!
  class Node {
    T info;
    Node prev;
    Node next;
  }

  // Interface methods
  public void enqueue(T item) {
    Node n = new Node();
    n.info = item;

    if (isEmpty()) {
      front = n;
    } else {
      n.prev = tail;
      tail.next = n;
    }
    tail = n;
    size++;

  }

  public T dequeue() {
   if (isEmpty()) {
     return null;
   }
   T returnme = front.info;

   // Set front to the next node.
   // This will set front to null if the
   // list was of size 1.
   front = front.next;

   // And if the list was size 1, you need to
   // set tail to null as well.
   if (size == 1) {
     tail = null;
   }
   size--;
   return returnme;

 }

 public T getFront() {
   if (isEmpty()) {
     return null;
   }
   T returnme = front.info;
   return returnme;
 }

  public void merge(RealQueue rq2) {
    int mid_index = (this.getSize()+1)/2;
    //Finds the middle index
    int count = 1;
    //counter variable used to traverse
    Node traverse = this.tail;
    //creates a node called traverse which is set equal to the tail node
    //the node traverse goes through the while loop from the tail until it gets to the middle index
    while (count < mid_index && traverse.prev!=null) {
      traverse = traverse.prev;
      count++;
    }
    //if rq2 still has items in the queue, a random number will generate and
    //if it's above 0.5, a new node insert is created which takes the info from
    //the dequeued node in rq2. The new node insert is then placed into rq1 at
    //that middle index
    while (rq2.getSize()!=0 && traverse != null) {
      double rand = Math.random();
      if (rand > 0.5) {
        Node insert = new Node();
        insert.info = (T)rq2.dequeue();
        if (traverse.prev != null) {
        traverse.prev.next = insert;
      } else {
        front = insert;
      }
        insert.next = traverse;
        insert.prev = traverse.prev;
        traverse.prev = insert;
    } //if the number generated isn't above 0.5, traverse moves over to the next index
    traverse = traverse.next;
  }
  //If rq1 is empty, it will just enqueue all of rq2.
    while (rq2.getSize()!=0) {
    this.enqueue((T)rq2.dequeue());
  }
  }

  public boolean isEmpty() {
    return (size==0);
  }

  public int getSize() {
    return size;
  }

  public String toString() {
     StringBuilder sb = new StringBuilder();
     Node traverse = front;
     while (traverse != null) {
       sb.append(traverse.info + " ");
       traverse = traverse.next;
     }
     return sb.toString();
   }

  public static void main (String[] args){
    //Regular test
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

    //Test with rq2 being empty
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

    //Test with rq1 being empty
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
