public class RealQueueCA<T> implements RealQueue<T> {

    // static variables
    // Here we're saying the maximum size of the real queue is 10.
    int CAPACITY = 20;

    // instance variables
    T[] storage;    // you need an array to store the real queue
    int front;      // index of the front
    int tail;       // index of the tail
    int size;       // size of the real queue

    // constructor
    public UnfairQueueArray () {
      // You want to create an array, but you aren't allowed to
      // create an array of a generic type, so this is a way around that.
      // Create an array of Objects that you then cast to type T
      @SuppressWarnings("unchecked")
      T[] temp = (T[]) new Object[CAPACITY];
      this.storage = temp;
      this.size = 0;
    }


    // Interface methods

    // Optional additional methods
    // Feel free to create any methods you need or want.

    // Main method
    // You must write a main method demonstrating how your code works.
    // You should write one main method that works in both implementations.
    // The only thing you should have to change are the lines that
    // instatiate the RealQueue objects.

}
