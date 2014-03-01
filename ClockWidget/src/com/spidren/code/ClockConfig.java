package com.spidren.code;

import java.util.Calendar;


import com.spidren.layout.MainLayout;
import com.spidren.widget.MainWidget;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ClockConfig {
	private static final String ACTION_UPDATE = "com.example.clockusingalarmmanager.GET_TIME_ACTION";
	public Context context;
	AlarmManager alarmMgr;
	ClockConfig(Context context)
	{
		this.context = context;
	}
	
	public void setAlarm()
	{
		Calendar calNow = Calendar.getInstance();
		Calendar calNext = (Calendar) calNow.clone();
		calNext.set(Calendar.HOUR_OF_DAY, calNow.getTime().getHours());
		calNext.set(Calendar.MINUTE, calNow.getTime().getMinutes()+1);
		calNext.set(Calendar.SECOND, 0);
		Log.i("My", "alrama set on"+calNext.getTime());
		setAlarmNextminit(calNext);
	}
	
	private void setAlarmNextminit(Calendar calNext) {
		Intent intent = new Intent(context,MainWidget.class);
		intent.setAction(ACTION_UPDATE);
		PendingIntent pendingintent = PendingIntent.getBroadcast(context, 1, intent, 0);
		alarmMgr = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
		alarmMgr.set(AlarmManager.RTC_WAKEUP, calNext.getTimeInMillis(), pendingintent);
	}
	
	void stopAlarm()
	{
		Intent intent = new Intent(context,MainLayout.class);
		intent.setAction(ACTION_UPDATE);
		PendingIntent pendingintent = PendingIntent.getBroadcast(context, 1, intent, 0);
		alarmMgr.cancel(pendingintent);
	}
}
