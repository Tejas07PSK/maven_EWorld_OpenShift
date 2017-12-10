/*  -> Designed for testing and development purposes.
 *  -> Project to design a small places prototype app.
 *  -> Development Phase -- Premature.
 *  -> Project Type -- Educational.
 *  -> Institute -- University Institute Of Technology, Burdwan University.
 *  -> Owner/Code file Designer :
 *             @ Name - Palash Sarkar.
 *             @ Department - Computer Science And Engineering.
 *             @ Roll.Number - 2014_1038.
 *             @ Email - palashsarkar0007@gmail.com.
 *  -> Copyright Norms - Every piece of code given below 
 *                       has been written by 'Palash Sarkar (Tj07)'©,
 *                       and he holds the rights to the file. Not meant to be
 *                       copied or tampered without prior permission
 *                       from the author. 
 *  -> Guide - Asst.Proff. Dr. S.K. Gupta.            
 */

package com.aps.datahandling;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import java.io.Serializable;

public abstract class Logic implements Serializable
{
       
     private static final long serialVersionUID = 1L;
       
       private static SessionFactory sf=null;
       static
       {
           if (sf==null)
           {
               try{
                         System.setProperty("hibernate.dialect.storage_engine","innodb");
                         sf=new Configuration().configure().buildSessionFactory();
                  }catch (Throwable ex)
                         {
                              System.out.println("Failed to create sessionFactory object."+ex);
                              ex.printStackTrace();
                         }
           }
       }
       
       public static void reset()
       {
             sf.close();
             try{
                         sf=new Configuration().configure().buildSessionFactory();
                  }catch (Throwable ex)
                         {
                              System.out.println("Failed to create sessionFactory object."+ex);
                              ex.printStackTrace();
                         }
       }
       
       public static void stop()
       {
               sf.close();
       }
       
       public static SessionFactory getSf()
       {
               return (sf);
       }
       
}
