package com.linkedlisttask;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTask {
	
	public ArrayListTask() {
		
	}
	
	public void arrayListTask() {

		ArrayList<String> list = new ArrayList<String>();;

		/* 1) create an array list, add some colors (strings) and print out the collection 
		   OUTPUT :- [RED,BLUE,YELLOW,BLACK]*/
		list.add("RED");
		list.add("BLUE");
		list.add("YELLOW");
		list.add("BLACK");
		
		System.out.println("\nElements of list: "+list);

		/* 2)  iterate through all elements in an array list
		   OUTPUT :- RED
				  	 BLUE
				  	 YELLOW
				  	 BLACK */
		System.out.println("\nElements of list: ");
		for(String data : list) {
    		System.out.println(data);
    	}
		
		/* 3)insert an element into the array list at the first position.
		   OUTPUT :- [RED,BLUE,YELLOW,BLACK]
				  [GREEN,RED,BLUE,YELLOW,BLACK] */
		list.add(0, "GREEN");
		System.out.println("\nElements of list: "+list);
								
		/* 4)retrieve an element (at a specified index) from a given array list.
		   OUTPUT :- YELLOW */
		System.out.println("\nElement of specific index is: "+list.get(3));

		/* 5) update an array element by the given element
		   OUTPUT :- [GREEN,RED,BLUE,YELLOW,BLACK]
			   	     [GREEN,WHITE,BLUE,YELLOW,BLACK] */
		list.set(1, "WHITE");
		System.out.println("\nElements of list: "+list);
		
		/* 6) remove the third element from an array list.
 		   OUTPUT :- [GREEN,WHITE,YELLOW,BLACK] */
		list.remove(2);
		System.out.println("\nElements of list: "+list);

		/* 7) search for an element in an array list.
			INPUT :- WHITE
			OUTPUT :-   element EXIST					
			INPUT :- RED
			OUTPUT :-  element NOT EXIST */
		Object list1 = "RED"; 
		if(list.contains(list1)) {
			System.out.println("\n"+list1+" element EXIST");
		} else {
			System.out.println("\n"+list1+" element NOT EXIST");
		}

		/* 8) to sort a given array list.
			INPUT :- [BLACK,GREEN,WHITE,YELLOW] */
		Collections.sort(list);
		System.out.println("\nSorted elements of list: "+list);

		/* 9) program to copy one array list into another. 			
			code example :- System.out.println(array1);
							System.out.println(Coppyarray)					
		    OUTPUT :- array1=[BLACK,GREEN,WHITE,YELLOW]
					 Coppyarray=[BLACK,GREEN,WHITE,YELLOW]*/
		System.out.println("\nOriginal elements of list: "+list);
		Object list2 = list.clone();
		System.out.println("Copied elements of list: "+list2);
		

		/* 10) reverse elements in an array list. */
		Collections.reverse(list);
		System.out.println("\nReverse elements of list: "+list);
	}
}
