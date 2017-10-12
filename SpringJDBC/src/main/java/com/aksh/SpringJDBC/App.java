package com.aksh.SpringJDBC;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	String confFile = "applicationContext.xml";
        ConfigurableApplicationContext context = 
                                    new ClassPathXmlApplicationContext(confFile);
        EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDAO");
        Employee emp = empDao.findEmployeeById(1);
        System.out.println(emp.getName()+" | "+emp.getSalary()+" | "+emp.getDept());
       // System.out.println( "Hello World!" );
    }
}
