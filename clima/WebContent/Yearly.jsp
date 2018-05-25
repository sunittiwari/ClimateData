<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"href="Authorize.css">
<link rel="stylesheet" type="text/css" href="bootstrap.css">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
        <li><a href="Monthly.jsp">Monthly</a></li>
        <li><a href = "#">Yearly</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="full-height">
	<table id ="Authenticate" class="table-full">
		<tr>
			<td>
				<form action = "Controller" class="form-horizontal">
					<div class="form-group">
			            <label for="formselect2" class="col-sm-2 control-label">CITY</label>
			            <div class="col-sm-10">
			            	<select name="city" class="form-control">
							  <option value="null">Please Select a City</option>
							  <option value="huntsville">HUNTSVILLE</option>
							  <option value="seattle">SEATTLE</option>
							  <option value="chicago">CHICAGO</option>
							  <option value="dallas">DALLAS</option>
							</select>
			            </div>
			        </div>
			        <div class="calender_container field_two">
			            <div class="form-group">
			              <label for="input2">DAY</label>
			              <input type="text" name="day" class="form-control" id="input2" placeholder="day">
			            </div>
			            <div class="form-group">
			              <label for="input3">MONTH</label>
			              <input type="text" name="month" class="form-control" id="input3" placeholder="month">
			            </div>
			        </div>
					<input type="hidden" name = "function" value = "yearly" />
					<div class="form-group">
			            <div class="col-sm-10">
							<input type="submit" name="getyear" value="GO" class="btn btn-primary">
			            </div>
			        </div>
				</form>
			</td>
		</tr>
	</table>
</div>
</body>
</html>