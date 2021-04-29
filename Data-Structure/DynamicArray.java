package Arrays;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray <T>  implements Iterable<T>{
	private   T[] array  ; 
	private  int capacity ;
	private int len  = 0  ;
	
	public DynamicArray() {this(16) ; }
	public     DynamicArray(int capacity) {
		if (capacity == 0 ) {capacity = 1 ; }
		this.capacity = capacity ;
		array = (T[]) new Object[capacity] ; 
	}
	public int  indexof(T elem ) {
		for (int i = 0 ;  i< len ; i++ ) {
			if ( array[i].equals(elem) ) {return i  ; }
		}
		return -1 ; 
	}
	public T get(int index ) {
		if (index < 0 || index >= len ) throw  new  IndexOutOfBoundsException() ; 
		return array[index] ; 
	}
	public boolean  contain(T elem ) {return indexof(elem) != -1 ; }
	public  int  len() {return len ; }
	public boolean IsEmpty() { return len() ==  0 ; }
	public void UpdateArr() {
		if(capacity == 0 ) {capacity = 1 ; }
		else {capacity *= 2 ; } 
		T[] newarr =  (T[] )  new Object[capacity] ; 
		for (int i = 0 ; i < len ; i++ ) {newarr[i] =  array[i]  ; }
		array = newarr ; 	
	}
	void  insert (int index , T elem ) {
		if ( index  < 0 ||  index  >= len  ) throw new IndexOutOfBoundsException() ; 
		if (capacity == len+1 ) UpdateArr() ;
		
		for (int i = len-1 ; i >= 0  ; i--) {
			array[i+1] = array [i]  ; 
			if ( i == index ) {array[i] = elem  ;break  ; }
			
		}
		len++ ; 
	}
	public void  shift(T elem) { 
		//insert(0,elem) ;
	    if ( len+1 == capacity) UpdateArr() ; 
	    T[] newarr = (T[] )  new Object[capacity] ;
	    newarr[0] = elem ; 
	    for ( int i = 0 , j = 1 ; i < len ; i++ , j++  )  {
	    	newarr[j] = array[i] ;  
	    }
	    len++ ; array = newarr ; 
	
	}
	void clear ( ) {
		for (int i = 0 ; i < len ; i++ ) { array[i] = null  ; }  len = 0  ;}
	void append(T elem )  {
		if ( len+1 == capacity ) {UpdateArr() ; }; 
		array[len++] = elem ; 
	}
	 void set(int index, T elem)  {
		 len++ ; 
		 if (index < 0 || index >= len )  {len-- ; throw  new  IndexOutOfBoundsException() ; }  
		    array[index] = elem;
		  }
	 public boolean  remove (T elem ) {
		 for (int i = 0 ; i < len  ; i++) {
			 if (array[i].equals(elem) ) {removeAt(i) ;  return true ; }
		 }
		 return false ; 
	 }
	 
	 public void removeAt(int index ) {
		 if ( index < 0 || index >= len ) throw  new  IndexOutOfBoundsException() ; 
		 if ( len ==  capacity/4) {
			T[] newarr = ( T[])  new Object[capacity/2] ; 
			 
			 for (int i = 0 , j= 0 ; i < len ; i++ , j++  ) {
				 
				 if (i == index ) {j-- ; }
				 else { newarr[j] = array[i] ;}
				
			
			 } array = newarr ; capacity = capacity/2 ;    
		 }
		 else {
			
			 for  ( int i = index   ; i < len-1 ; i++ )  array[i] = array[i+1] ;
			 array[len-1] = null ; 
			 
		 }
		
		  len-- ;
	 
	 }
	 public  void print () {
	        String  strarr  = "[" ; 
	        
	        for  ( int i =  0 ; i <capacity   ; i++   ) {
	            strarr += array[i] ; 
	        	if ( i !=capacity-1 ) { strarr += " , ";  }  
	            
	        }
	        strarr += "]" ; 
	        System.out.println(strarr) ; 
	    }
	@Override
	public  Iterator<T> iterator(){
		return new Iterator<T>() {
			int index  = 0 ; 
			@Override 
			public boolean hasNext() {
				return index < len  ; 
			}
			@Override 
			public T next() {
				return array[index++] ; 
			}
			
		};
	}
	

}
