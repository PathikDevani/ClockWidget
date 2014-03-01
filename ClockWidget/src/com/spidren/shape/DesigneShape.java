package com.spidren.shape;

import com.spidren.api.shapeImg;

import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.graphics.Path;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class DesigneShape extends shapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(74.25f, 12.75f);
			quadTo(87f, 25.5f, 87f, 43.5f);
			quadTo(87f, 61.5f, 74.25f, 74.25f);
			quadTo(61.5f, 87f, 43.5f, 87f);
			quadTo(25.5f, 87f, 12.75f, 74.25f);
			quadTo(0f, 61.5f, 0f, 43.5f);
			quadTo(0f, 25.5f, 12.75f, 12.75f);
			quadTo(25.5f, 0f, 43.5f, 0f);
			quadTo(61.5f, 0f, 74.25f, 12.75f);
		}
	}

	Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 87;
	float Wh = 87;
	
	public DesigneShape(int width, int height, int x, int y,String color1, String color2) {

		init((float) width / (float) Wh, (float) height / (float) Ht, x, y);
		LinearGradient Lg = null;
		S0.transform(matrix);
		Lg = new LinearGradient(0, 44, 87, 44, new int[] {
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