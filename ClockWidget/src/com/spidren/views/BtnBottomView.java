package com.spidren.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsoluteLayout;

import com.spidren.api.ABView;
import com.spidren.clockwidget.MainActivity;
import com.spidren.shape.BtnBottomshape;

@SuppressLint("NewApi")
public class BtnBottomView extends ABView {
	BtnBottomshape btn;
	int X, Y;
	int width, height;

	public BtnBottomView(Context context, int width, int height, int x, int y) {
		super(context, width, height, x, y);
		X = x;
		Y = y;
		this.width = width;
		this.height = height;

		btn = new BtnBottomshape(width, height, 0, 0);
		setTag(1);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		btn.draw(canvas);
	}

	@Override
	public void onClick(MotionEvent event) {

		setOnClick();
	}

	@Override
	protected void onAnimationEnd() {
		super.onAnimationEnd();
		if ((Integer) getTag() == 2) {
			AbsoluteLayout.LayoutParams l = (android.widget.AbsoluteLayout.LayoutParams) getLayoutParams();
			l.x = X;
			l.y = Y - MainActivity.cf.dpix[200];
			setLayoutParams(l);
			setTag(0);
		}
		if ((Integer) getTag() == 3) {
			AbsoluteLayout.LayoutParams l = (android.widget.AbsoluteLayout.LayoutParams) getLayoutParams();
			l.x = X;
			l.y = Y;
			setLayoutParams(l);
			setTag(1);
		}
	}

	public void setOnClick() {
		if (MainActivity.i == 0)
			MainActivity.i = 1;
		else {
			MainActivity.i = 0;
		}

		if ((Integer) getTag() == 1) {
			TranslateAnimation animation = new TranslateAnimation(
					Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0f,
					Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, -MainActivity.cf.dpix[200]);
			animation.setDuration(200);
			startAnimation(animation);
			invalidate();

			setTag(2);
		}
		if ((Integer) getTag() == 0) {
			TranslateAnimation animation = new TranslateAnimation(
					Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, 0f,
					Animation.ABSOLUTE, 0f, Animation.ABSOLUTE, MainActivity.cf.dpix[200]);
			animation.setDuration(200);
			startAnimation(animation);
			setTag(3);
		}
	}

}
