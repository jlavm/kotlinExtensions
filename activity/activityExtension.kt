import android.app.Activity
import android.content.Intent

enum class AnimationsActivities {
    NONE,
    FADE,
    SLIDE_HORIZONTAL,
    SLIDE_HORIZONTAL_INVERTED,
    SLIDE_VERTICAL,
    SLIDE_VERTICAL_INVERTED,
    ZOOM,
    SCALE
}

inline fun <reified T : Activity> Activity.goToActivity(
    clear: Boolean = true,
    animation: AnimationsActivities = AnimationsActivities.SLIDE_HORIZONTAL,
    init: Intent.() -> Unit = {}
) {

    val intent = Intent(this, T::class.java)
    if (clear) {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    intent.init()
    startActivity(intent)

    when (animation) {
        AnimationsActivities.FADE -> overridePendingTransition(
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL -> overridePendingTransition(
            R.anim.right_in,
            R.anim.left_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL_INVERTED -> overridePendingTransition(
            R.anim.left_in,
            R.anim.right_out
        )
        AnimationsActivities.SLIDE_VERTICAL -> overridePendingTransition(
            R.anim.slide_down_in,
            R.anim.slide_up_out
        )
        AnimationsActivities.SLIDE_VERTICAL_INVERTED -> overridePendingTransition(
            R.anim.slide_up_in,
            R.anim.slide_down_out
        )
        AnimationsActivities.ZOOM -> overridePendingTransition(
            R.anim.zoom_in,
            R.anim.zoom_out
        )
        AnimationsActivities.SCALE -> overridePendingTransition(
            R.anim.scale_in,
            R.anim.scale_out
        )
        AnimationsActivities.NONE -> {
            // Nothing to implement.
        }
    }
}

inline fun <reified T : Activity> Activity.goToActivityResult(
    requestCode: Int,
    clear: Boolean = true,
    animation: AnimationsActivities = AnimationsActivities.SLIDE_HORIZONTAL,
    init: Intent.() -> Unit = {}
) {
    val intent = Intent(this, T::class.java)
    if (clear) {
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }

    intent.init()
    startActivityForResult(intent, requestCode)

    when (animation) {
        AnimationsActivities.FADE -> overridePendingTransition(
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL -> overridePendingTransition(
            R.anim.right_in,
            R.anim.left_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL_INVERTED -> overridePendingTransition(
            R.anim.left_in,
            R.anim.right_out
        )
        AnimationsActivities.SLIDE_VERTICAL -> overridePendingTransition(
            R.anim.slide_down_in,
            R.anim.slide_up_out
        )
        AnimationsActivities.SLIDE_VERTICAL_INVERTED -> overridePendingTransition(
            R.anim.slide_up_in,
            R.anim.slide_down_out
        )
        AnimationsActivities.ZOOM -> overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out)
        AnimationsActivities.SCALE -> overridePendingTransition(R.anim.scale_in, R.anim.scale_out)
        AnimationsActivities.NONE -> {
            // Nothing to implement.
        }
    }
}

fun Activity.finishActivityWithAnimation(animation: AnimationsActivities = AnimationsActivities.SLIDE_HORIZONTAL) {
    this.finish()
    when (animation) {
        AnimationsActivities.FADE -> overridePendingTransition(
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL -> overridePendingTransition(
            R.anim.right_in,
            R.anim.left_out
        )
        AnimationsActivities.SLIDE_HORIZONTAL_INVERTED -> overridePendingTransition(
            R.anim.left_in,
            R.anim.right_out
        )
        AnimationsActivities.SLIDE_VERTICAL -> overridePendingTransition(
            R.anim.slide_down_in,
            R.anim.slide_up_out
        )
        AnimationsActivities.SLIDE_VERTICAL_INVERTED -> overridePendingTransition(
            R.anim.slide_up_in,
            R.anim.slide_down_out
        )
        AnimationsActivities.ZOOM -> overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out)
        AnimationsActivities.SCALE -> overridePendingTransition(R.anim.scale_in, R.anim.scale_out)
        AnimationsActivities.NONE -> {
            // Nothing to implement.
        }
    }
}