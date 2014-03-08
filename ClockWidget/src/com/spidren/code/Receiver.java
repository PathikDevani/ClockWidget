package com.spidren.code;

import com.spidren.layout.TopHalfLayout;
import com.spidren.views.ClockTimeView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver{
	public static final String TIME_UPDATE = "com.spidren.clockwidget.TIME_UPDATE_APP";
	public static final String TIME_SET = "android.intent.action.TIME_SET";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("My", "action form reciver :"+intent.getAction());
		if(intent.getAction().equals(TIME_UPDATE) || intent.getAction().equals(TIME_SET))
		{
			AppSetAlarmPerMinute s = new AppSetAlarmPerMinute(context);
			s.setAlarm();
			TopHalfLayout.Ctime.setColor(ClockTimeView.wc.getFirstColor(),ClockTimeView.wc.getSecondColor());
		}
		
	}

	
	
	

}
