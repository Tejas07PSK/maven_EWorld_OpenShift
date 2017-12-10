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

import com.aps.entitiespojos.Address;
import com.aps.entitiespojos.Places;
import com.aps.entitiespojos.UserDetails;
import com.aps.entitiespojos.UserRatings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public final class Validate extends Logic implements Serializable
{
        private static final long serialVersionUID = 1L;
     
        private static SessionFactory sf;
        
        synchronized public static boolean isUserEmailExists(String email)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<String> lst=new ArrayList<String> ();
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("select usr_id from UserDetails ud where ud.email_id=:eid");
                        qry.setParameter("eid", email);
                        lst=qry.getResultList();
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
                          if (lst.isEmpty())
                          {
                                return (false);
                          }
                          else
                          {
                               return (true);
                          }
                    }
                    else
                    {
                         return (true);
                    }
        }
        
        synchronized public static boolean isUserPhoneExists(String pno)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<String> lst=new ArrayList<String> ();
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("select usr_id from UserDetails ud where ud.mob_no=:mobno");
                        qry.setParameter("mobno", pno);
                        lst=qry.getResultList();
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
                          if (lst.isEmpty())
                          {
                                return (false);
                          }
                          else
                          {
                               return (true);
                          }
                    }
                    else
                    {
                         return (true);
                    }
        }
        
        synchronized public static boolean isUserPasswordExists(String pass)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<String> lst=new ArrayList<String> ();
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("select usr_id from UserDetails ud where ud.pass=:pss");
                        qry.setParameter("pss", pass);
                        lst=qry.getResultList();
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
                          if (lst.isEmpty())
                          {
                                return (false);
                          }
                          else
                          {
                               return (true);
                          }
                    }
                    else
                    {
                         return (true);
                    }
        }
        
        synchronized public static boolean isPlaceExists(String desc)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<String> lst=new ArrayList<String> ();
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("select pl_id from Places pl where pl.pl_desc=:pldesc");
                        qry.setParameter("pldesc", desc);
                        lst=qry.getResultList();
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
                          if (lst.isEmpty())
                          {
                                return (false);
                          }
                          else
                          {
                               return (true);
                          }
                    }
                    else
                    {
                         return (true);
                    }
        }
        
        synchronized public static String isRatingExists(UserDetails ud,String placeid)
        {
                 String rid = null;
                 for (UserRatings ur : ud.getUr())
                 {
                       if(placeid.equalsIgnoreCase(ur.getPl().getPl_id()))
                       {
                              rid = ur.getRat_id();
                              break;
                       }
                 }
                 if (rid!=null)
                 {
                      return (rid);
                 }
                 else
                 {
                      return (null);
                 }
        }
        
        synchronized public static boolean isUserExists(String uid, String passw)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<String> lst=new ArrayList<String> ();
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("select usr_id from UserDetails ud where ud.usr_id=:urid and ud.pass=:passd");
                        qry.setParameter("urid", uid);
                        qry.setParameter("passd",passw);
                        lst=qry.getResultList();
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
                          if (lst.isEmpty())
                          {
                                return (false);
                          }
                          else
                          {
                               return (true);
                          }
                    }
                    else
                    {
                         return (false);
                    }
        }
        
}
