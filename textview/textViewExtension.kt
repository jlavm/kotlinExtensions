import android.graphics.Typeface
import android.os.Build
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView
import java.util.*

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

fun TextView?.textSpannable(textValue: String?, textFind: String?, customSpan: Any?) = this?.run {
    if (!textValue.isNullOrBlank() && !textFind.isNullOrBlank()) {
        if (textValue.contains(textFind)) {
            val stringStart = textValue.indexOf(textFind)
            val spannableString = SpannableString(textValue)
            spannableString.setSpan(
                customSpan, stringStart,
                stringStart + textFind.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            this.text = spannableString
        } else {
            this.text = textValue
        }
    }
}

fun TextView?.textSpannableCollection(textValue: String?, textSpannableMap: HashMap<String, Any>) =
    this?.run {
        if (!textValue.isNullOrBlank() && !textSpannableMap.isNullOrEmpty()) {
            val spannableString = SpannableString(textValue)
            for ((textFind, customSpan) in textSpannableMap) {
                if (!textFind.isBlank() && textValue.contains(textFind)) {
                    val stringStart = textValue.indexOf(textFind)
                    spannableString.setSpan(
                        customSpan, stringStart,
                        stringStart + textFind.length,
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            }
            this.text = spannableString
        }
    }

fun TextView?.makeSectionOfTextBold(text: String, textToBold: String) = this?.run {

    val builder = SpannableStringBuilder()

    if (textToBold.isNotEmpty() && textToBold.trim { it <= ' ' } != "") {

        //for counting start/end indexes
        val startingIndex = text.indexOf(textToBold)
        val endingIndex = startingIndex + textToBold.length
        //for counting start/end indexes

        if (startingIndex < 0 || endingIndex < 0) {
            this.text = builder.append(text)
        } else if (startingIndex >= 0 && endingIndex >= 0) {
            builder.append(text)
            builder.setSpan(StyleSpan(Typeface.BOLD), startingIndex, endingIndex, 0)
        }
    } else {
        this.text = builder.append(text)
    }
    this.text = builder
}

fun TextView?.addClick(clickableText: String, clickableTextColor: Int, clickEvent: () -> Unit) =
    this?.run {
        if (text != null) {
            val initPos = text.toString().indexOf(clickableText)
            val endPos = initPos + clickableText.length

            if (initPos >= 0 && endPos < text.length) {
                val span = Spannable.Factory.getInstance().newSpannable(text)
                span.setSpan(object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        clickEvent()
                    }

                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)

                        ds.color = clickableTextColor
                    }
                }, initPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

                this.text = span
                movementMethod = LinkMovementMethod.getInstance()
            }
        }
    }