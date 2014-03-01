package com.spidren.layout;

import android.content.Context;

import com.spidren.api.abLyt;
import com.spidren.clockwidget.MainActivity;
import com.spidren.views.ClockTimeView;

public class TopHalfLayout extends abLyt {
	public static ClockTimeView Ctime;

	public TopHalfLayout(Context context, int width, int height, int x, int y) {
		super(context, width, height, x, y);
		// setBackgroundColor(Color.WHITE);

		Ctime = new ClockTimeView(context, MainActivity.cf.dpix[350],
				MainActivity.cf.dpix[140],
				(width - MainActivity.cf.dpix[350]) / 2,
				MainActivity.cf.dpix[30]);
		addView(Ctime);

	}

}
