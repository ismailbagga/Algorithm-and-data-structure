package Arrays;
@SuppressWarnings("hiding")
public class stack<T> implements Iterable<T> {
	private int  len ; 
	private Node<T> head ; 
	
	private class Node<T> {
		private T node ; 
		private Node<T> next  ; 
		public Node(T node , Node<T> next ) {
			this.node = node ; 
			this.next = next ; 
		}}
	public stack() {}
	public stack(T elem) {push(elem) ; }
	public void push(T elem ) {
		head = new Node<T>(elem,head) ;  
		len++ ; 
		}
	public T pop() {
		if (len == 0 ) return null ; 
		Node<T> ref = head ; 
		T data = head.node ; 
		head = head.next ; 
		ref.next = null ; ref.node = null ; ref = null ; 
		len-- ; 
		return data ; 
	}
	public boolean isEmpty() {return len == 0 ; }
	public T  peek() {return head.node ;}
	public int len() {return len ;  }
	public boolean contain(T elem ) {
		for (Node<T> ref = head ; ref != null ; ref = ref.next  ) {
			if ( ref.node.equals(elem)) return true ; 
		}
		return false ; 
	}
	public void clear( ) {
		Node<T> ref = head ; 
		while (ref != null ) {
			Node<T> next = ref.next ; 
			ref.next  = null ; ref.node = null ;  
			ref = next  ; 
		}
		head = null  ; len = 0 ;
		 
	}
	public void print() {
		String strarr = "[" ;
		for (Node<T> ref = head ; ref != null ; ref = ref.next) {
			strarr += ref.node ; if (ref.next != null ) {strarr +=" , " ;}
		}
		strarr += "]" ;
		System.out.println(strarr);
	}
	
	
	@Override
	public java.util.Iterator<T> iterator() {
		return new java.util.Iterator<T>() {
			Node<T> ref = head ; 
		   @Override 
		   public T next() {T data = ref.node ; ref = ref.next ; return data ; }
		   public boolean hasNext() { return ref != null ; }
		   public void remove() {throw new UnsupportedOperationException() ; }
		} ;
	}

	
	

}
