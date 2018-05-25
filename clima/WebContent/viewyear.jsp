<%@page import="com.clima.Pojo.Pojo"%>
<%@page import="java.util.*"%>
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
<title>VIEWBYYEAR</title>
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
<%-- <% Pojo  pojo = (Pojo)request.getAttribute("getdetailsbyyear");%> --%>
<div class="data-table-container table-responsive">
<% List<Pojo> yearly= (ArrayList)request.getAttribute("getdetailsbyyear"); %>

<table id="Authenticate" class="table table-hover"> 
   <thead>
            <tr>
                <th>CITY</th>
                <th>DAY</th>
                <th>MONTH</th>
                <th>YEAR</th>
                <th>DEWPOINT</th>
                <th>MIN</th>
                <th>MAX</th>
                <th>AVERAGE</th>
                <th>PRECIPITATION</th>
                <th>SNOWDEPTH</th>
                <th>CLIMATE CONDITION</th>
                </tr>
        </thead>
        <tbody>
            <%Iterator it = yearly.iterator();
            while(it.hasNext()){ 
            	Pojo yearDetails = (Pojo)it.next();
            %>
            
            <tr>
                    <td><%=yearDetails.getCity()%> </td>
                    <td><%=yearDetails.getDay()%> </td>
                    <td><%=yearDetails.getMonth()%> </td>
                    <td><%=yearDetails.getYear() %> </td>
                    <td><%=yearDetails.getDewpoint() %></td>
                    <td><%=yearDetails.getMin() %></td>
                    <td><%=yearDetails.getMax() %></td>
                    <td><%=yearDetails.getAverage() %></td>
                    <td><%=yearDetails.getPrecipitation() %></td>
                    <td><%=yearDetails.getSnowDepth() %></td>
                    <td><%=yearDetails.getClimacondtion() %></td>
                    
                    
<%} %>

 </tr>

           
        </tbody>
        </table>
    </div>
</body>
</html>