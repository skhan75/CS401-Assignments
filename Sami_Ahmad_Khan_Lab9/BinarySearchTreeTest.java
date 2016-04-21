package Lab9;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.Result;
import static org.junit.runner.JUnitCore.runClasses;
import java.util.*;

public class BinarySearchTreeTest extends BinarySearchTree
{
    public static void main(String[ ] args)
    {  
        Result result = runClasses (BinarySearchTreeTest.class);
        System.out.println ("Tests run = " + result.getRunCount() +
                            "\nTests failed = " + result.getFailures());
    } // method main

    protected BinarySearchTree<String> tree;          
                       
    @Before    
    public void RunBeforeEachTest()
    {
        tree = new BinarySearchTree<String>();      
    } // method RunBeforeEachTest     
    
    @Test
    /**
     * Added test to test height()
     */
    public void testHeight()
    {        
            tree.add ("e");
            tree.add ("f"); 
            tree.add ("g");
            tree.add ("h");
            tree.add ("a");
            tree.add ("b");
            tree.add ("c");
            tree.add ("d");
            tree.add ("i");
            tree.add ("j");
            
            assertEquals (5, tree.height());
                    
    } // method testIteratorHasNext
    
    
    @Test
    public void testDefaultConstructor() 
    {                                                      
        assertEquals (0, tree.size()); 
        assertEquals ("[]", tree.toString());       
    } // method testDefaultConstructor
    
    @Test
    public void testCopyConstructor1() 
    {                                                              
        tree.add ("b"); 
        tree.add ("a");
        tree.add ("c");
        BinarySearchTree<String> newTree = new BinarySearchTree<String> (tree);            
        assertEquals (tree, newTree);         
    } // method testCopyConstructor1        
        
    @Test
    public void testEqualsNull()
    {
        assertEquals (false, tree.equals (null));
    } // method testEqualsNull
    
    @Test
    public void testEquals1()                               
    {
       tree.add ("b");
       tree.add ("a");
       tree.add ("c");
       BinarySearchTree<String> newTree = new BinarySearchTree<String>();
       newTree.add ("b");
       newTree.add ("c");
       newTree.add ("a");       
       assertEquals (true, tree.equals (newTree));
    } // method testEquals1
    
    @Test
    public void testEquals2()                               
    {
       tree.add ("b");
       tree.add ("a");
       tree.add ("c");
       BinarySearchTree<String> newTree = new BinarySearchTree<String>();
       newTree.add ("a");
       newTree.add ("c");
       newTree.add ("b");       
       
    } // method testEquals2
       
    @Test (expected = ClassCastException.class)
    public void testAddMismatch()
    {        
            Object obj = new Integer (7); 
            tree.add ((String)obj);              
    } // method testAddMismatch  
    
   
    public void testAdd()
    {                      
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            tree.add ("e");
            tree.add ("c");
            tree.add ("d");           
            assertEquals ("[a, b, c, d, e]", tree.toString());        
    } // method testAdd    
    
   
    public void testContainsMismatch()
    {        
            Object obj = new Integer (7); 
            tree.contains ((String)obj);              
    } // method testContainsMismatch  
    
    @Test
    public void testContains()
    {                         
            tree.add ("a");
            tree.add ("b"); 
            tree.add ("c"); 
            assertEquals (true, tree.contains ("a")); 
            assertEquals (true, tree.contains ("b")); 
            assertEquals (true, tree.contains ("c")); 
            assertEquals (false, tree.contains ("x"));
            assertEquals (false, tree.contains (""));                
    } // method testContains        
    
   
    
    @Test (expected = ClassCastException.class)
    public void testRemoveMismatch()
    {        
            Object obj = new Integer (7); 
            tree.remove ((String)obj);              
    } // method testAddRemoveMismatch  
    
    @Test
    public void testRemove()
    {                            
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            assertEquals (true, tree.remove ("b"));
            assertEquals (2, tree.size());
            assertEquals (false, tree.remove ("b"));
            assertEquals (2, tree.size());                             
    } // method testRemove
    
    @Test
    public void testIteratorConstructor()
    {       
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());           
    } // method testIteratorConstructor
    
    @Test
    public void testIteratorHasNext()
    {        
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());
            assertEquals ("b", itr.next());
            assertEquals (true, itr.hasNext());
            assertEquals ("c", itr.next());
            assertEquals (false, itr.hasNext());            
    } // method testIteratorHasNext
    
    @Test (expected = NoSuchElementException.class)
    public void testIteratorNextFail()
    {       
            tree.add ("b");
            tree.add ("a"); 
            tree.add ("c");
            Iterator<String> itr = tree.iterator();
            assertEquals ("a", itr.next());
            assertEquals ("b", itr.next());
            assertEquals (true, itr.hasNext());
            assertEquals ("c", itr.next());
            assertEquals (false, itr.hasNext());
            itr.next();                  
    } // method testIteratorNextFail            
    
} // class BinarySearchTreeTest