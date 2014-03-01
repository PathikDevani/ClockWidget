package com.spidren.shape;

import com.spidren.api.shapeImg;

import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.graphics.Path;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Canvas;

public class DesignBackShape extends shapeImg {

	class Path0 extends Path {
		public Path0() {
			moveTo(200f, 40f);
			lineTo(0f, 40f);
			lineTo(0f, 0f);
			lineTo(200f, 0f);
			lineTo(200f, 40f);
		}
	}

	public Paint P0 = new Paint();
	Path0 S0 = new Path0();

	float Ht = 40;
	float Wh = 200;

	public DesignBackShape(int width, int height, int x, int y) {

		init((float) width / (float) Wh, (float) height / (float) Ht, x, y);
		LinearGradient Lg = null;
		S0.transform(matrix);
		Lg = new LinearGradient(0, 20, 200, 20, new int[] {
				Color.parseColor("#4Dfe4a67"), Color.parseColor("#4Dff523a"),
				Color.parseColor("#4Dffd200"), Color.parseColor("#4D61d2fe"),
				Color.parseColor("#4D0091fe"), Color.parseColor("#4D6b70e8") },
				new float[] { 0.0f, 0.1843137254901961f, 0.3803921568627451f,
						0.592156862745098f, 0.8117647058823529f, 1.0f },
				TileMode.MIRROR);
		Lg.setLocalMatrix(matrix);
		P0.setShader(Lg);
		P0.setAntiAlias(true);

	}

	public void draw(Canvas canvas) {
		canvas.drawPath(S0, P0);
	}
}