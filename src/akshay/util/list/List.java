package akshay.util.list;

import akshay.util.Collection;

public interface List<E> extends Collection<E> 
{
	/**
	 * Appends the specified element to the end of this list (optional operation).
	 * @param element element to be appended to this list.
	 * @return boolean value indicating weather the element was added to the collection.
	 */
	public boolean add(E element);
	
	/**
	 * Inserts the specified element at the specified position in this list (optional operation). 
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
	 * @param index index at which the specified element is to be inserted
	 * @param element element to be inserted
	 */
	public void add(int index, E element);
	
	/**
	 * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned 
	 * by the specified collection's iterator (optional operation). 
	 * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress. 
	 * (Note that this will occur if the specified collection is this list, and it's nonempty.)
	 * 
	 * @param c {@link Collection} containing elements to be added to this list
	 * @return true if this list changed as a result of the call
	 */
	/*public boolean addAll(Collection<? extends E> c);*/
	
	/**
	 * Inserts all of the elements in the specified collection into this list at the specified position (optional operation).
	 * 
	 * @param index  index at which to insert the first element from the specified collection
	 * @param c {@link Collection} containing elements to be added to this list
	 * 
	 * @return true if this list changed as a result of the call
	 */
	/*public boolean addAll(int index, Collection<? extends E> c);*/
	
	/**
	 * Removes all of the elements from this list (optional operation). The list will be empty after this call returns.
	 */
	public void clear();
	
	/**
	 * Returns true if this list contains the specified element. 
	 * More formally, returns true if and only if this list contains at least one element e 
	 * such that (o==null ? e==null : o.equals(e)).
	 * @param o element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 */
	public boolean contains(Object o);
	
	/**
	 * 
	 * @param c
	 * @return
	 */
	/*public boolean containsAll(Collection<?> c);*/
	
	/**
	 * Returns the element at the specified position in this list.
	 * @param index index of the element to return
	 * @return Returns the element at the specified position in this list.
	 */
	public E get(int index);
	
	/**
	 * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. 
	 * More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
	 * @param o element to search for
	 * @return the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
	 */
	public int indexOf(Object o);
	
	/**
	 * Returns true if this collection contains no elements.
	 * @return true if this collection contains no elements
	 */
	public boolean isEmpty();
	
	/**
	 * Removes the element at the specified position in this list (optional operation). 
	 * Shifts any subsequent elements to the left (subtracts one from their indices). Returns the element that was removed from the list.
	 * @param index  the index of the element to be removed
	 * @return the element previously at the specified position
	 */
	public E remove(int index);
	
	/**
	 * Removes a single instance of the specified element from this list, if it is present (optional operation). 
	 * More formally, removes an element e such that (o==null ? e==null : o.equals(e)), if this list contains one or more such elements. 
	 * Returns true if this list contained the specified element (or equivalently, if this list changed as a result of the call).
	 * @param o element to be removed from this list, if present
	 * @return true if an element was removed as a result of this call
	 */
	public boolean remove(Object o);
	
	/**
	 * Replaces the element at the specified position in this list with the specified element (optional operation).
	 * @param index index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 */
	public E set(int index, E element);
	
	/**
	 * Returns the number of elements in this collection.
	 * @return Returns the number of elements in this collection.
	 */
	public int size();
}
