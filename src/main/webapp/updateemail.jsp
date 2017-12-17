<%-- 
    Document   : updateemail
    Created on : 30 Nov, 2017, 1:58:14 AM
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
     <link rel="stylesheet" type="text/css" href="stylesheets/animations.css"/>
</head>

<body onload="myFunction()">
    <div class="bg">
    <img src="images/direction-icon.png" alt="E-WORLD Icon" width="120" height="100" >
       <h1> <strong>E-WORLD</strong></h1>
        
       <div id="myModal" class="modal">
            <div class="loader"><h4 style="color: bisque; position: relative;" align="center">LOADING</h4></div>
       </div> 
       <div style="display:none;" id="myDiv" class="animate-bottom">
    
    <h2>
    Here you can change/update your email.
    </h2>
    <form id="form14" method="GET" action="mainServlet">
         <input type="hidden" name="case" value="9">
         <input type = "hidden"
                 name = "uid" 
                 value = <%out.print("\""+request.getParameter("uid")+"\"");%>>
      <fieldset>
        <legend><strong>Enter new email</strong></legend>
        <p> 
             <br>
          <label><strong>Enter Email ID -</strong></label>
          <input type = "text"
                 name = "emailid" 
                  class="mytext"/><br>
            
          <button type = "submit"
                    class="sbutton">Submit</button>
            
        </p>
      </fieldset>
    </form>
        <br>
         <form  method="POST" action="SchUtil">
         <input type="hidden" name="case" value="9">
         <input type = "hidden"
                 name = "uid" 
                 value = <%out.print("\""+request.getParameter("uid")+"\"");%>>
         <button type="submit"
                    class="sbutton">Back</button>
         </form>
     </div>
      <script type="text/javascript" src="scripts/functions.js"></script>
    </div>
</body>
</html>
