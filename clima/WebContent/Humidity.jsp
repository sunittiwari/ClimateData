<%@page import="com.clima.Pojo.Pojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"href="Authorize.css">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <link rel="stylesheet" type="text/css" href="bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Humidity</title>
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img src="UAH.png" id ="UAH"></a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Monthly.jsp">Monthly</a></li>
        <li><a href = "Yearly.jsp">Yearly</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- <img src="UAH.png"style="width:304px;height:228px; id ="UAH""> -->
<div class="data-table-container table-responsive">
<% Pojo  pojo = (Pojo)request.getAttribute("getdetailsforhumid");%>
<table id="Authenticate" class="table table-hover"> 
   <thead>
            <tr>
               <th>CITY</th> 
                <th>DAY</th>
                <th>MONTH</th>
                <th>YEAR</th>
                <th>PRECIPITATION</th>
                <th>DEWPOINT</th>
                <th>CLIMATE CONDITION</th>
                <!-- <th>AVERAGE</th>
                <th>CLIMATE CONDITION</th> -->
                
                
                 </tr>
        </thead>
        <tbody>
            
                <tr>
                    
                    <td><%= pojo.getCity()%></td>
                    <td><%=pojo.getDay()%></td>
                    <td><%=pojo.getMonth()%></td>
                    <td><%= pojo.getYear()%></td>
                    <td><%= pojo.getPrecipitation()%></td>
                    <td> <%=pojo.getDewpoint()%></td>
                    <td> <%=pojo.getClimacondtion()%></td>
                    </tr>
           
        </tbody>
    </table>
</div>
</div>
    <div id ="Precipitation" align ="center" >
    <a href="Monthly.jsp">Monthly</a>
    <a href = "Yearly.jsp">Yearly</a>
</div>
</body>
</html>