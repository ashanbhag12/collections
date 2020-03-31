package akshay.util.stack;

import java.util.EmptyStackException;

/**
 * The Stack data structure represents a last in first out data structure.
 * 
 * 
 * @author AShanbhag
 *
 * @see 
 *
 * @Date Aug 24, 2015
 */
public interface Stack<E>
{
	/**
	 * Pushes an item onto the top of this stack.
	 * @param element - The item to be pushed onto this stack.
	 * @return the <code>item</code> argument.
	 */
	public E push(E element);
	
	/**
	 * Removes the object at the top of this stack and returns that object as the value of this function.
	 * @return The object at the top of this stack
	 * @throws EmptyStackException  if this stack is empty.
	 */
	public E pop();
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * @return The object at the top of this stack
	 * @throws  EmptyStackException  if this stack is empty.
	 */
	public E peek();
	
	/**
	 * Tests if this stack is empty.
	 * @return <code>true</code> if and only if this stack contains no items; <code>false</code> otherwise.
	 */
	public boolean empty();
	
	/**
	 * Returns the 1-based position from the top of the stack where an object is on this stack.
	 * @param o The object to be searched.
	 * @return the 1-based position from the top of the stack where
     *          the object is located; the return value <code>-1</code>
     *          indicates that the object is not on the stack.
	 */
	public int search(Object o);
}
