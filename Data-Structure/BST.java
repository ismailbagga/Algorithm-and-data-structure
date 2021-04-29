package Arrays;
@SuppressWarnings("hiding")
public class BST  <T extends Comparable<T>>{
	private Tree<T> root   ; 
	private int size ;
	
	private class Tree<T>{
		private T node ; 
		private Tree<T> left , right   ; 
		public  Tree(T node , Tree<T> left ,  Tree<T> right  ) {
			this.node = node ; this.left = left ; this.right = right ;  
		}
	}
	public int len() {return size ; }
	public void  add(T elem ) {
		root =  sink(elem,root) ; size++ ; 
	}
	public Tree<T> sink(T elem , Tree<T> root){
		if (root ==  null ) return new Tree<T> (elem,null,null) ; 
		else if  (elem.compareTo(root.node) ==  -1)root.left =  sink(elem,root.left) ;
		else if  (elem.compareTo(root.node) ==  1) root.right = sink(elem,root.right) ; 
        return root ; 
	}
	public void  Remove(T elem) {
		if  ( elem == null) throw  new  RuntimeException() ; 
		root = pop(elem,root) ; size-- ; 
		
	}
	public  Tree<T> pop(T elem , Tree<T> root ) {
		if (root ==  null ) return root  ; 
		else if  (elem.compareTo(root.node) ==  -1)root.left =  pop(elem,root.left) ;
		else if  (elem.compareTo(root.node) ==  1) root.right = pop(elem,root.right) ; 
		else  {
			
			if ( root.right == null ) {return root.left ; }
			else if (root.left == null ) { return root.right ;}
			else {
				T temp = find(root.right)   ; 
				root.node = temp  ; 
				root.right  = pop(temp,root.right) ; 
			
			} 
		 
		}
		return root ;
	}
	
	public  T find(Tree<T> root) {
		while( root.left != null) { 
			root = root.left  ; 
			} 
		return root.node ; 
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  void  print() {
    	inOrder(root) ; 
    }
    public void inOrder(Tree<T> node) {
    	if (node == null ) return ; 
    	inOrder(node.left) ; 
    	System.out.print(node.node+" ");
    	inOrder(node.right) ; 
    }











}
