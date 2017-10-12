package com.aksh.HibDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	HiberDemo hb = new HiberDemo();
    	hb.setName("akshaya");
    	HiberDemo hb1 = new HiberDemo();
    	hb1.setName("anjaly");
    	HiberDemo hb2 = new HiberDemo();
    	hb2.setName("afeefa");
    	Configuration con = new Configuration().configure().addAnnotatedClass(HiberDemo.class);
    	SessionFactory sf= con.buildSessionFactory();
    	Session session= sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(hb);
    	session.save(hb1);
    	
    	
    	
    	
    	session.save(hb2);
    	tx.commit();
    	session.close();
    }
}
