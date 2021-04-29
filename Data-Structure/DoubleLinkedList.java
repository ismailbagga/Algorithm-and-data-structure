package Arrays;

import java.util.Iterator;
@SuppressWarnings("hiding")
public class DoubleLinkedList<T> implements Iterable<T>{
	private Node<T> head , tail ; 
	private int len ; 
	
	private class Node<T> {
		Node<T> next , prev  ; 
		T node ; 
		public Node (T node, Node<T> next,Node<T> prev ){
			this.node = node ;
			this.next = next ; 
			this.prev = prev ; 
		}
	}
	
	// Q(1)
	public T peekLast() {return tail.node ; }
	// Q(1)
	public T peekfirst() {return head.node ; }
	// Q(1) 
	public boolean isEmpty() { return len == 0 ; }
	// Q(1) 
	public int len() {return len ; }
	// Q(1) 
	public void addAthead(T elem ) {
		if ( head == null ) {head = tail = new  Node<T>(elem ,null , null)  ; }
		else {
			head.prev = new Node<T>(elem,head,null); 
			head = head.prev ;  
		}
		len++ ; 
	}
	// Q(1) 
	public void  addAttail(T elem) {
		if ( head == null ) {
			tail = head = new Node<T>(elem,null,null) ; 
		}
		else {
			tail.next = new Node<T>(elem,null,tail) ; 
			tail = tail.next ; 
		}
		len++ ; 
	}
	// Q(1) 
	public void add(T elem) {addAttail(elem) ; } 
	// Q(n/2) = Q(n)  
	public void  insert(int index , T elem ) {
		if ( index < 0  || index > len ) throw new IndexOutOfBoundsException() ; 
		if ( index == len ) {addAttail(elem) ; }
		else if (index == 0 ) {addAthead(elem ) ; }
		else { 
			
			if (index > len-1/2) {	
				Node<T> ref = tail ;
				for (int i = len-1 ; ref != null   ; ref = ref.prev , i-- ) {
					if ( index == i ) {
						Node<T> node = new Node<T>(elem,ref,ref.prev)  ; 
						ref.prev.next   =  node; 
						ref.prev = node ; len++ ; return  ; } }}
			else  {	
				Node<T> ref = head ;
				for (int i = 0 ; ref != null ; ref = ref.next , i++ ) {
					if ( i == index) {
						Node<T> node = new Node<T>(elem,ref,ref.prev)  ; 
						ref.prev.next   =  node; 
						ref.prev = node ; 
					len++ ; return  ; 
					}}}
			
		}
	}
	// Q(n/2) = Q(n) 
	public T get(int index ) {
		if ( index < 0  || index >= len ) throw new IndexOutOfBoundsException() ; 
		if ( index >= len/2 ) {
			Node<T> ref = tail  ;
			for (int i = len-1  ; ref != null ; ref =ref.prev , i--) {
				   if (i == index ) {return ref.node ;  }
					 }
				
				return null ; 
		}
		else {
			Node<T> ref = head ;
		for (int i = 0  ; ref != null ; ref =ref.next , i++) {
		   if (i == index ) {return ref.node ;  }
			 }
		
		return null ; 
		}
		
	}
	// Q(n)
	public void clear() {
		Node<T> ref ,temp ; 
		ref = temp  =  head ; 
		while ( ref != null ) {
			ref = ref.next ;
			temp.prev = temp.next = null  ; 
			temp.node = null ; 
			temp = ref ; 
		}
		head = tail = null ; 
		len =  0 ; 
	}
	// Q(n)
	
	public boolean contain(T elem ) {
		return IndexOf(elem) != -1  ; 
	}
	public int IndexOf(T elem ) {
		Node<T> ref = head ;
		  for (int i= 0;  ref != null ; ref = ref.next , i++ ) {
			  if ( ref.node == null || elem == null) {
				  if (ref.node == elem) {return i ;  }
			  }
			  else { if  ( ref.node.equals(elem) || ref.node == elem ) {return i ; } }
	  } 
	  
	 
	  return -1 ; 
	}
	public  void removeAthead() {
		if (  ! isEmpty()  ) {
			if ( len == 1 ) { head = tail = null ; }
			else {
			Node<T> node = head ; 
			head.next.prev = null ; 
			head = head.next ;
			node.next = node.prev = null  ;
			node.node = null ;
			}
			 len --  ; 
		}	
	}
	public void removeAttail() {
		if ( ! isEmpty() ) {
			if ( len ==  1 ) {tail = head = null ;}
			else { 
			 Node<T> node = tail ; 
			 tail.prev.next = null ; 
			 tail = tail.prev ; 
			 node.next = node.prev = null ; 
			 node.node = null ; }
			 len --  ; 
		}
	}
	
	public void  remove(T elem ) {
	  if ( head.node.equals(elem)) {removeAthead() ;}
	  else if ( tail.node.equals(elem)) {removeAttail(); }
	  else {
		  
		  for (Node<T> ref = head ; ref != null ; ref= ref.next) {
			  if ( ref.node == null || elem == null  ) {
				  if (ref.node == elem ) {
					  ref.prev.next = ref.next ; 
					  ref.next.prev = ref.prev ; 
					  ref.node = null ; ref.next = ref.prev = null ; 
					  len-- ; break  ; 
				  }
				  
			  }
			  if (ref.node.equals(elem)) {
				  ref.prev.next = ref.next ; 
				  ref.next.prev = ref.prev ; 
				  ref.node = null ; ref.next = ref.prev = null ; 
				  len-- ; break  ; 
			  }
		  }
	  }
	}
	public  T removeAt(int index) {
		if  (index < 0 || index >= len ) throw new IndexOutOfBoundsException() ; 
		if ( index == 0) {removeAthead() ;return head.node ;}
		else if ( index == len-1) {removeAttail() ; return tail.node ; }
		else {
			Node<T> ref = head ; 
			for (int i = 0 ; ref != null ; i++ , ref = ref.next ) {
				if (index == i ) {
					T data = ref.node ; 
					ref.prev.next = ref.next ;
					ref.next.prev = ref.prev ; 
					ref.node = null ; ref.next = ref.prev = null ; len-- ;return data ; 
				}
			}
		}
		return null ; 
		
	} 
	@SuppressWarnings("unused")
	private void removeObj(Node<T> elem ) {
		if (elem.prev == null ) { removeAthead() ; }
		else if (elem.next == null ) {removeAttail() ;}
		else {
			for ( Node<T> ref = tail ; ref != null ; ref = ref.prev  ) {
				if (ref.equals(elem)) {
					ref.prev.next = ref.next ;
					ref.next.prev = ref.prev ; 
					ref.node = null ; ref.next = ref.prev = null ; len-- ;
				}
			}
		}
	}
	public void  print() {
		Node<T> ref = head ; 
		String arr  = "[ " ; 
		for ( ; ref != null ; ref = ref.next ) {
			arr += ref.node ; 
			if (ref.next != null) {
				arr +=  " ; " ; 
			}
		}
		arr += " ]" ; 
		System.out.println(arr);
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			private Node<T> ref = head ; 
			@Override
			public T next() { T data = ref.node ;  ref = ref.next ; return data ; }
			@Override
			public boolean hasNext() {
				return ref != null ; 
			}
			@Override 
			public void remove() {
				throw new UnsupportedOperationException() ;
			}
		};
	}
	
}
