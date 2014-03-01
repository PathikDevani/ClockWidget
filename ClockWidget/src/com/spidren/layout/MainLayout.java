package com.spidren.layout;

import android.content.Context;
import android.util.Log;

import com.spidren.api.abLyt;
import com.spidren.clockwidget.MainActivity;
import com.spidren.views.BackgroundView;

public class MainLayout extends abLyt{
	BackgroundView bv;
	TopHalfLayout tf;
	BottomHalfLayout bf;
	public MainLayout(Context context, int width, int height, int x, int y) {
		super(context, width, height, x, y);
		
		bv = new BackgroundView(context, width, height, 0, 0);
		addView(bv);
		
		tf = new TopHalfLayout(context, width, MainActivity.cf.dpix[140], 0, 0);
		addView(tf);
		
		bf = new BottomHalfLayout(context, width, height - MainActivity.cf.dpix[140], 0, MainActivity.cf.dpix[140]);
		addView(bf);
	}

}
