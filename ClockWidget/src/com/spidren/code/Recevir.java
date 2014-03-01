package com.spidren.code;

import com.spidren.layout.TopHalfLayout;
import com.spidren.views.ClockTimeView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Recevir extends BroadcastReceiver{
	public static final String TIME_UPDATE = "com.spidren.clockwidget.TIME_UPDATE";
	public static final String TIME_SET = "android.intent.action.TIME_SET";
	
	@Override
	public void onReceive(Context context, Intent intent) {
	
		if(intent.getAction().equals(TIME_UPDATE) || intent.getAction().equals(TIME_SET))
		{
			AppSetAlarmPerMintie s = new AppSetAlarmPerMintie(context);
			s.setAlarm();
			TopHalfLayout.Ctime.setColor(ClockTimeView.wc.getFirstColor(),ClockTimeView.wc.getSecondColor());
		}
	}

}
