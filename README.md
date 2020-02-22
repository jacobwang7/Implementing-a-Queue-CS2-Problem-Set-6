# Problem Set 6: Real Life Queue
## Due Saturday, February 29 at 11:59pm

---

In this problem set, you will be implementing the kind of queue you encounter a lot in real life. You are standing in line, when you see that another line is starting to form in a different direction behind someone in front of you in line. The people in that new line start merging into your line. Some people in your line might be nice and let a few people in. Others are territorial and refuse to let anyone cut in line. I find that this happens a lot when waiting for the escalator after you get off the subway. People are coming from several different directions, and they all need to merge into a single line. This is the type of queue you will be modeling for this problem set.

### The `RealQueue` ADT and interface

The interface looks like this. Most of the behaviors are what you'd expect from a queue: enqueue, dequeue, getFront, etc. However, there is an additional method called `merge()`. When one `RealQueue` object (RQ1) calls `merge` on another `RealQueue` object (RQ2), the elements in the argument `RealQueue` RQ2 will be merged into those of the calling `RealQueue` RQ1, as described below, leaving a single `RealQueue` object that contains all elements in both queues.


```java
public interface RealQueue<T> {
  enqueue(T item);
  T dequeue();
  T getFront();
  void merge(ReaQueue rq2);  // see below for a description
  boolean isEmpty();
  int getSize();
  String toString();        // print a RealQueue from front to tail
}
```

### Implementing the interface

You will be implementing this interface in two ways: (1) with a doubly-linked list (`RealQueueLL.java`); and (2) with a fixed-size circular array (`RealQueueCA.java`). I have provided a tiny bit of starter code, but you can repurpose a lot of the code in the various `example_code/week6` repositories.

### How does merge work?

Each element in the argument `RealQueue` (henceforth **RQ2**) will have to be added to the calling `RealQueue` (henceforth **RQ1**) as follows:

1. Find the middle element of RQ1. (See below for how to identify the middle element.)

2. Using a random number, decide whether the front element of RQ2 should be allowed to cut in front of that middle element of RQ1. If the answer is yes (i.e., the random number is greater than or equal to 0.5), then insert that element of RQ2 into RQ1 in front of the middle element. If the answer is no, then the element from RQ2 will have to try to cut in front of the next element in  RQ1. Keep repeating this until all the elements from RQ2 have been inserted into RQ1. If you end up running out of elements in RQ1 to try to cut in front of, then just add the rest of RQ2 to the tail of RQ1.

3. Once you have merged RQ1 with RQ2, RQ2 should be empty, and RQ1 should contain all of its own elements and all of RQ2's former elements.

### How do I find the "middle" element?

When you have an odd number of elements, the middle element is unambiguous. For example, the middle element of 5 elements is the third element; if the elements from front to tail are `A B C D E`, the middle element is always `C`. If you have an even number of elements, however, the middle is ambiguous: in a list that is `A B C D E F` from front to tail, you could say the middle element is `C` or `D`. For this problem set, we'll say it's always the element that is further back in line, which in this case would be `D`.

To figure out which one is the middle element, you can experiment with integer division or with the `Math.floor()` and `Math.ceil()` methods in conjunction with casting to `double`. You can also experiment with adding 1 or 2 to the size before doing the integer division.

### How to get to the middle element: linked list
You can traverse the linked list or you can keep an additional pointer to middle Node, along with the pointer to front and tail. Inserting elements will be straightforward, of course.

### How to get to the middle element: circular array
You can either have an additional instance variable to keep track of the middle, or you can calculate it on the fly as needed from the indices for front and tail. Keep in mind that this could get complicated if front or tail has wrapped around. The modulus operator might be helpful! 

### Managing the circular array
Even though this is a circular array, will need to shift some elements in RQ1 over when you insert an element from RQ2 in the middle of RQ1. You can't overwrite any of the elements in RQ1! 

### Don't forget the special cases
If your queue is empty, remember that `dequeue()` and `getFront()` should either throw an exception or return null. There might be some other special cases, so think about these carefully!

### Writing additional methods
You are more than welcome to write additional methods that you might find useful.

### Testing your code `main()`
You must write a  main method that works in both implementations. The only difference in the main method as it appears in `RealQueueLL` vs. `RealQueueCA` will be in the lines that instantiate the `RealQueue` objects, of course. The TAs will be writing their own main methods, so test your code very thoroughly!

---

## Pushing and verifying your submission

Once your code works to your satisfaction, push `RealQueueCA.java` and `RealQueueLL.java` to your personal master repo on the GitHub Classroom site, as you have done for your previous problem sets. Use the commit message "READY FOR GRADING" so we know you are done. 

---

## Important notes on grading

1. The files **must be in the `src` directory**. You will lose 2 points for each file that is in the wrong directory. The best way to make sure the files are in the right place is to never ever move them in the first place.

2. Your code must compile. If a class does not compile, you will get a 0 for that class.

3. The TAs are instructed to take off up to 1 point for missing or inadequate comments. Comment your code to make sure you get this point and to make sure the TAs know what you are trying to do.

4. Note that in addition to running your `main()` method, the TAs will try out one of their own. 
