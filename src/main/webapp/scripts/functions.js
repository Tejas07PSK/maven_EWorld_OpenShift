/* 
        @Author : Palash Sarkar
        @CreatedON : 16 Dec, 2017, 5:45:55 PM
        @FILEName : functions.js
 */

function passwordShowHide() 
                           {
                                   var pss = document.getElementById("pswf");
                                   if (pss.type === "password")
                                   {
                                       pss.type = "text";
                                   } 
                                   else
                                   {
                                       pss.type = "password"; 
                                   }
                           }
                             
function myFunction()
                    {
                        var myVar=setTimeout(showPage,3000);
                    }
                      
function showPage()
                   {
                           document.getElementById("myModal").style.display="none";
                           document.getElementById("myDiv").style.display="block";
                   }


