package com.aksh.collectionDemo;
import java.util.*;
public class TestCollection {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("akshaya");
		list.add("anjaly");
		list.add("afeefa");
		list.add("akshata");
		for(String obj:list)
		{
			System.out.println(obj);		
	}
		/*Iterator itr = list.iterator();
		while(itr.hasNext())
		System.out.println(itr.next());*/

	}
}
