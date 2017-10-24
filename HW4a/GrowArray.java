/*
 * CPE593_HW4a_GrowArray
 * Author: Zhihan Zhang
 * CWID: 10420346
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GrowArray {
	private int[] data;
	private int used;
	private int len;
	public GrowArray(int initialCapacity) {
		data = new int[initialCapacity];
		used = 0;
		len = initialCapacity;
	}
	private void addFront(int val) {
		if(used >= len){
			grow();
		}
		
		for(int i = used - 1; i >= 0; i--){
			data[i + 1] = data[i];
		}
		
		data[0] = val;
		used++;
	}
	
	private void addBack(int val) {
		if(used >= len){
			grow();
		}
		
		data[used] = val;
		
		used++;
	}
	
	private void grow() {
		if (len == 0) {
			data = new int[1];
			len = 1;
			used = 0;
		} else {
			int[] temp = data;
			len += len;
			data = new int[len];
			for(int i = 0; i < temp.length; i++){
				data[i] = temp[i];
			}
		}
	}
	
	public void add_Front(int start, int step, int end){	
		for(int i = start; i <= end; i += step){			
			addFront(i);
		}
	}
	
	public void add_Back(int start, int step, int end) {
		for(int i = start; i <= end; i += step){
			addBack(i);
		}
	}
	
	public void remove_Front(int t) {
		if(used == 0 ) {
			System.out.println("Can't remove! The Array is empty!");;
		}
		if(used < t) {
			System.out.println("Can't remove! There is no enough elements to remove");;
		}
		
		for(int i = t; i < used; i++){
			data[i - t] = data[i];
		}
		
		used -= t;
	}
	
	public void remove_Back(int t) {
		if(used == 0) {
			System.out.println("The Array is empty!");;
		}
		
		if(used < t) {
			System.out.println("Can't remove! There is no enough elements to remove");;
		}

		used -= t;
	}
	
	public void output() {
		for(int i = 0; i < used; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	public static void  main(String[] args) throws IOException{
		GrowArray a = new GrowArray(0);
		
		File file = new File("HW4a.txt");  
        if (!file.exists() || file.isDirectory()){
        	throw new FileNotFoundException();  
        }
        BufferedReader br = new BufferedReader(new FileReader(file));  
        String tempString = null;  
        StringBuffer sb = new StringBuffer();  
        while ((tempString = br.readLine()) != null) {   
            sb.append(tempString + "\n");    
        }
        String str = sb.toString();
        String[] tempStrArr = str.split("\n"); 
        
        for(int i = 0; i < tempStrArr.length; i++){
        	if(tempStrArr[i].equals("OUTPUT")){
        		a.output();
        	} else {
        		String[] tmp = tempStrArr[i].split(" ");
        		switch (tmp[0]) {
        		case "ADD_FRONT":
        			String[] args_Front = tmp[1].split(":");
        			a.add_Front(Integer.parseInt(args_Front[0]), Integer.parseInt(args_Front[1]), Integer.parseInt(args_Front[2]));
        			break;
        			
        		case "ADD_BACK":
        			String[] args_Back = tmp[1].split(":");
        			a.add_Back(Integer.parseInt(args_Back[0]), Integer.parseInt(args_Back[1]), Integer.parseInt(args_Back[2]));
        			break;
        			
        		case "REMOVE_FRONT":
        			a.remove_Front(Integer.parseInt(tmp[1]));
        			break;
        			
        		case "REMOVE_BACK":
        			a.remove_Back(Integer.parseInt(tmp[1]));
        			break;
        		default:
        			throw new IllegalArgumentException("Invalid Input!");
        		}
        	}
        }
        
	}
}
