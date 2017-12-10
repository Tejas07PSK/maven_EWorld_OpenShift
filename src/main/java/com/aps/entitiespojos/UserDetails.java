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

package com.aps.entitiespojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity 
@Table (name="USER_DETAILS")
public class UserDetails implements Serializable
{
	 
	private static final long serialVersionUID = 1L;
	 
               @Embedded
	        private Address ad;
	 
               @Id
               @Column (name="USER_ID",unique=true,nullable=false)
                private String usr_id;
	 
               @Column (name="FIRST_NAME",length=50,nullable=false)
                private String firstname;
	 
               @Column (name="LAST_NAME",length=50,nullable=false)
                private String lastname;
        
               @Column (name="EMAIL_ID",length=500,unique=true,nullable=false)
                private String email_id;
	 
               @Column (name="MOB_NO",unique=true,nullable=false,columnDefinition="char(10)")
                private String mob_no;
               
               @Column (name="PASSWORD",length=25,unique=true,nullable=false)
                private String pass; 
               
               @OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
               @JoinTable(name="USER_RATINGS_NORMAL_MAP",joinColumns=@JoinColumn(name="UID"),
                          inverseJoinColumns=@JoinColumn(name="RATING_ID")
                         )
                private Collection<UserRatings> ur;
	 
	     public UserDetails()
	     {
	           ur=new ArrayList <UserRatings> ();
                   ad=new Address();
                   usr_id="";
	           firstname="";
	           lastname="";
	           email_id="";
	           mob_no="";
                   pass="";
	     }
           
             public void setUr(Collection <UserRatings> ur)
             {
                   this.ur=ur;
             }
            
             public Collection <UserRatings> getUr()
             {
                   return (ur);
             }
           
             public Address getAddress()
             {
                   return (ad);
             }
             
             public void setAddress(Address ad)
             {
                   this.ad=ad;
             }

	     public String getUsr_id() 
	     {
		   return (usr_id);
	     }

	     public void setUsr_id(String usr_id) 
	     {
		   this.usr_id = usr_id;
	     }

	     public String getFirstname() 
	     {
		   return (firstname);
	     }

	     public void setFirstname(String firstname) 
	     {
		   this.firstname = firstname;
	     }

	     public String getLastname() 
	     {
		   return (lastname);
	     }

	     public void setLastname(String lastname) 
	     {
		   this.lastname = lastname;
	     }

	     public String getEmail_id() 
	     {
		   return (email_id);
	     }

	     public void setEmail_id(String email_id) 
	     {
		   this.email_id = email_id;
	     }

	     public String getMob_no() 
	     {
		   return (mob_no);
	     }

	     public void setMob_no(String mob_no) 
	     {
		   this.mob_no = mob_no;
	     }
          
             public void setPass(String password)
             {
                   this.pass = password;
             }
             
             public String getPass()
             {
                    return (pass);
             }
          
}

