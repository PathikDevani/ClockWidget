package com.spidren.shape;

import com.spidren.api.shapeImg;
import com.spidren.clockwidget.MainActivity;

import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.graphics.Path;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class BackgroundShape1 extends shapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(0f, 0f);
			lineTo(100f, 0f);
			lineTo(100f, 100f);
			lineTo(0f, 100f);
			lineTo(0f, 0f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 100;
	float Wh = 100;

	public BackgroundShape1(int width, int height, int x, int y,String color1,String color2) {

		init((float) width / (float) Wh, (float) height / (float) Ht, x, y);
		LinearGradient Lg = null;
		S0.transform(matrix);
		Lg = new LinearGradient(0, 50, 100, 50, new int[] {
				Color.parseColor(color1), Color.parseColor(color2) },
				new float[] { 0.0f, 1.0f }, TileMode.MIRROR);
		Lg.setLocalMatrix(matrix);
		P0.setShader(Lg);
		P0.setAntiAlias(true);

	}

	public void draw(Canvas canvas) {
		canvas.drawPath(S0, P0);
	}
}