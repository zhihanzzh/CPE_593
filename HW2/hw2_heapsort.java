package cpe593;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class hw2_heapsort {
	public static void heapsort(int[] a, int count) {
		heapify(a, count);
		
		int end = count - 1;
		
		while (end > 0) {
			int temp = a[0];
			a[0] = a[end];
			a[end] = temp;		
			end--;	
			siftDown(a, 0, end);
		}
	}
	public static void heapify(int[] a, int count) {
		int start = (count - 2) / 2;
		while (start >= 0) {
			siftDown(a, start, count - 1);
			start--;
		}
	}
	
	public static void siftDown(int[] a, int start, int end) {
		int root = start;
		
		while (2 * root + 1 <= end) {
			int child = 2 * root + 1;
			int swap = root;
			
			if (a[swap] < a[child]) {
				swap = child;
			}
			
			if (child + 1 <= end && a[swap] < a[child + 1]) {
				swap = child + 1;
			}
			
			if (swap == root) {
				return;
			} else {
				int temp = a[root];
				a[root] = a[swap];
				a[swap] = temp;
				root = swap;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
        File file = new File("hw2b.dat");  
        if (!file.exists() || file.isDirectory()){
        	throw new FileNotFoundException();  
        }
        BufferedReader br = new BufferedReader(new FileReader(file));  
        String tempString = null;  
        StringBuffer sb = new StringBuffer();  
        ;  
        while ((tempString = br.readLine()) != null) {   
            sb.append(tempString + "\n");    
        }
        String str = sb.toString();
        String[] tempStrArr = str.split("\n");
       for(int i = 1; i <= Integer.parseInt(tempStrArr[0]); i++){
    	   int[] arr = new int[Integer.parseInt(tempStrArr[2 * i - 1])];
    	   String[] temp = tempStrArr[2 * i].split(" ");
    	   for(int j = 0; j < temp.length; j++){
    		   arr[j] = Integer.parseInt(temp[j]);
    	   }
    	   heapsort(arr, arr.length);
    	   for(int ele : arr){
    		   System.out.print(ele + " ");
    	   }
    	   System.out.println();
       }
	}
}
