package com.phonegap.plugins;

import com.parse.Parse;
import com.parse.ParsePush;
import com.parse.PushService;
import com.parse.SaveCallback;
import com.parse.ParseInstallation;
import android.app.Application;
import android.util.Log;
import com.parse.ParseUser;
import com.parse.ParseException;
import com.parse.SignUpCallback;

public class ParseApp extends Application {

 @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "PARSE_APP_ID", "PARSE_CLIENT_KEY");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParsePush.subscribeInBackground("", new SaveCallback() {
          @Override
          public void done(ParseException e) {
            if (e == null) {
              Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
            } else {
              Log.e("com.parse.push", "failed to subscribe for push", e);
            }
          }
        });
    }
}