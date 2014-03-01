package com.spidren.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;

import com.spidren.api.ABView;
import com.spidren.clockwidget.MainActivity;
import com.spidren.database.WidgetColorContent;
import com.spidren.layout.TopHalfLayout;
import com.spidren.shape.DesigneShape;

public class DesignView extends ABView{
	DesigneShape ds;
	String color1,color2;
	Context context;
	public static final String COLOR_UPDATE = "com.spidren.clockwidget.COLOR_UPDATE";
	public DesignView(Context context, int width, int height, int x, int y,String color1,String color2) {
		super(context, width, height, x, y);
	
		this.context = context;
		this.color1 = color1;
		this.color2 = color2;
		ds = new DesigneShape(width - MainActivity.cf.dpix[60], width - MainActivity.cf.dpix[60], MainActivity.cf.dpix[30], (height - width + MainActivity.cf.dpix[60])/2,color1, color2);	
	}
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		ds.draw(canvas);
	}
	
	@Override
	public void onClick(MotionEvent event) {
		TopHalfLayout.Ctime.setColor(color1, color2);
		MainActivity.db.addContent(new WidgetColorContent(1, color1, color2));
		setBackgroundColor(Color.parseColor("#4Dffffff"));
		Intent intent = new Intent();
		intent.setAction(COLOR_UPDATE);
		context.sendBroadcast(intent);
	}
}
