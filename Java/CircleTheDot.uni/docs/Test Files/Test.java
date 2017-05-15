/*
 * Test.java
 *
 * Copyright 2016 Ryan Fleck <rflec028@uottawa.ca>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */


public class Test {
	

    private static Pair testMember;
	private static Pair nullTestMember;
	
	public static LinkedStack TestStack;
	public static LinkedQueue TestQueue;

    public static void main (String args[]) {
		
		//STACK testing section
		System.out.println("Stack testing: \n");
		TestStack = new LinkedStack();
		
		testMember = new Pair(1,1);
		nullTestMember = new Pair(null,null);
		
		TestStack.push(testMember);
		
		System.out.print("Peeking...   ");
		TestStack.peek();
		System.out.println("Peek successful!");
		
		
		System.out.println("Popping... ");
		TestStack.pop();
		System.out.println("Pop successful!");
		
		/*
		System.out.println("Popping again... ");
		TestStack.pop();
		System.out.println("Second pop successful!");
		*/
		
		
		
		//QUEUE testing section
		System.out.println("Queue testing: \n");
		TestQueue = new LinkedQueue();
		TestQueue.enqueue(null);
		System.out.println("Member Queued.");
		TestQueue.dequeue();
		System.out.println("Member Dequeued.");
		TestQueue.dequeue();
		System.out.println("Member Dequeued.");

    }
}

