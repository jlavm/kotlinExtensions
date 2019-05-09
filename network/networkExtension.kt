import android.net.ConnectivityManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager

fun Context.getNetworkInfo(): NetworkInfo? =
        (this.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager?)?.activeNetworkInfo

fun Context.getWifiManager(): WifiManager? = this.getSystemService(Context.WIFI_SERVICE) as? WifiManager?

fun Context.getWifiInfo(): WifiInfo? = getWifiManager()?.connectionInfo


fun ConnectivityManager.checkConn(): Boolean {
    return this.activeNetworkInfo != null && this.activeNetworkInfo.isConnected
}

fun Context.getWifiName(): String? {
        val info = this.getNetworkInfo()
        return when {
            info == null || !info.isConnected -> null //not connected
            info.type == ConnectivityManager.TYPE_WIFI -> this.getWifiInfo()?.ssid?.replace("\"", "")
            else -> null
        }
}