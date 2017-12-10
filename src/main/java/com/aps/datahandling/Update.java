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

import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.aps.entitiespojos.UserRatings;
import com.aps.entitiespojos.UserDetails;

public final class Update extends Logic implements Serializable 
{
        private static final long serialVersionUID = 1L;
     
        private static SessionFactory sf;
        
        synchronized public static boolean updateRating(String ... vals)
        {
                 int chk=0;
                 int nor=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("update UserRatings ur set ur.rat=:rating, ur.comm=:comment where ur.rat_id=:rid");
                        qry.setParameter("rid", vals[0]);
                        qry.setParameter("rating", vals[1]);
                        qry.setParameter("comment", vals[2]);
                        nor=qry.executeUpdate();
                        System.out.println("No. Of rows updated="+nor);
                        s.getTransaction().commit();
                    }catch (Exception e)
                         {
                                 chk=-1;
                                  System.out.println("HibernateException Occured!!"+e);
                                 e.printStackTrace();
                         }
                    finally
                         {
                                 if(s!=null)
                                 {
                                      s.clear();
                                      s.close();
                                 }
                         }
                    if(chk==0)
                    {
                         if(nor!=0)
                         {
                              return (true);
                         }
                         else
                         {
                              return (false);
                         }
                    }
                    else
                    {
                         return (false);
                    }
        }
        
        synchronized public static boolean updateUserEmail(String ... vals)
        {
                 int chk=0;
                 int nor=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("update UserDetails ud set ud.email_id=:email where ud.usr_id=:uid");
                        qry.setParameter("uid", vals[0]);
                        qry.setParameter("email", vals[1]);
                        nor=qry.executeUpdate();
                        System.out.println("No. Of rows updated="+nor);
                        s.getTransaction().commit();
                    }catch (Exception e)
                         {
                                 chk=-1;
                                  System.out.println("HibernateException Occured!!"+e);
                                 e.printStackTrace();
                         }
                    finally
                         {
                                 if(s!=null)
                                 {
                                      s.clear();
                                      s.close();
                                 }
                         }
                    if(chk==0)
                    {
                        if(nor!=0) 
                        {
                             return (true);
                        }
                        else
                        {
                             return (false);
                        }
                    }
                    else
                    {
                         return (false);
                    }
        }
        
        synchronized public static boolean updateUserPhone(String ... vals)
        {
                 int chk=0;
                 int nor=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("update UserDetails ud set ud.mob_no=:mobno where ud.usr_id=:uid");
                        qry.setParameter("uid", vals[0]);
                        qry.setParameter("mobno", vals[1]);
                        nor=qry.executeUpdate();
                        System.out.println("No. Of rows updated="+nor);
                        s.getTransaction().commit();
                    }catch (Exception e)
                         {
                                 chk=-1;
                                  System.out.println("HibernateException Occured!!"+e);
                                 e.printStackTrace();
                         }
                    finally
                         {
                                 if(s!=null)
                                 {
                                      s.clear();
                                      s.close();
                                 }
                         }
                    if(chk==0)
                    {
                         if(nor!=0)
                         {
                              return (true);
                         }
                         else
                         {
                              return (false);
                         }
                    }
                    else
                    {
                         return (false);
                    }
        }
        
        synchronized public static boolean updateUserPassword(String ... vals)
        {
                 int chk=0;
                 int nor=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("update UserDetails ud set ud.pass=:passw where ud.usr_id=:uid");
                        qry.setParameter("uid", vals[0]);
                        qry.setParameter("passw", vals[1]);
                        nor=qry.executeUpdate();
                        System.out.println("No. Of rows updated="+nor);
                        s.getTransaction().commit();
                    }catch (Exception e)
                         {
                                 chk=-1;
                                  System.out.println("HibernateException Occured!!"+e);
                                 e.printStackTrace();
                         }
                    finally
                         {
                                 if(s!=null)
                                 {
                                      s.clear();
                                      s.close();
                                 }
                         }
                    if(chk==0)
                    {
                         if(nor!=0)
                         {
                             return (true);
                         }
                         else
                         {
                            return (false);
                         }
                    }
                    else
                    {
                         return (false);
                    }
        }
}
