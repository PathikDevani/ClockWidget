package com.spidren.clockwidget;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.spidren.api.abLyt;
import com.spidren.api.config;
import com.spidren.code.AppSetAlarmPerMinute;
import com.spidren.code.Receiver;

import com.spidren.database.DatabaseHandler;
import com.spidren.database.WidgetColorContent;
import com.spidren.layout.BottomHalfLayout;
import com.spidren.layout.MainLayout;

public class MainActivity extends Activity {
	public static config cf;
	public static DatabaseHandler db;
	public static int i;
	public Receiver receiver;
	public IntentFilter intentFilter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Log.i("My", "i am onCreate.....");
		i = 0;

		// init & start Receiver
		receiver = new Receiver();
		intentFilter = new IntentFilter();
		intentFilter.addAction(Receiver.TIME_SET);
		intentFilter.addAction(Receiver.TIME_UPDATE);
		registerReceiver(receiver, intentFilter);
		
		

		// create databaseHandler
		db = new DatabaseHandler(getBaseContext());
		if (db.getContactsCount() == 0) {
			db.addContent(new WidgetColorContent(1, "#ffFFD200", "#ff46DF63"));
			db.addContent(new WidgetColorContent(2, "0", ""));
		}

		// init view
		final View V = new View(getBaseContext());
		setContentView(V);
		V.post(new Runnable() {

			@Override
			public void run() {
				// init config
				cf = new config(getBaseContext(), V.getWidth(), V.getHeight());
				init();
			}
		});
	}

	protected void init() {
		// set alarm per minute
		AppSetAlarmPerMinute s = new AppSetAlarmPerMinute(getBaseContext());
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
		// stop alarm
		AppSetAlarmPerMinute s = new AppSetAlarmPerMinute(getBaseContext());
		s.stopAlarm();

		// stop receiver
		//unregisterReceiver(receiver);
		super.onDestroy();

		// Log.i("My", "i am onDestroy.....");
	}

	@Override
	public void onBackPressed() {

		// back press control
		if (i == 1) {
			BottomHalfLayout.btn.setOnClick();
			BottomHalfLayout.ls.playAnimation();
		} else {

			super.onBackPressed();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// handle options
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
		// Log.i("My", "i am onresume.....");
		registerReceiver(receiver, intentFilter);
		super.onResume();
	}

	@Override
	protected void onPause() {
		// Log.i("My", "i am onPause.....");
		unregisterReceiver(receiver);
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// Log.i("My", "i am onRestart.....");
		super.onRestart();
	}

	@Override
	protected void onStop() {
		// Log.i("My", "i am onStop.....");
		super.onStop();
	}

	@Override
	protected void onStart() {
		// Log.i("My", "i am onStart.....");
		super.onStart();
		
		

	}
}