package Lab9;
/**
 * Name: SAMI AHMAD KHAN
 * CWID: A20352677
 * Lab#: 09
 */

import java.io.IOException;
import java.util.Stack;

import Lab9.CS401BST.TreeNode;

public class CS401BSTArray<E extends Comparable <E>> {
	   protected TreeNode<E> [] tree;
	   protected int root, size, indx;
	   int capacity = 21;
		
	   /**
	    * Initializes the BinarySearchTree object*/
	   public CS401BSTArray() {
	      tree =  (TreeNode<E>[]) new TreeNode[50];
	      root = 0;
	      size = 0;
	      indx = 0;
	   }

	   protected static class TreeNode<E> {
	      E element;
	      int parent, left, right;
			
	      public TreeNode (E element, int parent, int left, int right) {
	         this.element = element;
	         this.parent = parent;
	         this.left = left;
	         this.right = right;
	      }
	   }
	   
	   /**
	     * Do an inorder traversal of a binary-search tree.
	     * 
	     * @return the string representation of the concatenation of the elements
	     *         on the tree resulting from an inorder traversal.
	 * @throws IOException 
	     */
	    public String inorder() throws IOException  {
	       return inorder_p(root);
	    }
	    
	    /**
	     *  Determines if there is at least one element in this BinarySearchTree 
	     *  object that equals a specified element.
	     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).  
	     *
	     *  @param obj - the element sought in this BinarySearchTree object.
	     *
	     *  @return true - if there is an element in this BinarySearchTree object
	     *                the equals obj; otherwise, return false.
	     *
	     *  @throws ClassCastException - if obj cannot be compared to the 
	     *           elements in this BinarySearchTree object. 
	     *  @throws NullPointerException - if obj is null.
	     *  
	     */ 
	    public boolean contains (E obj) 
	    {
	        return getTreeNode (obj) != null;
	    } // method contains
	   
	   /**ADD
	     *  Ensures that this BinarySearchTree object contains a specified element.
	     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
	     *
	     *  @param element - the element whose presence is ensured in this 
	     *                 BinarySearchTree object.
	     * @param root2 
	     *
	     *  @return true - if this BinarySearchTree object changed as a result of 
	     *                 this method call (that is, if element was actually 
	     *                 inserted); otherwise, return false.
	     *
	     *  @throws ClassCastException - if element cannot be compared to the 
	     *                  elements already in this BinarySearchTree object.
	     *  @throws NullPointerException - if element is null.
	     *
	     */
	   public boolean add (E element)  {
			 if (element == null)
	             throw new NullPointerException();
			 
			 if (tree[root] == null) {
		            tree[root] = new TreeNode<E>(element,-1,-1,-1);
		            size++;             
		            return true;
			 } // empty tree
			 
			 else {
		         boolean added = false;
		         int currentIndex = 0;

		         while (!added) {
		            if (((Comparable) element).compareTo((tree[currentIndex].element) ) < 0) {
		               if(size + 2 > capacity) {
		            	 capacity = capacity * 3;
		            	 TreeNode<E>[] newData = (TreeNode<E> []) new TreeNode[capacity];
		          		 System.arraycopy(tree, 0, newData, 0, tree.length);
		          		 tree = newData;
		               }
		               // Go left
		               if (tree[currentIndex].left == -1) {
		                  tree[size] = new TreeNode<E> (element,currentIndex,-1,-1);
		                  tree[currentIndex].left = size;
		                  added = true;       
		               }
		               else
		                  currentIndex = tree[currentIndex].left;
		            }
		            
		            else {
		            	if(size + 2 > capacity) {
		            		capacity = capacity * 3;
		            		TreeNode<E>[] newData = (TreeNode<E> []) new TreeNode[capacity];
		            		System.arraycopy(tree, 0, newData, 0, tree.length);
		            		tree = newData;
		            	}

		            	if (tree[currentIndex].right == -1) {
		            		tree[size] = new TreeNode<E> (element, currentIndex,-1,-1);
		            		tree[currentIndex].right = size;
		            		added = true;  
		            	}
		            	else
		            		currentIndex = tree[currentIndex].right;
		            }      
		         }
			 }
			 size++; 
			 return true;
		
	   }
	   
