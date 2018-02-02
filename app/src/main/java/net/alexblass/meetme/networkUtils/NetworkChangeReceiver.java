package net.alexblass.meetme.networkUtils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import net.alexblass.meetme.MainActivity;
import net.alexblass.meetme.OfflineActivity;

import static android.content.Context.MODE_PRIVATE;
import static net.alexblass.meetme.constants.Keys.OFFLINE_ACTIVITY_KEY;
import static net.alexblass.meetme.constants.Keys.PREFS;

/**
 * A BroadcastReceiver to detect changes in network connectivity.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {

        int status = NetworkUtils.getConnectivityStatus(context);

        SharedPreferences sp = context.getSharedPreferences(PREFS, MODE_PRIVATE);
        boolean isActive = sp.getBoolean(OFFLINE_ACTIVITY_KEY, false);

        if (status == NetworkUtils.TYPE_NOT_CONNECTED && !isActive){
            Intent offlineActivty = new Intent(context, OfflineActivity.class);
            context.startActivity(offlineActivty);
        } else if (status != NetworkUtils.TYPE_NOT_CONNECTED && isActive){
            Toast.makeText(context, "close", Toast.LENGTH_SHORT).show();
        }

        // TODO: hide no internet screen when internet reconnects
    }
}