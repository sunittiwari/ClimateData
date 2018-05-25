<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.clima.Pojo.Pojo"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"href="Authorize.css">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <link rel="stylesheet" type="text/css" href="bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<% Pojo  bymonth = (Pojo)request.getAttribute("getdetailsbymonth");%>
<% List<Pojo> monthly= (ArrayList)request.getAttribute("getAllDetailsByMonth"); %>


<table id="Authenticate" class="table table-hover"> 
   <thead>
            <tr>
                <th>CITY</th>
                <th>MONTH</th>
                <th>YEAR</th>
                <th>DEWPOINT</th>
                <th>MAX</th>
                <th>MIN</th>
                <th>PRECIPITATION</th>
                <th>SNOWDEPTH</th>
               <!--  <th>min</th>
                <th>max</th>
                <th>temp</th>
                <th>dateTime</th>
                <th colspan="2">Action</th> -->
            </tr>
        </thead>
        <tbody>
            <%Iterator it = monthly.iterator();
            while(it.hasNext()){ 
            	Pojo monthDetails = (Pojo)it.next();
            %>
                <tr>
                    <td><%=monthDetails.getCity()%> </td>
                    <td><%=monthDetails.getMonth()%> </td>
                    <td><%=monthDetails.getYear() %> </td>
                    <td><%=monthDetails.getDewpoint() %></td>
                    <td><%=monthDetails.getMax() %></td>
                    <td><%=monthDetails.getMin() %></td>
                    <td><%=monthDetails.getPrecipitation() %></td>
                    <td><%=monthDetails.getSnowDepth() %></td>
                    <td><%=monthDetails.getClimacondtion() %></td>
                    
<%} %>

 </tr>
           
        </tbody>
        </table>
    </div>
</body>
</html>