package com.aksh.collectionDemo;
import java.util.*;
public class MapInterfaceExample {

	public static void main(String[] args) {
		Map<Integer,String> map= new HashMap<Integer,String>();
		map.put(1,"akshaya");
		map.put(2,"anjaly");
		map.put(3,"afeefa");
		for(Map.Entry m:map.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}

}
