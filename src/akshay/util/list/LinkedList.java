package akshay.util.list;


public class LinkedList<E> implements List<E>
{
	private Node<E> head = null;
	private Node<E> tail = null;
	
	private int size = 0;
	
	@Override
	public boolean add(E element)
	{
		size++;
		if(head == null)
		{
			Node<E> node = new Node<E>(element, null, null);
			head = node;
			tail = node;
		}
		else
		{
			Node<E> node = new Node<E>(element, null, tail);
			tail.next = node;
			tail = node;
		}
		return true;
	}

	@Override
	public void add(int index, E element)
	{
		rangeCheck(index);
		size ++;
		
		Node<E> nodeToInsert;
		if(index == 0)
		{
			nodeToInsert = new Node<>(element,head, null);
			head = nodeToInsert;
			return;
		}
		
		Node<E> temp;
		if(index <= size+1/2)
		{
			temp = head;
			for(int i=0;i<index; i++)
			{
				temp = temp.next;
			}
		}
		else
		{
			temp = tail;
			for(int i=0;i<size-index;i--)
			{
				temp = temp.previous;
			}
		}
		nodeToInsert = new Node<>(element, temp, temp.previous);
		
		if(head == null)
		{
			head = nodeToInsert;
			tail = nodeToInsert;
		}
		else if(tail == temp)
		{
			tail = nodeToInsert;
		}
		else
		{
			temp.previous.next = nodeToInsert;
		}
	}
	
	private void rangeCheck(int index)
	{
		if(index > size)
		{
			throw new IllegalArgumentException("Index out of bound : " + index);
		}
		
		if(index < 0)
		{
			throw new IllegalArgumentException("Negative index : " + index);
		}
	}

	@Override
	public void clear()
	{
		head = null;
		size = 0;
	}

	@Override
	public boolean contains(Object o)
	{
		return indexOf(o) != -1;
	}

	@Override
	public E get(int index)
	{
		rangeCheck(index);
		Node<E> temp;
		if(index <= size+1/2)
		{
			temp = head;
			for(int i=0;i<index; i++)
			{
				temp = temp.next;
			}
		}
		else
		{
			temp = tail;
			for(int i=0;i<size-index;i--)
			{
				temp = temp.previous;
			}
		}
		return temp.element;
	}

	@Override
	public int indexOf(Object o)
	{
		Node<E> temp = head;
		
		for(int i=0; i<size; i++ )
		{
			E element = temp.element;
			
			if(element.equals(o))
			{
				return i;
			}
			
			temp = temp.next;
		}
		return -1;
	}

	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	@Override
	public E remove(int index)
	{
		rangeCheck(index);
		size--;
		
		E element;
		
		Node<E> temp = head;
		for(int i = 0; i < index;i++)
		{
			temp = temp.next;
		}
		
		if(temp == head)
		{
			head = head.next;
			head.previous = null;
			temp.next = null;
			element = temp.element;
		}
		else if(temp == tail)
		{
			tail = tail.previous;
			tail.next = null;
			temp.previous = null;
			element = temp.element;
		}
		else
		{
			temp.previous.next = temp.next;
			temp.next.previous = temp.previous;
			temp.previous = null;
			temp.next = null;
			
			element = temp.element;
		}
		
		return element;
	}

	@Override
	public boolean remove(Object o)
	{
		int index = indexOf(o);
		if(index >= 0)
		{
			remove(index);
			return true;
		}
		return false;
	}

	@Override
	public E set(int index, E element)
	{
		rangeCheck(index);
		size--;
		
		E oldElement;
		
		Node<E> temp = head;
		for(int i = 0; i < index;i++)
		{
			temp = temp.next;
		}
		oldElement = temp.element;
		
		temp.element = element;
		
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
		
		Node<E> temp = head;
		sb.append("[");
		if(size > 0)
		{
			for(int i = 0; i < size - 1; i++)
			{
				sb.append(temp.element.toString());
				sb.append(", ");
				temp = temp.next;
			}
			sb.append(temp.element.toString());
		}
		sb.append("]");
		
		return sb.toString();
	}

	private static class Node<E>
	{
		E element;
		Node<E> next;
		Node<E> previous;

		Node(E element, Node<E> next, Node<E> previous)
		{
			super();
			this.element = element;
			this.next = next;
			this.previous = previous;
		}
	}
}
