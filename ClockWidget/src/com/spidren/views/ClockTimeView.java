package com.spidren.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;

import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.spidren.api.ABView;
import com.spidren.api.config;
import com.spidren.clockwidget.MainActivity;
import com.spidren.database.WidgetColorContent;
import com.spidren.shape.ClockTimeShape;

public class ClockTimeView extends ABView {
	public static ClockTimeShape Ctime, Cday, Campm;
	public static int w, h;
	public static Context c;
	public static WidgetColorContent wc;

	public ClockTimeView(Context context, int width, int height, int x, int y) {
		super(context, width, height, x, y);
		// setBackgroundColor(Color.GREEN);

		wc = MainActivity.db.getContent(1);

		w = width;
		h = height;
		c = context;
		Ctime = new ClockTimeShape(wc.getFirstColor(), wc.getSecondColor());
		Ctime.P0.setTypeface(Typeface.createFromAsset(context.getAssets(),
				"HelveticaNeue-UltraLight.otf"));
		Ctime.setText(config.getCurrentTime(), MainActivity.cf.dpix[90]);
		Ctime.finish((width - Ctime.width) / 2, 0);

		Campm = new ClockTimeShape(wc.getFirstColor(), wc.getSecondColor());
		Campm.P0.setTypeface(Typeface.createFromAsset(context.getAssets(),
				"HelveticaNeue-Light.otf"));
		Campm.setText(config.getAmPm(), MainActivity.cf.dpix[20]);
		Campm.finish((width - Ctime.width) / 2 + Ctime.width
				+ MainActivity.cf.dpix[5], Ctime.height - Campm.height);

		Cday = new ClockTimeShape(wc.getFirstColor(), wc.getSecondColor());
		Cday.P0.setTypeface(Typeface.createFromAsset(context.getAssets(),
				"HelveticaNeue-Light.otf"));
		Cday.setText(config.getCurrentDay(), MainActivity.cf.dpix[20]);
		Cday.finish((width - Cday.width) / 2, Ctime.height
				+ MainActivity.cf.dpix[7]);
		
	}
	@Override
	protected void onDraw(Canvas canvas) {
		Ctime.draw(canvas);
		Campm.draw(canvas);
		Cday.draw(canvas);
		
		//Log.i("My", "i am invalidate.....");
		//invalidate();
	}

	public void setColor(String color1, String color2) {
		wc = new WidgetColorContent(1, color1, color2);
		Ctime = new ClockTimeShape(color1, color2);
		Ctime.P0.setTypeface(Typeface.createFromAsset(c.getAssets(),
				"HelveticaNeue-UltraLight.otf"));
		Ctime.setText(config.getCurrentTime(), MainActivity.cf.dpix[90]);
		Ctime.finish((w - Ctime.width) / 2, 0);

		Campm = new ClockTimeShape(color1, color2);
		Campm.P0.setTypeface(Typeface.createFromAsset(c.getAssets(),
				"HelveticaNeue-Light.otf"));
		Campm.setText(config.getAmPm(), MainActivity.cf.dpix[20]);
		Campm.finish((w - Ctime.width) / 2 + Ctime.width
				+ MainActivity.cf.dpix[1], Ctime.height - Campm.height);

		Cday = new ClockTimeShape(color1, color2);
		Cday.P0.setTypeface(Typeface.createFromAsset(c.getAssets(),
				"HelveticaNeue-Light.otf"));
		Cday.setText(config.getCurrentDay(), MainActivity.cf.dpix[20]);
		Cday.finish((w - Cday.width) / 2, Ctime.height
				+ MainActivity.cf.dpix[7]);

		invalidate();
		// Log.i("My", "i am invalidate......from colck ");
	}

	@Override
	public void onClick(MotionEvent event) {
		super.onClick(event);
		Intent intent = new Intent(
				android.provider.Settings.ACTION_DATE_SETTINGS);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		c.startActivity(intent);
	}
}
