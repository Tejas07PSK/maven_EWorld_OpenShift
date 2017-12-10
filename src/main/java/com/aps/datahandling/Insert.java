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
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.Random;

 public final class Insert extends Logic implements Serializable
 {
        
      private static final long serialVersionUID = 1L;
     
        private static SessionFactory sf;
        synchronized public static boolean insert(char cs,String ... vals)
        {
             switch (cs)
             {
                  case 'U' : UserDetails ud=setUserDets(vals);
                             return(insert (ud,cs)); 
                  case 'P' : Places pl=setPlace(vals);
                             return(insert(pl,cs));
                  case 'R' : ArrayList<Object> arr=setUserRatings(vals);
                             return(insert(arr,cs));
                  default : return(false);
                             
             }
        }
        
	synchronized private static UserDetails setUserDets(String ... vals)
        {
                   UserDetails ud = new UserDetails ();
                   Address ad = ud.getAddress();
                   ud.setFirstname(vals[0]);
                   ud.setLastname(vals[1]);
                   ud.setMob_no(vals[2]);
                   ud.setEmail_id(vals[3]);
                   ud.setPass(vals[4]);
                   ad.setLocality(vals[5]);
                   ad.setCity(vals[6]);
                   ad.setPincode(vals[7]);
                   ad.setState(vals[8]);
                   ad.setCountry(vals[9]);
                   ud.setUsr_id(generateUSER_ID());
                   ud.setAddress(ad);
                   return (ud);
        }
        
        synchronized private static Places setPlace(String ... vals)
        {
                 UserDetails ud=null;
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                       s=sf.openSession();
                       s.beginTransaction();
                       Query qry=s.createQuery("from UserDetails ud where ud.usr_id=:uid");
                       qry.setParameter("uid", vals[0]);
                       ud=(UserDetails)qry.getSingleResult();
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
                           Places pl=new Places ();
                           Address addr = pl.getAddr();
                           pl.setPname(vals[1]);
                           pl.setPl_type(vals[2]);
                           pl.setPl_id(generatePLACE_ID());
                           addr.setLocality(vals[3]);
                           addr.setCity(vals[4]);
                           addr.setPincode(vals[5]);
                           addr.setState(vals[6]);
                           addr.setCountry(vals[7]);
                           pl.setAddr(addr);
                           pl.setPl_desc(vals[8]);
                           pl.setUd(ud);
                           return (pl);
                   }
                   else
                   {
                        return (null);
                   }
         }
        
        synchronized private static ArrayList<Object> setUserRatings(String ... vals)
        {
                 UserDetails ud=null;
                 Places pl=null;
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("from UserDetails ud where ud.usr_id=:uid");
                        qry.setParameter("uid", vals[0]);
                        ud=(UserDetails)qry.getSingleResult();
                        qry=s.createQuery("from Places p where p.pl_id=:pid");
                        qry.setParameter("pid",vals[1]);
                        pl=(Places)qry.getSingleResult();
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
                           UserRatings ur=new UserRatings ();
                           ur.setRat(vals[2]);
                           ur.setComm(vals[3]);
                           ur.setRat_id(generateRATE_ID());
                           ur.setPl(pl);
                           ArrayList<Object> arr=new ArrayList<Object> ();
                           arr.add(ud);
                           arr.add(ur);
                           return (arr);
                   }
                   else
                   {
                        return (null);
                   }
                 
        }
        synchronized private static boolean insert(Object O,char cs)
        {
                if (cs=='U')
                {
                       int chk =0;
                       sf=Logic.getSf();
                       Session s=null;
                       try {
                                s=sf.openSession();
                                s.beginTransaction();
                                s.saveOrUpdate((UserDetails)O);
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
                       
                       return ((chk==0));
                }
                if (cs=='P')
                {
                       int chk =0;
                       sf=Logic.getSf();
                       Session s=null;
                       try {
                                s=sf.openSession();
                                s.beginTransaction();
                                s.saveOrUpdate((Places)O);
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
                       
                       return ((chk==0));
                 }
                if (cs=='R')
                {
                       UserDetails ud = null;
                       UserRatings ur = null;
                       int chk =0;
                       sf=Logic.getSf();
                       Session s=null;
                       try {
                                s=sf.openSession();
                                s.beginTransaction();
                                ud=(UserDetails)(((ArrayList<Object>)O).get(0));
                                ur=(UserRatings)(((ArrayList<Object>)O).get(1));
                                ud.getUr().add(ur);
                                s.saveOrUpdate(ud);
                                s.saveOrUpdate(ur);
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
                       
                       return ((chk==0));    
                }
                else
                  {
                       return (false);
                  }
        }
        
        private static String generateUSER_ID() 
	{
		Random r = new Random ();
		int x = r.nextInt(50000);
		String uid = "UID"+x;
		      return (uid);
	}
              
        private static String generatePLACE_ID() 
	{
		Random r = new Random ();
		int x = r.nextInt(50000);
		String pid = "PL"+x;
		      return (pid);
	}
              
        private static String generateRATE_ID() 
	{
		Random r = new Random ();
		int x = r.nextInt(50000);
		String rid = "RT"+x;
		       return (rid);
	}
        
 }
