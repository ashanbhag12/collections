package akshay.util;

public interface Collection<E> 
{
	/**
	 * Ensures that this collection contains the specified element (optional operation).
	 * @param element Element to be added to the collection.
	 * @return boolean value indicating weather the element was added to the collection.
	 */
	public boolean add(E element);
	
	/**
	 * Adds all of the elements in the specified collection to this collection (optional operation).
	 * @param collection collection containing elements to be added to this collection
	 * @return true if this collection changed as a result of the call
	 */
	/*public boolean addAll(Collection<? extends E> collection);*/
	
	/**
	 * Removes all of the elements from this collection (optional operation). 
	 * The collection will be empty after this method returns.
	 */
	public void clear();
	
	/**
	 * Returns true if this collection contains the specified element. 
	 * More formally, returns true if and only if this collection contains at least one element e 
	 * such that (o==null ? e==null : o.equals(e)).
	 * @param o element whose presence in this collection is to be tested
	 * @return true if this collection contains the specified element
	 */
	public boolean contains(Object o);
	
	/**
	 * Returns true if this collection contains no elements.
	 * @return true if this collection contains no elements
	 */
	public boolean isEmpty();
	
	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation). 
	 * More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if this collection contains one or more such elements. 
	 * Returns true if this collection contained the specified element (or equivalently, if this collection changed as a result of the call).
	 * @param o element to be removed from this collection, if present
	 * @return true if an element was removed as a result of this call
	 */
	public boolean remove(Object o);
	
	/**
	 * Returns the number of elements in this collection.
	 * @return Returns the number of elements in this collection.
	 */
	public int size();
}
