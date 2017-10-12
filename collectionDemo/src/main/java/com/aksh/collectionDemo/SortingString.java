package com.aksh.collectionDemo;
import java.util.*;
public class SortingString {
	public static void main(String[] args) {
		ArrayList<String> list= new ArrayList<String>();
		list.add("karthik");
		list.add("akshaya");
		list.add("malu");
		list.add("afeefa");
		list.add("anjaly");
		list.add("neenu");
		list.add("paul");
		System.out.println("  BEFORE SORTING ");
		list.forEach(System.out::println);
		System.out.println("  AFTER SORTING ");
		//sorting the arraylist
		list.sort((p1, p2) -> p1.compareTo(p2));
		//printing the sorted arraylist
		list.forEach(System.out::println);
		/*for(int i=0;i<list.size();i++)
				System.out.println(list.get(i));*/
//		for(String name:list)
//			System.out.println("name\t"+name);
		
//		itr = list.iterator();
//		while(itr.hasNext())
//		System.out.println(itr.next());
		}

}
