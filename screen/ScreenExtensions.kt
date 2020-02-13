import android.content.res.Resources
import android.util.TypedValue
import kotlin.math.pow
import kotlin.math.sqrt

fun Resources.dp2pixels(dp: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, this.displayMetrics).toInt()
}

fun Resources.isTablet(): Boolean {
    val dm = this.displayMetrics
    val width = dm.widthPixels
    val height = dm.heightPixels
    val wi = width.toDouble() / dm.xdpi.toDouble()
    val hi = height.toDouble() / dm.ydpi.toDouble()
    val x = wi.pow(2.0)
    val y = hi.pow(2.0)
    val screenInches = sqrt(x + y)
    return screenInches >= 7
}