package Lab12;

public class HeapSort {
	
    private static String[] a1;
    private static int size;
    private static int left;
    private static int right;
    private static int max;

    public static void buildheap(String []a){
    	size=a.length-1;
        for(int i=size/2;i>=0;i--){
            heapify(a,i);
        }
    }
    
    public static void heapify(String[] a, int i){ 
        left=2*i;
        right=2*i+1;
        if(left <= size && a[left].compareTo(a[i]) > 0){
            max=left;
        }
        
        else{
            max=i;
        }
        
        if(right <= size && a[right].compareTo(a[max]) > 0){
            max=right;
        }
        
        if(max!=i){
            swap(i,max);
            heapify(a, max);
        }
    }
    
    public static void swap(int i, int j) {
    	String t=a1[i];
        a1[i]=a1[j];
        a1[j]=t; 
     }
    
    public static void sort(String [] a) {
        a1 = a;
        buildheap(a1);
        
        for(int i=size;i>0;i--) {
            swap(0, i);
            size=size-1;
            heapify(a, 0);
        }
    }
} 