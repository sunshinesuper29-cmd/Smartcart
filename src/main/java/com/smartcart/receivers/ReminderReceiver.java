package com.smartcart.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.smartcart.R;

import java.util.Random;

public class ReminderReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("message");

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "reminders")
            .setSmallIcon(R.drawable.ic_reminder)
            .setContentTitle("SmartCart Reminder")
            .setContentText(msg)
            .setPriority(NotificationCompat.PRIORITY_HIGH);

        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        manager.notify(new Random().nextInt(), builder.build());
    }
}