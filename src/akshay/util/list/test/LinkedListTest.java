package akshay.util.list.test;

import akshay.util.list.LinkedList;
import akshay.util.list.List;

/**
 * @author AShanbhag
 *
 * @see 
 *
 * @Date Aug 24, 2015
 */
public class LinkedListTest
{
	public static void main(String[] args) 
	{
		List<Integer> list = new LinkedList<>();
		
		for(int i = 1; i < 18; i++)
		{
			list.add(i);
		}
		
		System.out.println(list);
		
		list.add(18);
		
		System.out.println(list);
		
		list.add(0,0);
		
		System.out.println(list);
		
		System.out.println(list.contains(10));
		
		System.out.println(list.get(2));
		
		System.out.println(list.indexOf(2));
		
		System.out.println(list.indexOf(50));
		
		System.out.println(list.isEmpty());
		
		list.remove(0);
		
		for(int i=0;i<12;i++)
		{
			list.remove(0);
		}
		
		System.out.println(list);
		
		
	}
}
