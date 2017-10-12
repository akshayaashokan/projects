package com.aksh.collectionDemo;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
public class TestLambda {

	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7,8,9);
		values.forEach(i-> System.out.println(i));
	}

}
