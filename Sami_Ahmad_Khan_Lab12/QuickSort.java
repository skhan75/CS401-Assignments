package Lab12;

public class QuickSort{
	
   public static void sort(Object[] input){
      quicksort(input, 0, input.length-1);
   }

   public static void quicksort(Object[] input, int left, int right)
   {
      if (left < right)
      {
          int pi = (left+right)/2;
          int newPivotIndex = partition(input, left, right, pi);
          quicksort(input, left, newPivotIndex-1);
          quicksort(input, newPivotIndex+1, right);
      }
   }

   public static int partition(Object[] input, int left, int right, int pivotIndex)
   {
      Object pivot;
      Object tmp;
	int i, storeIndex;

      pivot = input[pivotIndex];

      tmp = input[pivotIndex];       /* Swap a[pivotIndex] and a[right] */
      input[pivotIndex] = input[right];
      input[right] = tmp;

     storeIndex = left;
     for (i = left; i < right; i++)
     {
        if (((Comparable) input[i]).compareTo(pivot) < 0)
        {
           tmp = input[storeIndex];       /* Swap a[i] and a[storeIndex] */
           input[storeIndex] = input[i];
           input[i] = tmp;
    
           storeIndex++;
        }
     }

     tmp = input[right];                /* Swap a[storeIndex] and a[right] */
     input[right] = input[storeIndex];      /* Moves pivot to its final place */
     input[storeIndex] = tmp;

     return storeIndex;
   }
}