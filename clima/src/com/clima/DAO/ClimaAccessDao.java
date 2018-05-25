package com.clima.DAO;
import com.clima.Pojo.*;
//import com.mysql.fabric.xmlrpc.base.Array;

//import com.clima.Util.DBUtil;
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import org.w3c.dom.Document;


public class ClimaAccessDao implements ClimaDao {
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	
	public  Connection getConnection() {
	    	try
	    	{
	    	  Class.forName("org.apache.hive.jdbc.HiveDriver");
	    	  //Class.forName("org.apache.hive.jdbc.HiveDriver").newInstance();
	    	 // String url = "jdbc:mysql://localhost:3306/test";
	    	  conn = DriverManager.getConnection("jdbc:hive2://192.168.73.139:10000/default", "hive", "");
	    	 // conn = DriverManager.getConnection(url, "root", "password");
	    	  System.out.println(conn);
	    	 
	    	 // conn.close();
	    	}
	    	catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
	    	//catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
	    	//catch (InstantiationException ex) {System.err.println(ex.getMessage());}
	    	catch (SQLException ex)           {System.err.println(ex.getMessage());}
	    	return conn;
	 }
	
	private Connection conn;

	@Override
	public Pojo getDetailsForTemp(String city, int day, int month, int year) {
		// TODO Auto-generated method stub
		Pojo getdetailsfortemp = new Pojo();
		try { 
			//String query =  "select city,day,month,year,min,max,climacondition from city";
			String query =  "select c.city, r.day,r.month,r.year,t.minimum,t.maximum,t.average,t.climacondition from city_name c,record r,temperature t where r.day="+day+" and r.month="+month+" and r.year="+year+" and c.city='"+city.toUpperCase()+"' and c.city=r.city and r.day=t.day and r.month=t.month and r.year=t.year AND C.CITY=T.CITY";
			conn =  getConnection();
			System.out.println(conn);
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt(1, day);
			//preparedStatement.setInt(2,month);
			//preparedStatement.setInt(3,year);
			//preparedStatement.setString(4,city);
			System.out.println("Running:"+query);
            ResultSet resultSet = preparedStatement.executeQuery();
            
		while( resultSet.next() ) {
            
			getdetailsfortemp.setCity(resultSet.getString("city"));
			getdetailsfortemp.setDay(resultSet.getInt("day"));
			getdetailsfortemp.setMonth(resultSet.getInt("MONTH"));
			getdetailsfortemp.setYear(resultSet.getInt("Year"));
			//getdetailsfortemp.setDewpoint(resultSet.getInt("dewp"));
			getdetailsfortemp.setMin(resultSet.getInt("minimum"));
			getdetailsfortemp.setMax(resultSet.getInt("maximum"));
			
			getdetailsfortemp.setAverage(resultSet.getDouble("Average"));
			//getdetailsfortemp.setSnowDepth(resultSet.getDouble("snowdepth"));
			getdetailsfortemp.setClimacondtion(resultSet.getString("climacondition"));
			
            }
		resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,e);
    	e.printStackTrace();
    }
		return getdetailsfortemp;
		
		
	}

	@Override
	public Pojo getDetailsForSnow(String city, int day, int month, int year) {
		// TODO Auto-generated method stub
		
		Pojo getdetailsforsnow = new Pojo();
		try { 
			String query =  "select c.city, r.day,r.month,r.year,s.SNOWDEPTH,s.climacondition from city_name c,record r,snow s where r.day="+day+" and r.month="+month+" and r.year="+year+" and c.city='"+city.toUpperCase()+"' and c.city=r.city and r.day=s.day and r.month=s.month and r.yea =s.year AND C.CITY=s.CITY";
			conn =  getConnection();
			System.out.println(conn);
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt(1, day);
			//preparedStatement.setInt(2,month);
			//preparedStatement.setInt(3,year);
			//preparedStatement.setString(4,city);
			//preparedStatement( city);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                
            	getdetailsforsnow.setCity(resultSet.getString("city"));
            	getdetailsforsnow.setDay(resultSet.getInt("day"));
    			getdetailsforsnow.setMonth(resultSet.getInt("MONTH"));
    			getdetailsforsnow.setYear(resultSet.getInt("Year"));
    			getdetailsforsnow.setSnowDepth(resultSet.getDouble("snowdepth"));
    			getdetailsforsnow.setClimacondtion(resultSet.getString("climacondition"));
            }
    		resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    		return getdetailsforsnow;
    		
    		
    	}

	@Override
	public Pojo getDetailsForHumid(String city, int day, int month, int year) {
		// TODO Auto-generated method stub
		Pojo getdetailsforhumid = new Pojo();
		try { 
			String query =  "select c.city, r.day,r.month,r.year,h.dewp,h.precipitation,h.climacondition from city_name c,record r,humidity h where r.day="+day+" and r.month="+month+" and r.year="+year+" and c.city='"+city.toUpperCase()+"' and c.city=r.city and r.day=h.day and r.month=h.month and r.year=h.year AND C.CITY=h.CITY";
			conn =  getConnection();
			System.out.println(conn);
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, day);
			preparedStatement.setInt(2,month);
			preparedStatement.setInt(3,year);
			preparedStatement.setString(4,city);
			//preparedStatement( city);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                
            	getdetailsforhumid.setCity(resultSet.getString("city"));
            	getdetailsforhumid.setDay(resultSet.getInt("day"));
            	getdetailsforhumid.setMonth(resultSet.getInt("MONTH"));
            	getdetailsforhumid.setYear(resultSet.getInt("Year"));
            	getdetailsforhumid.setPrecipitation(resultSet.getDouble("Precipitation"));
            	getdetailsforhumid.setDewpoint(resultSet.getInt("Dewp"));
            	getdetailsforhumid.setClimacondtion(resultSet.getString("climacondition"));
    			
            }
    		resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    		return getdetailsforhumid;
    		
    		
    	}

	@Override
	public Pojo getDetailsByMonth(String city, int month, int year) {
		// TODO Auto-generated method stub
		
		Pojo getdetailsbymonth = new Pojo();
		try { 
			String query =  "select c.city,r.month,r.year,avg(t.maximum) as average_max,avg(t.minimum) as average_min,avg(h.dewp) as average_dewp,avg(h.precipitation) as average_precipitation,avg(s.snowdepth) as average_snowdepth from city_name c, record r, temperature t, snow s, humidity h where r.month="+month+" and r.year="+year+" and c.city='"+city.toUpperCase()+"' and c.city=r.city and r.day=t.day and r.month=t.month and r.year=t.year AND C.CITY=T.CITY and c.city=s.city and c.city=h.city and r.day=s.day and r.month=s.month and r.year=s.year AND r.day=h.day and r.month=h.month and r.year=h.year group by c.city,r.month,r.year";
			conn =  getConnection();
			System.out.println(conn);
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt(1, day);
			//preparedStatement.setInt(1,month);
			//preparedStatement.setInt(2,year);
			//preparedStatement.setString(3,city);
			//preparedStatement( city);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                
            	getdetailsbymonth.setCity(resultSet.getString("city"));
            	//getdetailsforsnow.setDay(resultSet.getInt("day"));
            	getdetailsbymonth.setMonth(resultSet.getInt("MONTH"));
            	getdetailsbymonth.setYear(resultSet.getInt("Year"));
            	getdetailsbymonth.setAveragemax(resultSet.getDouble("average_max"));
            	getdetailsbymonth.setAveragemin(resultSet.getDouble("average_min"));
            	getdetailsbymonth.setAveragedewp(resultSet.getDouble("average_dewp"));
            	getdetailsbymonth.setAverageprecipitation(resultSet.getDouble("average_precipitation"));
            	getdetailsbymonth.setAveragesnow(resultSet.getDouble("average_snowdepth"));
            	
            }
		 
		resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
		return getdetailsbymonth;
		
		
	
		
	
	}

	@Override
	public List<Pojo> getAllDetailsByYear(String city, int day, int month) {
		// TODO Auto-generated method stub
		List<Pojo> detailsbyyear = new ArrayList<Pojo>();
		try { 
			String query =  "select c.city,r.day,r.month,r.year,h.dewp,t.minimum,t.maximum,t.average,h.precipitation,s.snowdepth,t.climacondition from city_name c, record r, temperature t, snow s, humidity h where r.day="+day+" and r.month="+month+" and c.city='"+city.toUpperCase()+"' and c.city=r.city and r.day=t.day and r.month=t.month and r.year=t.year AND C.CITY=T.CITY and c.city=s.city and c.city=h.city and r.day=s.day and r.month=s.month and r.year=s.year AND r.day=h.day and r.month=h.month and r.year=h.year group by c.city,r.day,r.month,r.year,h.dewp,t.minimum,t.maximum,t.average,h.precipitation,s.snowdepth,t.climacondition";
			System.out.println(query);
			conn =  getConnection();
			System.out.println(conn);
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			//preparedStatement.setInt(1, day);
			//preparedStatement.setString(2, city);
			ResultSet resultSet = preparedStatement.executeQuery();
			while( resultSet.next() ) {
				Pojo byyear = new Pojo();
				byyear.setCity(resultSet.getString("city"));
				byyear.setDay(resultSet.getInt("day"));
				byyear.setMonth(resultSet.getInt("MONTH"));
				byyear.setYear(resultSet.getInt("Year"));
				byyear.setDewpoint(resultSet.getInt("dewp"));
				byyear.setMin(resultSet.getInt("minimum"));
				byyear.setMax(resultSet.getInt("maximum"));
				byyear.setAverage(resultSet.getDouble("Average"));
				byyear.setPrecipitation(resultSet.getDouble("precipitation"));
				byyear.setSnowDepth(resultSet.getDouble("snowdepth"));
				byyear.setClimacondtion(resultSet.getString("climacondition"));
				detailsbyyear.add(byyear);
	            }
			resultSet.close();
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return detailsbyyear;
		
	}

	@Override
	public Pojo getDetailsForAllCond(String city, int day, int month, int year) {
		// TODO Auto-generated method stub
		Pojo getdetailsforallcond = new Pojo();
		try { 
			String query =  "select c.city,r.day,r.month,r.year,t.minimum,t.maximum,t.average,h.dewp,h.precipitation,s.snowdepth,t.climacondition from city_name c, record r, temperature t, snow s, humidity h where r.day="+day+" and r.month="+month+" and r.year="+year+" and c.city='"+city.toUpperCase()+"' and c.city=r.city and r.day=t.day and r.month=t.month and r.year=t.year AND C.CITY=T.CITY and c.city=s.city and c.city=h.city and r.day=s.day and r.month=s.month and r.year=s.year AND r.day=h.day and r.month=h.month and r.year=h.year";
			conn =  getConnection();
			System.out.println(conn);
			PreparedStatement preparedStatement = conn.prepareStatement( query );
			preparedStatement.setInt(1, day);
			preparedStatement.setInt(2,month);
			preparedStatement.setInt(3,year);
			preparedStatement.setString(4,city);
			//preparedStatement( city);
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                
            	getdetailsforallcond.setCity(resultSet.getString("city"));
            	getdetailsforallcond.setDay(resultSet.getInt("day"));
            	getdetailsforallcond.setMonth(resultSet.getInt("MONTH"));
            	getdetailsforallcond.setYear(resultSet.getInt("Year"));
            	getdetailsforallcond.setMin(resultSet.getInt("minimum"));
            	getdetailsforallcond.setMax(resultSet.getInt("maximum"));
            	getdetailsforallcond.setAverage(resultSet.getDouble("Average"));
				getdetailsforallcond.setDewpoint(resultSet.getInt("Dewp"));
            	getdetailsforallcond.setPrecipitation(resultSet.getDouble("Precipitation"));
            	getdetailsforallcond.setSnowDepth(resultSet.getDouble("snowdepth"));            	
            	getdetailsforallcond.setClimacondtion(resultSet.getString("climacondition"));
    			
            }
    		resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    		return getdetailsforallcond;
    		
	}
	
		
}
	 
	
	
	
	
    
    
    
