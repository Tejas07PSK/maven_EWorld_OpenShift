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
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="PLACES")
public class Places implements Serializable
{
        private static final long serialVersionUID = 1L;
        
        @Id
        @Column(name="PLACE_ID",unique=true)
        private String pl_id;
        
        @Column(name="PLACE_NAME",length=500)
        private String pname;
        
        @Column(name="PLACE_TYPE",length=50)
        private String pl_type;
        
        @Column(name="PLACE_DESC",unique=true,length=1000)
        private String pl_desc;
        
        @Embedded
        @AttributeOverrides({
                                @AttributeOverride(name="locality",column=@Column(name="PL_LOCALITY",length=500,nullable=false)),
                                @AttributeOverride(name="city",column=@Column(name="PL_CITY",length=500,nullable=false)),
                                @AttributeOverride(name="pincode",column=@Column(name="PL_PINCODE",columnDefinition="char(6)",nullable=false)),
                                @AttributeOverride(name="state",column=@Column(name="PL_STE",length=50,nullable=false)),
                                @AttributeOverride(name="country",column=@Column(name="PL_COUNTRY",length=50,nullable=false))
                             })
        private Address addr;
        
        @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
        @JoinColumn(name="USER_ID")
        private UserDetails ud;
        
        public Places()
        {
             ud=new UserDetails();
             pl_id="";
             pname="";
             pl_type="";
             pl_desc="";
             addr=new Address();
        }
        
        public void setUd(UserDetails ud)
        {
              this.ud=ud;
        }
        
        public UserDetails getUd()
        {
              return (ud);
        }

        public String getPl_id() 
        {
            return (pl_id);
        }

        public void setPl_id(String pl_id) 
        {
            this.pl_id = pl_id;
        }

        public String getPname() 
        {
              return (pname);
        }

        public void setPname(String pname) 
        {
             this.pname = pname;
        }

        public String getPl_type() 
        {
             return (pl_type);
        }

        public void setPl_type(String pl_type) 
        {
             this.pl_type = pl_type;
        }

        public String getPl_desc() 
        {
             return (pl_desc);
        }

        public void setPl_desc(String pl_desc) 
        {
             this.pl_desc = pl_desc;
        }
        
        public Address getAddr()
        {
               return (addr);
        }
        
        public void setAddr(Address addr)
        {
              this.addr=addr;
        }
        
}
