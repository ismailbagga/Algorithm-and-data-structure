package Arrays;	
@SuppressWarnings("unchecked")
public class UnionFind { 
		java.util.HashMap<Object,Integer> map = new java.util.HashMap<Object,Integer>() ; 
		private int[]  grp ;
		private int[] id ; 
		private int len ;
		private int comp ; 
		
		public UnionFind( Object[] l)  {
			comp = len = l.length ;
			id =  new int[len] ; 
			grp = new int[len] ; 		
			for (int i = 0 ; i < len ; i++ ) {
				map.put(l[i],i) ; 
				id[i] = i ;
				grp[i] = 1;
			}
		}
		public boolean Connected(Object A ) {return id[map.get(A)] != map.get(A) ;  }
		public int  Find(Object A ) {
			int i = map.get(A) ;
			int root = i ; 
			while (root != id[root] ) {
				root = id[root] ; 
			}
			int p = i  ;  
			while (p != root ) {
				int next = id[p] ; 
				id[p] = root ; 
				p = next ; 
			}
			return root ; 
 		}
		public int NumComp() {return comp ; }
		public void Union(Object A , Object B ) {
			int i = map.get(A) ;
			int j  = map.get(B) ;
			if (grp[i] >= grp[j]) {Merge(i,j) ; }
			else {Merge(j,i) ;  }
		} 
	
		public void Merge(int i , int j ) {
			if ( id[i] == id[j]) return ; 
			grp[id[i]] += grp[j] ; 
			
			id[j] = id[i] ;
			comp-- ; 
		}
		public void print() {
			for (int i : id  ) {System.out.print(i+" ");}
			System.out.println("\n");
			for (int j : grp  ) {System.out.print(j+" ");} 

		}







}
