package akshay.util.stack.test;

import akshay.util.stack.LinkedListStack;
import akshay.util.stack.Stack;

/**
 * 
 * @author AShanbhag
 *
 * @see 
 *
 * @Date Aug 26, 2015
 */
public class LinkedListStackTest
{
	public static void main(String[] args)
	{
		Stack<Integer> stack = new LinkedListStack<>();
		
		for(int i=1; i<=19; i++)
		{
			stack.push(i);
		}
		for(int i=0;i<16;i++)
		{
			stack.pop();
		}
		
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.search(3));
		System.out.println(stack.search(2));
		System.out.println(stack.search(1));
		System.out.println(stack.search(4));
		System.out.println(stack.empty());
		
		stack.push(null);
		
		System.out.println(stack.search(null));
		System.out.println(stack.peek());
	}
}
