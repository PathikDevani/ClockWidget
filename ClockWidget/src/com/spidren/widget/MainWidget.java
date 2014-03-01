package com.spidren.widget;

import com.spidren.clockwidget.MainActivity;
import com.spidren.clockwidget.R;
import com.spidren.code.TimeConfig;
import com.spidren.database.DatabaseHandler;
import com.spidren.database.WidgetColorContent;
import com.spidren.shape.ClockTimeShape;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.provider.AlarmClock;
import android.util.Log;
import android.widget.RemoteViews;

public class MainWidget extends AppWidgetProvider{
	
	public static final String TIME_UPDATE = "com.spidren.clockwidget.TIME_UPDATE";
	public static final String APP_START = "com.spidren.clockwidget.APP_START";
	public static final String COLOR_UPDATE = "com.spidren.clockwidget.COLOR_UPDATE";
	public static final String TIME_SET = "com.spidren.clockwidget.TIME_SET";
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		
		DatabaseHandler db = new DatabaseHandler(context);
		firstTimeConfig(db);
		
		WidgetSetAlarmPerMintie s =new WidgetSetAlarmPerMintie(context);
		s.setAlarm();
		WidgetColorContent wc = db.getContent(1);
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
		remoteViews.setImageViewBitmap(R.id.TimeImageview, TimeImage(context,wc.getFirstColor(), wc.getSecondColor()));
		
		Intent i = new Intent(context, MainActivity.class);
		//Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
		//i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.setAction(APP_START);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, 0);
		remoteViews.setOnClickPendingIntent(R.id.TimeImageview, pendingIntent);
		pushWidgetUpdate(context, remoteViews);
	}
	public void firstTimeConfig(DatabaseHandler db)
	{
		if(db.getContactsCount() == 0)
		{
			db.addContent(new WidgetColorContent(1, "#ffFFD200","#ff46DF63"));
			db.addContent(new WidgetColorContent(2, "0", "0"));
		}
	}
	
	private void pushWidgetUpdate(Context context,RemoteViews remoteViews)
	{
		ComponentName c = new ComponentName(context, this.getClass());
		AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
		appWidgetManager.updateAppWidget(c, remoteViews);
	}
	
	public Bitmap TimeImage( Context context,String color1,String color2) 
	{
		TimeConfig time = new TimeConfig(context);
		Bitmap myBitmap = Bitmap.createBitmap(time.dpix[500], time.dpix[165], Bitmap.Config.ARGB_4444);
	    Canvas myCanvas = new Canvas(myBitmap);
	    
		ClockTimeShape Ctime= new ClockTimeShape(color1,color2);
		Ctime.P0.setTypeface(Typeface.createFromAsset(context.getAssets(),"HelveticaNeue-UltraLight.otf"));
		Ctime.setText(time.getCurrentTime(),time.dpix[160]);
		
		
		ClockTimeShape Campm = new ClockTimeShape(color1, color2);
		Campm.P0.setTypeface(Typeface.createFromAsset(context.getAssets(),"HelveticaNeue-Light.otf"));
		Campm.setText(time.getAmPm(), time.dpix[36]);
		Campm.finish((time.dpix[500] - Ctime.width)/2 - Campm.width - time.dpix[6] + time.dpix[8] +Ctime.width ,Ctime.height - Campm.height);
		
		Ctime.finish((time.dpix[500] - Ctime.width)/2 - Campm.width - time.dpix[6], 0);
		
		ClockTimeShape Cdate= new ClockTimeShape(color1,color2);
		Cdate.P0.setTypeface(Typeface.createFromAsset(context.getAssets(),"HelveticaNeue-Light.otf"));
		Cdate.setText(time.getCurrentDay(),time.dpix[36]);
		Cdate.finish((time.dpix[500] - Cdate.width)/2 - Campm.width, Ctime.height+time.dpix[16]);
		
		Ctime.draw(myCanvas);
		Campm.draw(myCanvas);
		Cdate.draw(myCanvas);
		//Log.i("My", "i am invalidate.......");
	    return myBitmap;
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		super.onReceive(context, intent);
		if(intent.getAction().equals(TIME_UPDATE) || intent.getAction().equals(COLOR_UPDATE) ||intent.getAction().equals(TIME_SET)  );
		{
			WidgetSetAlarmPerMintie s =new WidgetSetAlarmPerMintie(context);
			s.setAlarm();
			DatabaseHandler d = new DatabaseHandler(context);
			firstTimeConfig(d);
			WidgetColorContent w = d.getContent(1);
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
			remoteViews.setImageViewBitmap(R.id.TimeImageview, TimeImage(context,w.getFirstColor(), w.getSecondColor()));
			pushWidgetUpdate(context, remoteViews);
		}
	}
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
		WidgetSetAlarmPerMintie s =new WidgetSetAlarmPerMintie(context);
		s.stopAlarm();
	}
	
}
