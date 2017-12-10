<%-- 
    Document   : listpage
    Created on : 19 Nov, 2017, 4:58:27 AM
    Author     : palashsarkar
--%>

<%@page import="java.util.List"%>
<%@page import="com.aps.entitiespojos.Places"%>
<%@page import="com.aps.entitiespojos.Address"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <title>Listing Page</title>
          <link rel="stylesheet" type="text/css" href="stylesheets/mainpage.css"/>
     </head>
     <body>
          <h1><%out.print(request.getAttribute("typoflst"));%></h1>
          <hr/>
          <hr/>
        <div id="list">
            <table id="places"  border="1">
                <tr>
                    <th style="color: red" colspan="2">List Of Places</th>
                </tr>
                <tr> 
                <td style="color: wheat">Place ID</td>
                <td style="color: wheat">Place Name</td>
                <td style="color: wheat">Place Type</td>
                <td style="color: wheat">Place Locality</td>
                <td style="color: wheat">Place City</td>
                <td style="color: wheat">Place Pincode</td>
                <td style="color: wheat">Place State</td>
                <td style="color: wheat">Place Country</td>
                <td style="color: wheat">Place Description</td>
                </tr>
                <% List<Places> lst = (List<Places>)request.getAttribute("lstofplcs");
                   for(Places pl:lst){ %>
                <tr>
                  <td style="color: lawngreen"><% out.print(pl.getPl_id()); %></td>
                  <td style="color: lawngreen"><% out.print(pl.getPname()); %></td>
                  <td style="color: lawngreen"><% out.print(pl.getPl_type()); %></td>
                  <td style="color: lawngreen"><% out.print((pl.getAddr()).getLocality()); %></td>
                  <td style="color: lawngreen"><% out.print((pl.getAddr()).getCity()); %></td>
                  <td style="color: lawngreen"><% out.print((pl.getAddr()).getPincode()); %></td>
                  <td style="color: lawngreen"><% out.print((pl.getAddr()).getState()); %></td>
                  <td style="color: lawngreen"><% out.print((pl.getAddr()).getCountry()); %></td>
                  <td style="color: lawngreen"><% out.print(pl.getPl_desc()); %></td>
                </tr>
                <% } %>
         
            </table>
        </div>
         <form id="fm1" >
                   
                         <a href="index.html">
                              <input id="back" type="button" value="Back to Home">
                         </a>
                    </form>
     </body>
</html>
