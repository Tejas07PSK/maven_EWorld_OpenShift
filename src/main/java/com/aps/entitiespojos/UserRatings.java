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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table (name="USER_RATINGS")
public class UserRatings implements Serializable
{
           
       private static final long serialVersionUID = 1L;
           
           @Id
           @Column (name="RATING_ID",unique=true)
            private String rat_id;
           
           @Column (name="RATING",length=5)
            private String rat;
           
           @Column (name="COMMENTS",length=1000)
            private String comm;
           
           @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
           @JoinColumn(name="PLACE_ID")
            private Places pl;
           
           public UserRatings()
           {
                 pl=new Places();
                 rat_id="";
                 rat="";
           }

          public String getComm() 
          {
                 return (comm);
          }

          public void setComm(String comm) 
          {
                 this.comm = comm;
          }
           
           public Places getPl() 
           {
                return (pl);
           }

           public void setPl(Places pl) 
           {
                this.pl = pl;
           }
           
           public String getRat_id() 
           {
                 return (rat_id);
           }

           public void setRat_id(String rat_id) 
           {
                this.rat_id = rat_id;
           }

           public String getRat() 
           {
                return (rat);
           }

           public void setRat(String rat) 
           {
                this.rat = rat;
           }
           
}
