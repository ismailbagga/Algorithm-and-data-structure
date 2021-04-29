package Arrays;
@SuppressWarnings("unchecked")
// Implements static array 
public class PQueue<T extends Comparable<T>>{
		private T[]  arr ;
		private int len =  0  ; 
		private int maxsize  = 0 ;
		private int nextchild = 0 ; 
		public PQueue() {this((T[]) new Comparable[16]) ; }
		public PQueue(int size) {
			this.maxsize = size ;
			
		} 
		public PQueue(T[] arr ) {
			this.arr = arr ; 
			this.nextchild =this.len = this.maxsize = arr.length ; 
			for (int i = arr.length-1  ;i >= 0  ; i-- ) {
				
				if ( arr != null ) sink(i) ; 
				else {len = nextchild = i ; }
			}
		}
		public int len() {return len  ; } 
		public boolean isEmpty() {return len == 0 ; }
		public boolean comp(int i ,int j ) {
			return arr[i].compareTo(arr[j]) == -1 ; 
			}
		public  void swap(int a , int b ) {
			T s = arr[a] ;
			arr[a] = arr[b] ; arr[b] = s ;
		}
		public void add(T elem) {
			if ( elem == null) throw new  IllegalArgumentException() ;
			if  (len  == maxsize ) return ; 
			else {
				arr[nextchild] = elem ; 
				swim(nextchild) ; 
				len++ ; nextchild++ ; 
			}
		}
		public void  swim(int index) {
			int parent = (index-1)/2 ;
			while ( index > 0  && comp(index,parent) ) {
				swap(parent,index) ;
				index = parent ;
				parent = (index-1)/2 ; 
				
				 
			}
		
		}
		public T poll() {
			if ( isEmpty() ) throw new RuntimeException() ; 
			T node = arr[0] ;
			int index = --nextchild ; 
			swap(index,0) ;
			arr[index] = null ;
			len-- ; 
			sink(0) ; 
			
			return node ; 
		}
		public boolean   remove(T elem ) {
			for ( int i = 0 ; i < len ; i++) {
				if ( arr[i].equals(elem)) {removeAt(i) ; return true ;} 
				
			}
			return false ; 
		}
		public T removeAt(int index ) {
			if ( index < 0 || index >= len) throw new IndexOutOfBoundsException() ; 
			if (index == 0 ) {return poll() ; }
			swap(index,nextchild-1) ;
			T data = arr[nextchild-1] ;  
			arr[nextchild] = null ; len-- ;nextchild++ ; 
			sink(index) ; 
			swim(index) ; 
			return data; 
			}
		
		
		public void sink(int index) {
			int bi = index ;
			int left , right ; 
			while (true) {
				
				left = 2*index+1 ; 
				right = 2*index+2 ; 
				if ( left < len && comp(left,index )) bi = left ; 
				if  (right < len && comp(right,bi))  bi = right ;
				if ( index == bi ) break ; 
				swap(index,bi) ; 
				index = bi ; 
			}
		}
		
		
		
		
		
		
	
		
		
		public   void print() {
			String s = "[" ; 
			for (int i = 0 ; i<len ;i++) {s+= arr[i]+" , " ; }
			s += "]" ; 
			System.out.println(s) ; 
		}
	}


