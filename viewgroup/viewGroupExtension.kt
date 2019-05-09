import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


//Inflate layout Res
fun ViewGroup.inflate(@LayoutRes viewId: Int, attachToRoot: Boolean = false): View = LayoutInflater.from(context).inflate(viewId, this, attachToRoot)