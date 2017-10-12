package com.aksh.Restaurant;
import java.util.Scanner;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import org.hibernate.mapping.List;
import org.hibernate.query.Query;
public class App 
{
	Configuration con = new Configuration().configure().addAnnotatedClass(Restaurant.class).addAnnotatedClass(Dish.class);
	SessionFactory sf= con.buildSessionFactory();
	Session session= sf.openSession();
	Transaction tx = session.beginTransaction();
	public static void main( String[] args )
    {
    	System.out.println("Enter the choice :");
    	System.out.println("1:CREATE  2:RETRIEVE  3:DROP");
    	Scanner scan = new Scanner(System.in);
    	int a= scan.nextInt();
    	App app= new App();
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
    		System.out.println("Deleting from table");
    		app.dropTable();
    		break;
    	}
    	
    }
    public void createTable() {
    	Dish ds1= new Dish();
    	ds1.setCat_id(2);
    	ds1.setCat_name("main course");
    	
    	Restaurant menu1 = new Restaurant();
    	menu1.setDish_name("chicken biryani");
    	menu1.setCategory_id(1);
    	menu1.setType("non-veg");
    	menu1.setPrice(180);
    	menu1.setDs(ds1);
    	
    	
    	session.save(ds1);
    	session.save(menu1);
    	
    	tx.commit();
    	session.close();
    	
}
    public void retrieveTable()
    {
    	List res = session.createQuery("from Restaurant").list();
    	 System.out.println("DISH_NAME     "+"CATEGORY_ID     "+"TYPE     "+"PRICE   "+"CAT_ID");
        for (Iterator iterator = res.iterator(); iterator.hasNext();) {
            Restaurant menu = (Restaurant) iterator.next();
           
            System.out.println(menu.getDish_name() + "    "
                    + menu.getCategory_id() + "          " + menu.getType()+"    "+menu.getPrice()+"    "+menu.getDs()
                    );
        }
        tx.commit();
      session.close();
    }
   
    public void dropTable()
    {
    	Restaurant menu= session.load(Restaurant.class, "chicken biryani");
    	session.delete(menu);
    	Dish ds = session.load(Dish.class,2);
    	session.delete(ds);
    	 tx.commit();
         session.close();
    }
	
}
