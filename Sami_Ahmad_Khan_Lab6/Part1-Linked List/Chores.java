package Lab6;
/*************************************************************************
 * NAME: Sami Ahmad Khan
 * CWID: A20352677
 * Lab # 06
 * DATE: 02/24/2016
 * TOPIC: "Linked List, Doubly Linked List and Sorted Linked List
 * @author SamAK
 *************************************************************************/
public class Chores implements Comparable<Chores>
{
   protected String chore_name;
   protected int    chore_time;

   public Chores(String n, int t)
   {
      chore_name = n;
      chore_time = t;
   }

   public String toString()
   {
      return "[" + chore_name + ":" + chore_time+ "]";
   }

   public int compareTo(Chores c)
   {
      if (this.chore_time > c.chore_time) 
          return 1;
      else if (this.chore_time < c.chore_time) 
          return -1;
      else /* (this.chore_time == c.chore_time)  */
          return 0;
   }
}
