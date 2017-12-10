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

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Address implements Serializable
{
           
       private static final long serialVersionUID = 1L;
           
           @Column(name="LOCALITY",length=500,nullable=false) 
            private String locality;
		   
           @Column(name="CITY",length=500,nullable=false)
            private String city;
                              
           @Column(name="PINCODE",columnDefinition="char(6)",nullable=false)
           private String pincode;
                              
           @Column(name="STE",length=50,nullable=false)
           private String state;
                              
           @Column(name="COUNTRY",length=50,nullable=false)
           private String country;
		   
           public Address()
           {		   
	       locality="";
	       city="";
                     pincode="";
	       state="";
	       country="";
           }
		   
           public String getLocality() 
           {
	     return (locality);
           }

           public void setLocality(String locality) 
           {
	     this.locality = locality;
           }

           public String getCity() 
           {
                   return (city);
           }

            public void setCity(String city) 
            {
	     this.city = city;
            }

            public String getPincode() 
            {
	      return (pincode);
            }

            public void setPincode(String pincode) 
            {
	      this.pincode = pincode;
            }

            public String getState() 
            {
	       return (state);
            }

            public void setState(String state) 
            {
	       this.state = state;
             }

             public String getCountry() 
             {
	       return (country);
             }

              public void setCountry(String country) 
              {
	       this.country = country;
              }
}
