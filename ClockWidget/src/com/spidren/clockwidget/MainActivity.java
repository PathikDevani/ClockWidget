package com.spidren.clockwidget;

import com.spidren.api.abLyt;
import com.spidren.api.config;
import com.spidren.code.AppSetAlarmPerMintie;
import com.spidren.database.DatabaseHandler;
import com.spidren.database.WidgetColorContent;
import com.spidren.layout.BottomHalfLayout;
import com.spidren.layout.MainLayout;
import com.spidren.layout.TopHalfLayout;

import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.app.Activity;
import android.content.Intent;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {
	public static config cf;
	public static DatabaseHandler db;
	public static int i;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("My", "i am onCreate.....");
		i=0;
		db = new DatabaseHandler(getBaseContext());
		if(db.getContactsCount() == 0 )
		{
			db.addContent(new WidgetColorContent(1, "#ffFFD200","#ff46DF63"));
			db.addContent(new WidgetColorContent(2, "0", ""));
		}
		final View V = new View(getBaseContext());
		setContentView(V);
		V.post(new Runnable() {

			@Override
			public void run() {
				cf = new config(getBaseContext(), V.getWidth(), V.getHeight());
				init();
			}
		});
	}
	protected void init() {
		AppSetAlarmPerMintie s = new AppSetAlarmPerMintie(getBaseContext());
		s.setAlarm();
		abLyt main = new MainLayout(getBaseContext(), cf.w, cf.h, 0, 0);
		setContentView(main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() {
		AppSetAlarmPerMintie s = new AppSetAlarmPerMintie(getBaseContext());
		s.stopAlarm();
		super.onDestroy();
		Log.i("My", "i am onDestroy.....");
	}
	@Override
	public void onBackPressed() {
		if(i == 1)
		{
			BottomHalfLayout.btn.setOnClick();
			BottomHalfLayout.ls.playAnimation();
		}
		else {
			
			super.onBackPressed();
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_about:
			String url1 = "https://play.google.com/store/search?q=spidren&hl=en";
			Intent i1 = new Intent(Intent.ACTION_VIEW);
			i1.setData(Uri.parse(url1));
			startActivity(i1);
			break;
		case R.id.menu_devlpoer:
			String url2 = "http://www.facebook.com/devani.pathiki";
			Intent i2 = new Intent(Intent.ACTION_VIEW);
			i2.setData(Uri.parse(url2));
			startActivity(i2);
			break;
		case R.id.menu_setalarm:
			Intent i = new Intent(AlarmClock.ACTION_SET_ALARM); 
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(i); 
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onResume() {
		Log.i("My", "i am onresume.....");
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		Log.i("My", "i am onPause.....");
		super.onPause();
	}
	@Override
	protected void onRestart() {
		Log.i("My", "i am onRestart.....");
		super.onRestart();
	}
	@Override
	protected void onStop() {
		Log.i("My", "i am onStop.....");
		super.onStop();
	}
	
	@Override
	protected void onStart() {
		Log.i("My", "i am onStart.....");
		super.onStart();
	}
}
