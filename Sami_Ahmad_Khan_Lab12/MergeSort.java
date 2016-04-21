package Lab12;

public class MergeSort{
	public static final int INSERTIONSORT_THRESHOLD = 7;
	
	public static void sort (Object[ ] a){
		Object aux[ ] = (Object [ ])a.clone();
		mergeSort (aux, a, 0, a.length);
	} // method sort
	
	private static void mergeSort (Object src[ ], Object dest[ ], int low, int high)
	{
	int length = high - low;
	
	// Use Insertion Sort for small subarrays.
	if (length < INSERTIONSORT_THRESHOLD /* = 7*/){
		for (int i = low; i < high; i++)
			for (int j = i; j >low && ((Comparable)dest[j - 1]).compareTo(dest[j]) > 0; j--)
					swap (dest, j, j-1);
			return;
	} 
	
	// Sort left and right halves of src into dest.
	int mid = (low + high) >> 1; // >> 1 has same effect as / 2, but is faster
	mergeSort (dest, src, low, mid);
	mergeSort (dest, src, mid, high);
	
	// If left subarray less than right subarray, copy src to dest.
	if (((Comparable)src [mid-1]).compareTo (src [mid]) <= 0){
		System.arraycopy (src, low, dest, low, length);
	return;
	}
	
	// Merge sorted subarrays in src into dest.
	for (int i = low, p = low, q = mid; i < high; i++)
		if (q>=high || (p<mid && ((Comparable)src[p]).compareTo (src[q])<= 0))
		dest [i] = src [p++];
		else
		dest[i] = src[q++];
	} // method mergeSort
	
	public static void swap (Object[ ] x, int a, int b){
		Object temp = x [a];
		x [a] = x [b];
		x [b] = temp;
	} // swap
}
