package com.aksh.RestaurantXML;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class App 
{
	  Configuration con = new Configuration().configure().addAnnotatedClass(ResMenu.class);
	   	SessionFactory sf= con.buildSessionFactory();
	   	Session session= sf.openSession();
	   	Transaction tx = session.beginTransaction();
    public static void main( String[] args )
    {
    	App app=new App();
       System.out.println("Enter the choice: ");
       System.out.println("1:CREATE  2:RETRIEVE  3:DELETE");
       Scanner scan = new Scanner(System.in);
       int a= scan.nextInt();
       switch(a)
       {
       case 1:
    	   System.out.println("creating table");
    	   app.createTable();
    	   break;
       case 2:
    	   System.out.println("Retrieving from table");
    	   app.retrieveTable();
    	   break;
       case 3:
    	   System.out.println("deleting from table");
    	   app.dropTable();
    	   break;
    	   
       }
       
    }
    public void createTable()
    {
    /*	ResMenu rm= new ResMenu();
        rm.setDish_name("chicken biryani");
        rm.setCategory_id(1);
        rm.setType("non-veg");
        rm.setPrice(180);
        ResMenu rm1= new ResMenu();
        rm1.setDish_name("vanilla ice cream");
        rm1.setCategory_id(2);
        rm1.setType("veg");
        rm1.setPrice(100);*/
    	
    	/*ResDish ds = new ResDish();
    	ds.setCatId(1);
    	ds.setCatName("main course");
    	session.save(ds);
    	
    	session.save(rm);
    	session.save(rm1);*/
    	
    	 ResDish rs = new ResDish();
    	 rs.setCatId(1);
    	 rs.setCatName("main course");
    	 //session.save(rs);
         ResMenu rm = new ResMenu("chicken biryani",1,"non-veg",180);
        rm.setDish(rs);
         Set<ResMenu> menu = new HashSet<ResMenu>();
         menu.add(rm);
         session.save(rm);
  
         rs.setMenu(menu);
         
         session.save(rs);
        
    	tx.commit();
    	session.close();
    }
    public void retrieveTable()
    {

    	List res = session.createQuery("from ResMenu").list();
    	 System.out.println("DISH_NAME     "+"CATEGORY_ID     "+"TYPE     "+"PRICE  ");
        for (Iterator iterator = res.iterator(); iterator.hasNext();) {
            ResMenu menu = (ResMenu) iterator.next();
           
            System.out.println(menu.getDish_name() + "    "
                    + menu.getCategory_id() + "           " + menu.getType()+"     "+menu.getPrice());
        }
        tx.commit();
      session.close();
    }
    public void dropTable()
    {
    	ResMenu menu= session.load(ResMenu.class, "chicken biryani");
    	session.delete(menu);
    	 tx.commit();
         session.close();
    }
}
