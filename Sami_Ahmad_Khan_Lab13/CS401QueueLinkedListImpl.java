/**
 * Created by SamAK on 4/20/16.
 */


import java.util.NoSuchElementException;


public class CS401QueueLinkedListImpl<E> implements CS401QueueInterface<E>  {
    private LinkEntry<E> head;
    private LinkEntry<E> tail;
    private int num_elements;

    public void add(E element) {

        LinkEntry<E> last = tail;
        tail = new LinkEntry<E>();
        tail.element = element;
        tail.next = null;
        if (is_empty())
            head = tail;
        else
            last.next = tail;

        num_elements++;
    }

    public E remove()  {
        if (is_empty())
            throw new NoSuchElementException("Queue underflow");
        E e  = head.element;
        head = head.next;
        num_elements--;

        return e;
    }
    public E peek()  {
        if (is_empty())
            throw new NoSuchElementException("Queue underflow");
        return head.element;
    }

    public boolean is_empty()  {
        return head == null;
    }

    public boolean is_full()  {
        return false; //as memory in linkedList is allocated dynamically and is never full
    }

    public int size(){
        return num_elements;
    }

    /* ------------------------------------------------------------------- */
	   /* Inner classes                                                      */
    protected class LinkEntry<E>
    {
        protected E element;
        protected LinkEntry<E> next;

        protected LinkEntry() { element = null; next = null; }
    }
}
