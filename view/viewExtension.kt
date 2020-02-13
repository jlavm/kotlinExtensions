import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

fun View?.visible() {
    this?.visibility = View.VISIBLE
}

fun View?.invisible() {
    this?.visibility = View.INVISIBLE
}

fun View?.gone() {
    this?.visibility = View.GONE
}

fun View?.isVisible(): Boolean =  this?.visibility == View.VISIBLE

fun View?.visibleOrGone(visible: Boolean) {
    this?.visibility = if(visible) View.VISIBLE else View.GONE
}

fun View?.visibleOrInvisible(visible: Boolean) {
    this?.visibility = if(visible) View.VISIBLE else View.INVISIBLE
}

fun View?.setCustomTypeface(fontId: Int) {
    if (this != null && this is ViewGroup) {
        val count = childCount
        for (i in 0 until count) {
            val child = getChildAt(i)
            if (child is ViewGroup) {
                child.setCustomTypeface(fontId)
            } else {
                if (child is TextView) {
                    val typeface = ResourcesCompat.getFont(context, fontId)
                    child.typeface = typeface
                    child.setPadding(0, 0, 0, 0)
                    child.gravity = Gravity.CENTER
                    child.maxWidth = context.convertDip2Pixels(200)
                    child.isSingleLine = true
                    child.ellipsize = TextUtils.TruncateAt.END
                }
            }
        }
    }
}