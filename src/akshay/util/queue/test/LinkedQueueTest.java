package akshay.util.queue.test;

import java.util.NoSuchElementException;

import akshay.util.queue.LinkedQueue;
import akshay.util.queue.Queue;

/**
 * 
 * @author AShanbhag
 *
 * @see 
 *
 * @Date Aug 31, 2015
 */
public class LinkedQueueTest
{
	public static void main(String[] args)
	{
		Queue<Integer> queue = new LinkedQueue<>();
		
		for(int i = 1; i<11; i++)
		{
			queue.add(i);
		}
		
		for(int i = 11; i<21; i++)
		{
			queue.offer(i);
		}
		
		System.out.println(queue);
		
		queue.add(21);
		System.out.println(queue);
		
		System.out.println(queue.contains(15));
		System.out.println(queue.contains(22));
		
		System.out.println(queue.element());
		System.out.println(queue.element());
		
		System.out.println(queue.remove(21));
		System.out.println(queue);
		
		System.out.println(queue.remove(21));
		System.out.println(queue);
		
		System.out.println(queue.remove(15));
		System.out.println(queue);
		
		System.out.println(queue.remove(1));
		System.out.println(queue);
		
		System.out.println(queue.size());

		System.out.println(queue.peek());
		System.out.println(queue.peek());

		System.out.println(queue.poll());
		System.out.println(queue);
		
		System.out.println(queue.poll());
		System.out.println(queue);
		
		queue.clear();
		System.out.println(queue);
		
		System.out.println(queue.peek());
		System.out.println(queue.poll());
		
		try
		{
			queue.element();
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
		
		try
		{
			queue.remove();
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