	   /**REMOVE_NODE
	     *  Ensures that this BinarySearchTree object does not contain a specified 
	     *  element.
	     *  The worstTime(n) is O(n) and averageTime(n) is O(log n).
	     *
	     *  @param obj - the object whose absence is ensured in this 
	     *                 BinarySearchTree object.
	     *
	     *  @return true - if this BinarySearchTree object changed as a result of
	     *                this method call (that is, if obj was actually removed); 
	     *                otherwise, return false.
	     *
	     *  @throws ClassCastException - if obj cannot be compared to the 
	     *                  elements already in this BinarySearchTree object. 
	     *  @throws NullPointerException - if obj is null.
	     *
	     */
	    public boolean remove (E obj) {
	        TreeNode<E> e = getTreeNode (obj); // Calling getTreeNode() with element to be removed passed as object
	        if (e == null){
	        	System.out.println("Element not present !");
	        	return false; //Not present 	 
	        }
	           
	        deleteTreeNode (e);       
	        return true;
	    }
		 
	    
	    /**GET_TREE_NODE
	     *  Finds the TreeNode object that houses a specified element, if there is 
	     *  such an TreeNode.
	     *  The worstTime(n) is O(n), and averageTime(n) is O(log n).
	     *
	     *  @param obj - the element whose TreeNode is sought.
	     *
	     *  @return the TreeNode object that houses obj - if there is such an TreeNode;
	     *                otherwise, return null.  
	     *
	     *  @throws ClassCastException - if obj is not comparable to the elements
	     *                  already in this BinarySearchTree object.
	     *  @throws NullPointerException - if obj is null.
	     *
	     */ 
		protected TreeNode<E> getTreeNode (E obj) {
			 int comp;	 
			 
			 if (obj == null)
				 throw new NullPointerException();
			 
			 int e = root;
			 
			 while (e != -1) { //searching iteratively in the tree for the element 
				 comp = (obj).compareTo (tree[e].element);
				 if (comp == 0)
					 return tree[e]; 
				 else if (comp < 0)
					 e = tree[e].left; //----> n/2
				 else
					 e = tree[e].right; // ---> n/2
			 } //end of while
			 return null;
		 } 
		 
		 
		 /**
	      *  Deletes the element in a specified TreeNode object from this 
	      *  BinarySearchTree.
	      *  
	      *  @param p - the TreeNode object whose element is to be deleted from this
	      *                 BinarySearchTree object.
	      *
	      *  @return the TreeNode object that was actually deleted from this
	      *                BinarySearchTree object. 
	      *
	      */
		 public boolean deleteTreeNode(TreeNode<E> e ){
			 E ele = e.element;
				 
			 for(int i = 0; i < size(); i++) {
				 
				 if(tree[i].element == ele) {
					 
					/* If p has two children, replace p's element with p's successor's
				     element, then make p reference that successor*/
					 if(tree[i].left == -1 && tree[i].right == -1) {
						 
						// TreeNode<E> s = successor(e); // SUCCESSSOR
						 
						 if(tree[tree[i].parent].left == i)
							 tree[tree[i].parent].left = -1;
						 else 
							 tree[tree[i].parent].right = -1;
						 
						 for(int k = i ; k < size(); k++) {
							 tree[k] = tree[k+1];						 
						 }
						 tree[size - 1] = null;
						 size = size - 1;				
					 }
					 
					 else if (tree[i].right == -1) {
						 
						 tree[tree[i].left].parent = tree[i].parent;
						 if(tree[tree[i].parent].left == i)
							 tree[tree[i].parent].left = tree[i].left;
						 else
							 tree[tree[i].parent].right = tree[i].left;
						 
						 for(int k = i ; k < size(); k++) {
							 tree[k] = tree[k+1];						 
						 }
						 
						 tree[size - 1] = null;
						 size = size - 1;
					 }
					 
					 else if (tree[i].left == -1 ) {
						 tree[tree[i].right].parent = tree[i].parent;
						 if(tree[tree[i].parent].left == i)
							 tree[tree[i].parent].left = tree[i].right;
						 else
							 tree[tree[i].parent].right = tree[i].right;
						// tree[tree[i].parent].right = tree[i].right;
						 
						 for(int k = i ; k < size(); k++) {
							 tree[k] = tree[k+1];						 
						 }
						 tree[size - 1] = null;
						 size = size - 1;
					 }
					 
					 else {		 
						 int right = tree[i].right;
						 while(tree[right].left != -1 ) {
							 right = tree[tree[right].left].left;		 	
						 }
						 tree[i].element = tree[right].element;
						 
						 if(tree[right].left == -1 && tree[right].right == -1) {
							 if(tree[tree[right].parent].left == right)
								 tree[tree[right].parent].left = -1;
							 else 
								 tree[tree[right].parent].right = -1;
							 
							 for(int k = right ; k < size(); k++) {
								 tree[k] = tree[k+1];						 
							 }
							 tree[size - 1] = null;
							 size = size - 1;	 
						 }
							 
						 else if (tree[right].right == -1) {
							 tree[tree[right].left].parent = tree[right].parent;
							 tree[tree[right].parent].left = tree[right].left;
							 
							 for(int k = right ; k < size(); k++) {
								 tree[k] = tree[k+1];						 
							 }
							 tree[size - 1] = null;
							 size = size - 1;
						 }
						 
						 else if (tree[right].left == -1 )
						 {
							 tree[tree[right].right].parent = tree[right].parent;
							 tree[tree[right].parent].right = tree[right].right;
							 
							 for(int k = right ; k < size(); k++) {
								 tree[k] = tree[k+1];						 
							 }
							 tree[size - 1] = null;
							 size = size - 1;
						 }				 
					 } 
				 } 
			 }		 		 
			 return true;
		 }
		 
