package cpe593;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class hw2_quicksort {

	
	public static void quicksort(int[] a, int start, int end) {
		
		if (start >= end) {
			return;
		}
		
		int i = start;
		int j = end;
		int key = a[start + (end - start) / 2];
		
		while (j >= i) {
			while (j > i && a[i] < key) {
				i++;
			}
			while (j > i && a[j] > key ) {
				j--;
			}
			
			if (j >= i) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
			quicksort(a, start, j);
			quicksort(a, i, end);
		
	}
	
	public static void main(String[] args) throws IOException {
        File file = new File("hw2a.dat");  
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
    	   quicksort(arr, 0, arr.length - 1);
    	   for(int ele : arr){
    		   System.out.print(ele + " ");
    	   }
    	   System.out.println();
       }
	}
}
