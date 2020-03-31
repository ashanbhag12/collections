package akshay.util.queue;

import akshay.util.Collection;

/**
 * Queues typically order elements in a FIFO (first-in-first-out) manner.
 * 
 * @author AShanbhag
 *
 * @see 
 *
 * @Date Aug 26, 2015
 */
public interface Queue<E> extends Collection<E>
{
	/**
	 * Retrieves, but does not remove, the head of this queue. 
	 * This method differs from peek only in that it throws an exception if this queue is empty.
	 * 
	 * @return the head of this queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public E element();
	
	/**
	 * Inserts the specified element into this queue if it is possible to do so immediately 
	 * without violating capacity restrictions. When using a capacity-restricted queue, 
	 * this method is generally preferable to add(E), which can fail to insert an element 
	 * only by throwing an exception.
	 * 
	 * @param element - the element to add
	 * @return true if the element was added to this queue, else false.
	 * @throws ClassCastException - if the class of the specified element prevents it from being added to this queue
	 * @throws NullPointerException - if the specified element is null and this queue does not permit null elements
	 * @throws IllegalArgumentException - if some property of this element prevents it from being added to this queue
	 */
	public boolean offer(E element);
	
	/**
	 * Retrieves and removes the head of this queue. This method differs from poll only in that 
	 * it throws an exception if this queue is empty.
	 * 
	 * @return the head of this queue
	 * @throws NoSuchElementException - if this queue is empty
	 */
	public E remove();
	
	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public E poll();
	
	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 * 
	 * @return the head of this queue, or null if this queue is empty
	 */
	public E peek();
}
