package Lab10;


import java.util.*;



/*
 * The definition of this class should really be 
 *   public class CS401BST<E extends Comparable<? super E>>
 * but for our purposes, the following simplified version is okay.
 * If you are curious, see 
 * https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html
 * for more information. 
 *
 * The definition below is saying that any class E used in the binary
 * search tree must extend the Comparable interface.
 */

public class CS401BST<E extends Comparable<E>> {
    protected TreeNode<E> root;
    protected int size;        
    
    /**
     *  Initializes this Binary Search Tree object to be empty
     */ 
    public CS401BST() {
        root = null;
        size = 0;  
    } // default constructor


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
    
    public String contains (long ID) {
    	if(root == null)
    		throw new NullPointerException();
    	
    	 return getTreeNode(ID);
    } 

    /**
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
    //RECURSIVE ADD METHOD
    public boolean add (String lastName, String firstName, String middleName, long ID) {
    	TreeNode node = new TreeNode(lastName, firstName, middleName, ID);
    	
        if(root == null) { // When there is no root
        	
        	if (ID == 0)
                throw new NullPointerException();
        	root = node;	
        }
        
        else 
        	root = recAdd(node, root); //Calling the recursive function
        
        size++;
        return true;
    }
    
    // This method takes the element and add it to the existing tree root recursively
    public TreeNode<E> recAdd(TreeNode node, TreeNode<E> root) {
    	
    	
    	if(node.ID < root.ID){
        	if(root.left == null)
        		root.left = node;
        	else
        		root.left = recAdd(node, root.left);
        }
        else if(node.ID > root.ID){
        	if(root.right == null)
        		root.right = node;
        	else
        		root.right = recAdd(node, root.right );
        }
        else
            ;
        return root;	
    }
   
    
	private String getTreeNode(long ID){
		long comp;
		
		
        if(ID == 0)
        	throw new NullPointerException();
        
        TreeNode<E> e = root;
        
        while (e != null) {    
        	
	        if(e.ID == ID){
				return "Success (record found) in BST: " +e.lastName+" "+ e.firstName+" "+ e.middleName+" "+ e.ID;
	        }
			
			else if(ID<e.ID){
				 e = e.left;
	        }
			
			else {
				 e = e.right;
	        }
        }
		return "No record with this key found in BST";
		
		
    }
    
    /**
     *  Finds the successor of a specified TreeNode object in this 
     *  BinarySearchTree. The worstTime(n) is O(n) and averageTime(n) is 
     *  constant
     *  @param e - the TreeNode object whose successor is to be found.
     *  @return the successor of e, if e has a successor; otherwise, return null
     */
    protected TreeNode<E> successor (TreeNode<E> e) 
    {
        if (e == null)
            return null;
        else if (e.right != null) 
        {
            // successor is leftmost TreeNode in right subtree of e
            TreeNode<E> p = e.right;
            while (p.left != null)
                p = p.left;
            return p;

        } // e has a right child
        else 
        {
            // go up the tree to the left as far as possible, then go up
            // to the right.
            TreeNode<E> p = e.parent;
            TreeNode<E> ch = e;
            while (p != null && ch == p.right) 
            {
                ch = p;
                p = p.parent;
            } // while
            return p;
        } // e has no right child
    } // method successor
    
    protected static class TreeNode<String> {
        
    	String firstName;
	    String lastName;
	    String middleName;
	    long ID;
        protected TreeNode<String> left = null,
                           right = null,
                           parent;
 
        
         public TreeNode (String lastName, String firstName, String middleName, long ID) {
        	 this.firstName=firstName;
        	 this.lastName=lastName;
        	 this.middleName=middleName;
        	 this.ID=ID;
         } 
    } 

} // class BinarySearchTree
