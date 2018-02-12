

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import ua.princeton.lib.StdIn;
import ua.princeton.lib.StdOut;

public class LinkedQueue<Item>{
	private Node first,last;
	private int count =0;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void engueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		count++;
		if (isEmpty())
			first = last;
		else
			oldLast.next=last;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		count--;
		if (isEmpty()) last =null;
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return count;
	}

	
	 public static void main(String[] args) throws FileNotFoundException {
			
			final String testFile = "to.txt";
			
			LinkedQueue deque = new LinkedQueue();
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(testFile));
			System.setIn(in);
			while(!StdIn.isEmpty()){
				String s = StdIn.readString();
				if (s.equals("-"))
					StdOut.print(deque.dequeue()+" ");
				else
					deque.engueue(s);
			}
			StdOut.print(deque.size());
		}
	
}
