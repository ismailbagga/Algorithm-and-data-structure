package Arrays;
import java.util.Iterator;
@SuppressWarnings("hiding")
public class SingleLinkedList <T> implements Iterable<T> {
	private int len ; 
	private Node<T>  head  ; 
	private Node<T> tail; 
	private  class Node <T>{ 
		private  T node ;
		private   Node<T> next ;
		
		public Node (T node ,Node<T> next ) {
			this.node = node ;
			this.next = next ; }}
	public void clear() {
		Node <T> ref  ,  temp ;
		ref = temp = head ;
		while ( ref != null ) {
			ref = ref.next ;
			temp.node  = null ;
			temp.node = null ; 
			temp = ref ; 
			
		}
		head = tail = null ; 
		len = 0  ; 
	}
	public int  len( ) {
		return len ;
	}
	public int indexOf(Object elem) {
		Node<T> ref = head ; 
		if (elem == null ) {
			for (int i = 0 ; ref != null ; ref = ref.next ,i++) {
				if ( ref.node == null) {return i ;  }
			}
		}
		else {
			for (int i = 0 ; ref != null ; ref = ref.next ,i++) {
			if (ref.node == null  ) {continue ; } 
			if (ref.node.equals(elem)) {return i ; }
		}
		}
		
		return -1 ; 
	}
	public boolean contain(Object elem ) {
		return indexOf(elem) != -1  ; 
	}
	public void reverse() {
		 if (len < 2   ) {return ; } // there is no need to create those variables 
		 Node<T> ref , temp , node ; 
		 ref = temp = head ;
		 node = ref.next ; 
		 ref.next = null ;
		 tail = ref ; 
		 while (node != null ) {
			 temp = node ; node = node.next ; 
			 temp.next = ref ; 
			 ref = temp ; 
		 }
		 head = temp  ; 
	}
	public T get(int index) {
		if (index < 0 || index >=  len  ) throw new IndexOutOfBoundsException(index +" index out of range ");
		if (index == 0 ) {
			return head.node ; 
		}
		if (index == len-1 ) {
			return tail.node ; 
		}
		Node<T> ref  = head  ;
		for ( int i = 0 ; i< index ; i++) {
			ref = ref.next ;}
		return ref.node ; 
	}
	public void insert(int index   ,T elem ) {
		if (index < 0 || index >=  len  ) throw new IndexOutOfBoundsException(index +" index out of range ");
		if ( index ==  0 ) {addAthead(elem) ; return ;}
		if ( index == len ) {addAttail(elem) ; return ; }
		Node<T> ref = head ; 
		for ( int i = 0 ; i < index-1;i++) {ref = ref.next ; }
		Node<T> newnode = new Node<T>(elem,ref.next) ;
		ref.next = newnode ; 
		len++ ; 
		
	}
	public void add(T elem ) {addAttail(elem) ; }
	public  void addAttail(T elem ) {
		if ( head == null ) {
			tail = head = new Node<T>(elem,null) ; 
		}
		else {
		tail.next = new Node<T>(elem,null) ;
		tail = tail.next ; 
		}
		
		len++ ; 
	}
	public void addAthead(T elem ) {
		
		if ( head == null ) {
			tail = head= new Node<T>(elem,null) ; 
		}
		else {
			head  = new Node<T>(elem,head) ; 
		}
		len++ ; 
	}
	public void removeHead() {
		head.node = null ; 
		head = head.next ; 
	}
	@SuppressWarnings("unused")
	private   void removeObj(Node<T>  obj) {
		int i= 0 ;
		Node<T> ref = head ; 
		while (ref != null ) {
			if ( ref.equals(obj)) {removeAt(i);return ;}
			i++ ;ref = ref.next ; 
		}
	}
	public void removeAt(int index) {
		boolean istail = false;
		if (index == 0 ) {removeHead( ); return  ; }
		if (index == len-1) {istail=true ; }
		Node<T> temp  ,ref ; 
		temp = ref =head ; 
		for (int i = 0 ; i <index ; i++) {
			if (i == index-1 ) {temp = ref ;}
			ref = ref.next ; 
		}
		
		temp.next = ref.next ; 
		ref.node = null ;  
		ref.next = null ; 
		if ( istail ) {
			tail = temp ; 
		}
	}
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> ref = head  ; 
			@Override 
			public boolean hasNext() {
				return (ref != null) ;
			}
			@Override 
			public T next() {
				T data = ref.node ; 
				ref = ref.next ;
				return data ; 
				
			}
			@Override 
			public void remove() {
				 throw new  UnsupportedOperationException() ; 
				
			}
		}; 
	}
	public void print() {
		String strarr = "[ " ;
		Node<T> ref  =  head ;  
		String op = " , " ; 
		while (ref  != null  ) {
			if (ref.next == null ) {
				op = " " ; 
				
			}
			strarr += ref.node+ op ;
			ref =ref.next ; 
		}
		System.out.println(strarr+"]") ; 
	}
}

