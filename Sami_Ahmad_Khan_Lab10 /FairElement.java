public class FairElement<E>
{  
  E element;
  
  long count;
  
  
  public FairElement (E element, long count)
  {  
    this.element = element;
    this.count = count;    
  } // constructor
  
  public E getElement()
  {
	  return element;
  }
    
} // class FairElement