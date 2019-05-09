import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadUrl(url: String?, options: RequestOptions?) {
    Glide.with(context)
            .load(url)
            .apply(options ?: RequestOptions())
            .into(this)
}

fun ImageView.loadDrawable(url: Int?, options: RequestOptions?) {
    Glide.with(context)
            .load(url)
            .apply(options ?: RequestOptions())
            .into(this)
}