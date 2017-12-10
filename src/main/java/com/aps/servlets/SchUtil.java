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

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

@WebServlet(description = "Search Suggestion and Utility Servlet", urlPatterns = { "/SchUtil" })
 public final class SchUtil extends HttpServlet
 {
          private static final long serialVersionUID = 1L;
	  private static  InetAddress ip ;
	  private static  String ipadd  ;
          
              @Override
	       public void init()
	       {
                    
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
                     
                     switch (Integer.parseInt(request.getParameter("case")))
                     {
                          case 1 :  getServletContext().getRequestDispatcher("/entryreview.jsp").forward(request,response);  
                                    return;
                          case 2 :  getServletContext().getRequestDispatcher("/place_entry.jsp").forward(request,response);
                                    return;
                          case 3 :  getServletContext().getRequestDispatcher("/updatemobno.jsp").forward(request,response);
                                    return;
                          case 4 :  getServletContext().getRequestDispatcher("/updatepassword.jsp").forward(request,response);
                                    return;
                          case 5 :  getServletContext().getRequestDispatcher("/updateemail.jsp").forward(request,response);
                                    return;
                          default : request.setAttribute("uid", request.getParameter("uid"));
                                    getServletContext().getRequestDispatcher("/successlogin.jsp").forward(request,response);
                                    return;
                     }
             }
  }
