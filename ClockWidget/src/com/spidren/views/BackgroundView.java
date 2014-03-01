package com.spidren.views;

import android.content.Context;
import android.graphics.Canvas;

import com.spidren.api.ABView;
import com.spidren.shape.BackgroundShape1;
import com.spidren.shape.BackgroundShape2;

public class BackgroundView extends ABView{
	BackgroundShape1 s1;
	BackgroundShape2 s2;
	public BackgroundView(Context context, int width, int height, int x, int y) {
		super(context, width, height, x, y);
		//s1 = new BackgroundShape1(width, height, x, y,"#ff49fcdc","#ff0364d9");
		s1 = new BackgroundShape1(width, height, x, y,"#ff000000","#ff000000");
		s2 = new BackgroundShape2(width, height, x, y);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		s1.draw(canvas);
		s2.draw(canvas);
	}
}
