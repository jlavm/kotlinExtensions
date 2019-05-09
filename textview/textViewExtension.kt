import android.os.Build
import android.text.Html
import android.view.View
import android.widget.TextView

fun TextView?.valueTextOrGone(value: Boolean, textValue: String?) = if (value) {
    this?.text = textValue
} else {
    this?.visibility = View.GONE
}

fun TextView?.valueTextOrInvisible(value: Boolean, textValue: String?) = if (value) {
    this?.text = textValue
} else {
    this?.visibility = View.INVISIBLE
}

@Suppress("DEPRECATION")
fun TextView?.textHtml(value: String?) {
    this?.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY) else Html.fromHtml(value)
}