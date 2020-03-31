package akshay.util.stack;

import java.util.EmptyStackException;

import akshay.util.list.ArrayList;

/**
 * Array backed implementation of {@link Stack} interface.
 * 
 * @author AShanbhag
 *
 * @see 
 *
 * @Date Aug 24, 2015
 */
public class ArrayStack<E> implements Stack<E>
{
	//Also represents the position where the next object is to be inserted in the stack
	private int size = 0;
	private Object[] elements;
	private static final int MAX_ELEMENTS = Integer.MAX_VALUE - 8;
	private static final int INITIAL_CAPACITY = 10;
	
	public ArrayStack()
	{
		elements = new Object[INITIAL_CAPACITY];
	}
	
	public ArrayStack(int capacity)
	{
		elements = new Object[capacity];
	}
	
	@Override
	public E push(E element)
	{
		ensureCapacity();
		elements[size++] = element;
		return element;
	}
	
	/**
	 * Ensures that there is space for an element to be added to the list.
	 * If the backed array is full, a new array is created with double the size 
	 * and the elements of the old array will be copied to the new array.
	 * If the size exceeds {@link ArrayList#MAX_ELEMENTS}, {@link IllegalStateException} will be thrown
	 * indicating that the list cannot be further grown.
	 */
	private void ensureCapacity()
	{
		if(size == elements.length)
		{
			ensureCapacity(elements.length * 2 + 1);
		}
	}
	
	private void ensureCapacity(int size)
	{
		int newCapacity = size;
		
		if(newCapacity > MAX_ELEMENTS)
		{
			newCapacity = MAX_ELEMENTS;
		}
		
		if(size == MAX_ELEMENTS)
		{
			throw new IllegalStateException("No more elements can be added to the ArrayList");
		}
		
		Object[] temp = new Object[newCapacity];
		System.arraycopy(elements, 0, temp, 0, elements.length);
		elements = temp;
	}

	@Override
	@SuppressWarnings("unchecked")
	public E pop()
	{
		
		E popedElement = (E)elements[size-1];
		
		elements[--size] = null;
		
		//If elements reduce to quarter of the size of the array, reduce the length of the array by half.
		if(size < elements.length/4 && elements.length/2 >= INITIAL_CAPACITY)
		{
			Object[] temp = new Object[elements.length/2];
			System.arraycopy(elements, 0, temp, 0, size);
			elements = temp;
		}
		
		return popedElement;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E peek()
	{
		if(size == 0)
		{
			throw new EmptyStackException();
		}
			
		return (E) elements[size-1];
	}

	@Override
	public boolean empty()
	{
		return size == 0;
	}

	@Override
	public int search(Object o)
	{
		int countFromTop = 0;
		
		for(int i = size-1; i >= 0; i--)
		{
			countFromTop ++ ;
			if(elements[i] == null && o == null)
			{
				return countFromTop;
			}
			else
			{
				if(elements[i]!=null && elements[i].equals(o))
				{
					return countFromTop;
				}
			}
		}
		
		return -1;
	}

}
