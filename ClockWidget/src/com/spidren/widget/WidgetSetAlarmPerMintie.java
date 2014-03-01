package com.spidren.widget;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WidgetSetAlarmPerMintie {
	public static final String TIME_UPDATE = "com.spidren.clockwidget.TIME_UPDATE";
	Context context;
	WidgetSetAlarmPerMintie(Context context)
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
		setAlarmNextminit(calNext);
	}
	private void setAlarmNextminit(Calendar calNext) {
		Intent intent = new Intent(context,MainWidget.class);
		intent.setAction(TIME_UPDATE);
		PendingIntent pendingintent = PendingIntent.getBroadcast(context, 1, intent, 0);
		AlarmManager alarmMgr = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
		alarmMgr.set(AlarmManager.RTC_WAKEUP, calNext.getTimeInMillis(), pendingintent);
	}
	void stopAlarm()
	{
		Intent intent = new Intent(context,MainWidget.class);
		intent.setAction(TIME_UPDATE);
		PendingIntent pendingintent = PendingIntent.getBroadcast(context, 1, intent, 0);
		AlarmManager alarmMgr = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
		alarmMgr.cancel(pendingintent);
	}
}