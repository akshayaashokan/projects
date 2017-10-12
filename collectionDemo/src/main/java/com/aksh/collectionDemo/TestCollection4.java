package com.aksh.collectionDemo;
import java.util.*;
public class TestCollection4 {

	public static void main(String[] args) {
		
HashSet<String> set = new HashSet<String>();
set.add("akshaya");
set.add("anjali");
set.add("anjali");
set.add("akshaya");
set.add("afeefa");
set.add("akshata");
set.add("anjali");
Iterator itr=set.iterator();
while(itr.hasNext())
	System.out.println(itr.next());
		}

}
