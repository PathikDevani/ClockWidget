package com.spidren.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.spidren.api.abLyt;
import com.spidren.clockwidget.MainActivity;
import com.spidren.database.WidgetColorContent;
import com.spidren.shape.DesignBackShape;
import com.spidren.views.DesignView;

public class ListViewLayout extends abLyt {
	DesignBackShape d;
	public boolean toggle;
	int X, Y,Current;
	DesignView[] array;
	String[][] color;	
	HorizontalScrollView hs;
	public ListViewLayout(Context context, int width, int height, int x, int y) {
		super(context, width, height, x, y);
		setBackgroundColor(Color.parseColor("#1A000000"));
		
		hs = new HorizontalScrollView(context);
		hs.setLayoutParams(new AbsoluteLayout.LayoutParams(AbsoluteLayout.LayoutParams.FILL_PARENT, AbsoluteLayout.LayoutParams.FILL_PARENT, 0, 0));
		
		LinearLayout l = new LinearLayout(context);
		l.setOrientation(LinearLayout.HORIZONTAL);
		l.setLayoutParams(new AbsoluteLayout.LayoutParams(AbsoluteLayout.LayoutParams.FILL_PARENT, AbsoluteLayout.LayoutParams.FILL_PARENT, 0, 0));
		
		hs.addView(l);
		addView(hs);
		toggle = true;
		X = x;
		Y = y;
		color = new String[][]{
				{"#ffFFD200","#ff46DF63"},
				{"#ffFFD200","#ffFF4967"},
				{"#ff2CBBE7","#ff48DC6A"},
				{"#ff6A71E5","#ff2ABBE7"},
				{"#ffFF5534","#ff48DC6A"},
				{"#ff6A71E5","#ffFF4967"},
				{"#ffFFFFFF","#ffFFFFFF"},
			
		};
		d = new DesignBackShape(width, height, 0, 0);
		array = new DesignView[color.length];
		Current = Integer.parseInt(MainActivity.db.getContent(2).getFirstColor());
		for (int i = 0; i < array.length; i++) {
			final int I =i;
			array[i] = new DesignView(context, height, height, 0 + ((width/6)*i), 0,color[i][0],color[i][1]){
				@Override
				public void onClick(MotionEvent event) {
					array[Integer.parseInt(MainActivity.db.getContent(2).getFirstColor())].setBackgroundColor(Color.parseColor("#00000000"));
					MainActivity.db.addContent(new WidgetColorContent(2, I+"", ""));
					super.onClick(event);	
				}
			};
			l.addView(array[i]);
			if(i == Current)
			{
				array[i].setBackgroundColor(Color.parseColor("#4Dffffff"));
				Current = -1;
			}
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		d.draw(canvas);
	}
	
	@Override
	protected void onAnimationEnd() {
		super.onAnimationEnd();
		if (toggle) {
			AbsoluteLayout.LayoutParams l = (android.widget.AbsoluteLayout.LayoutParams) getLayoutParams();
			l.x = X;
			l.y = Y;
			setLayoutParams(l);
		} else {
			AbsoluteLayout.LayoutParams l = (android.widget.AbsoluteLayout.LayoutParams) getLayoutParams();
			l.x = X;
			l.y = Y - MainActivity.cf.dpix[200];
			setLayoutParams(l);
		}
	}

	public void playAnimation() {
		if (toggle) {
			toggle = false;
			TranslateAnimation animation = new TranslateAnimation(
					Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0f,
					Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, -MainActivity.cf.dpix[200]);
			animation.setDuration(200); 
			startAnimation(animation);

		} else {
			toggle = true;
			TranslateAnimation animation = new TranslateAnimation(
					Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0f,
					Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, MainActivity.cf.dpix[200]);
			animation.setDuration(200);
			startAnimation(animation);
		}
	}

}
