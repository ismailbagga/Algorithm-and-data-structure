package Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
@SuppressWarnings("hiding")
public class Queue<T> implements Iterable<T>  {
	private Node<T> head , tail ; 
	private int len  = 0 ; 
	java.util.LinkedList<T> list = new java.util.LinkedList<T>() ; // using the built in Double linked list 
	// but we going to use single linked list to make it harder 
	private  class Node <T>{ 
		private  T node ;
		private   Node<T> next ;
		
		public Node (T node ,Node<T> next ) {
			this.node = node ;
			this.next = next ; }}
	public int len() {return len ; }
	public void  enqueue(T elem ) {
		if ( head == null ) { head = tail = new Node<T>(elem,null) ; }
		else { tail.next = new Node<T>(elem,null) ; tail = tail.next  ; } 
		len++ ; 
	}
	public T  dequeue()  {
		if ( len == 0) throw new EmptyStackException() ; 
		T data = head.node; head.node = null ;  head = head.next;len--; return data ;  }
	public boolean contain(T elem ) { 
		for (Node<T> ref = head ; ref != null ; ref = ref.next ){
	        if (elem.equals(ref.node)) {return true ; }
	        	} 
		return false ; 
		}
	public T peekFrist() {return head.node ; }
	public T peeklast() {return tail.node ; }
	public boolean  remove ( T elem ) {
		if  (elem.equals(head.node)) {dequeue(); return true ;  }
		Node<T> ref , node ; 
		ref =node =  head ; 
		while ( ref != null) {
			if (ref.node.equals(elem)) {
				
				node.next = ref.next ; 
				if(ref.next == null ) {tail = node ; }
				ref.node = null ; ref.next = null ; len-- ; 
				return true ; 
			}
			node = ref ; 
			ref = ref.next ; 
		}
		
		return false  ; 
	}
	
	
	
	
	
	
	
	
	public void  print() {
		Node<T> ref = head ;
		String s = "[ " ; 
		while ( ref != null ) {
			s += ref.node ; 
			if ( ref.next != null ) s+=" , "  ; 
			ref = ref.next ; 
		}
		s += " ]" ; 
		System.out.println(s);
		
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
