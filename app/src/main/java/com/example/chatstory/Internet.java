package com.example.chatstory;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Internet {

    Context context;

    public Internet(Context context) {
        this.context = context;
    }
    public boolean InternetConnecting(){
        ConnectivityManager connect = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connect != null)
        {
            NetworkInfo[] information = connect.getAllNetworkInfo();
            if (information != null)
                for (int x = 0; x < information.length; x++)
                    if (information[x].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
        }
        return false;
    }
}
