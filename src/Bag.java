
import java.util.Iterator;
import java.util.NoSuchElementException;

import ua.princeton.lib.StdIn;
import ua.princeton.lib.StdOut;


public class Bag<Integer> implements Iterable<Integer> {
    private Node<Integer> first;     
    private int n;                

  
    private static class Node<Integer> {
        private Integer item;
        private Node<Integer> next;
    }

    
    public Bag() {
        first = null;
        n = 0;
    }

    
    public boolean isEmpty() {
        return first == null;
    }

    
    public int size() {
        return n;
    }

     
    public void add(Integer item) {
        Node<Integer> oldfirst = first;
        first = new Node<Integer>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }


    
    public Iterator<Integer> iterator()  {
        return new ListIterator<Integer>(first);  
    }

     
    private class ListIterator<Integer> implements Iterator<Integer> {
        private Node<Integer> current;

        public ListIterator(Node<Integer> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            Integer item = current.item;
            current = current.next; 
            return item;
        }
    }

}