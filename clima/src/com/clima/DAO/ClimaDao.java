package com.clima.DAO;

import com.clima.Util.*;
import com.clima.Pojo.Pojo;
import java.util.*;
public interface ClimaDao {
    
	
	
   // public List<Pojo> details( int wban,int usaf );

	//public List<Pojo> getCity(String city);

	//Pojo getStateByCity(String city);

	//Pojo getDetailsByMonth(int month, int year,String city);
	//List<Pojo> getAllDetailsByMonth(int month, int year,String city);

	//Pojo getDetailsbyYear(String year);

	//Pojo getDetailsBymonth(int month, int year, String city);
   
	 public Pojo getDetailsForTemp(String city, int day,int month,int year);

	public Pojo getDetailsForSnow(String city, int day, int month, int year);

	public Pojo getDetailsForHumid(String city, int day, int month, int year);

	public Pojo getDetailsByMonth(String city, int month, int year);

	public List<Pojo> getAllDetailsByYear(String city, int day, int month);

	public Pojo getDetailsForAllCond(String city, int day, int month, int year);
}


