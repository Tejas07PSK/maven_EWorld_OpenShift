<%-- 
    Document   : updatepassword
    Created on : 30 Nov, 2017, 1:50:03 AM
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

    <img src="images/direction-icon.png" alt="E-WORLD Icon" width="120" height="100" >
       <h1> <strong>E-WORLD</strong></h1>
        
    <h2>
    Here you can change/update your password.
    </h2>
    <form id="form16" method="GET" action="mainServlet">
         <input type="hidden" name="case" value="9">
         <input type = "hidden"
                 name = "uid" 
                 value = <%out.print("\""+request.getParameter("uid")+"\"");%>>
      <fieldset>
        <legend><strong>Update Password</strong></legend>
        <p> 
           <br>
          <label><strong>Enter New Password -</strong></label>
          <input type = "text"
                 name = "pass" 
                  class="mytext"/><br>
            
          <button type = "submit"
                    class="sbutton">Submit</button>
            
        </p>
      </fieldset>
    </form>
    
     
    
</body>
</html>
