package com.spidren.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;

public class config {
	public int w, h;
	public static Context context;
	public float dpi;
	public int[] dpix = new int[1001];
	
	public static int minuteINT,hourINT,hourofdayINT,aaINT;
	public static String minute,hour,hourofday,aa,dayOfWeek,month,dayOfMonth;

	public config(Context baseContext, int width, int height) {
		w = width;
		h = height;
		context = baseContext;
		dpi = baseContext.getResources().getDisplayMetrics().density;
		for (int i = 1; i < 1001; i++) {
			dpix[i] = (int) (dpi * i);
		}
	}

	public static void setCurrentTime() {
		Calendar cal = Calendar.getInstance();
		
		//for AM_PM
		aaINT = cal.get(Calendar.AM_PM);
		if(aaINT==1)
			aa = "pm";
		else
			aa = "am";
		
		//for minute
		minuteINT = cal.get(Calendar.MINUTE);
		if(minuteINT < 10)
			minute = "0"+minuteINT;
		else 
			minute = ""+minuteINT;
		
		// 12 hour format
		hourINT = cal.get(Calendar.HOUR);
		if(hourINT < 10 && hourINT >0)
			hour = "0"+hourINT;
		else {
			if (hourINT == 0) {
				hour = "12";
			}
			else {
				hour = ""+hourINT;
			}
		}
		
		// 24 hour format
		hourofdayINT = cal.get(Calendar.HOUR_OF_DAY);
		if(hourofdayINT < 10)
			hourofday = "0"+hourofdayINT;
		else 
			hourofday = ""+hourofdayINT;
		
		//for day of week
	    int dayOfWeekINT = cal.get(Calendar.DAY_OF_WEEK);                
		if (Calendar.MONDAY == dayOfWeekINT) dayOfWeek = "Mon";
	    else if (Calendar.TUESDAY == dayOfWeekINT) dayOfWeek = "Tue";
	    else if (Calendar.WEDNESDAY == dayOfWeekINT) dayOfWeek = "Wed";
	    else if (Calendar.THURSDAY == dayOfWeekINT) dayOfWeek = "Thu";
	    else if (Calendar.FRIDAY == dayOfWeekINT) dayOfWeek = "Fri";
	    else if (Calendar.SATURDAY == dayOfWeekINT) dayOfWeek = "Sat";
	    else if (Calendar.SUNDAY == dayOfWeekINT) dayOfWeek = "Sun";	    
		
		//for month
		int monthINT = cal.get(Calendar.MONTH);
		switch (monthINT) {
		case 0:
			month = "Jan";
			break;
		case 1:
			month = "Feb";
			break;
		case 2:
			month = "Mar";
			break;
		case 3:
			month = "Apr";
			break;
		case 4:
			month = "May";
			break;
		case 5:
			month = "Jun";
			break;
		case 6:
			month = "Jul";
			break;
		case 7:
			month = "Aug";
			break;
		case 8:
			month = "Sep";
			break;
		case 9:
			month = "Oct";
			break;
		case 10:
			month = "Nov";
			break;
		case 11:
			month = "Dec";
			break;
		default:
			break;
		}
		
		//day of month
		int dayOfMonthINT = cal.get(Calendar.DAY_OF_MONTH);
		dayOfMonth = ""+dayOfMonthINT;
	}
	
	public static String getCurrentTime()
	{
		setCurrentTime();
		if(DateFormat.is24HourFormat(context))
			return hourofday+":"+minute;
		else {
			return hour+":"+minute;		
		}
	}
	public static String getCurrentDay()
	{
		setCurrentTime();
		return dayOfWeek+" ,"+dayOfMonth+" "+month;
	}
	
	public static String getAmPm()
	{
		setCurrentTime();
		return aa;
	}
	
	

}
