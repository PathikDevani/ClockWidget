package com.spidren.shape;

import com.spidren.api.shapeImg;

import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.graphics.Path;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class BackgroundShape2 extends shapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(100f, 31.75f);
			lineTo(100f, 35.4f);
			lineTo(52.8f, 0f);
			lineTo(57.65f, 0f);
			lineTo(100f, 31.75f);
			moveTo(100f, 77.25f);
			lineTo(100f, 96.4f);
			lineTo(0f, 21.4f);
			lineTo(0f, 2.25f);
			lineTo(100f, 77.25f);
			moveTo(55.35f, 100f);
			lineTo(47f, 100f);
			lineTo(0f, 64.75f);
			lineTo(0f, 58.5f);
			lineTo(55.35f, 100f);
		}
	}

	class Path1 extends Path {
		public Path1() {
			moveTo(55.35f, 100f);
			lineTo(0f, 58.5f);
			lineTo(0f, 21.4f);
			lineTo(100f, 96.4f);
			lineTo(100f, 100f);
			lineTo(55.35f, 100f);
			moveTo(57.65f, 0f);
			lineTo(100f, 0f);
			lineTo(100f, 31.75f);
			lineTo(57.65f, 0f);
			moveTo(100f, 35.4f);
			lineTo(100f, 77.25f);
			lineTo(0f, 2.25f);
			lineTo(0f, 0f);
			lineTo(52.8f, 0f);
			lineTo(100f, 35.4f);
			moveTo(47f, 100f);
			lineTo(0f, 100f);
			lineTo(0f, 64.75f);
			lineTo(47f, 100f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	Paint P1 = new Paint();
	Path1 S1 = new Path1();

	float Ht = 100;
	float Wh = 100;

	public BackgroundShape2(int width, int height, int x, int y) {

		init((float) width / (float) Wh, (float) height / (float) Ht, x, y);
		LinearGradient Lg = null;
		S0.transform(matrix);
		P0.setColor(Color.parseColor("#15ffffff"));
		P0.setAntiAlias(true);

		S1.transform(matrix);
		P1.setColor(Color.parseColor("#00ffffff"));
		P1.setAntiAlias(true);

	}

	public void draw(Canvas canvas) {
		canvas.drawPath(S0, P0);
		canvas.drawPath(S1, P1);
	}
}