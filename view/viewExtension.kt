import android.view.View

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