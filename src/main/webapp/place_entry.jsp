<%-- 
    Document   : place_entry
    Created on : 30 Nov, 2017, 1:44:13 AM
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
    Enter Place Details. 
    </h2>
    <form id="form13" method="POST" action="mainServlet">
         <input type="hidden" name="case" value="2">
         <input type = "hidden"
                 name = "uid" 
                 value = <%out.print("\""+request.getParameter("uid")+"\"");%>>
      <fieldset>
        <legend><strong>Place Entry</strong></legend>
        <p> 
          <br>
          <label><strong>Enter Place Name -</strong></label>
          <input type = "text"
                 name = "plname" 
                  class="mytext"/><br>
            <label><strong>Enter Type Of Place -</strong></label>
          <input type = "text"
                 name = "pltype" 
                  class="mytext"/><br>
             <label><strong>Enter Locality-</strong></label>
          <input type = "text"
                 name = "plocality" 
                  class="mytext"/><br>
	<label><strong>City -</strong></label>
          <input type = "text"
                 name = "pcity" 
                  class="mytext"/><br>
	<label><strong>State -</strong></label>
          <input type = "text"
                 name = "pstate" 
                  class="mytext"/><br>
	<label><strong>PinCode -</strong></label>
          <input type = "text"
                 name = "ppincode" 
                 maxlength = "6"
                  class="mytext"/><br>
          <label><strong>Country -</strong></label>
               <input type = "text"
                      name = "pcountry" 
                      class="mytext"/><br>
               <label><strong>Description -</strong></label>
               <input type = "text"
                      name = "plcdesc" 
                      class="mytext"/><br>
            <button type="submit"
                    class="sbutton">Submit</button>
        </p>
      </fieldset>
    </form>
    
     
    
</body>
</html>
