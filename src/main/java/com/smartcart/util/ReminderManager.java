package com.smartcart.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class ReminderManager {
    public static void scheduleReminder(Context context, long timeMillis, String msg) {
        Intent intent = new Intent(context, com.smartcart.receivers.ReminderReceiver.class);
        intent.putExtra("message", msg);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarm.setExact(AlarmManager.RTC_WAKEUP, timeMillis, pendingIntent);
    }
}