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

import com.aps.datahandling.Email;
import com.aps.datahandling.Fetch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
import java.util.List;
import java.io.File;

@WebServlet(description = "Core Servlet For Begining all Operations", urlPatterns = { "/mainServlet" })
 public final class MainServlet extends HttpServlet
 {
           
	      private static final long serialVersionUID = 1L;
	      private static  InetAddress ip ;
	      private static  String ipadd  ;
          
              @Override
	       public void init()
	       {
                          Email.buildEmail((getServletContext().getRealPath("/WEB-INF"))+File.separator+"Credentials");
                          try{
	                         System.setProperty("java.net.preferIPv4Stack", "true");
                                 ip = InetAddress.getLocalHost();
	                         ipadd = ip.getHostAddress();
	                      }catch (UnknownHostException e)
		                    {
		                          e.printStackTrace();
		                    }
	       }
              
               @Override          
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
                {
                          response.setContentType("text/html");
	                  response.setCharacterEncoding("UTF-8");
	                  response.setBufferSize(8192);
                          PrintWriter out = null;
                     
                          switch (Integer.parseInt(request.getParameter("case")))
                          {
                                 case 1 : if (Validate.isUserEmailExists(request.getParameter("emailid")))
                                          {
                                                    out=response.getWriter();
                                                    out.println("<html lang=\"en\">"
			    	                                      + "<head><title>HQL INSERTION ERROR!!</title></head>"
			    	                                      + "<body bgcolor=\"#DBB247\">"
			    	                                      + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                      + "<h2>REASON -- EmailId Already Exists!!</h2>"
			    	                                      + "<p>Please click the button to return to the User_Registration page--</p>"
			    	                                      + "<a href=\"userregistration.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                      + "</body></html>");
                                                    out.flush();
                                                    out.close();
                                                    return;
                                           } 
                                           if (Validate.isUserPhoneExists(request.getParameter("mobno")))
                                           {
                                                    out=response.getWriter();
                                                    out.println("<html lang=\"en\">"
			    	                                      + "<head><title>HQL INSERTION ERROR!!</title></head>"
			    	                                      + "<body bgcolor=\"#DBB247\">"
			    	                                      + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                      + "<h2>REASON -- MobNo Already Exists!!</h2>"
			    	                                      + "<p>Please click the button to return to the User_Registration page --</p>"
			    	                                      + "<a href=\"userregistration.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                      + "</body></html>");
                                                    out.flush();
                                                    out.close(); 
                                                    return;
                                           }
                                           if (Validate.isUserPasswordExists(request.getParameter("pass")))
                                           {
                                                    out=response.getWriter();
                                                    out.println("<html lang=\"en\">"
			    	                                      + "<head><title>HQL INSERTION ERROR!!</title></head>"
			    	                                      + "<body bgcolor=\"#DBB247\">"
			    	                                      + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                      + "<h2>REASON -- Password being used by another User!!</h2>"
			    	                                      + "<p>Please click the button to return to the UserRegistration page --</p>"
			    	                                      + "<a href=\"userregistration.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                      + "</body></html>");
                                                    out.flush();
                                                    out.close();
                                                    return;
                                           }
                                           else
                                           {
                                                    if (Insert.insert('U',request.getParameter("firstname"),request.getParameter("lastname"),request.getParameter("mobno"),request.getParameter("emailid"),request.getParameter("pass"),request.getParameter("locality"),request.getParameter("city"),request.getParameter("pincode"),request.getParameter("state"),request.getParameter("country")))
                                                    {
                                                             UserDetails ud = Fetch.getUserFromEmail(request.getParameter("emailid"));
                                                             out=response.getWriter();
                                                             out.println("<html lang=\"en\">"
			    	                                               + "<head><title>HQL INSERTION Successful!!</title></head>"
			    	                                               + "<body bgcolor=\"#DBB247\">"
			    	                                               + "<h1>You have been successfully registered in our database.</h1>"
                                                                               + "<h2>Salut & Welcome to the E-Burdwan community, new User!!</h2>"
                                                                               +"<h2>Given below are your registration details!!<br />"
                                                                               +"<br /> </h2>"+"<hr />"+"<h2><br /></h2>"
                                                                               +"<h4>"+"Firstname - "+ud.getFirstname()+"</h4>"
	            		                                               +"<h4>"+"LastName - "+ud.getLastname()+"</h4>"
	            		                                               +"<h4>"+"EmailId - "+ud.getEmail_id()+"</h4>"
	            		                                               +"<h4>"+"Mobno - "+ud.getMob_no()+"</h4>"
	            		                                               +"<h4>"+"Locality - "+(ud.getAddress()).getLocality()+"</h4>"
	            		                                               +"<h4>"+"City - "+(ud.getAddress()).getCity()+"</h4>"
	            		                                               +"<h4>"+"Pincode - "+(ud.getAddress()).getPincode()+"</h4>"
	            		                                               +"<h4>"+"State - "+(ud.getAddress()).getState()+"</h4>"
	            		                                               +"<h4>"+"Country - "+(ud.getAddress()).getCountry()+"</h4>"
                                                                               +"<h4>"+"Password - "+ud.getPass()+"</h4>"
                                                                               +"<h4>"+"User_Id - "+ud.getUsr_id()+"</h4>"
			    	                                               + "<p>Please click the button to go to the Login page --</p>"
			    	                                               + "<a href=\"Login.html\"><input type=\"button\" value=\"GoToLogin\"></a>"
			    	                                               + "</body></html>");
                                                               out.flush();
                                                               out.close();
                                                               Email.sendUserRegEmail(ud.getFirstname(),ud.getLastname(),ud.getEmail_id(),ud.getMob_no(),(ud.getAddress()).getLocality(),(ud.getAddress()).getCity(),(ud.getAddress()).getPincode(),(ud.getAddress()).getState(),(ud.getAddress()).getCountry(),ud.getPass(),ud.getUsr_id());
                                                               return;
                                                      }
                                                      else
                                                         {
                                                                   out=response.getWriter();
                                                                   out.println("<html lang=\"en\">"
			    	                                                     + "<head><title>HQL INSERTION ERROR!!</title></head>"
			    	                                                     + "<body bgcolor=\"#DBB247\">"
			    	                                                     + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                     + "<h2>REASON -- Internal SQLQuery/Transaction Error!!</h2>"
			    	                                                     + "<p>Please click the button to return to the UserRegistration page --</p>"
			    	                                                     + "<a href=\"userregistration.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                                     + "</body></html>");
                                                                   out.flush();
                                                                   out.close();
                                                         }
                                                  
                                                }
                                                return;
                                       case 2 : if (Validate.isPlaceExists(request.getParameter("plcdesc")))
                                                {
                                                            out=response.getWriter();
                                                            out.println("<html lang=\"en\">"
			    	                                               + "<head><title>HQL INSERTION ERROR!!</title></head>"
			    	                                               + "<body bgcolor=\"#DBB247\">"
			    	                                               + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                               + "<h2>REASON -- Place Already Exists!!</h2>"
			    	                                               + "<p>Please click the button to return to the User_Place_Insertion page--</p>"
                                                                               + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                               + "<input type=\"hidden\" name=\"case\" value=\"2\">"
                                                                               + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                               + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
			    	                                               + "</body></html>");
                                                            out.flush();
                                                            out.close();
                                                            return;
                                                }
                                                else
                                                   {
                                                            if (Insert.insert('P',request.getParameter("uid"),request.getParameter("plname"),request.getParameter("pltype"),request.getParameter("plocality"),request.getParameter("pcity"),request.getParameter("ppincode"),request.getParameter("pstate"),request.getParameter("pcountry"),request.getParameter("plcdesc")))
                                                            {
                                                                           Places pl = Fetch.getPlaceFromDesc(request.getParameter("plcdesc"));
                                                                           out=response.getWriter();
                                                                           out.println("<html lang=\"en\">"
			    	                                                             + "<head><title>HQL INSERTION Successful!!</title></head>"
			    	                                                             + "<body bgcolor=\"#DBB247\">"
			    	                                                             + "<h1>You have successfully inserted a place in our database.</h1>"
                                                                                             + "<h2>Salut & Welcome to the E-Burdwan community, User!!</h2>"
                                                                                             +"<h2>Given below are the details about the place you inserted!!<br />"
                                                                                             +"<br /> </h2>"+"<hr />"+"<h2><br /></h2>"
                                                                                             +"<h4>"+"UserId - "+request.getParameter("uid")+"</h4>"
                                                                                             +"<h4>"+"PlaceId - "+pl.getPl_id()+"</h4>"
	            		                                                             +"<h4>"+"PlaceName - "+pl.getPname()+"</h4>"
	            		                                                             +"<h4>"+"PlaceType - "+pl.getPl_type()+"</h4>"
	            		                                                             +"<h4>"+"Locality - "+(pl.getAddr()).getLocality()+"</h4>"
	            		                                                             +"<h4>"+"City - "+(pl.getAddr()).getCity()+"</h4>"
	            		                                                             +"<h4>"+"Pincode - "+(pl.getAddr()).getPincode()+"</h4>"
	            		                                                             +"<h4>"+"State - "+(pl.getAddr()).getState()+"</h4>"
	            		                                                             +"<h4>"+"Country - "+(pl.getAddr()).getCountry()+"</h4>"
                                                                                             +"<h4>"+"Description - "+pl.getPl_desc()+"</h4>"
			    	                                                             + "<p>Please click the button to return to the User_Account page --</p>"
			    	                                                             + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                             + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                             + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                             + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                             + "</body></html>");
                                                                           out.flush();
                                                                           out.close();
                                                                           return;
                                                             }
                                                             else
                                                             {
                                                                           out=response.getWriter();
                                                                           out.println("<html lang=\"en\">"
			    	                                                             + "<head><title>HQL INSERTION ERROR!!</title></head>"
			    	                                                             + "<body bgcolor=\"#DBB247\">"
			    	                                                             + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                             + "<h2>REASON -- Internal SQLQuery/Transaction Error!!</h2>"
			    	                                                             + "<p>Please click the button to return to the User_Place_Insertion page --</p>"
                                                                                             + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                             + "<input type=\"hidden\" name=\"case\" value=\"2\">"
                                                                                             + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                             + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
			    	                                                             + "</body></html>");
                                                                           out.flush();
                                                                           out.close();
                                                              }
                                                      }
                                                      return;   
                                             case 3 : String rid=Validate.isRatingExists(Fetch.getUserFromId(request.getParameter("uid")),request.getParameter("placeid"));
                                                      if (rid!=null)
                                                      {
                                                             if(Update.updateRating(rid,request.getParameter("rating"),request.getParameter("comments")))
                                                             {
                                                                          out=response.getWriter();
                                                                          out.println("<html lang=\"en\">"
			    	                                                             + "<head><title>HQL UPDATE Successful!!</title></head>"
			    	                                                             + "<body bgcolor=\"#DBB247\">"
			    	                                                             + "<h1>Successfully updated your rating for place  "+request.getParameter("placeid")+".</h1>"
                                                                                             + "<h2>REASON -- Internal SQLQuery/Transaction Successful!!</h2>"
			    	                                                             + "<p>Please click the button to return to the User_Account page --</p>"
			    	                                                             + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                             + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                             + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                             + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                             + "</body></html>");
                                                                          out.flush();
                                                                          out.close();
                                                                          return;
                                                             }
                                                             else
                                                             {
                                                                          out=response.getWriter();
                                                                          out.println("<html lang=\"en\">"
			    	                                                             + "<head><title>HQL INSERTION ERROR!!</title></head>"
			    	                                                             + "<body bgcolor=\"#DBB247\">"
			    	                                                             + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                             + "<h2>REASON -- Internal SQLQuery/Transaction Error!!</h2>"
			    	                                                             + "<p>Please click the button to return to the Set_User_Rating_Page --</p>"
			    	                                                             + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                             + "<input type=\"hidden\" name=\"case\" value=\"1\">"
                                                                                             + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                             + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                             + "</body></html>");
                                                                          out.flush();
                                                                          out.close();
                                                                          return;
                                                              }
                                                         }
                                                         else
                                                         {
                                                                    if (Insert.insert('R', request.getParameter("uid"), request.getParameter("placeid"), request.getParameter("rating"), request.getParameter("comments")))
                                                                    {
                                                                               UserRatings ur = Fetch.getUserRatingForPlace(Fetch.getUserFromId(request.getParameter("uid")),request.getParameter("placeid"));
                                                                               out=response.getWriter();
                                                                               out.println("<html lang=\"en\">"
			    	                                                                 + "<head><title>HQL INSERTION Successful!!</title></head>"
			    	                                                                 + "<body bgcolor=\"#DBB247\">"
			    	                                                                 + "<h1>You have successfully rated the place in our database.</h1>"
                                                                                                 + "<h2>Salut & Welcome to the E-Burdwan community, User!!</h2>"
                                                                                                 +"<h2>Given below are your rating details for the place!!<br />"
                                                                                                 +"<br /> </h2>"+"<hr />"+"<h2><br /></h2>"
                                                                                                 +"<h4>"+"UserId - "+request.getParameter("uid")+"</h4>"
                                                                                                 +"<h4>"+"PlaceId - "+(ur.getPl()).getPl_id()+"</h4>"
	            		                                                                 +"<h4>"+"PlaceName - "+(ur.getPl()).getPname()+"</h4>"
	            		                                                                 +"<h4>"+"PlaceType - "+(ur.getPl()).getPl_type()+"</h4>"
	            		                                                                 +"<h4>"+"Locality - "+((ur.getPl()).getAddr()).getLocality()+"</h4>"
	            		                                                                 +"<h4>"+"City - "+((ur.getPl()).getAddr()).getCity()+"</h4>"
	            		                                                                 +"<h4>"+"Pincode - "+((ur.getPl()).getAddr()).getPincode()+"</h4>"
	            		                                                                 +"<h4>"+"State - "+((ur.getPl()).getAddr()).getState()+"</h4>"
	            		                                                                 +"<h4>"+"Country - "+((ur.getPl()).getAddr()).getCountry()+"</h4>"
                                                                                                 +"<h4>"+"Description - "+(ur.getPl()).getPl_desc()+"</h4>"
                                                                                                 +"<h4>"+"RatingId - "+ur.getRat_id()+"</h4>" 
                                                                                                 +"<h4>"+"Rating - "+ur.getRat()+"</h4>"
                                                                                                 +"<h4>"+"UserComments - "+ur.getComm()+"</h4>"
			    	                                                                 + "<p>Please click the button to return to the User_Account page --</p>"
			    	                                                                 + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                                 + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                                 + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                                 + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                                 + "</body></html>");
                                                                               out.flush();
                                                                               out.close();
                                                                               return;
                                                                    }
                                                                    else
                                                                    {
                                                                               out=response.getWriter();
                                                                               out.println("<html lang=\"en\">"
			    	                                                                + "<head><title>HQL INSERTION ERROR!!</title></head>"
			    	                                                                + "<body bgcolor=\"#DBB247\">"
			    	                                                                + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                                + "<h2>REASON -- Internal SQLQuery/Transaction Error!!</h2>"
			    	                                                                + "<p>Please click the button to return to the Set_User_Rating_For_Place page --</p>"
			    	                                                                + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                                + "<input type=\"hidden\" name=\"case\" value=\"1\">"
                                                                                                + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                                + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                                + "</body></html>");
                                                                                out.flush();
                                                                                out.close();
                                                                      }
                                                            }
                                                           return;
                                                 default : if (Validate.isUserExists(request.getParameter("uid"),request.getParameter("pass")))
                                                           {
                                                                      request.setAttribute("uid", request.getParameter("uid"));
                                                                      getServletContext().getRequestDispatcher("/successlogin.jsp").forward(request,response);
                                                           }
                                                           else
                                                           {
                                                                       out=response.getWriter();
                                                                       out.println("<html lang=\"en\">"
			    	                                                         + "<head><title>ERROR!!</title></head>"
			    	                                                         + "<body bgcolor=\"#DBB247\">"
			    	                                                         + "<h1>FAILED!!! Incorrect User_Id Or Password.</h1>"
                                                                                         + "<h2>REASON -- User/Password Does Not Exist!!</h2>"
			    	                                                         + "<p>Please click the button to return to the Home page --</p>"
			    	                                                         + "<a href=\"index.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                                         + "</body></html>");
                                                                        out.flush();
                                                                        out.close();
                                                           }
                                                           return;
                                }
              }
             
             @Override
              protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
              {
                                   response.setContentType("text/html");
	                           response.setCharacterEncoding("UTF-8");
	                           response.setBufferSize(8192);
                                   PrintWriter out = null;
                           switch (Integer.parseInt(request.getParameter("case")))
                           {
                                  case 1 : List<Places> plt = Fetch.getPlaceFromType(request.getParameter("plctype"));
                                           if (plt!=null)
                                           {
                                                 request.setAttribute("lstofplcs", plt);
                                                 request.setAttribute("typoflst", "List Of Places According To Type : "+request.getParameter("plctype"));
                                                 getServletContext().getRequestDispatcher("/listpage.jsp").forward(request,response);
                                           }
                                           else
                                           {
                                                             out=response.getWriter();
                                                             out.println("<html lang=\"en\">"
			    	                                                 + "<head><title>ERROR!!</title></head>"
			    	                                                 + "<body bgcolor=\"#DBB247\">"
			    	                                                 + "<h1>FAILED!!! No Place Type.</h1>"
                                                                                 + "<h2>REASON -- Places of such type don't exist in our database!!</h2>"
			    	                                                 + "<p>Please click the button to return to the Home page --</p>"
			    	                                                 + "<a href=\"index.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                                 + "</body></html>");
                                                            out.flush();
                                                            out.close();    
                                           }
                                           return;
                                  case 2 : List<Places> pllc = Fetch.getPlaceFromLocality(request.getParameter("plclocality"));
                                           if (pllc!=null)
                                           {
                                                    request.setAttribute("lstofplcs", pllc);
                                                    request.setAttribute("typoflst", "List Of Places According To Locality : "+request.getParameter("plclocality"));
                                                    getServletContext().getRequestDispatcher("/listpage.jsp").forward(request,response);
                                           }
                                           else
                                           {
                                                             out=response.getWriter();
                                                             out.println("<html lang=\"en\">"
			    	                                                + "<head><title>ERROR!!</title></head>"
			    	                                                + "<body bgcolor=\"#DBB247\">"
			    	                                                + "<h1>FAILED!!! No Place Type.</h1>"
                                                                                + "<h2>REASON -- Places of such type don't exist in our database!!</h2>"
			    	                                                + "<p>Please click the button to return to the Home page --</p>"
			    	                                                + "<a href=\"index.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                                + "</body></html>");
                                                              out.flush();
                                                              out.close();    
                                           }
                                           return;
                                  case 3 : List<Object> lo=Fetch.getPlaceRating(request.getParameter("plid"));
                                           if (lo!=null)
                                           {
                                                       request.setAttribute("lstofratings", lo);
                                                       request.setAttribute("typoflst", "List Of Ratings According To Place For ID : "+request.getParameter("plid"));
                                                       getServletContext().getRequestDispatcher("/ratinglistpage.jsp").forward(request,response);
                                           }
                                           else
                                           {
                                                             out=response.getWriter();
                                                             out.println("<html lang=\"en\">"
			    	                                                + "<head><title>ERROR!!</title></head>"
			    	                                                + "<body bgcolor=\"#DBB247\">"
			    	                                                + "<h1>FAILED!!! No Place Type.</h1>"
                                                                                + "<h2>REASON -- Places of such type don't exist in our database!!</h2>"
			    	                                                + "<p>Please click the button to return to the Home page --</p>"
			    	                                                + "<a href=\"index.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                                + "</body></html>");
                                                             out.flush();
                                                             out.close();    
                                           }
                                           return;
                                  case 4 : List<Places> pln = Fetch.getPlaceFromName(request.getParameter("pname"));
                                           if (pln!=null)
                                           {
                                                       request.setAttribute("lstofplcs", pln);
                                                       request.setAttribute("typoflst", "List Of Places According To Their Names : "+request.getParameter("pname"));
                                                       getServletContext().getRequestDispatcher("/listpage.jsp").forward(request,response);
                                           }
                                           else
                                           {
                                                             out=response.getWriter();
                                                             out.println("<html lang=\"en\">"
			    	                                               + "<head><title>ERROR!!</title></head>"
			    	                                               + "<body bgcolor=\"#DBB247\">"
			    	                                               + "<h1>FAILED!!! No Place Type.</h1>"
                                                                               + "<h2>REASON -- Places of such type don't exist in our database!!</h2>"
			    	                                               + "<p>Please click the button to return to the Home page --</p>"
			    	                                               + "<a href=\"index.html\"><input type=\"button\" value=\"Return\"></a>"
			    	                                               + "</body></html>");
                                                             out.flush();
                                                             out.close();    
                                           }
                                           return;
                                 default : if (request.getParameterMap().containsKey("emailid"))
                                           {
                                                    if (Validate.isUserEmailExists(request.getParameter("emailid")))
                                                    {
                                                             out=response.getWriter();
                                                             out.println("<html lang=\"en\">"
			    	                                               + "<head><title>HQL UPDATE ERROR!!</title></head>"
			    	                                               + "<body bgcolor=\"#DBB247\">"
			    	                                               + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                               + "<h2>REASON -- EmailId Already Exists!!</h2>"
			    	                                               + "<p>Please click the button to return to the User_Email_Update page--</p>"
			    	                                               + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                               + "<input type=\"hidden\" name=\"case\" value=\"5\">"
                                                                               + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                               + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                               + "</body></html>");
                                                             out.flush();
                                                             out.close();
                                                             return;
                                                     } 
                                                     else 
                                                     {
                                                             if (Update.updateUserEmail(request.getParameter("uid"),request.getParameter("emailid")))
                                                             {
                                                                       out=response.getWriter();
                                                                       out.println("<html lang=\"en\">"
			    	                                                         + "<head><title>HQL UPDATE Successful!!</title></head>"
			    	                                                         + "<body bgcolor=\"#DBB247\">"
			    	                                                         + "<h1>Success!!! We have updated your email_id.</h1>"
                                                                                         + "<h2>REASON -- Internal hql query successful!!</h2>"
			    	                                                         + "<p>Please click the button to return to the User_Account page--</p>"
			    	                                                         + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                         + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                         + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                         + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                         + "</body></html>");
                                                                       out.flush();
                                                                       out.close();
                                                                       return;
                                                             }
                                                             else
                                                             {
                                                                            out=response.getWriter();
                                                                            out.println("<html lang=\"en\">"
			    	                                                              + "<head><title>HQL UPDATE ERROR!!</title></head>"
			    	                                                              + "<body bgcolor=\"#DBB247\">"
			    	                                                              + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                              + "<h2>REASON -- Internal SQLQuery/Transaction Error!!</h2>"
			    	                                                              + "<p>Please click the button to return to the User_Account page --</p>"
			    	                                                              + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                              + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                              + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                              + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                              + "</body></html>");
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
                                                                    out.println("<html lang=\"en\">"
			    	                                                      + "<head><title>HQL UPDATE ERROR!!</title></head>"
			    	                                                      + "<body bgcolor=\"#DBB247\">"
			    	                                                      + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                      + "<h2>REASON -- Mobile Number Already Exists!!</h2>"
			    	                                                      + "<p>Please click the button to return to the User_Mobile_Update page--</p>"
			    	                                                      + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                      + "<input type=\"hidden\" name=\"case\" value=\"3\">"
                                                                                      + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                      + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                      + "</body></html>");
                                                                     out.flush();
                                                                     out.close();
                                                                     return;
                                                       } 
                                                       else 
                                                       {
                                                                     if (Update.updateUserPhone(request.getParameter("uid"),request.getParameter("mobno")))
                                                                     {
                                                                                     out=response.getWriter();
                                                                                     out.println("<html lang=\"en\">"
			    	                                                                       + "<head><title>HQL UPDATE Successful!!</title></head>"
			    	                                                                       + "<body bgcolor=\"#DBB247\">"
			    	                                                                       + "<h1>Success!!! We have updated your phone number.</h1>"
                                                                                                       + "<h2>REASON -- Internal hql query successful!!</h2>"
			    	                                                                       + "<p>Please click the button to return to the User_Account page--</p>"
			    	                                                                       + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                                       + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                                       + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                                       + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                                       + "</body></html>");
                                                                                     out.flush();
                                                                                     out.close();
                                                                                     return;
                                                                     }
                                                                     else
                                                                     {
                                                                                    out=response.getWriter();
                                                                                    out.println("<html lang=\"en\">"
			    	                                                                      + "<head><title>HQL UPDATE ERROR!!</title></head>"
			    	                                                                      + "<body bgcolor=\"#DBB247\">"
			    	                                                                      + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                                      + "<h2>REASON -- Internal SQLQuery/Transaction Error!!</h2>"
			    	                                                                      + "<p>Please click the button to return to the User_Account page --</p>"
			    	                                                                      + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                                      + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                                      + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                                      + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                                      + "</body></html>");
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
                                                                         out.println("<html lang=\"en\">"
			    	                                                           + "<head><title>HQL UPDATE ERROR!!</title></head>"
			    	                                                           + "<body bgcolor=\"#DBB247\">"
			    	                                                           + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                           + "<h2>REASON -- Password Already Being Used By Another User!!</h2>"
			    	                                                           + "<p>Please click the button to return to the User_Password_Update page--</p>"
			    	                                                           + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                           + "<input type=\"hidden\" name=\"case\" value=\"4\">"
                                                                                           + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                           + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                           + "</body></html>");
                                                                         out.flush();
                                                                         out.close();
                                                                         return;
                                                             } 
                                                             else 
                                                             {
                                                                      if (Update.updateUserPassword(request.getParameter("uid"),request.getParameter("pass")))
                                                                      {
                                                                                     out=response.getWriter();
                                                                                     out.println("<html lang=\"en\">"
			    	                                                                      + "<head><title>HQL UPDATE Successful!!</title></head>"
			    	                                                                      + "<body bgcolor=\"#DBB247\">"
			    	                                                                      + "<h1>Success!!! We have updated your password.</h1>"
                                                                                                      + "<h2>REASON -- Internal hql query successful!!</h2>"
			    	                                                                      + "<p>Please click the button to return to the User_Account page--</p>"
			    	                                                                      + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                                      + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                                      + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                                      + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                                      + "</body></html>");
                                                                                      out.flush();
                                                                                      out.close();
                                                                                      return;
                                                                      }
                                                                      else
                                                                      {
                                                                                      out=response.getWriter();
                                                                                      out.println("<html lang=\"en\">"
			    	                                                                         + "<head><title>HQL UPDATE ERROR!!</title></head>"
			    	                                                                         + "<body bgcolor=\"#DBB247\">"
			    	                                                                         + "<h1>FAILED!!! Error Occured_database exception.</h1>"
                                                                                                         + "<h2>REASON -- Internal SQLQuery/Transaction Error!!</h2>"
			    	                                                                         + "<p>Please click the button to return to the User_Account page --</p>"
			    	                                                                         + "<form id=\"form80\" method=\"POST\" action=\"SchUtil\">"
                                                                                                         + "<input type=\"hidden\" name=\"case\" value=\"9\">"
                                                                                                         + "<input type=\"hidden\" name=\"uid\" value=\""+request.getParameter("uid")+"\">"
                                                                                                         + "<button name=\"addplace\" class=\"rqstbutton\" type=\"submit\">Return</button>"
                                                                                                         + "</body></html>");
                                                                                      out.flush();
                                                                                      out.close();
                                                                       }
                                                            }    
                                               }
                                               return;
                                 }
                 }

}
