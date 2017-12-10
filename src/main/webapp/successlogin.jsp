<%-- 
    Document   : successlogin
    Created on : 30 Nov, 2017, 1:12:07 AM
    Author     : palashsarkar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>      
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>E-WORLD</title>
     <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <meta name="description" content="Visit The E-World Website">
     <link rel="stylesheet" type="text/css" href="stylesheets/mainpage.css"/>
</head>
<body>


    <img src="images/direction-icon.png" alt="E-World Icon" width="120" height="100" >
       <h1> <strong>E-WORLD</strong></h1>
     <table id="table2">    
    <tr>
    <th>
           <form id="form30" method="POST" action="SchUtil">
                 <input type="hidden" name="case" value="1">
                 <input type="hidden" name="uid" value=<%out.print("\""+request.getAttribute("uid")+"\"");%>>
                 <button name="addreview" class="rqstbutton" type="submit">
                    Add Review
                 </button>
           </form>
    </th>
    <th>
         <form id="form30" method="POST" action="SchUtil">
                 <input type="hidden" name="case" value="2">
                 <input type="hidden" name="uid" value=<%out.print("\""+request.getAttribute("uid")+"\"");%>>
                 <button name="addplace" class="rqstbutton" type="submit">
                    Add Place
                 </button>
           </form>
    </th> 
    <th><input type="button" onclick="location.href='Login.html';"
                    value = "Logout"
                    class="rqstbutton"/></th>
    </tr>
    <tr>
          <th>
               <form id="form30" method="POST" action="SchUtil">
                 <input type="hidden" name="case" value="3">
                 <input type="hidden" name="uid" value=<%out.print("\""+request.getAttribute("uid")+"\"");%>>
                 <button name="updatemobno" class="rqstbutton" type="submit">
                    Update Mobile Number
                 </button>
              </form>
          </th>
          <th>
               <form id="form30" method="POST" action="SchUtil">
                 <input type="hidden" name="case" value="4">
                 <input type="hidden" name="uid" value=<%out.print("\""+request.getAttribute("uid")+"\"");%>>
                 <button name="updatepassword" class="rqstbutton" type="submit">
                    Update Password
                 </button>
              </form>
         </th>
         <th>
              <form id="form30" method="POST" action="SchUtil">
                 <input type="hidden" name="case" value="5">
                 <input type="hidden" name="uid" value=<%out.print("\""+request.getAttribute("uid")+"\"");%>>
                 <button name="updateemail" class="rqstbutton" type="submit">
                    Update Email
                 </button>
             </form>
        </th>
    </tr>	
  </table>
 </body>
</html>
