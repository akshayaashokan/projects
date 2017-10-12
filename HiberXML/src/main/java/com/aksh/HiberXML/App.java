package com.aksh.HiberXML;

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
       
        Person pb = new Person();
         pb.setFirstname("akshaya");
         pb.setAge(22);
         pb.setLastname("ashokan");
        
         Person pb1 = new Person();
         pb1.setFirstname("anjaly");
         pb1.setAge(22);
         pb1.setLastname("nair");
         Person pb2 = new Person();
         pb2.setFirstname("afeefa");
         pb2.setAge(22);
         pb2.setLastname("rahnas");
        
    	Configuration con = new Configuration().configure().addAnnotatedClass(Person.class);
    	SessionFactory sf= con.buildSessionFactory();
    	Session session= sf.openSession();
    	Transaction tx = session.beginTransaction();
    	session.save(pb);
    	session.save(pb1);
    	session.save(pb2);
    	tx.commit();
    	session.close();
    }
}
