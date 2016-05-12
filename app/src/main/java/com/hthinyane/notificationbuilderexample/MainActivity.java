package com.hthinyane.notificationbuilderexample;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String msg;
    private EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textField = (EditText)findViewById(R.id.editText);
    }

    public void onClickNotification(View view) {
        msg = textField.getText().toString();

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notify)
                .setContentText(msg)
                .setContentTitle("Hey...");

        NotificationManager nManage =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManage.notify(0, mBuilder.build());
    }

    public void onClickInboxNotification(View view) {
        msg = textField.getText().toString();

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Inbox Notification");
        inboxStyle.addLine(msg);
        inboxStyle.addLine("and more about " + msg);
        inboxStyle.addLine("and even more about " + msg);

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notify)
                .setContentText(msg)
                .setStyle(inboxStyle)
                .setContentTitle("Email hey...");

        NotificationManager nManage = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManage.notify(0, mBuilder.build());

    }

    public void onClickPicNotification(View view) {
        msg = textField.getText().toString();


        NotificationCompat.BigPictureStyle picStyle = new NotificationCompat.BigPictureStyle();
        picStyle.bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.frog)).build();

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notify)
                .setStyle(picStyle)
                .setContentTitle("The pic...");

        NotificationManager nManage =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nManage.notify(0, mBuilder.build());

    }

    public void onClickToast(View view) {
        msg = textField.getText().toString();

        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }

    private void notify(String mesg) {

    }

}
