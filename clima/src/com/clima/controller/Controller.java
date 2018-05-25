/*It is the middleware which will map all the incoming values from the JSP pages to its respective Data Access methods */
package com.clima.controller;
/*Importing all the required files for using multiple predefined methods*/
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.clima.DAO.ClimaAccessDao;
import com.clima.DAO.ClimaDao;
import com.clima.Pojo.Pojo;
import java.util.*;

//@WebServlet("Controller")

public class Controller extends HttpServlet {
	
	private ClimaDao dao;
    private static final long serialVersionUID = 1L;

   
/*Initializing and object for the ClimaDao*/
public Controller() {	
    dao = new ClimaAccessDao();
}


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String function = request.getParameter("function").toString();
	
	/*Getting parameters from the Webpage and using name value to determine the unique function intended by the user and placing it in the if case*/ 
    
           
    	if(function.equalsIgnoreCase("temp"))
    	{
    	
    		String city = request.getParameter("city");
    		int day = Integer.parseInt(request.getParameter("day"));
    		int month = Integer.parseInt(request.getParameter("month"));
    		int year = Integer.parseInt(request.getParameter("year"));
    		 Pojo getdetailsfortempy = dao.getDetailsForTemp(city, day, month, year);
    		 RequestDispatcher rd = request.getRequestDispatcher("/Temperature.jsp");
    		 request.setAttribute("getdetailsfortemp", getdetailsfortempy);
    		 rd.forward(request, response);
    	}
    	
    	else if(function.equalsIgnoreCase("snow"))
    	
    	{
    		
    		String city = request.getParameter("city");
    		int day = Integer.parseInt(request.getParameter("day"));
    		int month = Integer.parseInt(request.getParameter("month"));
    		int year = Integer.parseInt(request.getParameter("year"));
    		Pojo getdetailsforsnowy = dao.getDetailsForSnow(city,day,month,year); 
    		RequestDispatcher rd = request.getRequestDispatcher("/Snow.jsp");
    		request.setAttribute("getdetailsforsnow", getdetailsforsnowy);
   		 	rd.forward(request, response);
    	}
    
    	else if(function.equalsIgnoreCase("humid"))
    	{
    		/*Capturing the values from the webpage and then assigning it in a local variable */
    		String city = request.getParameter("city");
    		int day = Integer.parseInt(request.getParameter("day"));
    		int month = Integer.parseInt(request.getParameter("month"));
    		int year = Integer.parseInt(request.getParameter("year"));
    		/*Passing the assigned variables on to an abstract class where all the Disk access operations are defined and then the return is also stored in the return type and then forwarded to */
    		Pojo getdetailsforhumidy = dao.getDetailsForHumid(city,day,month,year); 
    		RequestDispatcher rd = request.getRequestDispatcher("/Humidity.jsp");
    		request.setAttribute("getdetailsforhumid", getdetailsforhumidy);
   		 	rd.forward(request, response);
    	}

    	else if(function.equalsIgnoreCase("all"))
    	{
    		/*Capturing the values from the webpage and then assigning it in a local variable */
    		String city = request.getParameter("city");
    		int day = Integer.parseInt(request.getParameter("day"));
    		int month = Integer.parseInt(request.getParameter("month"));
    		int year = Integer.parseInt(request.getParameter("year"));
    		/*Passing the assigned variables on to an abstract class where all the Disk access operations are defined and then the return is also stored in the return type and then forwarded to */
    		Pojo getdetailsforally = dao.getDetailsForAllCond(city,day,month,year); 
    		RequestDispatcher rd = request.getRequestDispatcher("/allClimaConds.jsp");
    		request.setAttribute("getdetailsforall", getdetailsforally);
   		 	rd.forward(request, response);
    	}
	

		else if(function.equalsIgnoreCase("monthly"))
				{
			
			String city = request.getParameter("city");
    		int month = Integer.parseInt(request.getParameter("month"));
    		int year = Integer.parseInt(request.getParameter("year"));
    		Pojo getdetailsbymonthy = dao.getDetailsByMonth(city,month,year); 
    		RequestDispatcher rd = request.getRequestDispatcher("/monthview.jsp");
    		request.setAttribute("getdetailsbymonth", getdetailsbymonthy);
   		 	rd.forward(request, response);
		}


		else if(function.equalsIgnoreCase("yearly"))
		{
			
			String city = request.getParameter("city");
			int day = Integer.parseInt(request.getParameter("day"));
			int month = Integer.parseInt(request.getParameter("month"));
			List<Pojo> yearly =dao.getAllDetailsByYear(city,day,month);
			RequestDispatcher rd = request.getRequestDispatcher("/viewyear.jsp");
			request.setAttribute("getdetailsbyyear", yearly);
   		 	rd.forward(request, response);
			
		}
		





}
}

