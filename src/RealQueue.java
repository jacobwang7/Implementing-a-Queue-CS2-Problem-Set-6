public interface RealQueue<T> {
  void enqueue(T item);
  T dequeue();
  T getFront();
  void merge(RealQueue rq2);
  boolean isEmpty();
  int getSize();
  String toString();
}
