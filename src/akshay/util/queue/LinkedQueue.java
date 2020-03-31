package akshay.util.queue;

import java.util.NoSuchElementException;

/**
 * Double Linked List representation of a queue.
 * 
 * @author AShanbhag
 *
 * @see 
 *
 * @Date Aug 28, 2015
 */
public class LinkedQueue<E> implements Queue<E>
{
	private Node<E> head;
	private Node<E> tail;
	private int size;

	@Override
	public boolean add(E element)
	{
		size++;
		if(tail == null)
		{
			Node<E> nodeToInsert = new Node<E>(element, null, null);
			head = tail = nodeToInsert;
			return true;
		}
		else
		{
			Node<E> nodeToInsert = new Node<E>(element, null, tail);
			tail.next = nodeToInsert;
			tail = nodeToInsert;
		}
		return true;
	}

	@Override
	public void clear()
	{
		size = 0;
		head = tail = null;
	}

	@Override
	public boolean contains(Object o)
	{
		Node<E> temp = head;
		while(temp != null)
		{
			if(o == null && temp.element == null)
			{
				return true;
			}
			else if(o != null && o.equals(temp.element))
			{
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	@Override
	public boolean isEmpty()
	{
		return tail == null;
	}

	@Override
	public boolean remove(Object o)
	{
		Node<E> temp = head;
		Node<E> nodeToDelete = null;
		
		while(temp != null)
		{
			if(temp.element == null && o == null)
			{
				nodeToDelete = temp;
				break;
			}
			else if(o!= null && o.equals(temp.element))
			{
				nodeToDelete = temp;
				break;
			}
			temp = temp.next;
		}
		if(nodeToDelete != null)
		{
			size--;
			if(head == tail && nodeToDelete == head)
			{
				head = tail = null;
				return true;
			}
			else if(head == nodeToDelete)
			{
				head = nodeToDelete.next;
				nodeToDelete.next = null;
				head.previous = null;
				return true;
			}
			else if(tail == nodeToDelete)
			{
				tail = nodeToDelete.previous;
				nodeToDelete.previous = null;
				tail.next = null;
				return true;
			}
			else
			{
				nodeToDelete.previous.next = nodeToDelete.next;
				nodeToDelete.next.previous = nodeToDelete.previous;
				nodeToDelete.previous = null;
				nodeToDelete.next = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public E element()
	{
		if(size == 0)
		{
			throw new NoSuchElementException("Queue is empty");
		}
		return head.element;
	}

	@Override
	public boolean offer(E element)
	{ 
		return add(element);
	}

	@Override
	public E remove()
	{
		if(size == 0)
		{
			throw new NoSuchElementException("Queue is empty");
		}
		E element = head.element;
		
		Node<E> temp = head;
		head.next.previous = null;
		head = head.next;
		temp.next = null;
		
		return element;
	}

	@Override
	public E poll()
	{
		E element = null;
		try
		{
			element = remove();
		}
		catch(NoSuchElementException e)
		{
			//Eat the exception. Do not propagate it
		}
		return element;
	}

	@Override
	public E peek()
	{
		E element = null;
		
		try
		{
			element = element();
		}
		catch(NoSuchElementException e)
		{
			//Eat the exception. Do not propagate it.
		}
		return element;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		Node<E> nodeToPrint = head;
		while(true)
		{
			if(nodeToPrint == tail)
			{
				break;
			}
			sb.append(nodeToPrint.element);
			sb.append(", ");
			nodeToPrint = nodeToPrint.next;
		}
		if(tail!=null)
		{
			sb.append(tail.element);
		}
		sb.append("]");
		
		return sb.toString();
	}
	
	private static class Node<E>
	{
		private E element;
		private Node<E> next;
		private Node<E> previous;
		
		Node(E element, Node<E> next, Node<E> previous)
		{
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}

}
