package akshay.util.list;



public class ArrayList<E> implements List<E>
{
	private static final int INITIAL_CAPACITY = 10;
	private Object[] elements;
	private int size;
	private static final int MAX_ELEMENTS = Integer.MAX_VALUE - 8;
	private transient int modCount = 0;
	
	public ArrayList()
	{
		this(INITIAL_CAPACITY);
	}
	
	public ArrayList(int size)
	{
		elements = new Object[size];
	}
	
	@Override
	public boolean add(E element) 
	{
		ensureCapacity();
		elements[size++] = element;
		
		return true;
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
		else
		{
			modCount++;
		}
	}
	
	private void ensureCapacity(int size)
	{
		modCount++;
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
	public void add(int index, E element) 
	{
		ensureCapacity();
		size++;
		System.arraycopy(elements, index, elements, index+1, size - index);
		elements[index] = element;
	}

	@Override
	public void clear() 
	{
		modCount++;
		elements = new Object[INITIAL_CAPACITY];
	}

	@Override
	public boolean contains(Object o) 
	{
		return indexOf(o) != -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) 
	{
		rangeCheck(index);
		return (E)elements[index];
	}
	
	private void rangeCheck(int index) 
	{
		if(index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
	}

	@Override
	public int indexOf(Object o) 
	{
		for(int i=0; i<elements.length; i++)
		{
			if(elements[i] == null && o == null)
			{
				return i;
			}
			else if(elements[i]!=null && elements[i].equals(o))
			{
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E remove(int index) 
	{
		rangeCheck(index);
		E oldElement = (E)elements[index];
		modCount++;
		
		System.arraycopy(elements, index+1, elements, index, size - index-1);
		
		elements[--size] = null;
		
		//If elements reduce to quarter of the size of the array, reduce the length of the array by half.
		if(size < elements.length/4 && elements.length/2 >= INITIAL_CAPACITY)
		{
			Object[] temp = new Object[elements.length/2];
			System.arraycopy(elements, 0, temp, 0, size);
			elements = temp;
		}
		
		return oldElement;
	}

	@Override
	public boolean remove(Object o) 
	{
		int index = indexOf(o);
		if(index == -1)
		{
			return false;
		}
		
		modCount++;
		
		remove(index);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E set(int index, E element) 
	{
		modCount++;
		E oldElement = (E)elements[index];
		
		elements[index] = element;
		
		return oldElement;
	}

	@Override
	public int size() 
	{
		return size;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		if(size > 0)
		{
			for(int i = 0; i < size - 1; i++)
			{
				sb.append(elements[i]);
				sb.append(", ");
			}
			sb.append(elements[size-1]);
		}
		sb.append("]");
		
		return sb.toString();
	}
}
