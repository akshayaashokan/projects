package com.aksh.SpringDb;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
         
    	    EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
    	   System.out.println("Enter choice : 1.Insert 2:Delete");
    	   Scanner scan = new Scanner(System.in);
    	   int a= scan.nextInt();
    	   switch(a)
    	   {
    	   case 1:
    		   dao.saveEmployee(new Employee());
       	    System.out.println("inserted!!");  
       	    break;
    	   case 2:
    		   dao.deleteEmployee(new Employee());
    		   System.out.println("deleted!!");
    		   break;
    	   }
    	   
    	   
    }
}
