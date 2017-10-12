package com.aksh.collectionDemo;
import java.util.*;
public class TestCollection3 {
//storing objects in array list
	public static void main(String[] args) {
		Student s1= new Student(1,"akshaya",22);
		Student s2= new Student(2,"afeefa",22);
		Student s3= new Student(3,"anjali",22);
		ArrayList<Student> al=new ArrayList<Student>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		Iterator itr=al.iterator();
		while(itr.hasNext()) {
			Student st=(Student)itr.next();		
			System.out.println(st.rollno+" "+st.name+" "+st.age);
			}
			
		

	}

}
