package akshay.util.stack;

/**
 * 
 * @author AShanbhag
 *
 * @see 
 *
 * @Date Aug 26, 2015
 */
public class LinkedListStack<E> implements Stack<E>
{
	private Node<E> top = null;
	private int size;
	
	@Override
	public E push(E element)
	{
		size++;
		Node<E> nodeToInsert = new Node<E>(element, top);
		top = nodeToInsert;
		return nodeToInsert.element;
	}

	@Override
	public E pop()
	{
		E oldElement = top.element;
		top = top.previous;
		return oldElement;
	}

	@Override
	public E peek()
	{
		return top.element;
	}

	@Override
	public boolean empty()
	{
		return top == null;
	}

	@Override
	public int search(Object o)
	{
		int positionFromTop = 0;
		Node<E> currentNode = top;
		
		while(currentNode!= null)
		{
			positionFromTop++;
			if(currentNode.element==null && o== null)
			{
				return positionFromTop;
			}
			else
			{
				if(currentNode.element!=null && currentNode.element.equals(o))
				{
					return positionFromTop;
				}
			}
			currentNode = currentNode.previous;
		}
		return -1;
	}
	
	private static class Node<E>
	{
		E element;
		Node<E> previous;
		
		Node(E element, Node<E> previous)
		{
			this.element = element;
			this.previous = previous;
		}
	}

}
