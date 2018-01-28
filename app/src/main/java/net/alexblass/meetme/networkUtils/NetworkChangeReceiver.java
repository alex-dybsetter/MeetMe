package net.alexblass.meetme.networkUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import net.alexblass.meetme.OfflineActivity;

/**
 * A BroadcastReceiver to detect changes in network connectivity.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        int status = NetworkUtils.getConnectivityStatus(context);

        if (status == NetworkUtils.TYPE_NOT_CONNECTED){
            Intent offlineActivty = new Intent(context, OfflineActivity.class);
            context.startActivity(offlineActivty);
        }

        // TODO: hide no internet screen when internet reconnects
    }
}