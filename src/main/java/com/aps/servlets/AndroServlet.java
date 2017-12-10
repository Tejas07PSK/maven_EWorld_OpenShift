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

package com.aps.servlets;

import com.aps.datahandling.Fetch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import com.aps.datahandling.Insert;
import com.aps.datahandling.Update;
import com.aps.datahandling.Validate;
import com.aps.entitiespojos.Places;
import com.aps.entitiespojos.UserDetails;
import com.aps.entitiespojos.UserRatings;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;


public final class AndroServlet extends HttpServlet 
{
           
     private static final long serialVersionUID = 1L;
	
              private static  InetAddress ip ;
	private static  String ipadd  ;
          
              @Override
	public void init()
	{
                    System.setProperty("java.net.preferIPv4Stack", "true");
                    try{
	                ip = InetAddress.getLocalHost();
	                ipadd = ip.getHostAddress();
	          }catch (UnknownHostException e)
		{
		       e.printStackTrace();
		}
	}
          
            @Override
            @SuppressWarnings({"unchecked", "unchecked"})
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
                         response.setContentType("text/json");
	           response.setCharacterEncoding("UTF-8");
	           response.setBufferSize(8192);
                         PrintWriter out = null;
                         
                         if (Validate.isUserExists(request.getParameter("uid"),request.getParameter("pass")))
                         {
                                          out=response.getWriter();
                                          out.print("Login Success!! \n"
                                                      +"Welcome User : "+request.getParameter("uid")+" \n");
                                          out.flush();
                                          out.close();
                         }
                         else
                            {
                                  out=response.getWriter();
                                  out.print("ERROR!! \n"
			     + "FAILED!!! Incorrect User_Id Or Password. \n"
                                              + "REASON -- User/Password Does Not Exist!! \n"
			     + "Please Enter Correct Credentials!! \n");
                                  out.flush();
                                  out.close();
                            }
                         return;
            }
            
            @Override
            @SuppressWarnings({"unchecked", "unchecked"})
             protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
             {
                         response.setContentType("text/json");
	           response.setCharacterEncoding("UTF-8");
	           response.setBufferSize(8192);
                         PrintWriter out = null;
                         StringWriter sw = null;
                         JSONObject jsobj = null;
                         JSONArray arr = null;
                     
                     switch (Integer.parseInt(request.getParameter("case")))
                     {
                          case 1 : List<Places> plt = Fetch.getPlaceFromType (request.getParameter("plctype"));
                                   if (plt!=null)
                                   {
                                         out = response.getWriter();
                                         arr = new JSONArray();
                                         for (Places pl : plt)
                                         {
                                                jsobj = new JSONObject();
                                                jsobj.put("PLACE_ID", pl.getPl_id());
                                                jsobj.put("PLACE_NAME",pl.getPname()); 
                                                jsobj.put("PLACE_TYPE",pl.getPl_type());
                                                jsobj.put("PLACE_LOCALITY",(pl.getAddr()).getLocality());
                                                jsobj.put("PLACE_CITY",(pl.getAddr()).getCity());
                                                jsobj.put("PLACE_PINCODE",(pl.getAddr()).getPincode());
                                                jsobj.put("PLACE_STATE",(pl.getAddr()).getState());
                                                jsobj.put("PLACE_COUNTRY",(pl.getAddr()).getCountry());
                                                jsobj.put("PLACE_DESCRIPTION",pl.getPl_desc());
                                                arr.add(jsobj);
                                         }
                                               jsobj = new JSONObject ();
                                               jsobj.put("LIST_OF_PLACES_ACCTO_TYPE", arr);
                                         sw = new StringWriter ();
                                               jsobj.writeJSONString(sw);
                                         out.println(sw.toString());
                                         sw.flush();
                                         sw.close();
                                         out.flush();
                                         out.close();
                                   }
                                   else
                                   {
                                         out=response.getWriter();
                                         out.print("ERROR!! \n"
			             + "FAILED!!! No Place Type. \n"
                                                      + "REASON -- Places of such type don't exist in our database!! \n"
			             + "Please Enter correct Place Type!! \n");
                                         out.flush();
                                         out.close();    
                                   }
                                   return;
                         case 2 :  List<Places> pllc = Fetch.getPlaceFromLocality(request.getParameter("plclocality"));
                                   if (pllc!=null)
                                   {
                                         out = response.getWriter();
                                         arr = new JSONArray();
                                         for (Places pl : pllc)
                                         {
                                                jsobj = new JSONObject();
                                                jsobj.put("PLACE_ID", pl.getPl_id());
                                                jsobj.put("PLACE_NAME",pl.getPname()); 
                                                jsobj.put("PLACE_TYPE",pl.getPl_type());
                                                jsobj.put("PLACE_LOCALITY",(pl.getAddr()).getLocality());
                                                jsobj.put("PLACE_CITY",(pl.getAddr()).getCity());
                                                jsobj.put("PLACE_PINCODE",(pl.getAddr()).getPincode());
                                                jsobj.put("PLACE_STATE",(pl.getAddr()).getState());
                                                jsobj.put("PLACE_COUNTRY",(pl.getAddr()).getCountry());
                                                jsobj.put("PLACE_DESCRIPTION",pl.getPl_desc());
                                                arr.add(jsobj);
                                         }
                                                jsobj = new JSONObject ();
                                                jsobj.put("LIST_OF_PLACES_ACCTO_LOCALITY", arr);
                                         sw = new StringWriter ();
                                                jsobj.writeJSONString(sw);
                                         out.println(sw.toString());
                                         sw.flush();
                                         sw.close();
                                         out.flush();
                                         out.close();     
                                   }
                                   else
                                   {
                                         out=response.getWriter();
                                               out.print("ERROR!! \n"
			    	        + "FAILED!!! No Place Type. \n"
                                                               + "REASON -- Places of such type don't exist in our database!! \n"
			    	        + "Please enter correct locality!!! \n");
                                               out.flush();
                                               out.close();    
                                   }
                                   return;
                         case 4 : List<Places> pln = Fetch.getPlaceFromName(request.getParameter("pname"));
                                   if (pln!=null)
                                   {
                                         out = response.getWriter();
                                         arr = new JSONArray();
                                         for (Places pl : pln)
                                         {
                                                jsobj = new JSONObject();
                                                jsobj.put("PLACE_ID", pl.getPl_id());
                                                jsobj.put("PLACE_NAME",pl.getPname()); 
                                                jsobj.put("PLACE_TYPE",pl.getPl_type());
                                                jsobj.put("PLACE_LOCALITY",(pl.getAddr()).getLocality());
                                                jsobj.put("PLACE_CITY",(pl.getAddr()).getCity());
                                                jsobj.put("PLACE_PINCODE",(pl.getAddr()).getPincode());
                                                jsobj.put("PLACE_STATE",(pl.getAddr()).getState());
                                                jsobj.put("PLACE_COUNTRY",(pl.getAddr()).getCountry());
                                                jsobj.put("PLACE_DESCRIPTION",pl.getPl_desc());
                                                arr.add(jsobj);
                                         }
                                                jsobj = new JSONObject ();
                                                jsobj.put("LIST_OF_PLACES_ACCTO_NAME", arr);
                                         sw = new StringWriter ();
                                                jsobj.writeJSONString(sw);
                                         out.println(sw.toString());
                                         sw.flush();
                                         sw.close();
                                         out.flush();
                                         out.close();     
                                   }
                                   else
                                   {
                                         out=response.getWriter();
                                               out.print("ERROR!! \n"
			    	        + "FAILED!!! No Place Type. \n"
                                                               + "REASON -- Places of such type don't exist in our database!! \n"
			    	        + "Please enter correct locality!!! \n");
                                               out.flush();
                                               out.close();    
                                   }
                                  return;
                         case 3 : List<Object> lo=Fetch.getPlaceRating(request.getParameter("plid"));
                                  if (lo!=null)
                                   {
                                         double avg = 0.0;
                                         double sum = 0.0;
                                         int num = 0;
                                         out = response.getWriter();
                                         arr = new JSONArray();
                                         jsobj = new JSONObject();
                                         jsobj.put("PLACE_ID", ((Places)lo.get(0)).getPl_id());
                                                jsobj.put("PLACE_NAME",((Places)lo.get(0)).getPname()); 
                                                jsobj.put("PLACE_TYPE",((Places)lo.get(0)).getPl_type());
                                                jsobj.put("PLACE_LOCALITY",(((Places)lo.get(0)).getAddr()).getLocality());
                                                jsobj.put("PLACE_CITY",(((Places)lo.get(0)).getAddr()).getCity());
                                                jsobj.put("PLACE_PINCODE",(((Places)lo.get(0)).getAddr()).getPincode());
                                                jsobj.put("PLACE_STATE",(((Places)lo.get(0)).getAddr()).getState());
                                                jsobj.put("PLACE_COUNTRY",(((Places)lo.get(0)).getAddr()).getCountry());
                                                jsobj.put("PLACE_DESCRIPTION",((Places)lo.get(0)).getPl_desc());
                                        JSONObject tmp = null;
                                        for (UserRatings ur : (List<UserRatings>)lo.get(1))
                                        {
                                             tmp = new JSONObject ();
                                             tmp.put("USER_NAME",((((List<Object []>)lo.get(2)).get(num))[0]+" "+(((List<Object []>)lo.get(2)).get(num))[1]));
                                             tmp.put("RATING_GIVEN",ur.getRat());
                                             tmp.put("USER_COMMENTS",ur.getComm());
                                             arr.add(tmp);
                                             sum = sum + Double.parseDouble(ur.getRat());
                                             num++;
                                        }
                                        avg = sum/num;
                                                jsobj.put("AVERAGE_PLACE_RATING", avg);
                                                jsobj.put("USER_RATING_LIST",arr);
                                         sw = new StringWriter ();
                                                jsobj.writeJSONString(sw);
                                         out.println(sw.toString());
                                         sw.flush();
                                         sw.close();
                                         out.flush();
                                         out.close(); 
                                   }
                                   else
                                   {
                                         out=response.getWriter();
                                             out.print("ERROR!! \n"
			    	    + "FAILED!!! No Place Type. \n"
                                                           + "REASON -- Places of such type don't exist in our database!! \n"
			    	    + "Please enter correct Place_ID. \n");
                                             out.flush();
                                             out.close();    
                                   }
                                   return;
                         default : if (request.getParameterMap().containsKey("emailid"))
                                   {
                                        if (Validate.isUserEmailExists(request.getParameter("emailid")))
                                          {
                                                   out=response.getWriter();
                                                   out.print("HQL UPDATE ERROR!!"
			    	          + "FAILED!!! Error Occured_database exception. \n"
                                                                 + "REASON -- EmailId Already Exists!! \n"
			    	          + "Please enter a different email_id. \n");
                                                   out.flush();
                                                   out.close();
                                                   return;
                                           } 
                                        else 
                                        {
                                              if (Update.updateUserEmail(request.getParameter("uid"),request.getParameter("emailid")))
                                              {
                                                   out=response.getWriter();
                                                   out.print( "HQL UPDATE Successful!! \n"
			    	          + "Success!!! We have updated your email_id. \n"
                                                                 + "REASON -- Internal hql query successful!!"
			    	          + "Thank you!! \n");
                                                   out.flush();
                                                   out.close();
                                                   return;
                                              }
                                              else
                                              {
                                                   out=response.getWriter();
                                                             out.print("HQL UPDATE ERROR!! \n"
			    	                   + "FAILED!!! Error Occured_database exception. \n"
                                                                          + "REASON -- Internal SQLQuery/Transaction Error!! \n"
			    	                   + "Please try again later!! \n");
                                                             out.flush();
                                                             out.close();
                                              }
                                        }
                                   }
                                   else if (request.getParameterMap().containsKey("mobno"))
                                   {
                                           if (Validate.isUserPhoneExists(request.getParameter("mobno")))
                                          {
                                                   out=response.getWriter();
                                                   out.print("HQL UPDATE ERROR!! \n"
			    	          + "FAILED!!! Error Occured_database exception. \n"
                                                                 + "REASON -- Mobile Number Already Exists!! \n"
			    	          + "Please enter a different mobile number. \n");
                                                   out.flush();
                                                   out.close();
                                                   return;
                                           } 
                                        else 
                                        {
                                              if (Update.updateUserPhone(request.getParameter("uid"),request.getParameter("mobno")))
                                              {
                                                   out=response.getWriter();
                                                   out.print("HQL UPDATE Successful!! \n"
			    	          + "Success!!! We have updated your phone number. \n"
                                                                 + "REASON -- Internal hql query successful!! \n"
			    	          + "Thank you!! \n");
                                                   out.flush();
                                                   out.close();
                                                   return;
                                              }
                                              else
                                              {
                                                   out=response.getWriter();
                                                             out.print("HQL UPDATE ERROR!! \n"
			    	                   + "FAILED!!! Error Occured_database exception. \n"
                                                                          + "REASON -- Internal SQLQuery/Transaction Error!! \n"
			    	                   + "Please try again later!! \n");
                                                             out.flush();
                                                             out.close();
                                              }
                                        }    
                                   }
                                   else if (request.getParameterMap().containsKey("pass"))
                                   {
                                            if (Validate.isUserPasswordExists(request.getParameter("pass")))
                                          {
                                                   out=response.getWriter();
                                                   out.print("HQL UPDATE ERROR!! \n"
			    	          + "FAILED!!! Error Occured_database exception. \n"
                                                                 + "REASON -- Password Already Being Used By Another User!! \n"
			    	          + "Please enter a different password. \n");
                                                   out.flush();
                                                   out.close();
                                                   return;
                                           } 
                                        else 
                                        {
                                              if (Update.updateUserPassword(request.getParameter("uid"),request.getParameter("pass")))
                                              {
                                                   out=response.getWriter();
                                                   out.print("HQL UPDATE Successful!! \n"
			    	         + "Success!!! We have updated your password. \n"
                                                                + "REASON -- Internal hql query successful!! \n"
			    	         + "Thank you!! \n");
                                                   out.flush();
                                                   out.close();
                                                   return;
                                              }
                                              else
                                              {
                                                   out=response.getWriter();
                                                             out.print("HQL UPDATE ERROR!! \n"
			    	                   + "FAILED!!! Error Occured_database exception. \n"
                                                                          + "REASON -- Internal SQLQuery/Transaction Error!! \n"
			    	                   + "Please try again later. \n");
                                                             out.flush();
                                                             out.close();
                                              }
                                        }    
                                   }
                                   return;
                     }
             
             }
             @Override
             protected void doPut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
             {
                         response.setContentType("text/json");
	           response.setCharacterEncoding("UTF-8");
	           response.setBufferSize(8192);
                         PrintWriter out = null;
                         
                             BufferedReader rd = new BufferedReader(new InputStreamReader(request.getInputStream()));
		 StringBuffer req = new StringBuffer();
		 String line = "";
		 while ((line = rd.readLine()) != null) 
		 {
			 req.append(line);
		 }
		 rd.close();
                     
                         JSONParser parser = new JSONParser ();
                         JSONObject jsobj = null; 
	           
                         try 
	           {
	               jsobj=(JSONObject)(parser.parse(req.toString()));
                         }catch(ParseException pe)
                              {
                                     System.out.println(pe);
                                     return;
                              }
                     
                     switch (Integer.parseInt((String)jsobj.get("case")))
                     {
                          case 1 : if (Validate.isUserEmailExists((String)jsobj.get("emailid")))
                                   {
                                          out=response.getWriter();
                                          out.print("HQL INSERTION ERROR!! \n"
			    	+ "FAILED!!! Error Occured_database exception. \n"
                                                       + "REASON -- EmailId Already Exists!! \n"
			    	+ "Please enter a different email_id. \n");
                                          out.flush();
                                          out.close();
                                          return;
                                   } 
                                   if (Validate.isUserPhoneExists((String)jsobj.get("mobno")))
                                   {
                                          out=response.getWriter();
                                          out.print("HQL INSERTION ERROR! \n"
			    	+ "FAILED!!! Error Occured_database exception. \n"
                                                       + "REASON -- MobNo Already Exists!! \n"
			    	+ "Please enter a different mobile number. \n");
                                          out.flush();
                                          out.close(); 
                                          return;
                                   }
                                   if (Validate.isUserPasswordExists((String)jsobj.get("pass")))
                                   {
                                          out=response.getWriter();
                                          out.print("HQL INSERTION ERROR!! \n"
			    	+ "FAILED!!! Error Occured_database exception. \n"
                                                       + "REASON -- Password being used by another User!! \n"
			    	+ "Please enter a different password. \n");
                                          out.flush();
                                          out.close();
                                          return;
                                    }
                                    else
                                    {
                                          if (Insert.insert('U',(String)jsobj.get("firstname"),(String)jsobj.get("lastname"),(String)jsobj.get("mobno"),(String)jsobj.get("emailid"),(String)jsobj.get("pass"),(String)jsobj.get("locality"),(String)jsobj.get("city"),(String)jsobj.get("pincode"),(String)jsobj.get("state"),(String)jsobj.get("country")))
                                          {
                                                        UserDetails ud = Fetch.getUserFromEmail((String)jsobj.get("emailid"));
                                                        out=response.getWriter();
                                                        out.print("HQL INSERTION Successful!! \n"
			    	            + "You have been successfully registered in our database. \n"
                                                                   + "Salut & Welcome to the E-Burdwan community, new User!! \n"
                                                                   + "Given below are your registration details!! \n"
                                                                   + "Firstname - "+ud.getFirstname()+" \n"
	            		                          + "LastName - "+ud.getLastname()+" \n"
	            		                          + "EmailId - "+ud.getEmail_id()+" \n"
	            		                          + "Mobno - "+ud.getMob_no()+" \n"
	            		                          + "Locality - "+(ud.getAddress()).getLocality()+" \n"
	            		                          + "City - "+(ud.getAddress()).getCity()+" \n"
	            		                          + "Pincode - "+(ud.getAddress()).getPincode()+" \n"
	            		                          + "State - "+(ud.getAddress()).getState()+" \n"
	            		                          + "Country - "+(ud.getAddress()).getCountry()+" \n"
                                                                   + "Password - "+ud.getPass()+" \n"
                                                                   + "User_Id - "+ud.getUsr_id()+" \n"
			    	            + "Thank you!! \n");
                                                        out.flush();
                                                        out.close();
                                                        return;
                                          }
                                          else
                                          {
                                                         out=response.getWriter();
                                                         out.print("HQL INSERTION ERROR!! \n"
			    	              + "FAILED!!! Error Occured_database exception. \n"
                                                                     + "REASON -- Internal SQLQuery/Transaction Error!! \n"
                                                                     + "Please Try Again Later!!! \n");
                                                         out.flush();
                                                         out.close();
                                          }
                                                  
                                    }
                                    return;
                                    
                          case 2 : if (Validate.isPlaceExists((String)jsobj.get("plcdesc")))
                                   {
                                            out=response.getWriter();
                                            out.print("HQL INSERTION ERROR!! \n" 
			    	  + "FAILED!!! Error Occured_database exception. \n"
                                                         + "REASON -- Place Already Exists!! \n"
			    	  + "Please enter a unique description. \n");
                                            out.flush();
                                            out.close();
                                            return;
                                   }
                                   else
                                   {
                                          if (Insert.insert('P',(String)jsobj.get("uid"),(String)jsobj.get("plname"),(String)jsobj.get("pltype"),(String)jsobj.get("plocality"),(String)jsobj.get("pcity"),(String)jsobj.get("ppincode"),(String)jsobj.get("pstate"),(String)jsobj.get("pcountry"),(String)jsobj.get("plcdesc")))
                                          {
                                                        Places pl = Fetch.getPlaceFromDesc((String)jsobj.get("plcdesc"));
                                                        out=response.getWriter();
                                                        out.print("HQL INSERTION Successful!! \n"
			    	              + "You have successfully inserted a place in our database. \n"
                                                                     + "Salut & Welcome to the E-Burdwan community, User!! \n"
                                                                     + "Given below are the details about the place you inserted!! \n"
                                                                     + "UserId - "+(String)jsobj.get("uid")+" \n"
                                                                     + "PlaceId - "+pl.getPl_id()+" \n"
	            		                            + "PlaceName - "+pl.getPname()+" \n"
	            		                            + "PlaceType - "+pl.getPl_type()+" \n"
	            		                            + "Locality - "+(pl.getAddr()).getLocality()+" \n"
	            		                            + "City - "+(pl.getAddr()).getCity()+" \n"
	            		                            + "Pincode - "+(pl.getAddr()).getPincode()+" \n"
	            		                            + "State - "+(pl.getAddr()).getState()+" \n"
	            		                            + "Country - "+(pl.getAddr()).getCountry()+" \n"
                                                                     + "Description - "+pl.getPl_desc()+" \n"
			    	              + "Thank you!! \n");
                                                        out.flush();
                                                        out.close();
                                                        return;
                                          }
                                          else
                                             {
                                                       out=response.getWriter();
                                                       out.print("HQL INSERTION ERROR!! \n"
			    	             + "FAILED!!! Error Occured_database exception. \n"
                                                                    + "REASON -- Internal SQLQuery/Transaction Error!! \n"
			    	             + "Please Try Again Later!!! \n");
                                                       out.flush();
                                                       out.close();
                                             }
                                                  
                                   }
                                   return;   
                          case 3 : String rid=Validate.isRatingExists(Fetch.getUserFromId((String)jsobj.get("uid")),(String)jsobj.get("placeid"));
                                   if (rid!=null)
                                   {
                                          if(Update.updateRating(rid,(String)jsobj.get("rating"),(String)jsobj.get("comments")))
                                          {
                                                             out=response.getWriter();
                                                             out.print("HQL UPDATE Successful!! \n"
			    	                  + "Successfully updated your rating for place : "+(String)jsobj.get("placeid")+". \n"
                                                                         + "REASON -- Internal SQLQuery/Transaction Successful!! \n"
			    	                  + "Thank you!! \n");
                                                             out.flush();
                                                             out.close();
                                                             return;
                                          }
                                          else
                                          {
                                                             out=response.getWriter();
                                                             out.print("HQL INSERTION ERROR!! \n"
			    	                   + "FAILED!!! Error Occured_database exception. \n"
                                                                          + "REASON -- Internal SQLQuery/Transaction Error!! \n"
			    	                   + "Please Try Again Later!! \n");
                                                             out.flush();
                                                             out.close();
                                                             return;
                                          }
                                   }
                                   else
                                   {
                                         if (Insert.insert('R', (String)jsobj.get("uid"), (String)jsobj.get("placeid"), (String)jsobj.get("rating"), (String)jsobj.get("comments")))
                                         {
                                               UserRatings ur = Fetch.getUserRatingForPlace(Fetch.getUserFromId((String)jsobj.get("uid")),(String)jsobj.get("placeid"));
                                                        out=response.getWriter();
                                                        out.print("HQL INSERTION Successful!! \n"
			    	              + "You have successfully rated the place in our database. \n"
                                                                     + "Salut & Welcome to the E-Burdwan community, User!! \n"
                                                                     + "Given below are your rating details for the place!! \n"
                                                                     + "UserId - "+(String)jsobj.get("uid")+" \n"
                                                                     + "PlaceId - "+(ur.getPl()).getPl_id()+" \n"
	            		                            + "PlaceName - "+(ur.getPl()).getPname()+" \n"
	            		                            + "PlaceType - "+(ur.getPl()).getPl_type()+" \n"
	            		                            + "Locality - "+((ur.getPl()).getAddr()).getLocality()+" \n"
	            		                            + "City - "+((ur.getPl()).getAddr()).getCity()+" \n"
	            		                            + "Pincode - "+((ur.getPl()).getAddr()).getPincode()+" \n"
	            		                            + "State - "+((ur.getPl()).getAddr()).getState()+" \n"
	            		                            + "Country - "+((ur.getPl()).getAddr()).getCountry()+" \n"
                                                                     + "Description - "+(ur.getPl()).getPl_desc()+" \n"
                                                                     + "RatingId - "+ur.getRat_id()+" \n" 
                                                                     + "Rating - "+ur.getRat()+" \n"
                                                                     + "UserComments - "+ur.getComm()+" \n"
			    	              + "Thank you!! \n");
                                                        out.flush();
                                                        out.close();
                                                        return;
                                         }
                                         else
                                         {
                                                out=response.getWriter();
                                                out.print("HQL INSERTION ERROR!! \n"
			                     + "FAILED!!! Error Occured_database exception. \n"
                                                              + "REASON -- Internal SQLQuery/Transaction Error!! \n"
			    	       + "Please Try Again Later!! \n");
                                                out.flush();
                                                out.close();
                                         }
                                   }
                                   return;
                          default : return;
                    }
             }
	           
 }

