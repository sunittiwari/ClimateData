<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
<link rel="stylesheet" type="text/css"href="Authorize.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authorize</title>
 <script type="text/javascript">
         
            function getConfirmation(){
               var retVal = confirm("Do you want to continue ?");
               if( retVal == true ){
                //  document.write ("User wants to continue!");
                  return true;
               }
               else{
                  document.write ("User does not want to continue!");
                  return false;
               }
            }
         
      </script>
</head>
<body>
  <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">
        <img src="UAH.png" id ="UAH">
      </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <!-- <li><a href="#">Link</a></li> -->
      </ul>
    </div>
  </div>
</nav>
<div id="signup" class="full-height"> 
<table id="Authenticate" class="table-full">
  <tr>
    <td>
      <form class="signin form-horizontal" action="Controller" method="get" >
        <div class="form-group">
          <label for="formselect1" class="col-sm-2 control-label">CITY</label>
          <div class="col-sm-10">
            <select name="city" class="form-control" id="formselect1">
              <option value="null">Please Select a City</option>
              <option value="Huntsville">HUNTSVILLE</option>
              <option value="New York">NEWYORK</option>
              <option value="sanfransisco">SANFRANSISCO</option>
              <option value="dallas">DALLAS</option>
            </select>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-10">
            <input type="submit" value="submit" class="btn btn-primary" onclick="getConfirmation();"/>
          </div>
        </div>
        <input type = "hidden" value = "welcome" name= "welcome">

  <!-- <tr>
  <td>
  <label>Start Date</label>
  </td>
  <td>
  <input type = "text" name = "day" value = "day" />
  </td>
  <td>
  <input type = "text" name = "month" value = "month" />
  </td>
  <td>
  <input type = "text" name = "year" value = "year" />
  </td>
  <td>
  </tr> 

  </tr>-->

      </form>
    </td>
  </tr>
</table>
</div>
</body>
</html>