<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--Including external css file for design -->
  <link rel="stylesheet" type="text/css" href="bootstrap.css">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" type="text/css"href="Authorize.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<!-- Java Script to get a dialogue box for user confirmation -->
<script type="text/javascript">
         
            function getConfirmation(){
               var retVal = confirm("Do you want to continue ?");
               if( retVal == true ){
                
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
        <!-- <li><a href="Monthly.jsp">Monthly</a></li>
        <li><a href = "Yearly.jsp">Yearly</a></li> -->
        <li><b href = "">United States of America</b></li>
        
      </ul>
    </div>
  </div>
</nav>
<div id="signup" class="full-height"> 
<table id="Home" class="table-full">
<tr>

<td>
<form class = "signin form-horizontal width-500" action="Controller" method="get" >
  <div class="form-group">
  
    <label for="formselect1" class="col-sm-2 control-label">CITY</label>
    <div class="col-sm-10">
      <select name="city" class="form-control" id="formselect1">
        <option value="null">Please Select a City</option>
        <option value="huntsville">HUNTSVILLE</option>
        <option value="seattle">SEATTLE</option>
        <option value="chicago">CHICAGO</option>
        <option value="dallas">DALLAS</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="formselect2" class="col-sm-2 control-label">CLIMATE CONDITION</label>
     <div class="col-sm-10">
     
      <select name="function"  class="form-control" id="formselect2">
        <option value="null">Please Select a function</option>
        <option value="temp">TEMPERATURE</option>
        <option value="snow">SNOW</option>
        <option value="humid">HUMIDITY</option>
        <option value="all">ALL CLIMATE CONDITIONS</option>
      </select>
    </div>
  </div>
   <div class="calender_container">
            <div class="form-group">
                <label for="input1">DAY</label>
                <input type="text" name="day" class="form-control" id="input1" placeholder="day">
            </div>
            <div class="form-group">
              <label for="input2">MONTH</label>
              <input type="text" name="month" class="form-control" id="input2" placeholder="month">
            </div>
            <div class="form-group">
              <label for="input3">YEAR</label>
              <input type="text" name="year" class="form-control" id="input3" placeholder="year">
            </div>
  </div>
  <input type = "hidden" value = "welcome" name= "welcome">
  <div class="form-group">
            <div class="col-sm-10">
              <input type="submit" value="submit" class="btn btn-primary" onclick="getConfirmation();"/>
            </div>
  </div>
</form>

</td>
</tr>
</table>
</div>
</body>
</html>