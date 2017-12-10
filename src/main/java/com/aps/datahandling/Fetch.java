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

import com.aps.entitiespojos.Places;
import java.io.Serializable;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import com.aps.entitiespojos.UserDetails;
import com.aps.entitiespojos.UserRatings;
import java.util.ArrayList;
import java.util.List;

public final class Fetch extends Logic implements Serializable 
{
        private static final long serialVersionUID = 1L;
     
        private static SessionFactory sf;
        
        synchronized public static UserDetails getUserFromEmail(String email)
        {
                 UserDetails ud = null;
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("from UserDetails ud where ud.email_id=:eid");
                        qry.setParameter("eid", email);
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
                         //ud=lst.get(0);
                         return (ud);
                    }
                    else
                    {
                         return (new UserDetails());
                    }
        }
        
        synchronized public static Places getPlaceFromDesc(String desc)
        {
                 Places pl = null;
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("from Places pl where pl.pl_desc=:pldesc");
                        qry.setParameter("pldesc", desc);
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
                         return (pl);
                    }
                    else
                    {
                         return (new Places());
                    }
        }
        
        synchronized public static UserDetails getUserFromId(String userid)
        {
                 UserDetails ud = null;
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("from UserDetails ud where ud.usr_id=:uid");
                        qry.setParameter("uid", userid);
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
                         return (ud);
                    }
                    else
                    {
                         return (new UserDetails());
                    }
        }
        
        synchronized public static UserRatings getUserRatingForPlace(UserDetails ud,String placeid)
        {
                 UserRatings ur = null;
                 for (UserRatings urt : ud.getUr())
                 {
                       if(placeid.equalsIgnoreCase(urt.getPl().getPl_id()))
                       {
                              ur = urt;
                              break;
                       }
                 }
                 if (ur!=null)
                 {
                      return (ur);
                 }
                 else
                 {
                      return (new UserRatings());
                 }
        }
        
        synchronized public static List<Places> getPlaceFromType(String plctype)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<Places> plt=new ArrayList<Places> (); 
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("from Places pl where pl.pl_type=:plt");
                        qry.setParameter("plt", plctype);
                        plt=(List<Places>)qry.getResultList();
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
                         if(plt.isEmpty())
                         {
                             return (null);
                         }
                         else
                         {
                              return (plt);
                         }
                    }
                    else
                    {
                         return (null);
                    }
        }
        
        synchronized public static List<Places> getPlaceFromLocality(String plclocality)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<Places> pllc=new ArrayList<Places> (); 
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("from Places pl where pl.addr.locality=:plcloc");
                        qry.setParameter("plcloc", plclocality);
                        pllc=(List<Places>)qry.getResultList();
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
                         if(pllc.isEmpty())
                         {
                             return (null);
                         }
                         else
                         {
                              return (pllc);
                         }
                    }
                    else
                    {
                         return (null);
                    }
        }
        
        synchronized public static List<Places> getPlaceFromName(String pname)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<Places> pllc=new ArrayList<Places> (); 
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("from Places pl where pl.pname=:pnm");
                        qry.setParameter("pnm", pname);
                        pllc=(List<Places>)qry.getResultList();
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
                         if(pllc.isEmpty())
                         {
                             return (null);
                         }
                         else
                         {
                              return (pllc);
                         }
                    }
                    else
                    {
                         return (null);
                    }
        }
        
        synchronized public static List<Object> getPlaceRating(String plcid)
        {
                 int chk=0;
                 sf=Logic.getSf();
                 Session s = null;
                 List<Object> lo=new ArrayList<Object> (); 
                 try{
                        s=sf.openSession();
                        s.beginTransaction();
                        Query qry=s.createQuery("from Places pl where pl.pl_id=:plid");
                        qry.setParameter("plid", plcid);
                        lo.add(qry.getSingleResult());
                        qry=s.createQuery("select ur from UserRatings ur left join ur.pl as plc where plc.pl_id=:plid");
                        qry.setParameter("plid", plcid);
                        lo.add(qry.getResultList());
                        List<UserRatings> ur = (List<UserRatings>)lo.get(1);
                        List<Object[]> o = new ArrayList<Object[]>();
                        for(UserRatings urt:ur)
                        {
                             o.add((Object[])((s.createQuery("select ud.firstname, ud.lastname from UserDetails ud left join ud.ur as urat where urat.rat_id=:rid")).setParameter("rid",urt.getRat_id())).getSingleResult());
                        }
                        lo.add(o);
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
                         if(lo.isEmpty())
                         {
                             return (null);
                         }
                         else
                         {
                              return (lo);
                         }
                    }
                    else
                    {
                         return (null);
                    }
        }
}
