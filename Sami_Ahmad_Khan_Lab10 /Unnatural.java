   import java.util.*;   

   class Unnatural<E> implements Comparator<E>
   {
       protected Comparator<E> comp;
       
       public Unnatural (Comparator<E> comp)
       {
           this.comp = comp;
       } // constructor
       
       public int compare (E e1, E e2) 
       {
           int result = comp.compare((E)((FairElement)e1).element, (E)((FairElement)e2).element);
        		   //((FairElement)e1.element < (FairElement)e2.element) ? -1:
        	  // ((FairElement)e1.element > (FairElement)e2.element) ? 1 : 0;
           if (result != 0)
               return result;
           return (int)(((FairElement)e1).count - ((FairElement)e2).count);         
       } // method compare
     
   } // class Unnatural