		 /**
		     *  Returns the size of this BinarySearchTree object.
		     *
		     * @return the size of this BinarySearchTree object.
		     *
		     */
		 public int size( ) {
			 return size;
		 } 
		  
	   /**
	    * print - Prints the array based tree as a table with 4 columns.
	    */
	   void print()  {
	      int indx;

	      for (indx = 0; indx < size; indx++)  {
	         System.out.println(tree[indx].element + ", " +
	                            tree[indx].parent  + ", " +
	                            tree[indx].left    + ", " +
	                            tree[indx].right);
	      }
	   }
	  
	   
	/*private String inorder_p(TreeNode<E>[] tree) throws IOException  {
	   TreeNode<E> current, prev = null;
	   String s = "";
       
       if(tree == null)
    	   return null;
       
       current = tree[root];
  
       while(current!=null){
    	   if (current.left == -1) {
                s = (String)current.element; //+ "," +current.parent + "," +current.left + "," +current.right + "\n";
                current = tree[current.right];
    	   }
    	   
    	   else {
    		   // Find the inorder predecessor of current 
                prev = tree[current.left];
                try{
                while (prev.right!= -1 && prev.right != current.left) {
                	prev = tree[prev.right];
                }
                }catch(Exception e){}
                
    	   
                // Make current as right child of its inorder predecessor 
                try{
                if (prev.right == -1) {
                	tree[prev.right] = current;
                	current = tree[current.left];
                }
                
                else {
                	prev.right = -1;
                	s= (String) current.element;// + "," +current.parent + "," +current.left + "," +current.right + "\n";
                	current = tree[current.right];
                }
                }catch(Exception e){}
    	   }
       } 
       return s;
   }*/

	  private String inorder_p(int root){
		   String str = "";

			if (tree[root] != null)  {

				try{
					str += inorder_p(tree[root].left)+ "\n";
				}
				catch(Exception e){}
					str += tree[root].element.toString();
					try {
						str += "\n" +  inorder_p(tree[root].right);}
				catch(Exception e)
				{}
			}
			return str;
	  }

	
	   

	    /**
	     *  Finds the successor of a specified TreeNode object in this 
	     *  BinarySearchTree. The worstTime(n) is O(n) and averageTime(n) is 
	     *  constant
	     *  @param e - the TreeNode object whose successor is to be found.
	     *  @return the successor of e, if e has a successor; otherwise, return null
	     */
	   /* protected TreeNode<E> successor (TreeNode<E> e) 
	    {
	    	//E ele = e.element; 
	        if (e == null)
	            return null;
	        
	        else if (e.right != -1) {
	            // successor is leftmost TreeNode in right subtree of e
	            TreeNode<E> p = e;
	            
	            for(int k = right ; k < size(); k++) {
					 tree[k] = tree[k+1];						 
	            }
	            while (p.left != -1)
	                p = p.left;
	            return p;

	        } // e has a right child
	        
	        else {
	            // go up the tree to the left as far as possible, then go up
	            // to the right.
	            TreeNode<E> p = e.parent;
	            TreeNode<E> ch = e;
	            while (p != null && ch == p.right) */
	           // {
	           //     ch = p;
	             //   p = p.parent;
	            //} // while
	          //  return p;
	       // } // e has no right child
	   // } // method successor
	    
	   

	   public static void main(String[] args)  {
	      CS401BSTArray<Integer> myGenClassArray = new CS401BSTArray<Integer>();

	      myGenClassArray.add(33);
	      myGenClassArray.add(20);
	      myGenClassArray.add(40);

	      myGenClassArray.print();
	   }
	}