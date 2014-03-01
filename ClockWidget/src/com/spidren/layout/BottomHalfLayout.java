package com.spidren.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.spidren.api.ABView;
import com.spidren.api.abLyt;
import com.spidren.clockwidget.MainActivity;
import com.spidren.views.BtnBottomView;

public class BottomHalfLayout extends abLyt {
	public static BtnBottomView btn;
	public static ListViewLayout ls;

	public BottomHalfLayout(final Context context, final int width,
			final int height, int x, int y) {
		super(context, width, height, x, y);

		btn = new BtnBottomView(context, MainActivity.cf.dpix[80],
				MainActivity.cf.dpix[25],
				(width - MainActivity.cf.dpix[80]) / 2, height
						- MainActivity.cf.dpix[25]) {
			int i = 0, end = 1;

			@Override
			public void onClick(MotionEvent event) {
				if (i == 0) {
					i = 1;
					ls = new ListViewLayout(context, width,
							MainActivity.cf.dpix[200], 0, height);
					addView(ls);
					btn.bringToFront();
				}
				if (end == 1) {
					super.onClick(event);
					ls.playAnimation();
					end = 0;
				}
			}

			@Override
			protected void onAnimationEnd() {
				super.onAnimationEnd();
				end = 1;
			}
		};
		addView(btn);
	}

}
