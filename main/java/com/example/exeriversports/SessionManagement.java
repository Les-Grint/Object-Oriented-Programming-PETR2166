package com.example.exeriversports;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME = "session";
    String SESSION_KEY = "session_user";

    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // This saves the session of the user once they are logged in.
    public void saveSession(User user){
        String Email = user.getEmail();

        editor.putString(SESSION_KEY, Email).commit();
    }

    // This will get the String value stored in 'SESSION_KEY', if no value exists it will get the next value by default
    public String getSession(){
        return sharedPreferences.getString(SESSION_KEY, "No_Session");
    }

    public void removeSession() {
        editor.putString(SESSION_KEY, "No_Session").commit();
    }
}
