package com.spidren.shape;

import com.spidren.api.shapeImg;

import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.graphics.Path;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class BtnBottomshape extends shapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(5.05f, 8.05f);
			lineTo(33.45f, 8.05f);
			lineTo(38.7f, 16.95f);
			lineTo(38.7f, 17f);
			lineTo(9.25f, 17f);
			lineTo(5f, 8.05f);
			lineTo(5.05f, 8.05f);
		}
	}

	class Path1 extends Path {
		public Path1() {
			moveTo(5.05f, 8.05f);
			lineTo(5f, 8.05f);
			lineTo(9.25f, 17f);
			lineTo(0f, 17f);
			lineTo(0f, 0f);
			lineTo(39f, 0f);
			lineTo(39f, 17f);
			lineTo(38.7f, 17f);
			lineTo(38.7f, 16.95f);
			lineTo(33.45f, 8f);
			lineTo(5f, 8f);
			lineTo(5.05f, 8.05f);
		}
	}

	class Path2 extends Path {
		public Path2() {
			moveTo(4.8f, 8f);
			lineTo(4.8f, 5.9f);
			lineTo(33.55f, 5.9f);
			lineTo(33.55f, 8f);
			lineTo(4.8f, 8f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	Paint P1 = new Paint();
	Path1 S1 = new Path1();

	Paint P2 = new Paint();
	Path2 S2 = new Path2();

	float Ht = 17;
	float Wh = 39;

	public BtnBottomshape(int width, int height, int x, int y) {

		init((float) width / (float) Wh, (float) height / (float) Ht, x, y);
		LinearGradient Lg = null;
		S0.transform(matrix);
		P0.setColor(Color.parseColor("#1A000000"));
		P0.setAntiAlias(true);

		S1.transform(matrix);
		P1.setColor(Color.parseColor("#73ffffff"));
		P1.setAntiAlias(true);

		S2.transform(matrix);
		P2.setColor(Color.parseColor("#000000"));
		P2.setAntiAlias(true);

	}

	public void draw(Canvas canvas) {
		canvas.drawPath(S0, P0);
		canvas.drawPath(S1, P1);
		canvas.drawPath(S2, P2);
	}
}
