import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.support.v4.content.ContextCompat

fun Context.color(id: Int): Int = ContextCompat.getColor(this, id)